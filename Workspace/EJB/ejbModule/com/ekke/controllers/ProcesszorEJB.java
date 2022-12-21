package com.ekke.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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

	@Override
	public List<Processzor> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
