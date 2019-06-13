package npcs;

import java.util.ArrayList;

import nonActiveClasses.Display;

public class NpcQuestTurnInListDisplay implements Display{
	
	private int selection;
	private ArrayList<String> questNames;
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
			"* entrer = selectionner                                                        *"};
	
	
	public void reset(ArrayList<String> questNames, int selection) {
		this.questNames = questNames;
		this.selection = selection;
		for (int i = 0; i < questNames.size(); i++) {
			System.out.println(questNames.get(i));
		}
		display();
	}
	
	public void display() {
		for (int i = 0; i < questNames.size(); i++) {
			screen[(i*2)+2] = insertStringAt(screen[(i*2)+2], questNames.get(i), 10);
		}
		screen[2+(2*questNames.size())] = insertStringAt(screen[2+(2*questNames.size())], "back", 10);
		screen[selection*2] = insertStringAt(screen[selection*2], "->", 7);
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