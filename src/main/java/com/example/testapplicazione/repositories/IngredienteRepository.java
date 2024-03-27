package com.example.testapplicazione.repositories;

import com.example.testapplicazione.entities.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
    // Eventuali metodi personalizzati possono essere definiti qui, se necessario

    // Metodo per l'aggiunta di un nuovo ingrediente
    Ingrediente save(Ingrediente ingrediente);

    // Metodo per l'eliminazione di un ingrediente
    void deleteById(Integer id);
}
