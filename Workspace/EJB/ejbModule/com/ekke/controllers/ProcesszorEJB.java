package com.ekke.controllers;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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

}
