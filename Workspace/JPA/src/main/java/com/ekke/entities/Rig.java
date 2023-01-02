package com.ekke.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RIG database table.
 * 
 */
@Entity
@NamedQuery(name="Rig.findAll", query="SELECT r FROM Rig r")
public class Rig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Processzor
	@ManyToOne
	@JoinColumn(name="PROC_ID")
	private Processzor processzor;

	//bi-directional many-to-one association to Ram
	@ManyToOne
	@JoinColumn(name="MEM_ID")
	private Ram ram;

	//bi-directional many-to-one association to Vga
	@ManyToOne
	private Vga vga;

	public Rig() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Processzor getProcesszor() {
		return this.processzor;
	}

	public void setProcesszor(Processzor processzor) {
		this.processzor = processzor;
	}

	public Ram getRam() {
		return this.ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public Vga getVga() {
		return this.vga;
	}

	public void setVga(Vga vga) {
		this.vga = vga;
	}

	@Override
	public String toString() {
		return "id=" + id + ", processzor=" + processzor.getId() + ", ram=" + ram.getId() + ", vga=" + vga.getId() +"";
	}
	
	

}