package com.example.testapplicazione.repositories;

import com.example.testapplicazione.entities.Primo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimoRepository extends JpaRepository<Primo, Integer> {
    // Eventuali metodi personalizzati possono essere definiti qui, se necessario

    // Metodo per creare un nuovo primo
    Primo save(Primo primo);

    // Metodo per eliminare un primo
    void deleteById(int id);
}

