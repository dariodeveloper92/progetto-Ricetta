package com.example.testapplicazione.servicies;

import com.example.testapplicazione.entities.Dolce;
import com.example.testapplicazione.repositories.DolceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DolceService {

    private final DolceRepository dolceRepository;

    @Autowired
    public DolceService(DolceRepository dolceRepository) {
        this.dolceRepository = dolceRepository;
    }

    public List<Dolce> getAllDolci() {
        return dolceRepository.findAll();
    }

    public Dolce getDolceById(Long id) {
        return dolceRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Dolce non trovato con id: " + id));
    }

    public Dolce createDolce(Dolce dolce) {
        return dolceRepository.save(dolce);
    }

    public void updateDolce(Long id, Dolce updatedDolce) {
        if (!dolceRepository.existsById(Math.toIntExact(id))) {
            throw new RuntimeException("Dolce non trovato con id: " + id);
        }
        updatedDolce.setId(id);
        dolceRepository.save(updatedDolce);
    }

    public void deleteDolce(Long id) {
        dolceRepository.deleteById(Math.toIntExact(id));
    }
}

