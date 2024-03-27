package com.example.testapplicazione.servicies;

import com.example.testapplicazione.entities.Antipasto;
import com.example.testapplicazione.repositories.AntipastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AntipastoService {

    private final AntipastoRepository antipastoRepository;

    @Autowired
    public AntipastoService(AntipastoRepository antipastoRepository) {
        this.antipastoRepository = antipastoRepository;
    }

    public List<Antipasto> getAllAntipasti() {
        return antipastoRepository.findAll();
    }

    public Antipasto getAntipastoById(Long id) {
        return antipastoRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Antipasto non trovato con id: " + id));
    }

    public Antipasto createAntipasto(Antipasto antipasto) {
        return antipastoRepository.save(antipasto);
    }

    public void updateAntipasto(Long id, Antipasto updatedAntipasto) {
        if (!antipastoRepository.existsById(Math.toIntExact(id))) {
            throw new RuntimeException("Antipasto non trovato con id: " + id);
        }
        updatedAntipasto.setId(id);
        antipastoRepository.save(updatedAntipasto);
    }

    public void deleteAntipasto(Long id) {
        antipastoRepository.deleteById(Math.toIntExact(id));
    }

}

