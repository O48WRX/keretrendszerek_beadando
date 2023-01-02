package com.ekke.controllers;

import java.util.List;

import javax.annotation.processing.Processor;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
	private static EntityManager em = Persistence.createEntityManagerFactory("JPA").createEntityManager();
	
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
	public void updateRig(int id, int processzor_id, int ram_id, int vga_id) {
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		Rig rig = em.find(Rig.class, id);
		Processzor processor = em.find(Processzor.class, processzor_id);
		rig.setProcesszor(processor);
		Ram ram = em.find(Ram.class, ram_id);
		rig.setRam(ram);
		Vga vga = em.find(Vga.class, vga_id);
		rig.setVga(vga);
		em.merge(rig);
		t.commit();
	}

	@Override
	public void createRig(int processzor_id, int ram_id, int vga_id) {
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		Rig rig = new Rig();
		Processzor processzor = em.find(Processzor.class, processzor_id);
		rig.setProcesszor(processzor);
		Ram ram = em.find(Ram.class, ram_id);
		rig.setRam(ram);
		Vga vga = em.find(Vga.class, vga_id);
		rig.setVga(vga);
		
		if(processzor == null || ram == null || vga == null)
			return;
					
		em.persist(rig);
		t.commit();
	}

}
