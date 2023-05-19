package com.isa.todo.service;
import com.isa.todo.model.Category;
import com.isa.todo.model.Task;
import com.isa.todo.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    private TaskService taskService;
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskService = new TaskService(taskRepository);
    }

    @Test
    void addTask() {
        // Given
        Task task = new Task("Task 1", Category.WORK, 1, LocalDate.now());

        // When
        taskService.addTask(task);

        // Then
        verify(taskRepository, times(1)).addTask(task);
    }


    @Test
    void addTask_WhenTaskIsNull_ShouldNotAddTask() {
        // Given
        Task task = null;

        // When
        taskService.addTask(task);
        List<Task> tasks = taskService.getAllTasks();

        // Then
        assertFalse(tasks.contains(task));
    }



    @Test
    void getAllTasks() {
    }

    @Test
    void getTaskById() {
    }

    @Test
    void findTasksWithPriority1() {
    }

    @Test
    void findTasksForNextDay() {
    }

    @Test
    void sortTasksByPriorityDescending() {
    }

    @Test
    void sortTasksByDate() {
    }

    @Test
    void removeTask() {
    }

    @Test
    void findTasksByCategory() {
    }

    @Test
    void findTasksByDescriptionContains() {
    }

    @Test
    void findMostUrgentTask() {
    }

    @Test
    void divideTasksByCategory() {
    }

    @Test
    void divideTasksByPriority() {
    }

    @Test
    void findHighestPriorityTaskForEachCategory() {
    }
}