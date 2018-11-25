package controleur;

import java.util.Date;

public class Tache {
	
	private int id;
	private String designation;
	private String description;
	private String datedebut;
	private String datefin;
	private String etat;
	
	public Tache(int id, String designation, String description, String datedebut, String datefin, String etat) {
		this.id = id;
		this.designation = designation;
		this.description = description;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.etat = etat;
	}
	//===================================================ACCESSEURS=======================================
	public int getId() {
		return this.id;
	}
	public String getDesignation() {
		return this.designation;
	}
	public String getDescription() {
		return this.description;
	}
	public String getDateDebut() {
		return this.datedebut;
	}
	public String getDateFin() {
		return this.datefin;
	}
	public String getEtat() {
		return this.etat;
	}
	//=================================================MUTATEURS===========================================
	public void setId(int id) {
		
		this.id = id;
	}
	public void setDesignation(String designation) {
		
		this.designation = designation;
	}
	public void setDescription(String description) {
		
		this.description = description;
	}
	public void setDatedebut(String datedebut) {
		
		this.datedebut = datedebut;
	}
	public void setDatefin(String datefin) {
		
		this.datefin = datefin;
	}
	public void setEtat(String etat) {
		
		this.etat = etat;
	}
}
