package com.isa.todo.controller;

import com.isa.todo.model.Category;
import com.isa.todo.model.Task;
import com.isa.todo.repository.JsonTaskRepository;
import com.isa.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final JsonTaskRepository taskRepository;

    @Autowired
    public TaskController(JsonTaskRepository taskRepository) {
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
//
//    @GetMapping("/delete/{id}")
//    public String deleteTask(@PathVariable("id") Long id) {
//        Task task = taskRepository.getTaskById(id);
//        if (task != null) {
//            taskRepository.removeTask(task);
//        }
//        return "redirect:/";
//    }
}
