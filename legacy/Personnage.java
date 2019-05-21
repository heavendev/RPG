package legacy;

import java.util.ArrayList;

public abstract class Personnage implements Combat {
	private String nom;
	private boolean avoirPouvoir;
	ArrayList<Equipement> inventaireEquipement = new ArrayList<Equipement>();
	private int nbEpee;
	private int nbArmure;
	private int nbBouclier;

	/* Définir les points de vie, attaque .. par défaut */
	private int Ptv = 100;
	private int Pta = 30;
	private int Ptd = 5;
	private int Ptb;
	private int Vitesse;
	private int Magie;
	private int Resistance;
	private Race race;
	private Metiers metier;
	private Equipement equipement;

	public Personnage(String nom) {
		this.nom = nom;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Metiers getMetier() {
		return metier;
	}

	public void setMetier(Metiers metier) {
		this.metier = metier;
	}

	public Equipement getEquipement() {
		return equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

	public void setPtv(int ptv) {
		Ptv = ptv;
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

	/* Exemple d'utilisation d'un combat pour personnage par défaut */

	public int attaquer(Personnage personnageCible) {
		return (this.Pta - personnageCible.Ptd);
	}

	public boolean Sedefendre(Personnage personnageAttaquant) {
		Ptd -= 5;
		return true;
	}

	public void utiliserPouvoir() {
		setPtv(Ptv += 10);
		avoirPouvoir = false;
	}

	public void addEquipement(Equipement e) {
		if (equipement.getTypeEquipement() == TypeEquipement.EPEE) {
			inventaireEquipement.add(e);
			nbEpee++;
		} else if (equipement.getTypeEquipement() == TypeEquipement.ARMURE) {
			inventaireEquipement.add(e);
			nbArmure++;
		} else if (equipement.getTypeEquipement() == TypeEquipement.BOUCLIER) {
			inventaireEquipement.add(e);
			nbBouclier++;
		}

	}
	
	public String toString(){
        return "Nom du personnage: " + this.nom +
               "Nombre de point de Vie: " + Ptv +
                "Nombre de point d'Attaque: " + Pta+
                       "Nombre de point de defense: " + this.Ptd;
    }
}
