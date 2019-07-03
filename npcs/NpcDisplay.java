package npcs;

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
			screen[4+(2*tmp)] = insertStringAt(screen[4+(2*tmp)], "Trade", 50); 
			}
		tmp += (isTrader ? 1 : 0);
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
	
	public void displayQuestList(String[] portrait, String[] names, int selection) {
		for (int i = 0; i < names.length; i++) {
			screen[2+(2*i)] = insertStringAt(screen[2+(2*i)], names[i], 50);
		}
		screen[2+(2*selection)] = insertStringAt(screen[2+(2*selection)], "->", 47);
		displayAndReset(portrait);
	}
	
	public void questPresentation(String[] portrait, String[] questPresentation, int selection) {
		for (int i = 0; i < questPresentation.length; i++) {
			screen[2+i] = insertStringAt(screen[2+i], questPresentation[i], 45);
		}
		screen[16] = insertStringAt(screen[16], "Accepter    Refuser", 50);
		screen[16] = insertStringAt(screen[16], "->", 47 + (selection == 0 ? 0 : 12));
		displayAndReset(portrait);
	}
	
	
	private void displayAndReset(String[] portrait) {
		for (int i = 1; i < 18; i++) {
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
