package com.example.testapplicazione.repositories;

import com.example.testapplicazione.entities.Antipasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntipastoRepository extends JpaRepository<Antipasto, Integer> {
    // Metodi personalizzati possono essere definiti qui, se necessario

    // Metodo per l'aggiunta di un nuovo antipasto
    Antipasto save(Antipasto antipasto);

    // Metodo per l'eliminazione di un antipasto
    void deleteById(Integer id);
}
