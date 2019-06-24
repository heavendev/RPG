package npcs;

import java.util.ArrayList;

import nonActiveClasses.Display;

public class NpcNewQuestListDisplay implements Display{
	
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
		display();
	}
	
	public void display() {
		for (int i = 0; i < questNames.size(); i++) {
				screen[2+(2*i)] = insertStringAt(screen[2+(2*i)], questNames.get(i), 10);
			if (i == questNames.size()-1) {
				screen[4+(2*i)] = insertStringAt(screen[4+(4*i)], "back", 10);
			}
		}
		screen[(selection*2)] = insertStringAt(screen[(selection*2)], "->", 7);
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
		return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
	}
	
}