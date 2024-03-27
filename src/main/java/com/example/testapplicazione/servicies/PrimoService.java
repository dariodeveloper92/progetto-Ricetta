package com.example.testapplicazione.servicies;

import com.example.testapplicazione.entities.Primo;
import com.example.testapplicazione.repositories.PrimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PrimoService {

    private final PrimoRepository primoRepository;

    @Autowired
    public PrimoService(PrimoRepository primoRepository) {
        this.primoRepository = primoRepository;
    }

    public List<Primo> getAllPrimi() {
        return primoRepository.findAll();
    }

    public Primo getPrimoById(Long id) {
        return primoRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Primo non trovato con id: " + id));
    }

    public Primo createPrimo(Primo primo) {
        return primoRepository.save(primo);
    }

    public void deletePrimoById(Long id) {
        primoRepository.deleteById(Math.toIntExact(id));
    }

    public Primo updatePrimo(Long id, Primo updatedPrimo) {
        Primo existingPrimo = getPrimoById(id);
        existingPrimo.setRicetta(updatedPrimo.getRicetta());
        return primoRepository.save(existingPrimo);
    }
}

