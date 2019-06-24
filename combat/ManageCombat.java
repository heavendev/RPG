package combat;

import java.util.ArrayList;

import characters.Personnage;

public class ManageCombat {

	boolean finCombat = false;
	ArrayList<Personnage> PersoGentil = new ArrayList<Personnage>();

	ArrayList<Personnage> PersoMechant = new ArrayList<Personnage>();

	/* Parcourir la liste pour pouvoir comparer les vitesses */

	/* PersoGentil , PersoMechant */

	public void jouerCombat(Personnage personnage1, Personnage personnage2) {

		int degat1 = 0;
		int degat2 = 0;
		int objet1 = 0;
		int objet2 = 0;
		int choix1 = 0;
		int choix2 = 0;

//		startCombat();

		// TODO créer une fonction choix pour personnage1 ou personnage2

		switch (choix1) {
		case 1:
			degat1 = personnage1.attaquer(personnage2);
			break;
		case 2:
			// Utiliser un objet contre une personne
			objet1 = personnage1.utiliserObjet(personnage2);
			break;
		case 3:
			// Attaque défensive
			personnage1.utiliserPouvoir();
		case 4: 
			personnage1.utiliserObjet();
		case 5: 
			// Attaque offensive
			personnage1.utiliserPouvoir(personnage2);
			break;
		default:
			break;
		}

		switch (choix2) {
		case 1:
			degat2 = personnage2.attaquer(personnage1);
			break;
		case 2:
			// utiliser un objet contre une personne
			objet2 = personnage2.utiliserObjet(personnage1);
			break;
		case 3:
			//Attaque défensive
			personnage2.utiliserPouvoir();
		case 4: 
			personnage2.utiliserObjet();
		case 5: 
			// Attaque offensive
			personnage2.utiliserPouvoir(personnage1);
		default:
			break;
		}
	}

	public int choiseAction(Personnage personnage){
		int choix = 0;
		
		return 0;
		
	}
//	public void startCombat() {
//
//		while (!checkEndFight()) {
//			if (PersoGentil.size() > 1) {
//				for (Personnage p : PersoGentil) { // Trier les perso par vitesse
//					Collections.sort(PersoGentil, (p1, p2) -> p1.getPtv() - (p2.getPtv()));
//				}
//			}
//			if (PersoMechant.size() > 1) {
//				for (Personnage p : PersoMechant) {
//					Collections.sort(PersoMechant, (p1, p2) -> p1.getPtv() - (p2.getPtv()));
//				}
//			}
//
//		}
//	}

	public boolean checkEndFight() {
		boolean verif = true;
		boolean verif2 = true;
		for (Personnage p : PersoGentil) {
			if (p.getLifePoints()> 0) {
				verif = false;
				break;
			}
		}
		for (Personnage p : PersoMechant) {
			if (p.getLifePoints() > 0) {
				verif2 = false;
				break;
			}
		}
		if (!verif && !verif2) {
			return false;
		}
		return true;
	}
}