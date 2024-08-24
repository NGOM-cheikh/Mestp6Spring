



package fr.diginamic.mestpspring.dao;



import fr.diginamic.mestpspring.entities.Town;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.transaction.Transactional;

import java.util.List;


@Service
public class TownDAO extends DAO {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void create(Town town) {
        em.persist(town);
    }

    public List<Town> findAll(){
        TypedQuery<Town> query = em.createQuery("SELECT T FROM Town T",Town.class);
        return query.getResultList();
    }

    public Town find(Long id) {
        return em.find(Town.class, id);
    }

    public Town findByName(String name){
        TypedQuery<Town> query = em.createQuery("SELECT T FROM Town T where T.name=\""+name+"\"",Town.class);
        return query.getSingleResult();
    }

    @Transactional
    public Town update(Town town) {
        return em.merge(town);
    }

    @Transactional
    public void delete(Town town) {
        em.remove(town);
    }
    @Transactional
    public void deleteById(Long id) {
        Town t = em.find(Town.class, id);
        em.remove(t);
    }
}


