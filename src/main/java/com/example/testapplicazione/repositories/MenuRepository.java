package com.example.testapplicazione.repositories;

import com.example.testapplicazione.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    // Eventuali metodi personalizzati possono essere definiti qui, se necessario

    // Metodo per creare un nuovo menu
    Menu save(Menu menu);

    // Metodo per eliminare un menu
    void deleteById(int id);
}

