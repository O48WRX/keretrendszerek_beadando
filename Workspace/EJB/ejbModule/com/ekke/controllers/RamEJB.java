package com.ekke.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.ekke.entities.Processzor;
import com.ekke.entities.Ram;

/**
 * Session Bean implementation class RamEJB
 */
@Stateless(mappedName = "RamEJB")
@LocalBean
public class RamEJB implements RamEJBLocal {

    /**
     * Default constructor. 
     */
    public RamEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager em;

	@Override
	public List<Ram> getList() {
		return em.createNamedQuery("Ram.findAll", Ram.class).getResultList();
	}

	@Override
	public void deleteRam(int id) {
		EntityTransaction t =em.getTransaction();
		
		t.begin();
		Ram remRam = em.find(Ram.class, id);
		em.remove(remRam);
		t.commit();
	}

	@Override
	public void updateRam(int id, String nev) {
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		Ram ram = em.find(Ram.class, id);
		ram.setNev(nev);
		t.commit();
	}

	@Override
	public void createRam(String nev) {
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		Ram newRam = new Ram();
		newRam.setNev(nev);
		em.persist(newRam);
		t.commit();
	}

}
