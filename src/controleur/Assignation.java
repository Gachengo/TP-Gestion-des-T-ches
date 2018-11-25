package controleur;

public class Assignation {
	
	private int idTache;
	private String tache;
	private String membre;
	private String dateAssignation;
	private String dateDebut;
	private String dateFin;
	private String etat;
	
	public Assignation(int idTache, String tache, String membre, String dateAssignation, String dateDebut, String dateFin, String etat) {
		
		this.idTache = idTache;
		this.tache  = tache;
		this.membre = membre;
		this.dateAssignation = dateAssignation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etat = etat;
	}
	//=====================================================MUTATEUR======================================
	public int getIdTache() {
		return this.idTache;
	}
	public String getTache() {
		return this.tache;
	}
	public String getMembre() {
		return this.membre;
	}
	public String getDateAssignation() {
		return this.dateAssignation;
	}
	public String getDateDebut() {
		return this.dateDebut;
	}
	public String getDateFin() {
		return this.dateFin;
	}
	public String getEtat() {
		return this.etat;
	}
	//====================================================ACCESSEUR=======================================
	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}
	public void setTache(String tache) {
		this.tache = tache;
	}
	public void setMembre(String membre) {
		this.membre = membre;
	}
	public void setDateAssignation(String dateAssignation) {
		this.dateAssignation = dateAssignation;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
}
