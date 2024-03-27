package com.example.testapplicazione.controllers;

import com.example.testapplicazione.entities.Ricetta;
import com.example.testapplicazione.response.Response;
import com.example.testapplicazione.servicies.RicettaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class RicettaController {

    private final RicettaService ricettaService;

    @Autowired
    public RicettaController(RicettaService ricettaService) {
        this.ricettaService = ricettaService;
    }

    @RequestMapping(value = "/ricette", method = RequestMethod.GET)
    public ResponseEntity<List<Ricetta>> getAllRicette() {
        List<Ricetta> ricette = ricettaService.getAllRicette();
        return new ResponseEntity<>(ricette, HttpStatus.OK);
    }

    @RequestMapping(value = "/ricette", method = RequestMethod.GET, params = {"id"})
    public ResponseEntity<Ricetta> getRicettaById(@PathVariable Long id) {
        Ricetta ricetta = ricettaService.getRicettaById(id);
        return new ResponseEntity<>(ricetta, HttpStatus.OK);
    }

    @RequestMapping(value = "/nome", method = RequestMethod.GET, params = {"nome"})
    public ResponseEntity<Ricetta> getRicettaByNome(@PathVariable String nome) {
        Ricetta ricetta = ricettaService.getRicettaByNome(nome);
        return new ResponseEntity<>(ricetta, HttpStatus.OK);
    }

    @RequestMapping(value = "/ricette", method = RequestMethod.POST)
    public ResponseEntity<Ricetta> createRicetta(@RequestBody Ricetta ricetta) {
        Ricetta createdRicetta = ricettaService.createRicetta(ricetta);
        return new ResponseEntity<>(createdRicetta, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE, params = {"id"})
    public ResponseEntity<Response> deleteRicettaById(@PathVariable Long id) {
        boolean deleted = ricettaService.deleteRicettaById(id);
        String message;
        HttpStatus status;

        if (deleted) {
            message = "Ricetta " + id + " eliminata correttamente!";
            status = HttpStatus.OK;
        } else {
            message = "Ricetta " + id + " non trovata!";
            status = HttpStatus.NOT_FOUND;
        }

        Response response = new Response(status, message);
        return ResponseEntity.status(status).body(response);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, params = {"id"})
    public ResponseEntity<Ricetta> updateRicetta(@PathVariable Long id, @RequestBody Ricetta updatedRicetta) {
        Ricetta ricetta = ricettaService.updateRicetta(id, updatedRicetta);
        return new ResponseEntity<>(ricetta, HttpStatus.OK);
    }
}

