package com.isa.todo.repository;

import com.isa.todo.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> getAllTasks();

    void addTask(Task task);

    void removeTask(Task task);

    Task getTaskById(String id);

}
