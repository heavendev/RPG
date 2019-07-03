package npcs;

import game.Jeu;
import nonActiveClasses.Scroll;
import quest.Quest;

public class NpcController {
	
	private Jeu jeu;
	private NpcDisplay display;
	private NPC npc;
	private Status status;
	
	
	
	public NpcController(Jeu jeu, NPC npc) {
		this.jeu = jeu;
		reset(npc);
	}
	
	public void reset(NPC npc) {
		this.npc = npc;
	}
	
	
	
	public void scroll(Scroll scroll) {
		switch (status) {
			case DIALOGUE :
				
				break;
			case LIFE :
				
				break;
			case QUEST_LIST :
				
				break;
			case TURN_IN_LIST :
				
				break;
			case QUEST_PRESENTATION :
				
				break;
			case MARKET :
				
				break;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private enum Status {
		DIALOGUE,
		LIFE,
		QUEST_LIST,
		TURN_IN_LIST,
		QUEST_PRESENTATION,
		MARKET;
	}
	
}