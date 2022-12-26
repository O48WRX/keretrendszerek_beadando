package com.ekke.controllers;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class RigEJB
 */
@Stateless(mappedName = "RigEJB")
@LocalBean
public class RigEJB implements RigEJBLocal {

    /**
     * Default constructor. 
     */
    public RigEJB() {
        // TODO Auto-generated constructor stub
    }

}
