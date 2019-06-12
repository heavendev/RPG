package npcs;

import nonActiveClasses.Display;

public class NpcLifeDisplay implements Display{
	
	String[] npcLife;
	String[] screen = {"********************************************************************************",
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
			"*                                                  -> Continuer                *",
			"*                                                                              *",
			"********************************************************************************",
			"* entrer = valider                                                             *"};
	
	public void reset(String[] npcLife) {
		this.npcLife = npcLife;
		display();
	}
	
	public void display() {
		for (int i = 0; i < npcLife.length; i++) {
			screen[i+2] = insertStringAt(screen[i+2], npcLife[i], 10);
		}
		for (int i = 0; i < screen.length; i++) {
			System.out.println(screen[i]);
		}
		for (int i = 0; i < npcLife.length; i++) {
			screen[i+2] = "*                                                                              *";
		}
	}
	
	
	
	private String insertStringAt(String baseString, String newString, int at) {
		for (int i = 0; i < newString.length(); i++) {
			baseString = changeCharAt(baseString, at + i, newString.charAt(i));
		}
		return baseString;
	}
	
	private String changeCharAt(String str, int charAt, char replaceBy) {
		String toReturn = "";
		for (int i = 0; i < str.length(); i++) {
			if (i == charAt-1) {
				toReturn = toReturn + replaceBy;
			} else {
				toReturn = toReturn + str.charAt(i);
			}
		}
		return toReturn;
	}
	
}