package com.isa.todo.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Task {
    private String description;
    private Category category;
    private int priority;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dueDate;

    public Task() {}

    public Task(String description, Category category, int priority, LocalDateTime dueDate) {
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

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public boolean validate() {
        boolean isValid = true;
        if (priority < 1 || priority > 5) {
            isValid = false;
        }
        if (dueDate.isBefore(LocalDateTime.now())) {
            isValid = false;
        }
        return isValid;
    }
}
