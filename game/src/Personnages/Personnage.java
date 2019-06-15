package Personnages;

public class Personnage {
	private String nom;
	private int Ptv = 100;
	private int Pta = 30; 
	private int Ptd = 15;
	private int Ptb;
	private int Vitesse;
	private int Magie;
	private int Resistance;
	private  Categories categories;
	protected Metiers metier;
	private Equipement equipement;
	
	public Personnage(String nom) {
		this.equipement = equipement;
		this.metier= metier;
		this.Vitesse=Vitesse;
		this.Resistance= Resistance;
		this.Magie=Magie;
		this.race= race;
		
	}

	public String getNom() {
		return nom;
	}

	public int getPtv() {
		return Ptv;
	}

	public int getPta() {
		return Pta;
	}

	public int getPtd() {
		return Ptd;
	}

	public int getPtb() {
		return Ptb;
	}

	public int getVitesse() {
		return Vitesse;
	}

	public int getMagie() {
		return Magie;
	}

	public int getResistance() {
		return Resistance;
	}

	public Categories getRace() {
		return categories;
	}

	public Metiers getMetier() {
		return metier;
	}

	public Equipement getEquipement() {
		return equipement;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setRace(Categories categories) {
		this.categories = categories;
	}

	public void setMetier(Metiers metier) {
		this.metier = metier;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	
	

}
