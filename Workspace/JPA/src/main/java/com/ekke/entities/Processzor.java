package com.ekke.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PROCESSZOR database table.
 * 
 */
@Entity
@NamedQuery(name="Processzor.findAll", query="SELECT p FROM Processzor p")
public class Processzor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int ar;

	private String nev;

	//bi-directional many-to-one association to Rig
	@OneToMany(mappedBy="processzor")
	private List<Rig> rigs;

	public Processzor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAr() {
		return this.ar;
	}

	public void setAr(int ar) {
		this.ar = ar;
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
		rig.setProcesszor(this);

		return rig;
	}

	public Rig removeRig(Rig rig) {
		getRigs().remove(rig);
		rig.setProcesszor(null);

		return rig;
	}

	@Override
	public String toString() {
		return "Processzor [id=" + id + ", ar=" + ar + ", nev=" + nev + "]";
	}
	
	

}