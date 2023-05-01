package com.isa.todo.repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.todo.model.Task;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class JsonTaskRepository implements TaskRepository {

    private static final String FILE_NAME = "tasks.json";
    private final ObjectMapper objectMapper;
    private List<Task> tasks;

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
        saveTasksToFile();
    }

    @Override
    public void removeTask(Task task) {
        tasks.remove(task);
        saveTasksToFile();
    }

    private void saveTasksToFile() {
        try {
            objectMapper.writeValue(new File(FILE_NAME), tasks);
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
