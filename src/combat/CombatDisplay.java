package combat;

import java.util.ArrayList;

import characters.Ennemy;
import characters.Personnage;;

public class CombatDisplay{
	
	private String[] zonePersoGentil= {"********************", 
			"*                   ",
			"*                   ",
			"*                   ",
			"*                   ",
			"*                   ",
			"*                   ", 
			"*                   ", 
			"*                   ",
			"*                   ",
			"*                   ", 
			"*                   ", 
			"*                   ", 
			"*                   ",
			"*                   ",
			"*                   ",
			"*                   ",
			"*                   ", 
			"********************",
			"*                   *"};
	
	private String[] zonePersoMechant= {"********************", 
			"                    ",
			"                    ",
			"                    ", 
			"                    ",
			"                    ",
			"                    ",
			"                    ",
			"                    ",
			"                    ",
			"                    ",
			"                    ",
			"                    ", 
			"                    ",
			"                    ",
			"                    ",
			"                    ",
			"                    ",
			"********************", 
			"                    "};
	
	private String[] screen= {"****************************************", 
			"                                       *",
			"                                       *",
			"                                       *",
			"                                       *",
			"                                       *",
			"                                       *",
			"                                       *", 
			"                                       *", 
			"                                       *",
			"                                       *",
			"                                       *",
			"                                       *", 
			"                                       *", 
			"                                       *", 
			"                                       *", 
			"                                       *", 
			"                                       *", 
			"****************************************",
			"                                       *"};
	
	// Selectionner actions en fonction du personnage gentil ou méchant
	public void combatPersoChoice(String nom, int selection, ArrayList<Personnage> pGentil,ArrayList<Ennemy> pMechant) {
		getLeftScreenInfos(pGentil,pMechant);
		screen[16] = insertStringAt(screen[16],  "Utiliser pouvoir", 15);
		screen[14] = insertStringAt(screen[14],  "Attaquer", 15);
		screen[4] = insertStringAt(screen[4], "Autour de " + nom, 10);
		screen[6] = insertStringAt(screen[6], "Choisissez votre action", 10);
		screen[14+(2*selection)] = insertStringAt(screen[14+2*selection], "->", 10);
		for(int i= 0; i < screen.length; i++) {
			System.out.println(zonePersoGentil[i] + zonePersoMechant[i] +screen[i]);
		}
		reset();
	}
	
	// Selectionner actions en fonction du personnage mob 
	public void playerActionResolver(String nom, String nomMob, int pntVie, String[] actionText,
			ArrayList<Personnage> pGentil,ArrayList<Ennemy> pMechant) {
		getLeftScreenInfos(pGentil,pMechant);
		for(int i = 0; i < actionText.length ; i++) {
			screen[6 + i] = insertStringAt(screen[6 + i], actionText[i], 5);
		}
		screen[6 + actionText.length + 2] = insertStringAt(screen[6 + actionText.length + 2 ], nom +"inflige" + pntVie + "degats", 10);
		screen[8 + actionText.length + 2] = insertStringAt(screen[8 + actionText.length + 2], "à" + nomMob, 10);
		screen[16] = insertStringAt(screen[16],"-> Continuer", 25);
		
		for(int i= 0; i < screen.length; i++) {
			System.out.println(zonePersoGentil[i] + zonePersoMechant[i] +screen[i]);
		}
		reset();
	}
	
	// TODO à modifier ...
	public void targetChoice(String nom, int selection,ArrayList<Personnage> pGentil,ArrayList<Ennemy> pMechant) {
		getLeftScreenInfos(pGentil,pMechant);
		screen[4] = insertStringAt(screen[4],"Qui allez-vous attaquer? ", 10);
		ArrayList<Ennemy> tmp = new ArrayList<Ennemy>();
		for (Ennemy e : pMechant) {
			if (e.isAlive()) {
				tmp.add(e);
			}
		}
		for (int i = 0; i < tmp.size(); i++) {
			screen[6+(2*i)] = insertStringAt(screen[6+(2*i)], tmp.get(i).getName(), 10);
		}
		screen[6+(2*selection)] = insertStringAt(screen[6+2*selection], "->", 7);
		for(int i= 0; i < screen.length; i++) {
			System.out.println(zonePersoGentil[i] + zonePersoMechant[i] + screen[i]);
		}
		reset();
	}
	
