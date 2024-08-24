package fr.diginamic.mestpspring.services;

import fr.diginamic.mestpspring.entities.Town;

import java.util.List;

public class TownRepository {
    public List<Town> findAll() {
        return List.of();
    }

    public ScopedValue<Object> findById(int idTown) {
        return null;
    }

    public Town findByName(String name) {
        return null;
    }

    public void deleteById(int idTown) {
    }

    public void save(Town town) {
    }
}
