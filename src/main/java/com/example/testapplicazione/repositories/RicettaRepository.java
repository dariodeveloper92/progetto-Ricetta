package com.example.testapplicazione.repositories;

import com.example.testapplicazione.entities.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RicettaRepository extends JpaRepository<Ricetta, Integer> {
    // Eventuali metodi personalizzati possono essere definiti qui, se necessario

    // Metodo per trovare una ricetta per nome
    Ricetta findByNome(String nome);
}

