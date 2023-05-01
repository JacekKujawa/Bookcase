package com.isa.todo.controller;

import com.isa.todo.model.Task;
import com.isa.todo.repository.JsonTaskRepository;
import com.isa.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class TaskController {
    private final TaskService taskService;

    private final JsonTaskRepository taskRepository;

    @Autowired
    public TaskController(TaskService taskService, JsonTaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Task> tasks = taskRepository.getAllTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("newTask", new Task());
        return "index";
    }

    @GetMapping("/new")
    public String showNewTaskForm(Model model) {
        model.addAttribute("newTask", new Task());
        return "new";
    }

    @PostMapping("/new")
    public String addTask(@ModelAttribute("newTask") @Valid Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "new";
        }
        taskRepository.addTask(task);
        return "redirect:/";
    }
    @PostMapping("/{id}/completed")
    public String markTaskAsCompleted(@PathVariable String id, @RequestParam boolean completed) {

        taskService.markTaskAsCompleted(id, completed);
        return "redirect:/";
    }


    @GetMapping("/remove/{id}")
    public String deleteTask(@PathVariable("id") String id) {
        Task task = taskRepository.getTaskById(id);
        if (task != null) {
            taskRepository.removeTask(task);
        }
        return "redirect:/";
    }
}
