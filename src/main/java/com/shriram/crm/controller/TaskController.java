package com.shriram.crm.controller;

import com.shriram.crm.entity.Task;
import com.shriram.crm.entity.TaskStatus;
import com.shriram.crm.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Task Related APIs", description = "Operations related to TASK management")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    @Operation(
            summary = "Get  ALL TASK by ID",
            description = "Retrieve ALL TASK from the database")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get TASK by ID",
            description = "Retrieve TASK by id from the database")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping
    @Operation(
            summary = "Add  TASK by ID",
            description = "ADD TASK ")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update TASK by ID",
            description = "Update TASK by id from the database")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return ResponseEntity.ok(taskService.updateTask(id, taskDetails));
    }

    @PatchMapping("/{id}/status")
    @Operation(
            summary = "update  TASK status by ID",
            description = "Retrieve TASK by id from the database")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestParam TaskStatus status) {
        return ResponseEntity.ok(taskService.updateTaskStatus(id, status));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "DELETE TASK by ID",
            description = "DELETE TASK by id from the database")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task with ID " + id + " deleted successfully");
    }
}
