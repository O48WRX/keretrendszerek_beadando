package com.ekke.controllers;

import java.util.List;

import javax.ejb.Local;

import com.ekke.entities.Vga;

@Local
public interface vgaEJBLocal {
	public List<Vga> getList();
	public void deleteVga(int id);
	public void updateVga(int id, String nev);
	public void createVga(String nev);
}
