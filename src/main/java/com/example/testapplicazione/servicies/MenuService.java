package com.example.testapplicazione.servicies;

import com.example.testapplicazione.entities.Menu;
import com.example.testapplicazione.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Menu non trovato con id: " + id));
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public void deleteMenuById(Long id) {
        menuRepository.deleteById(Math.toIntExact(id));
    }

    public Menu updateMenu(Long id, Menu updatedMenu) {
        Menu existingMenu = getMenuById(id);
        existingMenu.setAntipasto(updatedMenu.getAntipasto());
        existingMenu.setPrimo(updatedMenu.getPrimo());
        existingMenu.setSecondo(updatedMenu.getSecondo());
        existingMenu.setDolce(updatedMenu.getDolce());
        return menuRepository.save(existingMenu);
    }
}

