package com.example.testapplicazione.controllers;

import com.example.testapplicazione.entities.Dolce;
import com.example.testapplicazione.servicies.DolceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dolci")
public class DolceController {

    private final DolceService dolceService;

    @Autowired
    public DolceController(DolceService dolceService) {
        this.dolceService = dolceService;
    }

    @GetMapping
    public ResponseEntity<List<Dolce>> getAllDolci() {
        List<Dolce> dolci = dolceService.getAllDolci();
        return new ResponseEntity<>(dolci, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dolce> getDolceById(@PathVariable Long id) {
        Dolce dolce = dolceService.getDolceById(id);
        return new ResponseEntity<>(dolce, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Dolce> createDolce(@RequestBody Dolce dolce) {
        Dolce createdDolce = dolceService.createDolce(dolce);
        return new ResponseEntity<>(createdDolce, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDolce(@PathVariable Long id, @RequestBody Dolce updatedDolce) {
        dolceService.updateDolce(id, updatedDolce);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDolce(@PathVariable Long id) {
        dolceService.deleteDolce(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

