package com.isa.todo.service;

import com.isa.todo.model.Category;
import com.isa.todo.model.Task;
import com.isa.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
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
                .filter(task -> Objects.equals(task.getPriority(), 1))
                .collect(Collectors.toList());
    }

    public List<Task> findTasksForNextDay() {
        LocalDate nextDay = LocalDate.now().plusDays(1);
        return taskRepository.getAllTasks().stream()
                .filter(task -> task.getDueDate().equals(nextDay))
                .collect(Collectors.toList());
    }

    public List<Task> sortTasksByPriorityDescending() {
        return taskRepository.getAllTasks().stream()
                .sorted(Comparator.comparingInt(Task::getPriority))
                .collect(Collectors.toList());
    }

    public List<Task> sortTasksByDate() {
        return taskRepository.getAllTasks().stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .collect(Collectors.toList());
    }

    public void removeTask(String id) {
        Task task = taskRepository.getTaskById(id);
        if (task != null) {
            taskRepository.removeTask(task);
        }
    }

    public List<Task> findTasksByCategory(Category category) {
        return taskRepository.getAllTasks().stream()
                .filter(task -> task.getCategory() == category)
                .collect(Collectors.toList());
    }

    public List<Task> findTasksByDescriptionContains(String keyword) {
        return taskRepository.getAllTasks().stream()
                .filter(task -> task.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Task> findMostUrgentTask() {
        return taskRepository.getAllTasks().stream()
                .min(Comparator.comparing(Task::getDueDate).thenComparingInt(Task::getPriority));
    }
    public Map<Category, List<Task>> divideTasksByCategory() {
        return taskRepository.getAllTasks().stream()
                .collect(Collectors.groupingBy(Task::getCategory));
    }

    public Map<Integer, List<Task>> divideTasksByPriority() {
        return taskRepository.getAllTasks().stream()
                .collect(Collectors.groupingBy(Task::getPriority));
    }
    public Map<Category, Optional<Task>> findHighestPriorityTaskForEachCategory() {
        return taskRepository.getAllTasks().stream()
                .collect(Collectors.groupingBy(Task::getCategory,
                        Collectors.minBy(Comparator.comparingInt(Task::getPriority))));
    }
}
