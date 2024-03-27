package com.example.testapplicazione.servicies;

import com.example.testapplicazione.entities.RicettaIngrediente;
import com.example.testapplicazione.repositories.RicettaIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RicettaIngredienteService {

    private final RicettaIngredienteRepository ricettaIngredienteRepository;

    @Autowired
    public RicettaIngredienteService(RicettaIngredienteRepository ricettaIngredienteRepository) {
        this.ricettaIngredienteRepository = ricettaIngredienteRepository;
    }

    public List<RicettaIngrediente> getAllRicettaIngredienti() {
        return ricettaIngredienteRepository.findAll();
    }

    public RicettaIngrediente getRicettaIngredienteById(Long id) {
        return ricettaIngredienteRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("RicettaIngrediente non trovato con id: " + id));
    }

    // Altri metodi di servizio possono essere aggiunti qui se necessario
}

