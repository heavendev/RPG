package gestion_Equipe;

import java.util.ArrayList;
import java.util.HashMap;
import quest.QuestPageDisplay;
import characters.Personnage;
import nonActiveClasses.QuestStatus;
import nonActiveClasses.Scroll;
import data.Squad;
import quest.Quest;
import data.Equipment;
import data.GameEquipmentList;
import quest.Quest;

public class SquadManagingDisplay {

	private static String[] screen = { 
			"*********************************************************************************",
			"*        Team          *         Inventory         *          Quests            *",
			"*********************************************************************************",
			"*                                                                               *",
			"*                                                                               *",
			"*                                                                               *",
			"*                                                                               *",
			"*                                                                               *",
			"*                                                                               *",
			"*                                                                               *",
			"*                                                                               *",
			"*                                                                               *",
			"*                                                                               *",
			"*                                                                               *",
			"*                                                                               *",
			"*                                                                               *",
			"*                                                                               *",
			"*                                                                               *",
			"*********************************************************************************",
			"*      z=monter, s=desendre, entrer= valider, echap = retour                    *"

	};

	// faire mes boutons monter descendre droite gauche echaper retour
	
	public void displayMenu(int selection) {
		screen[2+(2*selection)]=insertStringAt(screen[2+(2*selection)], "->", 6);
		
		screen[16]="*q= gauche, d= droite, entrer = valider, echap = retour*";
		
		displayAndReset(screen);
	}

	public void displayTeam(int selection, String[] perso) {
		for (int i = 0; i < perso.length; i++) {
			screen[4 + (3 * i)] = insertStringAt(screen[4 + (3 * i)], perso[i], 20);
		}
		screen[4 + (3 * selection)] = insertStringAt(screen[4 + (3 * selection)], "->", 17);

		displayAndReset(screen);
	}
	
	public void displayCharactersTeamDdetails(int selection, HashMap p, Personnage name) {
		boolean isMainChar= true;
		screen[2] = insertStringAt(screen[2], (String) p.get("name"), 20);
		screen[4] = insertStringAt(screen[4], (String) p.get("attack"), 20);
		screen[5] = insertStringAt(screen[5], (String) p.get("defence"), 20);
		screen[6] = insertStringAt(screen[6], (String) p.get("magic"), 20);
		screen[7] = insertStringAt(screen[7], (String) p.get("resistance"), 20);
		screen[8] = insertStringAt(screen[8], (String) p.get("speed"), 20);
		screen[9] = insertStringAt(screen[9], (String) p.get("lifePoints"), 20);
		screen[10] = insertStringAt(screen[10], (String) p.get("willPoints"), 20);
		if (!isMainChar) {
			screen[14]=insertStringAt(screen[14],"remove",35);
		}
		screen[12]= insertStringAt(screen[12], "back",35);
		screen[12+(2*selection)]=insertStringAt(screen[12+(2*selection)], "->",30);
		displayAndReset(screen);	
	}

	void reset() {
		String[] tmp = { 
				"*********************************************************************************",
				"*       Equipe          *         Inventaire          *          Quêtes         *",
				"*********************************************************************************",
				"*                                                                               *",
				"*                                                                               *",
				"*                                                                               *",
				"*                                                                               *",
				"*                                                                               *",
				"*                                                                               *",
				"*                                                                               *",
				"*                                                                               *",
				"*                                                                               *",
				"*                                                                               *",
				"*                                                                               *",
				"*                                                                               *",
				"*                                                                               *",
				"*                                                                               *",
				"*                                                                                *",
				"*                                                                               *",
				"*********************************************************************************",
				"*      z= monter, s= descendre, entrer= valider  echap=retour                   *" };

		screen = tmp;
	}

	
	
	
	public void displayInventory(int selection, String[] getEquipmentTeam, String[] equipmentOwner) {
		if (getEquipmentTeam.length < 8) {
			for (int i = 0; i < getEquipmentTeam.length; i++) {
				screen[4 + (2 * i)] = insertStringAt(screen[4 + (2 * i)],
						getEquipmentTeam[i] + "(" + equipmentOwner[i] + ")", 20);
			}
			screen[4 + (2 * selection)] = insertStringAt(screen[4 + (2 * selection)], "->", 17);
		} else if (selection < 4) {
			for (int i = 0; i < 7; i++) {
				screen[4 + (2 * i)] = insertStringAt(screen[4 + (2 * i)], getEquipmentTeam[i] + "(" + equipmentOwner[i],
						20);
			}
			screen[4 + (2 * selection)] = insertStringAt(screen[4 + (2 * selection)], "->", 17);
		} else if (getEquipmentTeam.length - selection > 3) {
			for (int i = 0; i < 7; i++) {
				screen[4 + (2 * i)] = insertStringAt(screen[4 + (2 * i)], getEquipmentTeam[i] + "(" + equipmentOwner[i],
						20);
			}
			screen[8] = insertStringAt(screen[8], "->", 17);
		} else {
			for (int i = 0; i < 7; i++) {
				screen[4 + (2 * i)] = insertStringAt(screen[4 + (2 * i)],
						getEquipmentTeam[getEquipmentTeam.length - 7 + i] + "(" + equipmentOwner.length + ")", 20);
			}
			screen[4 + (2 * (selection - getEquipmentTeam.length + 7))] = insertStringAt(
					screen[2 + (2 * (selection - getEquipmentTeam.length + 7))] + "(" + equipmentOwner.length + ")",
					"->", 17);
		}
		screen[16] = "*z=monter, s =descendre, entrer= valider, echap = retour*";
		displayAndReset(screen);
	}
	
