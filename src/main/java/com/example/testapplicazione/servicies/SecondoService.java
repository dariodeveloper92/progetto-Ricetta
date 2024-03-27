package com.example.testapplicazione.servicies;

import com.example.testapplicazione.entities.Secondo;
import com.example.testapplicazione.repositories.SecondoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondoService {

    private final SecondoRepository secondoRepository;

    @Autowired
    public SecondoService(SecondoRepository secondoRepository) {
        this.secondoRepository = secondoRepository;
    }

    public List<Secondo> getAllSecondi() {
        return secondoRepository.findAll();
    }

    public Secondo getSecondoById(Long id) {
        return secondoRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Secondo piatto non trovato con id: " + id));
    }

    public Secondo createSecondo(Secondo secondo) {
        return secondoRepository.save(secondo);
    }

    public void deleteSecondoById(Long id) {
        secondoRepository.deleteById(Math.toIntExact(id));
    }

    public Secondo updateSecondo(Long id, Secondo updatedSecondo) {
        Secondo existingSecondo = getSecondoById(id);
        existingSecondo.setRicetta(updatedSecondo.getRicetta());
        return secondoRepository.save(existingSecondo);
    }
}

