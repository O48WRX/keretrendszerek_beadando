package com.ekke.controllers;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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

}