	// Résultat des dégâts d'une personne n sur un autre personnage
	public void ennemyAction(String nom, String nomMechant, int degats, ArrayList<Personnage> pGentil, ArrayList<Ennemy> pMechant) {
		getLeftScreenInfos(pGentil,pMechant);
		screen[6] = insertStringAt(screen[6], nomMechant +"inflige" + degats +"degats", 10);
		screen[8] = insertStringAt(screen[8], "à" + nom, 10);
		screen[10] = insertStringAt(screen[10],"-> Continuer", 20);
		for(int i= 0; i < screen.length; i++) {
			System.out.println(zonePersoGentil[i] + zonePersoMechant[i] +screen[i]);
		}
		reset();
	}
	
	
	public void reset() {
		String[] tmp = {"********************", 
				"*                   ",
				"*                   ",
				"*                   ",
				"*                   ",
				"*                   ",
				"*                   ", 
				"*                   ", 
				"*                   ",
				"*                   ",
				"*                   ", 
				"*                   ", 
				"*                   ", 
				"*                   ",
				"*                   ",
				"*                   ",
				"*                   ",
				"*                   ", 
				"********************",
				"*                  *"};
		zonePersoGentil = tmp;
		String[] tmpTwo = {"********************", 
				"                    ",
				"                    ",
				"                    ", 
				"                    ",
				"                    ",
				"                    ",
				"                    ",
				"                    ",
				"                    ",
				"                    ",
				"                    ",
				"                    ", 
				"                    ",
				"                    ",
				"                    ",
				"                    ",
				"                    ",
				"********************", 
				"                    "};
		zonePersoMechant = tmpTwo;
		String[] tmpThree = {"****************************************", 
				"                                       *",
				"                                       *",
				"                                       *",
				"                                       *",
				"                                       *",
				"                                       *",
				"                                       *", 
				"                                       *", 
				"                                       *",
				"                                       *",
				"                                       *",
				"                                       *", 
				"                                       *", 
				"                                       *", 
				"                                       *", 
				"                                       *", 
				"                                       *", 
				"****************************************",
				"                                       *"};
		screen = tmpThree;
	}
	
	/* faire fonction qui recup nom dans arraylist mechant et gentil, recupere point de vie et point de volonte*/
	 private void getLeftScreenInfos(ArrayList<Personnage> pGentil, ArrayList<Ennemy> pMechant) {
		  for(int i = 0; i < pGentil.size(); i++) {
			  zonePersoGentil[(i*5)+3] = insertStringAt(zonePersoGentil[(i*5)+3], pGentil.get(i).getName(),3);
			  zonePersoGentil[(i*5)+4] = insertStringAt(zonePersoGentil[(i*5)+4], 
					  "PV: " + createPointString(pGentil.get(i).getLifePoints(), pGentil.get(i).getMaxLifePoints()), 3);
			  zonePersoGentil[(i*5)+5] = insertStringAt(zonePersoGentil[(i*5)+5], 
					  "Volonte: " + createPointString(pGentil.get(i).getWillPoints(), pGentil.get(i).getMaxWillPoints()), 3);				  
		  }
		  
		  for(int i = 0; i < pMechant.size();i++) {
			  zonePersoMechant[(i*5)+3] = insertStringAt(zonePersoMechant[((i*5)+3)],pMechant.get(i).getName(),3);
			  zonePersoMechant[(i*5)+4] = insertStringAt(zonePersoMechant[(i*5)+4], 
					  "PV: " + createPointString(pGentil.get(i).getLifePoints(), pMechant.get(i).getMaxLifePoints()), 3);
			  zonePersoMechant[(i*5)+5] = insertStringAt(zonePersoMechant[(i*5)+5], 
					  "Volonte: " + createPointString(pMechant.get(i).getWillPoints(), pMechant.get(i).getMaxWillPoints()), 3);
		  }	  
	 }
	
	 private String createPointString(int p, int pMax) {
		 float nb = (float)p / (float)pMax; 
		 if(nb >= 0.8) {
			 return "*****";
		 }else if (nb >= 0.6){
			 return "****.";
		 }else if (nb >= 0.4){
			 return "***..";
		 }else if(nb >=0.2){
			 return "**...";
		 }else if(nb > 0) {
			 return "*....";
		 }else {
			 return ".....";
		 }
	 }
	
	private String insertStringAt(String baseString, String newString, int at) {
		return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
	}
    
}