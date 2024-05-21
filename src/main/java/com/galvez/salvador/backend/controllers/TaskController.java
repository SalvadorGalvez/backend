package com.galvez.salvador.backend.controllers;

import com.galvez.salvador.backend.models.Task;
import com.galvez.salvador.backend.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> index() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task show(@PathVariable("id") Long id) {
        return taskService.findById(id);
    }

    @PostMapping
    public Task create(@RequestBody() Task task) {
        return taskService.create(task);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable("id") Long id, @RequestBody() Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        taskService.delete(id);
    }
}
