package com.isa.todo.service;

import com.isa.todo.model.Category;
import com.isa.todo.model.Task;
import com.isa.todo.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
    void getAllTasks_WhenTasksExist_ShouldReturnAllTasks() {
        // Given
        Task task1 = new Task("Task 1", Category.WORK, 1, LocalDate.now());
        Task task2 = new Task("Task 2", Category.HOME, 2, LocalDate.now().plusDays(1));
        Task task3 = new Task("Task 3", Category.OTHER, 3, LocalDate.now().plusDays(2));

        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2, task3));

        // When
        List<Task> tasks = taskService.getAllTasks();

        // Then
        assertEquals(3, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
        assertTrue(tasks.contains(task3));
    }

    @Test
    void getAllTasks_WhenNoTasksExist_ShouldReturnEmptyList() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList());

        // When
        List<Task> tasks = taskService.getAllTasks();

        // Then
        assertTrue(tasks.isEmpty());
    }


    @Test
    void getTaskById_WhenTaskDoesNotExist_ShouldReturnNull() {
        // Given
        Task task1 = new Task("Task 1", Category.WORK, 1, LocalDate.now());
        Task task2 = new Task("Task 2", Category.HOME, 2, LocalDate.now().plusDays(1));
        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2));

        // When
        Task result = taskService.getTaskById("nonexistent_id");

        // Then
        assertNull(result);
    }


    @Test
    void findTasksWithPriority1_WhenTasksExist_ShouldReturnTasksWithPriority1() {
        // Given
        Task task1 = new Task("Task 1", Category.WORK, 1, LocalDate.now());
        Task task2 = new Task("Task 2", Category.HOME, 1, LocalDate.now().plusDays(1));
        Task task3 = new Task("Task 3", Category.OTHER, 2, LocalDate.now().plusDays(2));

        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2, task3));

        // When
        List<Task> tasks = taskService.findTasksWithPriority1();

        // Then
        assertEquals(2, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
    }

    @Test
    void findTasksWithPriority1_WhenNoTasksWithPriority1_ShouldReturnEmptyList() {
        // Given
        Task task1 = new Task("Task 1", Category.WORK, 2, LocalDate.now());
        Task task2 = new Task("Task 2", Category.HOME, 3, LocalDate.now().plusDays(1));

        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2));

        // When
        List<Task> tasks = taskService.findTasksWithPriority1();

        // Then
        assertTrue(tasks.isEmpty());
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