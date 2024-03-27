package com.example.testapplicazione.repositories;

import com.example.testapplicazione.entities.Dolce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DolceRepository extends JpaRepository<Dolce, Integer> {
    // Eventuali metodi personalizzati possono essere definiti qui, se necessario

    // Metodo per l'aggiunta di un nuovo dolce
    Dolce save(Dolce dolce);

    // Metodo per l'eliminazione di un dolce
    void deleteById(Integer id);
}
