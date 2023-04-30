package com.isa.todo.service;

import com.isa.todo.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();


    void addTask(Task task);

    void removeTask(Task task);
}
