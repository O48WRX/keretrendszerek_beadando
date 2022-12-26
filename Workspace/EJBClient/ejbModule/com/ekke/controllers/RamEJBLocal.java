package com.ekke.controllers;

import java.util.List;

import javax.ejb.Local;

import com.ekke.entities.Ram;

@Local
public interface RamEJBLocal {
	public List<Ram> getList();
	public void deleteRam(int id);
	public void updateRam(int id, String nev);
	public void createRam(String nev);
}
