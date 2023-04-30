package com.isa.todo.controller;

import com.isa.todo.model.Category;
import com.isa.todo.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    private List<Task> taskList = new ArrayList<>();

    @GetMapping("/")
    public String showAllTasks(Model model) {
        model.addAttribute("tasks", taskList);
        return "index";
    }

    @GetMapping("/add")
    public String addTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("categories", Category.values());
        return "add-task";
    }

    @PostMapping("/add")
    public String addTaskSubmit(@Valid @ModelAttribute("task") Task task, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", Category.values());
            return "add-task";
        }
        taskList.add(task);
        return "redirect:/";
    }

}
