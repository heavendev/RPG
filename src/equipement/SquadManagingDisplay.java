package equipement;

import java.util.ArrayList;
import java.util.HashMap;

import characters.Personnage;
import nonActiveClasses.QuestStatus;
import nonActiveClasses.Scroll;
import data.Squad;
import quest.Quest;
import data.Equipment;
import data.GameEquipmentList;
import quest.Quest;


public class SquadManagingDisplay {
	
	private String[] screen= {
			"*********************************************************************************",
			"*                Team                  *                          Inventory             *                  Quest              *",
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
		String[]tmp= {
				"*********************************************************************************",
				"*               Team                  *                          Inventory             *                  Quest                       *",
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
		
		screen= tmp;
		}
	
	
	public void displayInventory(int selection,HashMap<String,String>getEquipmentDetails) {
		for(int i=0; i<getEquipmentDetails.size(); i++) {
			screen[4+(3*i)]=insertStringAt(screen[4+(3*i)],getEquipmentDetails.get(i),20);
		}
		screen[4+(3*selection)]=insertStringAt(screen[4+(3*selection)], "->", 24);
		
		displayReset();
	}
	
	public void displayQuest(int selection, QuestStatus status, String questName, String[] questDescription) {
		
		
	}
	
	private String insertStringAt(String baseString, String newString, int at) {
        return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
    }


}