package com.ekke.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.ekke.entities.Processzor;
import com.ekke.entities.Vga;

/**
 * Session Bean implementation class vgaEJB
 */
@Stateless(mappedName = "vgaEJB")
@LocalBean
public class vgaEJB implements vgaEJBLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
    EntityManager em;
	
    public vgaEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Vga> getList() {
		return em.createNamedQuery("Vga.findAll", Vga.class).getResultList();
	}

	@Override
	public void deleteVga(int id) {
		EntityTransaction t =em.getTransaction();
		
		t.begin();
		Vga remVga = em.find(Vga.class, id);
		em.remove(remVga);
		t.commit();
	}

	@Override
	public void updateVga(int id, String nev) {
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		Vga vga = em.find(Vga.class, id);
		vga.setNev(nev);
		t.commit();
	}

	@Override
	public void createVga(String nev) {
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		Vga vga = new Vga();
		vga.setNev(nev);
		em.persist(vga);
		t.commit();
	}

}
