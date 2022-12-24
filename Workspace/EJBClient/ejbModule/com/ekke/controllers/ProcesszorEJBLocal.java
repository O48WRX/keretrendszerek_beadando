package com.ekke.controllers;

import java.util.List;

import javax.ejb.Local;

import com.ekke.entities.Processzor;

@Local
public interface ProcesszorEJBLocal {
	public List<Processzor> getList();
	public void deleteProcesszor(int id);
	public void updateProcesszor(int id, int ar, String nev);
	public void createProcesszor(int ar, String nev);
}
