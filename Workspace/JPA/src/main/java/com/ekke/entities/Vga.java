package com.ekke.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the VGA database table.
 * 
 */
@Entity
@NamedQuery(name="Vga.findAll", query="SELECT v FROM Vga v")
public class Vga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nev;

	//bi-directional many-to-one association to Rig
	@OneToMany(mappedBy="vga")
	private List<Rig> rigs;

	public Vga() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNev() {
		return this.nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public List<Rig> getRigs() {
		return this.rigs;
	}

	public void setRigs(List<Rig> rigs) {
		this.rigs = rigs;
	}

	public Rig addRig(Rig rig) {
		getRigs().add(rig);
		rig.setVga(this);

		return rig;
	}

	public Rig removeRig(Rig rig) {
		getRigs().remove(rig);
		rig.setVga(null);

		return rig;
	}

	@Override
	public String toString() {
		return "id=" + id + ", nev=" + nev +"";
	}
	
	

}