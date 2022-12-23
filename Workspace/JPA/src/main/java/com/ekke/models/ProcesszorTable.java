package com.ekke.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ekke.entities.Processzor;

public class ProcesszorTable {
	private EntityManager em;
	
	public ProcesszorTable() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		em = emf.createEntityManager();
	}
	
	public List<Processzor> getList() {
		return em.createNamedQuery("Processzor.findAll", Processzor.class).getResultList();
	}
}
