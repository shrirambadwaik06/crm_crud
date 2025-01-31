package com.shriram.crm.controller;

import com.shriram.crm.entity.Client;
import com.shriram.crm.service.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Client Related APIs", description = "Operations related to client management")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    @Operation(
            summary = "Get All Clients",
            description = "Retrieve a list of all clients from the database")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
     
    @GetMapping("/{id}")
    @Operation(
            summary = "Get Clients by ID",
            description = "Retrieve clients by id from the database")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping
    @Operation(
            summary = "ADD Clients by ID",
            description = "ADD clients by id from the database")

    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "UPDATE  Clients by ID",
            description = "UPDATE clients by id")

    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        return ResponseEntity.ok(clientService.updateClient(id, clientDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete Clients by ID",
            description = "DELETE clients by id from the database")

    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("Client with ID " + id + " deleted successfully");
    }
}
