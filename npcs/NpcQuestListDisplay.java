package npcs;

import java.util.ArrayList;

import nonActiveClasses.Display;

public class NpcQuestListDisplay implements Display{
	
	private int selection;
	private ArrayList<String> questNames;
	
	
	public void reset(ArrayList<String> questNames, int selection) {
		this.questNames = questNames;
		this.selection = selection;
		display();
	}
	
	
	
	public void display() {
		
	}
	
	
	
	public void setSelection(int selection) {
		this.selection = selection;
		display();
	}
	
}