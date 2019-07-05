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
		return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
	}
	
}