package com.isa.todo.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    @NotEmpty(message = "Description cannot be empty")
    private String description;
    private Category category;
    private int priority;
    @NotNull(message = "Date cannot be empty")
    @Future(message = "Due date must be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    public Task() {
    }

    public Task(String description, Category category, int priority, LocalDate dueDate) {
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
