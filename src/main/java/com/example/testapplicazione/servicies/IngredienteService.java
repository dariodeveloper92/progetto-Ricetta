package com.example.testapplicazione.servicies;

import com.example.testapplicazione.entities.Ingrediente;
import com.example.testapplicazione.repositories.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public List<Ingrediente> getAllIngredienti() {
        return ingredienteRepository.findAll();
    }

    public Ingrediente getIngredienteById(Long id) {
        return ingredienteRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Ingrediente non trovato con id: " + id));
    }

    public Ingrediente createIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    public void updateIngrediente(Long id, Ingrediente updatedIngrediente) {
        if (!ingredienteRepository.existsById(Math.toIntExact(id))) {
            throw new RuntimeException("Ingrediente non trovato con id: " + id);
        }
        updatedIngrediente.setId((long) id);
        ingredienteRepository.save(updatedIngrediente);
    }

    public void deleteIngrediente(Long id) {
        ingredienteRepository.deleteById(Math.toIntExact(id));
    }
}

