package npcs;

import nonActiveClasses.Display;

public class NpcDialogueDisplay implements Display{
	
	
	private String[] npcPortrait;
	private boolean newQuestAvailable;
	private boolean questTurnIn;
	
	
	
	public void resetDisplay(String[] npcPortrait, int selection, boolean turnInAvailable, boolean questAvailable) {
		this.npcPortrait = npcPortrait;
		this.questTurnIn = turnInAvailable;
		this.newQuestAvailable = questAvailable;
	}
	
	
	public void display() {
		
	}
	
	
	

}
