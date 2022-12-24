package com.ekke.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
		// TODO Auto-generated method stub
		//return new ArrayList<Processzor>();
		/*ProcesszorTable pt = new ProcesszorTable();
		return pt.getList(); */
		return em.createNamedQuery("Processzor.findAll", Processzor.class).getResultList();
		
	}

}
