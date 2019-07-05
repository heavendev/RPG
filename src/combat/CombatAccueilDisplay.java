package combat;

import nonActiveClasses.Display;

public class CombatAccueilDisplay implements Display {
	
	private String[] acceuil = {"********************************************************************************", 
			"*                                                                              *", 
			"*                                                                              *", 
			"*                                                                              *",  
			"*                                                                              *", 
			"*                                                                              *",  
			"*            Vous avez été intercepté par un adversaire                        *",  
			"*                  des forces du mal ... :o                                    *", 
			"*                                                                              *",  
			"*                                                                              *",  
			"*                    Préparez-vous au combat ...                               *",  
			"*                                                                              *",  
			"*                                                                              *",  
			"*                                                                              *", 
			"*                                                                              *", 
			"*                                                                              *", 
			"*                                                 Entrer pour continuer        *", 
			"*                                                                              *", 
			"********************************************************************************", 
			"* z = monter, s = descendre, entrer = valider, echappe = annuler               *"};

	public void display() {
		for (int i = 0; i < acceuil.length; i++) {
			System.out.println(acceuil[i]);
		}
	}
	
	
}
