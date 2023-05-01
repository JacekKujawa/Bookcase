package com.isa.todo.repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.todo.model.Task;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JsonTaskRepository implements TaskRepository {

    private static final String FILE_NAME = "tasks.json";
    private final ObjectMapper objectMapper;
    private List<Task> tasks;
    TaskRepository taskRepository;

    public JsonTaskRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.tasks = loadTasksFromFile();
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
        saveTasksToFile(tasks);
    }

    @Override
    public void removeTask(Task task) {
        tasks.remove(task);
        saveTasksToFile(tasks);
    }
    @Override
    public void updateTask(Task updatedTask) {
        List<Task> tasks = getAllTasks();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(updatedTask.getId())) {
                tasks.set(i, updatedTask);
                saveTasksToFile(tasks);
                return;
            }
        }
    }


    @Override
    public Task getTaskById(String id) {

        Optional<Task> taskOptional = taskRepository.getAllTasks().stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
        return taskOptional.orElse(null);
    }

    private void saveTasksToFile(List<Task> tasks) {
        try {
            objectMapper.writeValue(new File(FILE_NAME), this.tasks);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save tasks to file", e);
        }
    }

    private List<Task> loadTasksFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<Task>>() {});
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load tasks from file", e);
        }
        return new ArrayList<>();
    }
}
