package com.shriram.crm.controller;

import com.shriram.crm.entity.Developer;
import com.shriram.crm.service.DeveloperService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
@Tag(name = "Developer Related APIs", description = "Operations related to DEVELOPER management")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @GetMapping
    @Operation(
            summary = "Get  all DEVELOPER ",
            description = "Retrieve clients by ")

    public List<Developer> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get DEVELOPER by ID",
            description = "Retrieve DEVELOPER by id from the database")

    public ResponseEntity<Developer> getDeveloperById(@PathVariable Long id) {
        return ResponseEntity.ok(developerService.getDeveloperById(id));
    }

    @PostMapping
    @Operation(
            summary = "Add DEVELOPER by ID",
            description = "Retrieve DEVELOPER by id from the database")

    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer developer) {
        return ResponseEntity.ok(developerService.createDeveloper(developer));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update  DEVELOPER  by ID",
            description = "update  clients ")

    public ResponseEntity<Developer> updateDeveloper(@PathVariable Long id, @RequestBody Developer developerDetails) {
        return ResponseEntity.ok(developerService.updateDeveloper(id, developerDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete DEVELOPER by ID",
            description = "DELETE clients by id from the database")

    public ResponseEntity<String> deleteDeveloper(@PathVariable Long id) {
        developerService.deleteDeveloper(id);
        return ResponseEntity.ok("Developer with ID " + id + " deleted successfully");
    }
}
