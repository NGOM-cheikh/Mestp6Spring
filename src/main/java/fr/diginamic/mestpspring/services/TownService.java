package fr.diginamic.mestpspring.services;



import fr.diginamic.mestpspring.dao.TownDAO;
import fr.diginamic.mestpspring.entities.Town;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import jakarta.annotation.PostConstruct;
import jakarta.persistence.NoResultException;

import java.util.List;

@Service
public class TownService {

    @Autowired
    TownDAO townDao;

    @PostConstruct
    public void init() {
        townDao.create(new Town("Paris",2133111));
        townDao.create(new Town("Marseille", 873076));
        townDao.create(new Town("Lyon", 522250));
    }


    public List<Town> getAllTowns(){
        return townDao.findAll();
    }

    public Town getTown(Long id) {
        Town result = null;
        try {
            result = townDao.find(id);
        }catch(NoResultException nre) {
        }
        return result;
    }

    public Town getTownByName(String name) {
        Town result = null;
        try {
            result = townDao.findByName(name);
        }catch(NoResultException nre) {
        }
        return result;
    }

    public boolean addTown(Town town) {
        Town result = null;
        try {
            result = townDao.findByName(town.getName());
        } catch (NoResultException nre) {
        }
        if (result!=null) {
            return false;
        }else {
            townDao.create(town);
            return true;
        }
    }
    public boolean updateTown(Town town) {
        Town result = null;
        try {
            result = townDao.find(town.getId());
        } catch (NoResultException nre) {
            return false;
        }
        result.setName(town.getName());
        result.setNbHabitants(town.getNbInhabitants());
        townDao.update(town);
        return true;
    }

    public boolean deleteTown(Long id) {
        Town result = null;
        try {
            result = townDao.find(id);
        } catch (NoResultException nre) {
            return false;
        }
        townDao.deleteById(id);
        return true;
    }
}
