package npcs;

import nonActiveClasses.Display;

public class NpcQuestPresentationDisplay implements Display {
	
	private String[] npcPortrait;
	private String[] questPresentation;
	private int selection;
	private String[] leftScreen = {"****************************************",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"*                                       ",
			"****************************************",
			"* entrer = valider, q = selection preced"};
	private String[] rightScreen = {"****************************************",
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
			"               refuser      accepter   *",
			"                                       *",
			"****************************************",
			"ente, d = selection suivante           *"};
	
	
	
	public void reset(String[] npcPortrait, String[] questPresentation, int selection) {
		this.selection = selection;
		this.npcPortrait = npcPortrait;
		this.questPresentation = questPresentation;
		display();
	}
	
	
	public void display() {
		for (int i = 0; i < npcPortrait.length; i++) {
			leftScreen[i+1] = insertStringAt(leftScreen[i+1], npcPortrait[i],1);
		}
		for (int i = 0; i < questPresentation.length; i++) {
			rightScreen[i+2] = insertStringAt(rightScreen[i+2], questPresentation[i], 2);
		}
		if (selection == 1) {
			rightScreen[16] = insertStringAt(rightScreen[16], "->", 13);
		} else {
			rightScreen[16] = insertStringAt(rightScreen[16], "->", 26);
		}
		for (int i = 0; i < 20; i++) {
			System.out.println(leftScreen[i] + rightScreen[i]);
		}
		for (int i = 0; i < npcPortrait.length; i++) {
			leftScreen[i+1] = "*                                       ";
		}
		for (int i = 0; i < questPresentation.length; i++) {
			rightScreen[i+2] = "                                       *";
		}
		rightScreen[16] = "               refuser      acceper    *";
	}
	
	public void setSelection(int selection) {
		this.selection = selection;
		display();
	}
	
	private String insertStringAt(String baseString, String newString, int at) {
		try {
			return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("baseString : " + baseString);
			System.out.println("newString : " + newString);
			System.out.println("at : " + at);
			return null;
		}
	}
	
}