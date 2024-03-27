package com.example.testapplicazione.controllers;

import com.example.testapplicazione.entities.RicettaIngrediente;
import com.example.testapplicazione.servicies.RicettaIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/ricetteIngredienti")
public class RicettaIngredienteController {

    private final RicettaIngredienteService ricettaIngredienteService;

    @Autowired
    public RicettaIngredienteController(RicettaIngredienteService ricettaIngredienteService) {
        this.ricettaIngredienteService = ricettaIngredienteService;
    }

    @GetMapping
    public ResponseEntity<List<RicettaIngrediente>> getAllRicettaIngredienti() {
        List<RicettaIngrediente> ricettaIngredienti = ricettaIngredienteService.getAllRicettaIngredienti();
        return new ResponseEntity<>(ricettaIngredienti, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RicettaIngrediente> getRicettaIngredienteById(@PathVariable Long id) {
        RicettaIngrediente ricettaIngrediente = ricettaIngredienteService.getRicettaIngredienteById(id);
        return new ResponseEntity<>(ricettaIngrediente, HttpStatus.OK);
    }

    // Altri metodi del controller possono essere aggiunti qui se necessario
}

