package com.isa.todo.controller;
import com.isa.todo.model.Task;
import com.isa.todo.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TaskController {
    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String taskList(Model model) {
        model.addAttribute("taskList", taskRepository.getAllTasks());
        return "index";
    }
    @GetMapping("/new")
    public String showAddTaskForm(Model model) {
        model.addAttribute("newTask", new Task());
        model.addAttribute("categories", taskRepository.getAllCategories());
        return "addTask";
    }


//    @PostMapping("/new")
//    public String addTask(@ModelAttribute("newTask") @Valid Task task, BindingResult result) {
//        if (result.hasErrors()) {
//            return "new";
//        }
//        taskRepository.addTask(task);
//        return "redirect:/";
//    }
}
