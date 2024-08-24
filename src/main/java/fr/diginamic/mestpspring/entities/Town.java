package fr.diginamic.mestpspring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int nbHabitants;

    // Constructeur par défaut
    public Town() {}

    // Constructeur avec paramètres
    public Town(String name, int nbHabitants) {
        this.name = name;
        this.nbHabitants = nbHabitants;
    }

    // Getters et Setters
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbHabitants() {
        return nbHabitants;
    }

    public void setNbHabitants(int nbHabitants) {
        this.nbHabitants = nbHabitants;
    }

    public int getNbInhabitants() {
        return 0;
    }
}
