package com.galvez.salvador.backend.services;

import com.galvez.salvador.backend.exceptions.ResourceNotFoundException;
import com.galvez.salvador.backend.models.Task;
import com.galvez.salvador.backend.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("La tarea con el id " + id + " no existe."));
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Long id, Task task) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("La tarea con el id " + id + " no existe.");
        }
        task.setId(id);
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
