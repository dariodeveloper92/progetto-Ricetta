package com.example.testapplicazione.repositories;

import com.example.testapplicazione.entities.RicettaIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RicettaIngredienteRepository extends JpaRepository<RicettaIngrediente, Integer> {
    // Eventuali metodi personalizzati possono essere definiti qui, se necessario
}

