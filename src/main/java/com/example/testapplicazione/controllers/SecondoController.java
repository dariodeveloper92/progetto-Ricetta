package com.example.testapplicazione.controllers;

import com.example.testapplicazione.entities.Secondo;
import com.example.testapplicazione.servicies.SecondoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/secondi")
public class SecondoController {

    private final SecondoService secondoService;

    @Autowired
    public SecondoController(SecondoService secondoService) {
        this.secondoService = secondoService;
    }

    @GetMapping
    public ResponseEntity<List<Secondo>> getAllSecondi() {
        List<Secondo> secondi = secondoService.getAllSecondi();
        return new ResponseEntity<>(secondi, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Secondo> getSecondoById(@PathVariable Long id) {
        Secondo secondo = secondoService.getSecondoById(id);
        return new ResponseEntity<>(secondo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Secondo> createSecondo(@RequestBody Secondo secondo) {
        Secondo createdSecondo = secondoService.createSecondo(secondo);
        return new ResponseEntity<>(createdSecondo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSecondoById(@PathVariable Long id) {
        secondoService.deleteSecondoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Secondo> updateSecondo(@PathVariable Long id, @RequestBody Secondo updatedSecondo) {
        Secondo secondo = secondoService.updateSecondo(id, updatedSecondo);
        return new ResponseEntity<>(secondo, HttpStatus.OK);
    }
}

