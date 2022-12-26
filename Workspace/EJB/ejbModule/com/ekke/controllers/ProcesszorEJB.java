package com.ekke.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.ekke.entities.Processzor;

/**
 * Session Bean implementation class ProcesszorEJB
 */
@Stateless(mappedName = "ProcesszorEJB")
@LocalBean
public class ProcesszorEJB implements ProcesszorEJBLocal {

    /**
     * Default constructor. 
     */
    public ProcesszorEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager em;
    
	@Override
	public List<Processzor> getList() {
		return em.createNamedQuery("Processzor.findAll", Processzor.class).getResultList();
	}

	@Override
	public void deleteProcesszor(int id) {
		EntityTransaction t =em.getTransaction();
		t.begin();
		Processzor remProc = em.find(Processzor.class, id);
		em.remove(remProc);
		t.commit();
	}

	@Override
	public void updateProcesszor(int id, int ar, String nev) {
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		Processzor proc = em.find(Processzor.class, id);
		proc.setAr(ar);
		proc.setNev(nev);
		t.commit();
	}

	@Override
	public void createProcesszor(int ar, String nev) {
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		Processzor newProc = new Processzor();
		newProc.setAr(ar);
		newProc.setNev(nev);
		em.persist(newProc);
		t.commit();
	}

}
