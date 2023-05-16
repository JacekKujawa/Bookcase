package com.isa.todo.service;

import com.isa.todo.model.Task;
import com.isa.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public Task getTaskById(String id) {
        return taskRepository.getTaskById(id);
    }

    public List<Task> findTasksWithPriority1() {
        return taskRepository.getAllTasks().stream()
                .filter(task -> Objects.equals(task.getPriority(), "1"))
                .collect(Collectors.toList());
    }

    public void removeTask(String id) {
        Task task = taskRepository.getTaskById(id);
        if (task != null) {
            taskRepository.removeTask(task);
        }
    }

}
