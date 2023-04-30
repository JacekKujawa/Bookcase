package com.isa.todo.model;
import java.util.ArrayList;
import java.util.List;

import com.isa.todo.repository.TaskRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

    private List<Task> tasks = new ArrayList<>();

    @Override
    public void save(Task task) {
        tasks.add(task);
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }
}
