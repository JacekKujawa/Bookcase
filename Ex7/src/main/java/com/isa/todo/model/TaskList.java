package com.isa.todo.model;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    String filePath = getClass().getClassLoader().getResource("tasks.json").getPath();

    private List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void saveToJson(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(filePath), tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromJson(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            tasks = mapper.readValue(new File(filePath), new TypeReference<List<Task>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
