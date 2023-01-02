package com.ekke.controllers;

import java.util.List;

import javax.ejb.Local;

import com.ekke.entities.Processzor;
import com.ekke.entities.Ram;
import com.ekke.entities.Rig;
import com.ekke.entities.Vga;

@Local
public interface RigEJBLocal {
	public List<Rig> getList();
	public void deleteRig(int id);
	public void updateRig(int id, int processor_id, int ram_id, int vga_id);
	public void createRig(int processzo_idr, int ram_id, int vga_id);
}
