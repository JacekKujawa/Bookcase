package com.isa.todo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.todo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class JsonTaskRepository implements TaskRepository {

    private final String filePath;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonTaskRepository() {
        this.filePath = "tasks.json";
    }

    @Override
    public List<Task> getAllTasks() {
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<List<Task>>() {});
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void addTask(Task task) {
        try {
            List<Task> tasks = getAllTasks();
            tasks.add(task);
            System.out.println("Adding task..");
            objectMapper.writeValue(new File(filePath), tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeTask(Task task) {
        try {
            List<Task> tasks = getAllTasks();
            tasks.remove(task);
            objectMapper.writeValue(new File(filePath), tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
