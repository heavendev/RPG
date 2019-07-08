package npcs;

import java.util.ArrayList;
import java.util.HashMap;

public class NpcDisplay {
	
	private String[] screen = {"********************************************************************************",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"********************************************************************************",
			"* z = monter, s = descrendre, entrer = valider                                 *"};
	
	public void displayDialogue(String[] portrait, int selection, boolean questAvailable, boolean turnInAvailable, boolean isTrader) {
		int tmp = 0;
		screen[2] = insertStringAt(screen[2], "Bonjour!", 50);
		if (questAvailable) { 
			screen[4] = insertStringAt(screen[4], "Available quests!", 50); 
			}
		tmp += (questAvailable ? 1 : 0);
		if (turnInAvailable) { 
			screen[4+(2*tmp)] = insertStringAt(screen[4+(2*tmp)], "Turn in quest", 50); 
			}
		tmp += (turnInAvailable ? 1 : 0);
		if (isTrader) { 
			screen[4+(2*tmp)] = insertStringAt(screen[4+(2*tmp)], "Buy item", 50); 
			screen[6+(2*tmp)] = insertStringAt(screen[6+(2*tmp)], "Sell item", 50); 
			}
		tmp += (isTrader ? 2 : 0);
		screen[4+(2*tmp)] = insertStringAt(screen[4+(2*tmp)], "back", 50);
		screen[2+(2*selection)] = insertStringAt(screen[2+(2*selection)], "->", 47);
		displayAndReset(portrait);
	}
	
	public void displayLife(String[] portrait, String[] life) {
		for (int i = 0; i < life.length; i++) {
			screen[i+2] = insertStringAt(screen[i+2], life[i], 45);
		}
		screen[16] = insertStringAt(screen[16], "-> Continuer", 60);
		displayAndReset(portrait);
	}
	
	public void displayQuestList(String[] portrait, ArrayList<String> questNames, int selection) {
		for (int i = 0; i < questNames.size(); i++) {
			screen[2+(2*i)] = insertStringAt(screen[2+(2*i)], questNames.get(i), 50);
		}
		screen[2+(2*questNames.size())] = insertStringAt(screen[2+(2*selection)], "back", 50);
		screen[2+(2*selection)] = insertStringAt(screen[2+(2*selection)], "->", 47);
		displayAndReset(portrait);
	}
	
	public void displayQuestPresentation(String[] portrait, String[] questPresentation, int selection) {
		for (int i = 0; i < questPresentation.length; i++) {
			screen[2+i] = insertStringAt(screen[2+i], questPresentation[i], 45);
		}
		screen[16] = insertStringAt(screen[16], "Accepter    Refuser", 50);
		screen[16] = insertStringAt(screen[16], "->", 47 + (selection == 0 ? 0 : 12));
		screen[19] = "* q = gauche, d = droite, entrer = valider                                     *";
		displayAndReset(portrait);
	}
	
	public void displayTrade(String[] portrait, String[] itemNames, int selection) {
		if (itemNames.length < 8) {
			for (int i = 0; i < itemNames.length; i++) {
				screen[2+(2*i)] = insertStringAt(screen[2+(2*i)], itemNames[i], 50);
			}
			screen[2+(2*selection)] = insertStringAt(screen[2+(2*selection)], "->", 47);
		} else if (selection < 4) {
			for (int i = 0; i < 7; i++) {
				screen[2+(2*i)] = insertStringAt(screen[2+(2*i)], itemNames[i], 50);
			}
			screen[2+(2*selection)] = insertStringAt(screen[2+(2*selection)], "->", 47);
		} else if (itemNames.length - selection > 3) {
			for (int i = 0; i < 7; i++) {
				screen[2+(2*i)] = insertStringAt(screen[2+(2*i)], itemNames[selection - 3 + i], 50);
			}
			screen[8] = insertStringAt(screen[8], "->", 47);
		} else {
			for (int i = 0; i < 7; i++) {
				screen[2+(2*i)] = insertStringAt(screen[2+(2*i)], itemNames[itemNames.length-7+i], 50);
			}
			screen[2+(2*(selection-itemNames.length+7))] = insertStringAt(screen[2+(2*(selection-itemNames.length+7))], "->", 47);
		}
		screen[19] = "* z = monter, s = descrendre, entrer = valider, echap = retour                 *";
		displayAndReset(portrait);
	}
	
	public void displayItemDetails(HashMap h, int selection, boolean buyingOrSelling) {
		screen[2] = insertStringAt(screen[2], (String) h.get("name"), 10);
		screen[4] = insertStringAt(screen[4], "Modificateur d'attaque : " + h.get("attackBonus"), 20);
		screen[5] = insertStringAt(screen[5], "Modificateur de défence : " + h.get("attackBonus"), 20);
		screen[6] = insertStringAt(screen[6], "Modificateur de magie : " + h.get("attackBonus"), 20);
		screen[7] = insertStringAt(screen[7], "Modificateur de résistance : " + h.get("attackBonus"), 20);
		screen[8] = insertStringAt(screen[8], "Modificateur de vitesse : " + h.get("attackBonus"), 20);
		screen[9] = insertStringAt(screen[9], "Modificateur de point de vie : " + h.get("attackBonus"), 20);
		screen[10] = insertStringAt(screen[10], "Modificateur de points de volonté : " + h.get("attackBonus"), 20);
		screen[12] = insertStringAt(screen[12], "Prix : " + h.get("value"), 20);
		if (buyingOrSelling) {
			screen[14] = insertStringAt(screen[14], "Acheter", 40);
		} else {
			screen[14] = insertStringAt(screen[14], "Vendre", 40);
		}
		screen[16] = insertStringAt(screen[16], "Retour", 40);
		screen[14+(2*selection)] = insertStringAt(screen[14+(2*selection)], "->", 37);
		for (int i = 0; i < screen.length; i++) {
			System.out.println(screen[i]);
		}
		reset();
	}
	
	public void displayItemTradeConfirmation(boolean buyingOrSelling, boolean transactionSuccess, String itemName) {
		if (buyingOrSelling) {
			if (transactionSuccess) {
				screen[2] = insertStringAt(screen[2], "Vous avez acheté " + itemName + "avec succès!", 10);
			} else {
				screen[2] = insertStringAt(screen[2], "Vous n'avez pas assez d'or pour acheter " + itemName, 10);
			}
		} else {
			screen[2] = insertStringAt(screen[2], "Vous avez vendu " + itemName + "avec succès!", 10);
		}
		screen[16] = insertStringAt(screen[16], "-> Continuer", 50);
		for (int i = 0; i < screen.length; i++) {
			System.out.println(screen[i]);
		}
		reset();
	}
	
	private void displayAndReset(String[] portrait) {
		for (int i = 1; i < portrait.length+1; i++) {
			screen[i] = insertStringAt(screen[i], portrait[i-1], 1);
		}
		for (int i = 0; i < screen.length; i++) {
			System.out.println(screen[i]);
		}
		reset();
	}
	
	private void reset() {
		String[] tmp = {"********************************************************************************",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"*                                                                              *",
				"********************************************************************************",
				"* z = monter, s = descrendre, entrer = valider                                 *"};
		screen = tmp;
	}
	
	private String insertStringAt(String baseString, String newString, int at) {
		return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
	}
	
}