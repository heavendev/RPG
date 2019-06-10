package npcs;

import nonActiveClasses.Display;

public class NpcDialogueDisplay implements Display{
	
	
	private String[] npcPortrait;
	private boolean newQuestAvailable;
	private boolean questTurnIn;
	private int selection;
	
	
	
	public void resetDisplay(String[] npcPortrait, int selection, boolean turnInAvailable, boolean questAvailable) {
		this.npcPortrait = npcPortrait;
		this.selection = selection;
		this.questTurnIn = turnInAvailable;
		this.newQuestAvailable = questAvailable;
	}
	
	
	public void display() {
		
	}
	
	
	public void setSelection(int selection) {
		this.selection = selection;
		display();
	}

}
