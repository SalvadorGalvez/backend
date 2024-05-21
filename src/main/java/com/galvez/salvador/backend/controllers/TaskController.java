package com.galvez.salvador.backend.controllers;

import com.galvez.salvador.backend.models.Task;
import com.galvez.salvador.backend.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
@Tag(name = "Tareas", description = "API para gestionar tareas")
@CrossOrigin(origins = "*")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    @Operation(summary = "Obtener la lista de tareas", tags = {"Tareas"})
    public List<Task> index() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener tarea por id", tags = {"Tareas"})
    public Task show(@PathVariable("id") Long id) {
        return taskService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear tarea nueva", tags = {"Tareas"})
    public Task create(@RequestBody() Task task) {
        return taskService.create(task);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar tarea", tags = {"Tareas"})
    public Task update(@PathVariable("id") Long id, @RequestBody() Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar tarea", tags = {"Tareas"})
    public void delete(@PathVariable("id") Long id) {
        taskService.delete(id);
    }
}
