package com.isa.todo.controller;

import com.isa.todo.model.Task;
import com.isa.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;

    }

    @GetMapping("/")
    public String home(Model model) {
        List<Task> tasks = taskService.getAllTasks();
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
        taskService.addTask(task);
        return "redirect:/";
    }


    @GetMapping("/remove/{id}")
    public String deleteTask(@PathVariable("id") String id) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            taskService.removeTask(id);
        }
        return "redirect:/";
    }
}
