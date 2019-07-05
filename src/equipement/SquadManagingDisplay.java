package equipement;

import java.util.ArrayList;

import characters.Personnage;
import nonActiveClasses.Scroll;
import data.Squad;
import quest.Quest;

public class SquadManagingDisplay {
	
	private String[] screen= {
			"*********************************************************************************",
			"*                Equipe                  *                          Inventaire             *                  Quêtes                *",
			"*********************************************************************************",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*                                                                                                                                                              *",
			"*********************************************************************************",
			"*                                                                                                                                                              *" };
	// faire mes boutons monter descendre droite gauche echaper retour 
	
	
	public void displayTeam(int selection,  ArrayList<String>perso) {
		for(int i=0; i< perso.size(); i++) {
			screen[4+(3*i)]=insertStringAt(screen[4+(3*i)], perso.get(i),20);	
		}
		screen[4+(3*selection)]=insertStringAt(screen[4+(3*selection)], "->", 17);
		
		displayReset();
	}
	
	private void displayReset() {
		
	}
	
	//public void displayInventory(int selection, )
	// prendre string 
	private String insertStringAt(String baseString, String newString, int at) {
        return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
    }


}