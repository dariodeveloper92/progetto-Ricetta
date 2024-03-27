package com.example.testapplicazione.repositories;

import com.example.testapplicazione.entities.Secondo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondoRepository extends JpaRepository<Secondo, Integer> {
    // Eventuali metodi personalizzati possono essere definiti qui, se necessario
}

