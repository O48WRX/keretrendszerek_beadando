package com.ekke.controllers;

import java.util.List;

import javax.ejb.Local;

import com.ekke.entities.Processzor;

@Local
public interface ProcesszorEJBLocal {
	public List<Processzor> getList();
}
