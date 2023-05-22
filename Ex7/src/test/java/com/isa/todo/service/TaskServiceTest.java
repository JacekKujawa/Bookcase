package com.isa.todo.service;

import com.isa.todo.model.Category;
import com.isa.todo.model.Task;
import com.isa.todo.repository.TaskRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    Task task1 = new Task("Task 1", Category.WORK, 1, LocalDate.now().plusDays(1));
    Task task2 = new Task("Task 2", Category.HOME, 2, LocalDate.now().plusDays(2));
    Task task3 = new Task("Task 3", Category.OTHER, 3, LocalDate.now().plusDays(3));
    Task task4 = new Task("Task 4", Category.WORK, 1, LocalDate.now().plusDays(1));
    private TaskService taskService;
    private TaskRepository taskRepository;
    private String name;

    @AfterAll
    static void afterAll() {

        System.out.println(" AllTests has been completed. Thanks :)\n");
    }

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskService = new TaskService(taskRepository);
        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2, task3, task4));

    }

    @AfterEach
    void afterEach() {

        System.out.println(name + " has been completed\n");
    }

    @Test
    void addTask() {

        // When
        taskService.addTask(task1);

        // Then
        verify(taskRepository, times(1)).addTask(task1);
        name = "addTask";
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
        name = "addTask_WhenTaskIsNull_ShouldNotAddTask";
    }


    @Test
    void getAllTasks_WhenTasksExist_ShouldReturnAllTasks() {

        // When
        List<Task> tasks = taskService.getAllTasks();

        // Then
        assertAll("Tasks",
                () -> assertEquals(4, tasks.size(), "Incorrect number of tasks"),
                () -> assertTrue(tasks.contains(task1), "Task 1 is not present"),
                () -> assertTrue(tasks.contains(task2), "Task 2 is not present"),
                () -> assertTrue(tasks.contains(task3), "Task 3 is not present"),
                () -> assertTrue(tasks.contains(task4), "Task 4 is not present")
        );
        name = "getAllTasks_WhenTasksExist_ShouldReturnAllTasks";
    }

    @Test
    void getAllTasks_WhenNoTasksExist_ShouldReturnEmptyList() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList());

        // When
        List<Task> tasks = taskService.getAllTasks();

        // Then
        assertTrue(tasks.isEmpty(), "Result is not empty");
        name = "getAllTasks_WhenNoTasksExist_ShouldReturnEmptyList";
    }

    @Test
    void getTaskById() {

        when(taskRepository.getTaskById(task1.getId())).thenReturn(task1);

        // When
        Task result = taskService.getTaskById(task1.getId());

        // Then
        assertAll("Tasks",
                () -> assertNotNull(result, "Result is null"),
                () -> assertEquals(task1, result, "Result does not match expected task")
        );
        name = "getTaskById";
    }


    @Test
    void getTaskById_WhenTaskDoesNotExist_ShouldReturnNull() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task1, task2));

        // When
        Task result = taskService.getTaskById("nonexistent_id");

        // Then
        assertNull(result, "Result is null");
        name = "getTaskById_WhenTaskDoesNotExist_ShouldReturnNull";
    }


    @Test
    void findTasksWithPriority1_WhenTasksExist_ShouldReturnTasksWithPriority1() {

        // When
        List<Task> tasks = taskService.findTasksWithPriority1();

        // Then
        assertAll("Tasks",
                () -> assertEquals(2, tasks.size(), "Incorrect number of tasks"),
                () -> assertTrue(tasks.contains(task1), "Task 1 is not present"),
                () -> assertTrue(tasks.contains(task4), "Task 4 is not present")
        );
        name = "findTasksWithPriority1_WhenTasksExist_ShouldReturnTasksWithPriority1";
    }

    @Test
    void findTasksWithPriority1_WhenNoTasksWithPriority1_ShouldReturnEmptyList() {
        // Given

        when(taskRepository.getAllTasks()).thenReturn(Arrays.asList(task2, task3));

        // When
        List<Task> tasks = taskService.findTasksWithPriority1();

        // Then
        assertTrue(tasks.isEmpty(), "Result is not null");
        name = "findTasksWithPriority1_WhenNoTasksWithPriority1_ShouldReturnEmptyList";
    }


    @Test
    void findTasksForNextDay_WhenTasksExist_ShouldReturnTasksForNextDay() {

        // When
        List<Task> tasks = taskService.findTasksForNextDay();

        assertAll("Tasks",
                () -> assertEquals(2, tasks.size(), "Incorrect number of tasks"),
                () -> assertTrue(tasks.contains(task1), "Task 1 is not present"),
                () -> assertTrue(tasks.contains(task4), "Task 4 is not present")
        );
        name = "findTasksForNextDay_WhenTasksExist_ShouldReturnTasksForNextDay";
    }

    @Test
    void findTasksForNextDay_WhenNoTasksExist_ShouldReturnEmptyList() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Collections.emptyList());

        // When
        List<Task> tasks = taskService.findTasksForNextDay();

        // Then
        assertTrue(tasks.isEmpty(), "Result is not null");
        name = "findTasksForNextDay_WhenNoTasksExist_ShouldReturnEmptyList";
    }


    @Test
    void sortTasksByPriorityDescending_WhenTasksExist_ShouldReturnTasksSortedByPriorityDescending() {

        // When
        List<Task> tasks = taskService.sortTasksByPriorityDescending();

        // Then
        assertAll("Tasks",
                () -> assertEquals(4, tasks.size(), "Incorrect number of tasks"),
                () -> assertEquals(task1, tasks.get(0), "Task 1 does not match"),
                () -> assertEquals(task4, tasks.get(1), "Task 4 does not match"),
                () -> assertEquals(task2, tasks.get(2), "Task 2 does not match"),
                () -> assertEquals(task3, tasks.get(3), "Task 3 does not match")
        );
        name = "sortTasksByPriorityDescending_WhenTasksExist_ShouldReturnTasksSortedByPriorityDescending";
    }

    @Test
    void sortTasksByPriorityDescending_WhenNoTasksExist_ShouldReturnEmptyList() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Collections.emptyList());

        // When
        List<Task> tasks = taskService.sortTasksByPriorityDescending();

        // Then
        assertTrue(tasks.isEmpty(), "Result is not null");
    }


    @Test
    void sortTasksByDate_WhenTasksExist_ShouldReturnTasksSortedByDate() {

        // When
        List<Task> tasks = taskService.sortTasksByDate();

        // Then
        assertAll("Tasks",
                () -> assertEquals(4, tasks.size(), "Incorrect number of tasks"),
                () -> assertEquals(task1, tasks.get(0), "Task 1 does not match"),
                () -> assertEquals(task4, tasks.get(1), "Task 4 does not match"),
                () -> assertEquals(task2, tasks.get(2), "Task 2 does not match"),
                () -> assertEquals(task3, tasks.get(3), "Task 3 does not match")
        );
        name = "sortTasksByDate_WhenTasksExist_ShouldReturnTasksSortedByDate";
    }

    @Test
    void sortTasksByDate_WhenNoTasksExist_ShouldReturnEmptyList() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Collections.emptyList());

        // When
        List<Task> tasks = taskService.sortTasksByDate();

        // Then
        assertTrue(tasks.isEmpty(), "Result is not null");
        name = "sortTasksByDate_WhenNoTasksExist_ShouldReturnEmptyList";
    }


    @Test
    void removeTask_WhenTaskExists_ShouldRemoveTask() {
        // Given

        when(taskRepository.getTaskById(task2.getId())).thenReturn(task2);

        // When
        taskService.removeTask(task2.getId());

        // Then
        verify(taskRepository, times(1)).removeTask(task2);
        name = "removeTask_WhenTaskExists_ShouldRemoveTask";
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
        name = "removeTask_WhenTaskDoesNotExist_ShouldNotRemoveTask";
    }


    @Test
    void findTasksByCategory_WhenTasksExistForCategory_ShouldReturnTasksForCategory() {

        // When
        List<Task> tasks = taskService.findTasksByCategory(Category.WORK);

        // Then
        assertAll("Tasks",
                () -> assertEquals(2, tasks.size(), "Incorrect number of tasks"),
                () -> assertTrue(tasks.contains(task1), "Task 1 is not present"),
                () -> assertTrue(tasks.contains(task4), "Task 4 is not present")
        );
        name = "findTasksByCategory_WhenTasksExistForCategory_ShouldReturnTasksForCategory";
    }

    @Test
    void findTasksByCategory_WhenNoTasksExistForCategory_ShouldReturnEmptyList() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Collections.emptyList());

        // When
        List<Task> tasks = taskService.findTasksByCategory(Category.HOME);

        // Then
        assertTrue(tasks.isEmpty(), "Result is not empty");
        name = "findTasksByCategory_WhenNoTasksExistForCategory_ShouldReturnEmptyList";
    }


    @Test
    void findTasksByDescriptionContains_WhenTasksExistWithMatchingDescription_ShouldReturnMatchingTasks() {

        // When
        List<Task> tasks = taskService.findTasksByDescriptionContains("Task");

        // Then
        assertAll("Tasks",
                () -> assertEquals(4, tasks.size(), "Incorrect number of tasks"),
                () -> assertTrue(tasks.contains(task1), "Task 1 is not present"),
                () -> assertTrue(tasks.contains(task2), "Task 2 is not present"),
                () -> assertTrue(tasks.contains(task3), "Task 3 is not present"),
                () -> assertTrue(tasks.contains(task4), "Task 4 is not present")
        );
        name = "findTasksByDescriptionContains_WhenTasksExistWithMatchingDescription_ShouldReturnMatchingTasks";
    }

    @Test
    void findTasksByDescriptionContains_WhenNoTasksExistWithMatchingDescription_ShouldReturnEmptyList() {

        // When
        List<Task> tasks = taskService.findTasksByDescriptionContains("Work");

        // Then
        assertTrue(tasks.isEmpty(), "Result is not empty");
        name = "findTasksByDescriptionContains_WhenNoTasksExistWithMatchingDescription_ShouldReturnEmptyList";
    }


    @Test
    void findMostUrgentTask_WhenTasksExist_ShouldReturnMostUrgentTask() {

        // When
        Optional<Task> mostUrgentTask = taskService.findMostUrgentTask();

        // Then
        assertAll("Most Urgent Task",
                () -> assertTrue(mostUrgentTask.isPresent(), "Most urgent task is not present"),
                () -> assertEquals(task1, mostUrgentTask.get(), "Most urgent task does not match expected task")
        );
        name = "findMostUrgentTask_WhenTasksExist_ShouldReturnMostUrgentTask";
    }

    @Test
    void findMostUrgentTask_WhenNoTasksExist_ShouldReturnEmptyOptional() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Collections.emptyList());

        // When
        Optional<Task> mostUrgentTask = taskService.findMostUrgentTask();

        // Then
        assertFalse(mostUrgentTask.isPresent(), "Most urgent task is present");
        name = "findMostUrgentTask_WhenNoTasksExist_ShouldReturnEmptyOptional";
    }

    @Test
    void divideTasksByCategory_WhenTasksExist_ShouldReturnTasksDividedByCategory() {

        // When
        Map<Category, List<Task>> dividedTasks = taskService.divideTasksByCategory();

        // Then
        assertAll("Divided Tasks",
                () -> assertNotNull(dividedTasks, "Divided tasks map is null"),
                () -> assertEquals(3, dividedTasks.size(), "Incorrect number of divided categories"),
                () -> assertTrue(dividedTasks.containsKey(Category.WORK), "Category WORK is not present"),
                () -> assertTrue(dividedTasks.containsKey(Category.HOME), "Category HOME is not present"),
                () -> assertTrue(dividedTasks.containsKey(Category.OTHER), "Category OTHER is not present"),
                () -> assertEquals(Arrays.asList(task1, task4), dividedTasks.get(Category.WORK), "Tasks in WORK category do not match"),
                () -> assertEquals(Collections.singletonList(task2), dividedTasks.get(Category.HOME), "Tasks in HOME category do not match"),
                () -> assertEquals(Collections.singletonList(task3), dividedTasks.get(Category.OTHER), "Tasks in OTHER category do not match")
        );
        name = "divideTasksByCategory_WhenTasksExist_ShouldReturnTasksDividedByCategory";
    }

    @Test
    void divideTasksByCategory_WhenNoTasksExist_ShouldReturnEmptyMap() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Collections.emptyList());

        // When
        Map<Category, List<Task>> dividedTasks = taskService.divideTasksByCategory();

        // Then
        assertNotNull(dividedTasks, "Divided tasks map is null");
        assertTrue(dividedTasks.isEmpty(), "Divided tasks map is mot empty");
        name = "divideTasksByCategory_WhenNoTasksExist_ShouldReturnEmptyMap";
    }


    @Test
    void divideTasksByPriority_WhenTasksExist_ShouldReturnTasksDividedByPriority() {

        // When
        Map<Integer, List<Task>> dividedTasks = taskService.divideTasksByPriority();

        // Then
        assertAll("Divided Tasks",
                () -> assertNotNull(dividedTasks, "Divided tasks map is null"),
                () -> assertEquals(3, dividedTasks.size(), "Incorrect number of divided categories"),
                () -> assertTrue(dividedTasks.containsKey(1), "Category 1 is not present"),
                () -> assertTrue(dividedTasks.containsKey(2), "Category 2 is not present"),
                () -> assertTrue(dividedTasks.containsKey(3), "Category 3 is not present"),
                () -> assertEquals(Arrays.asList(task1, task4), dividedTasks.get(1), "Tasks in Category 1 do not match"),
                () -> assertEquals(Collections.singletonList(task2), dividedTasks.get(2), "Tasks in Category 2 do not match"),
                () -> assertEquals(Collections.singletonList(task3), dividedTasks.get(3), "Tasks in Category 3 do not match")
        );
        name = "divideTasksByPriority_WhenTasksExist_ShouldReturnTasksDividedByPriority";
    }

    @Test
    void divideTasksByPriority_WhenNoTasksExist_ShouldReturnEmptyMap() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Collections.emptyList());

        // When
        Map<Integer, List<Task>> dividedTasks = taskService.divideTasksByPriority();

        // Then
        assertNotNull(dividedTasks, "Divided tasks map is null");
        assertTrue(dividedTasks.isEmpty(), "Divided tasks map is mot empty");
        name = "divideTasksByPriority_WhenNoTasksExist_ShouldReturnEmptyMap";
    }


    @Test
    void findHighestPriorityTaskForEachCategory_WhenTasksExist_ShouldReturnHighestPriorityTaskForEachCategory() {

        // When
        Map<Category, Optional<Task>> highestPriorityTasks = taskService.findHighestPriorityTaskForEachCategory();

        // Then
        assertAll("Highest Priority Tasks",
                () -> assertNotNull(highestPriorityTasks, "Highest priority tasks map is null"),
                () -> assertEquals(3, highestPriorityTasks.size(), "Incorrect number of categories with highest priority tasks"),
                () -> assertTrue(highestPriorityTasks.containsKey(Category.WORK), "Category WORK is not present"),
                () -> assertTrue(highestPriorityTasks.containsKey(Category.HOME), "Category HOME is not present"),
                () -> assertTrue(highestPriorityTasks.containsKey(Category.OTHER), "Category OTHER is not present"),
                () -> assertEquals(task1, highestPriorityTasks.get(Category.WORK).orElse(null), "Highest priority task in WORK category does not match"),
                () -> assertEquals(task2, highestPriorityTasks.get(Category.HOME).orElse(null), "Highest priority task in HOME category does not match"),
                () -> assertEquals(task3, highestPriorityTasks.get(Category.OTHER).orElse(null), "Highest priority task in OTHER category does not match")
        );
        name = "findHighestPriorityTaskForEachCategory_WhenTasksExist_ShouldReturnHighestPriorityTaskForEachCategory";
    }

    @Test
    void findHighestPriorityTaskForEachCategory_WhenNoTasksExist_ShouldReturnEmptyMap() {
        // Given
        when(taskRepository.getAllTasks()).thenReturn(Collections.emptyList());

        // When
        Map<Category, Optional<Task>> highestPriorityTasks = taskService.findHighestPriorityTaskForEachCategory();

        // Then
        assertNotNull(highestPriorityTasks, "Divided tasks map is null");
        assertTrue(highestPriorityTasks.isEmpty(), "Divided tasks map is mot empty");
        name = "findHighestPriorityTaskForEachCategory_WhenNoTasksExist_ShouldReturnEmptyMap";

    }

}