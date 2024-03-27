package com.example.testapplicazione.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_antipasto")
    private Antipasto antipasto;

    @ManyToOne
    @JoinColumn(name = "id_primo")
    private Primo primo;

    @ManyToOne
    @JoinColumn(name = "id_secondo")
    private Secondo secondo;

    @ManyToOne
    @JoinColumn(name = "id_dolce")
    private Dolce dolce;

    // costruttore

    public Menu() {
    }

    // getter e setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Antipasto getAntipasto() {
        return antipasto;
    }

    public void setAntipasto(Antipasto antipasto) {
        this.antipasto = antipasto;
    }

    public Primo getPrimo() {
        return primo;
    }

    public void setPrimo(Primo primo) {
        this.primo = primo;
    }

    public Secondo getSecondo() {
        return secondo;
    }

    public void setSecondo(Secondo secondo) {
        this.secondo = secondo;
    }

    public Dolce getDolce() {
        return dolce;
    }

    public void setDolce(Dolce dolce) {
        this.dolce = dolce;
    }
}

