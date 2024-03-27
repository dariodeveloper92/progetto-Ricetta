package com.example.testapplicazione.controllers;

import com.example.testapplicazione.entities.Antipasto;
import com.example.testapplicazione.servicies.AntipastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/antipasti")
public class AntipastoController {

    private final AntipastoService antipastoService;

    @Autowired
    public AntipastoController(AntipastoService antipastoService) {
        this.antipastoService = antipastoService;
    }

    @GetMapping
    public ResponseEntity<List<Antipasto>> getAllAntipasti() {
        List<Antipasto> antipasti = antipastoService.getAllAntipasti();
        return new ResponseEntity<>(antipasti, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Antipasto> getAntipastoById(@PathVariable Long id) {
        Antipasto antipasto = antipastoService.getAntipastoById(id);
        return new ResponseEntity<>(antipasto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Antipasto> createAntipasto(@RequestBody Antipasto antipasto) {
        Antipasto createdAntipasto = antipastoService.createAntipasto(antipasto);
        return new ResponseEntity<>(createdAntipasto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAntipasto(@PathVariable Long id, @RequestBody Antipasto updatedAntipasto) {
        antipastoService.updateAntipasto(id, updatedAntipasto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAntipasto(@PathVariable Long id) {
        antipastoService.deleteAntipasto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

