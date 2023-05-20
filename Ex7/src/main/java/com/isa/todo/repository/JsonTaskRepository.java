package com.isa.todo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.todo.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JsonTaskRepository implements TaskRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskRepository.class);

    private final ObjectMapper objectMapper;
    private final List<Task> tasks;
    TaskRepository taskRepository;

    Resource resource = new ClassPathResource("tasks.json");
    File FILE_NAME = resource.getFile();

    public JsonTaskRepository(ObjectMapper objectMapper) throws IOException {
        this.objectMapper = objectMapper;
        this.tasks = loadTasksFromFile();
        this.taskRepository = this;
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
        saveTasksToFile();
    }

    @Override
    public void removeTask(Task task) {
        tasks.remove(task);
        saveTasksToFile();
    }


    @Override
    public Task getTaskById(String id) {
        LOGGER.debug("Searching for task with id: {}", id);

        Optional<Task> taskOptional = this.taskRepository.getAllTasks().stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            LOGGER.debug("Found task: {}", task);
            return task;
        } else {
            LOGGER.debug("Task not found for id: {}", id);
            return null;
        }
    }

    private void saveTasksToFile() {
        try {
            objectMapper.writeValue(new File(FILE_NAME.toURI()), this.tasks);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save tasks to file", e);
        }
    }

    private List<Task> loadTasksFromFile() {
        try {
            File file = new File(FILE_NAME.toURI());
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<>() {
                });
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load tasks from file", e);
        }
        return new ArrayList<>();
    }
}
