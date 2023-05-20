package com.isa.todo.service;

import com.isa.todo.model.Category;
import com.isa.todo.model.Task;
import com.isa.todo.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

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
    void getTaskById() {
        // Given
        Task task = new Task("Task", Category.WORK, 1, LocalDate.now());

        when(taskRepository.getTaskById(task.getId())).thenReturn(task);

        // When
        Task result = taskService.getTaskById(task.getId());

        // Then
        assertNotNull(result);
        assertEquals(task, result);
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
    void findTasksForNextDay_WhenTasksExist_ShouldReturnTasksForNextDay() {
        // Given
        Task task1 = new Task("Task 1", Category.WORK, 1, LocalDate.now().plusDays(1));
        Task task2 = new Task("Task 2", Category.HOME, 2, LocalDate.now().plusDays(2));
        Task task3 = new Task("Task 3", Category.OTHER, 3, LocalDate.now().plusDays(3));
        Task task4 = new Task("Task 4", Category.WORK, 1, LocalDate.now().plusDays(1));

        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2, task3, task4));

        // When
        List<Task> tasks = taskService.findTasksForNextDay();

        // Then
        assertEquals(2, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task4));
    }

    @Test
    void findTasksForNextDay_WhenNoTasksExist_ShouldReturnEmptyList() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Collections.emptyList());

        // When
        List<Task> tasks = taskService.findTasksForNextDay();

        // Then
        assertTrue(tasks.isEmpty());
    }


    @Test
    void sortTasksByPriorityDescending_WhenTasksExist_ShouldReturnTasksSortedByPriorityDescending() {
        // Given
        Task task1 = new Task("Task 1", Category.WORK, 1, LocalDate.now());
        Task task2 = new Task("Task 2", Category.HOME, 3, LocalDate.now().plusDays(1));
        Task task3 = new Task("Task 3", Category.OTHER, 2, LocalDate.now().plusDays(2));

        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2, task3));

        // When
        List<Task> tasks = taskService.sortTasksByPriorityDescending();

        // Then
        assertEquals(3, tasks.size());
        assertEquals(task2, tasks.get(2));
        assertEquals(task3, tasks.get(1));
        assertEquals(task1, tasks.get(0));
    }

    @Test
    void sortTasksByPriorityDescending_WhenNoTasksExist_ShouldReturnEmptyList() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Collections.emptyList());

        // When
        List<Task> tasks = taskService.sortTasksByPriorityDescending();

        // Then
        assertTrue(tasks.isEmpty());
    }


    @Test
    void sortTasksByDate_WhenTasksExist_ShouldReturnTasksSortedByDate() {
        // Given
        Task task1 = new Task("Task 1", Category.WORK, 1, LocalDate.now().plusDays(2));
        Task task2 = new Task("Task 2", Category.HOME, 3, LocalDate.now().plusDays(1));
        Task task3 = new Task("Task 3", Category.OTHER, 2, LocalDate.now());

        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2, task3));

        // When
        List<Task> tasks = taskService.sortTasksByDate();

        // Then
        assertEquals(3, tasks.size());
        assertEquals(task3, tasks.get(0));
        assertEquals(task2, tasks.get(1));
        assertEquals(task1, tasks.get(2));
    }

    @Test
    void sortTasksByDate_WhenNoTasksExist_ShouldReturnEmptyList() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Collections.emptyList());

        // When
        List<Task> tasks = taskService.sortTasksByDate();

        // Then
        assertTrue(tasks.isEmpty());
    }


    @Test
    void removeTask_WhenTaskExists_ShouldRemoveTask() {
        // Given
        Task task1 = new Task("Task 1", Category.WORK, 1, LocalDate.now());
        Task task2 = new Task("Task 2", Category.HOME, 2, LocalDate.now().plusDays(1));
        Task task3 = new Task("Task 3", Category.OTHER, 3, LocalDate.now().plusDays(2));

        when(taskRepository.getTaskById(task2.getId())).thenReturn(task2);

        // When
        taskService.removeTask(task2.getId());

        // Then
        verify(taskRepository, times(1)).removeTask(task2);
    }

    @Test
    void removeTask_WhenTaskDoesNotExist_ShouldNotRemoveTask() {
        // Given
        String nonExistentTaskId = "non-existent-task-id";

        when(taskRepository.getTaskById(nonExistentTaskId)).thenReturn(null);

        // When
        taskService.removeTask(nonExistentTaskId);

        // Then
        verify(taskRepository, never()).removeTask(any());
    }


    @Test
    void findTasksByCategory_WhenTasksExistForCategory_ShouldReturnTasksForCategory() {
        // Given
        Task task1 = new Task("Task 1", Category.WORK, 1, LocalDate.now());
        Task task2 = new Task("Task 2", Category.HOME, 2, LocalDate.now().plusDays(1));
        Task task3 = new Task("Task 3", Category.WORK, 3, LocalDate.now().plusDays(2));

        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2, task3));

        // When
        List<Task> tasks = taskService.findTasksByCategory(Category.WORK);

        // Then
        assertEquals(2, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task3));
    }

    @Test
    void findTasksByCategory_WhenNoTasksExistForCategory_ShouldReturnEmptyList() {
        // Given
        Task task1 = new Task("Task 1", Category.HOME, 1, LocalDate.now());
        Task task2 = new Task("Task 2", Category.HOME, 2, LocalDate.now().plusDays(1));
        Task task3 = new Task("Task 3", Category.HOME, 3, LocalDate.now().plusDays(2));

        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2, task3));

        // When
        List<Task> tasks = taskService.findTasksByCategory(Category.WORK);

        // Then
        assertTrue(tasks.isEmpty());
    }


    @Test
    void findTasksByDescriptionContains_WhenTasksExistWithMatchingDescription_ShouldReturnMatchingTasks() {
        // Given
        Task task1 = new Task("Task 1", Category.WORK, 1, LocalDate.now());
        Task task2 = new Task("Task 2", Category.HOME, 2, LocalDate.now().plusDays(1));
        Task task3 = new Task("Task 3", Category.WORK, 3, LocalDate.now().plusDays(2));

        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2, task3));

        // When
        List<Task> tasks = taskService.findTasksByDescriptionContains("Task");

        // Then
        assertEquals(3, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
        assertTrue(tasks.contains(task3));
    }

    @Test
    void findTasksByDescriptionContains_WhenNoTasksExistWithMatchingDescription_ShouldReturnEmptyList() {
        // Given
        Task task1 = new Task("Task 1", Category.HOME, 1, LocalDate.now());
        Task task2 = new Task("Task 2", Category.HOME, 2, LocalDate.now().plusDays(1));
        Task task3 = new Task("Task 3", Category.HOME, 3, LocalDate.now().plusDays(2));

        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2, task3));

        // When
        List<Task> tasks = taskService.findTasksByDescriptionContains("Work");

        // Then
        assertTrue(tasks.isEmpty());
    }


    @Test
    void findMostUrgentTask_WhenTasksExist_ShouldReturnMostUrgentTask() {
        // Given
        Task task1 = new Task("Task 1", Category.WORK, 1, LocalDate.now().plusDays(1));
        Task task2 = new Task("Task 2", Category.HOME, 2, LocalDate.now());
        Task task3 = new Task("Task 3", Category.OTHER, 3, LocalDate.now().plusDays(2));

        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2, task3));

        // When
        Optional<Task> mostUrgentTask = taskService.findMostUrgentTask();

        // Then
        assertTrue(mostUrgentTask.isPresent());
        assertEquals(task2, mostUrgentTask.get());
    }
    @Test
    void findMostUrgentTask_WhenNoTasksExist_ShouldReturnEmptyOptional() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Collections.emptyList());

        // When
        Optional<Task> mostUrgentTask = taskService.findMostUrgentTask();

        // Then
        assertFalse(mostUrgentTask.isPresent());
    }

    @Test
    void divideTasksByCategory_WhenTasksExist_ShouldReturnTasksDividedByCategory() {
        // Given
        Task task1 = new Task("Task 1", Category.WORK, 1, LocalDate.now().plusDays(1));
        Task task2 = new Task("Task 2", Category.HOME, 2, LocalDate.now());
        Task task3 = new Task("Task 3", Category.WORK, 3, LocalDate.now().plusDays(2));
        Task task4 = new Task("Task 4", Category.OTHER, 1, LocalDate.now().plusDays(3));

        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2, task3, task4));

        // When
        Map<Category, List<Task>> dividedTasks = taskService.divideTasksByCategory();

        // Then
        assertNotNull(dividedTasks);
        assertEquals(3, dividedTasks.size());
        assertTrue(dividedTasks.containsKey(Category.WORK));
        assertTrue(dividedTasks.containsKey(Category.HOME));
        assertTrue(dividedTasks.containsKey(Category.OTHER));
        assertEquals(Arrays.asList(task1, task3), dividedTasks.get(Category.WORK));
        assertEquals(Collections.singletonList(task2), dividedTasks.get(Category.HOME));
        assertEquals(Collections.singletonList(task4), dividedTasks.get(Category.OTHER));
    }

    @Test
    void divideTasksByCategory_WhenNoTasksExist_ShouldReturnEmptyMap() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Collections.emptyList());

        // When
        Map<Category, List<Task>> dividedTasks = taskService.divideTasksByCategory();

        // Then
        assertNotNull(dividedTasks);
        assertTrue(dividedTasks.isEmpty());
    }


    @Test
    void divideTasksByPriority() {
    }

    @Test
    void findHighestPriorityTaskForEachCategory() {
    }
}