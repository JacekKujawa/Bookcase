package com.isa.todo.model;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import javax.validation.constraints.*;

public class Task {

    @NotBlank(message = "Opis nie może być pusty.")
    private String description;

    @NotNull(message = "Kategoria nie może być pusta.")
    private Category category;

    @Min(value = 1, message = "Priorytet musi mieć wartość od 1 do 5.")
    @Max(value = 5, message = "Priorytet musi mieć wartość od 1 do 5.")
    private int priority;

    @NotNull(message = "Termin nie może być pusty.")
    @FutureOrPresent(message = "Termin nie może być z przeszłości.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dueDate;
    public Task() {}

    public Task(String description, Category category, int priority, LocalDate dueDate) {
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.dueDate = dueDate;
    }


}
