package npcs;

import nonActiveClasses.Display;

public class NpcDialogueDisplay implements Display{
	
	
	private String[] npcPortrait;
	private boolean newQuestAvailable;
	private boolean questTurnIn;
	private int selection;
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
			"*                                                                              *",
			"*                                                                              *",
			"********************************************************************************",
			"* z = monter, s = descrendre, entrer = valider                                 *"};
	
	
	
	public void resetDisplay(String[] npcPortrait, int selection, boolean turnInAvailable, boolean questAvailable) {
		this.npcPortrait = npcPortrait;
		this.selection = selection;
		this.questTurnIn = turnInAvailable;
		this.newQuestAvailable = questAvailable;
		display();
	}
	
	
	public void display() {
		for (int i = 0; i < npcPortrait.length; i++) {
			screen[i+1] = insertStringAt(screen[i+1], npcPortrait[i], 1);
		}
		screen[3] = insertStringAt(screen[3], "Bonjour!", 50);
		if (newQuestAvailable) {
			screen[5] = insertStringAt(screen[5], "Available quests", 50);
		}
		if (questTurnIn && newQuestAvailable) {
			screen[7] = insertStringAt(screen[7], "Turn in quest", 50);
		} else if (questTurnIn) {
			screen[5] = insertStringAt(screen[5], "Turn in quest", 50);
		}
		if (newQuestAvailable && questTurnIn) {
			screen[9] = insertStringAt(screen[9], "Retour", 50);
		} else if (newQuestAvailable || questTurnIn) {
			screen[7] = insertStringAt(screen[7], "Retour", 50);
		} else {
			screen[5] = insertStringAt(screen[5], "Retour", 50);
		}
		screen[(2*selection)+1] = insertStringAt(screen[(2*selection)+1], "->", 47);
		for (int i = 0; i < screen.length; i++) {
			System.out.println(screen[i]);
		}
		for (int i = 0; i < 17; i++) {
			screen[i+1] = "*                                                                              *";
		}
	}
	
	public void setSelection(int selection) {
		this.selection = selection;
		display();
	}
	
	private static String insertStringAt(String baseString, String newString, int at) {
		return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
	}
	
}
