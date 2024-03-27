package com.example.testapplicazione.controllers;

import com.example.testapplicazione.entities.Primo;
import com.example.testapplicazione.servicies.PrimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/primi")
public class PrimoController {

    private final PrimoService primoService;

    @Autowired
    public PrimoController(PrimoService primoService) {
        this.primoService = primoService;
    }

    @GetMapping
    public ResponseEntity<List<Primo>> getAllPrimi() {
        List<Primo> primi = primoService.getAllPrimi();
        return new ResponseEntity<>(primi, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Primo> getPrimoById(@PathVariable Long id) {
        Primo primo = primoService.getPrimoById(id);
        return new ResponseEntity<>(primo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Primo> createPrimo(@RequestBody Primo primo) {
        Primo createdPrimo = primoService.createPrimo(primo);
        return new ResponseEntity<>(createdPrimo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrimoById(@PathVariable Long id) {
        primoService.deletePrimoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Primo> updatePrimo(@PathVariable Long id, @RequestBody Primo updatedPrimo) {
        Primo primo = primoService.updatePrimo(id, updatedPrimo);
        return new ResponseEntity<>(primo, HttpStatus.OK);
    }
}

