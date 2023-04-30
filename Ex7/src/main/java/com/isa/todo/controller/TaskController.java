package com.isa.todo.controller;

import com.isa.todo.model.Category;
import java.time.LocalDate;
import javax.validation.Valid;

import com.isa.todo.model.Task;
import com.isa.todo.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
    }

    @GetMapping("/new")
    public String getNewTask(Model model) {
        model.addAttribute("task", new Task());
        return "new-task";
    }

    @PostMapping("/new")
    public String postNewTask(@ModelAttribute("task") @Valid Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-task";
        } else {
            taskRepository.save(task);
            return "redirect:/";
        }
    }
}
