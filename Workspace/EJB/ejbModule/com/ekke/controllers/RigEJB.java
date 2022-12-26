package com.ekke.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.ekke.entities.Processzor;
import com.ekke.entities.Ram;
import com.ekke.entities.Rig;
import com.ekke.entities.Vga;

/**
 * Session Bean implementation class RigEJB
 */
@Stateless(mappedName = "RigEJB")
@LocalBean
public class RigEJB implements RigEJBLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
    EntityManager em;
	
    public RigEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Rig> getList() {
		return em.createNamedQuery("Rig.findAll", Rig.class).getResultList();
	}

	@Override
	public void deleteRig(int id) {
		EntityTransaction t =em.getTransaction();
		
		t.begin();
		Rig remRig = em.find(Rig.class, id);
		em.remove(remRig);
		t.commit();
	}

	@Override
	public void updateRig(int id, Processzor processzor, Ram ram, Vga vga) {
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		Rig rig = em.find(Rig.class, id);
		rig.setProcesszor(processzor);
		rig.setRam(ram);
		rig.setVga(vga);
		t.commit();
	}

	@Override
	public void createRig(Processzor processzor, Ram ram, Vga vga) {
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		Rig rig = new Rig();
		rig.setProcesszor(processzor);
		rig.setRam(ram);
		rig.setVga(vga);
		em.persist(rig);
		t.commit();
	}

}
