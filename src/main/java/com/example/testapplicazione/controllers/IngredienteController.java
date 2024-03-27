package com.example.testapplicazione.controllers;

import com.example.testapplicazione.entities.Ingrediente;
import com.example.testapplicazione.servicies.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/ingredienti")
public class IngredienteController {

    private final IngredienteService ingredienteService;

    @Autowired
    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @GetMapping
    public ResponseEntity<List<Ingrediente>> getAllIngredienti() {
        List<Ingrediente> ingredienti = ingredienteService.getAllIngredienti();
        return new ResponseEntity<>(ingredienti, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> getIngredienteById(@PathVariable Long id) {
        Ingrediente ingrediente = ingredienteService.getIngredienteById(id);
        return new ResponseEntity<>(ingrediente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ingrediente> createIngrediente(@RequestBody Ingrediente ingrediente) {
        Ingrediente createdIngrediente = ingredienteService.createIngrediente(ingrediente);
        return new ResponseEntity<>(createdIngrediente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateIngrediente(@PathVariable Long id, @RequestBody Ingrediente updatedIngrediente) {
        ingredienteService.updateIngrediente(id, updatedIngrediente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngrediente(@PathVariable Long id) {
        ingredienteService.deleteIngrediente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