	public void displayTeamEquipmentDetails(int selection, HashMap h, boolean equiped) {
		screen[2] = insertStringAt(screen[2], (String) h.get("equipmentOwner"), 20);
		screen[4] = insertStringAt(screen[4], (String) h.get("attackBonus"), 20);
		screen[5] = insertStringAt(screen[5], (String) h.get("defenceBonus"), 20);
		screen[6] = insertStringAt(screen[6], (String) h.get("magicBonus"), 20);
		screen[7] = insertStringAt(screen[7], (String) h.get("resistanceBonus"), 20);
		screen[8] = insertStringAt(screen[8], (String) h.get("speedBonus"), 20);
		screen[9] = insertStringAt(screen[9], (String) h.get("lifePointsBonus"), 20);
		screen[10] = insertStringAt(screen[10], (String) h.get("willPointsBonus"), 20);
		screen[11] = insertStringAt(screen[11], (String) h.get("value"), 20);

		if (equiped) {
			screen[14] = insertStringAt(screen[14], "unequip", 40);
		} else { 
			screen[14] = insertStringAt(screen[14], "equip", 40);
		}
			screen[16] = insertStringAt(screen[16], "back", 40);
			screen[14 + (2 * selection)] = insertStringAt(screen[14 + (2 * selection)], "->", 37);
		displayAndReset(screen);
	}

	public void displayCharacterChoiceForEquipment(String [] perso, int selection) {
		screen[4]=insertStringAt(screen[4], "Choisissez le personnage que vous voulez equiper",20);
		for(int i=0; i<perso.length; i++) {
			screen[6+(3*i)]= insertStringAt(screen[6+(3*i)], perso[i],20);	
		}
		screen[6+(3*selection)]=insertStringAt(screen[6+(3*selection)],"->",17);
		screen[6+(3*perso.length)] = insertStringAt(screen[6+(3*perso.length)], "retour", 20);
		displayAndReset(screen);
	}

	private void displayAndReset(String[] screen) {
		for (int i = 0; i < screen.length; i++) {
			System.out.println(screen[i]);
		}
		reset();
	}

	public void displayQuest(int selection, String[] questName) {
		if (questName.length < 8) {
			for (int i = 0; i < questName.length; i++) {
				screen[4 + (2 * i)] = insertStringAt(screen[4 + (2 * i)], questName[i], 30);
			}

			screen[4 + (2 * selection)] = insertStringAt(screen[4 + (2 * selection)], "->", 27);
		} else if (selection < 4) {
			for (int i = 0; i < 7; i++) {
				screen[2 + (2 * i)] = insertStringAt(screen[4 + (2 * i)], questName[i], 30);
			}
			screen[4 + (2 * selection)] = insertStringAt(screen[4 + (2 * selection)], "->", 27);
		} else if (questName.length - selection > 3) {
			for (int i = 0; i < 7; i++) {
				screen[4 + (2 * i)] = insertStringAt(screen[4 + (2 * i)], questName[selection - 3 + i], 30);
			}
			screen[8] = insertStringAt(screen[8], "->", 27);
		} else {
			for (int i = 0; i < 7; i++) {
				screen[4 + (2 * i)] = insertStringAt(screen[2 + (2 * i)], questName[questName.length - 7 + i], 30);
			}
			screen[4 + (2 * (selection - questName.length + 7))] = insertStringAt(
					screen[4 + (2 * (selection - questName.length + 7))], "->", 47);
		}

		screen[16] = "* Z=monter, s= descendre, entrer= valider, echap = retour";

		displayAndReset(screen);

	}

	public void displayQuestDetails(QuestStatus status, String questName, String[] questDetails) {
		screen[4] = insertStringAt(screen[4], questName, 10);
		screen[6] = insertStringAt(screen[4], "" + status, 10);
		for (int i = 0; i < questDetails.length; i++) {
			screen[4+i] = insertStringAt(screen[4+i], questDetails[i], 40);
		}
		displayAndReset(screen);
	}

	private String insertStringAt(String baseString, String newString, int at) {
		return (baseString.substring(0, at) + newString + baseString.substring(newString.length() + at));
	}
	// this.questObjectiveReached = questObjectiveReached;
	
	public static String[] getScreen() {
		return screen;
		
		
	}
}
