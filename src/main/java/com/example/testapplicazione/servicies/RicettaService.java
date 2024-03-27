package com.example.testapplicazione.servicies;

import com.example.testapplicazione.entities.Ricetta;
import com.example.testapplicazione.repositories.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RicettaService {

    private final RicettaRepository ricettaRepository;

    @Autowired
    public RicettaService(RicettaRepository ricettaRepository) {
        this.ricettaRepository = ricettaRepository;
    }

    public List<Ricetta> getAllRicette() {
        return ricettaRepository.findAll();
    }

    public Ricetta getRicettaById(Long id) {
        return ricettaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Ricetta non trovata con id: " + id));
    }

    public Ricetta getRicettaByNome(String nome) {
        return ricettaRepository.findByNome(nome);
    }

    public Ricetta createRicetta(Ricetta ricetta) {
        return ricettaRepository.save(ricetta);
    }

//    public boolean deleteRicettaById(Long id) {
//        ricettaRepository.deleteById(Math.toIntExact(id));
//        return false;
//    }

    public boolean deleteRicettaById(Long id) {
        Optional<Ricetta> ricettaOptional = ricettaRepository.findById(Math.toIntExact(id));
        if (ricettaOptional.isPresent()) {
            ricettaRepository.deleteById(Math.toIntExact(id));
            return true; // Restituisce true solo se l'eliminazione ha avuto successo
        }
        return false; // Restituisce false se l'ID della ricetta non è presente nel database
    }


    public Ricetta updateRicetta(Long id, Ricetta updatedRicetta) {
        Ricetta existingRicetta = getRicettaById(id);
        existingRicetta.setNome(updatedRicetta.getNome());
        existingRicetta.setProcedimento(updatedRicetta.getProcedimento());
        return ricettaRepository.save(existingRicetta);
    }
}
