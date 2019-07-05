package npcs;

import game.Jeu;
import nonActiveClasses.Scroll;

public class NpcLifeController {
	
	private Jeu jeu;
	private NpcLifeDisplay display;
	private NPC npc;
	
	
	
	public NpcLifeController(Jeu jeu, NPC npc) {
		this.jeu = jeu;
		display = new NpcLifeDisplay();
		reset(npc);
	}
	
	public void reset(NPC npc) {
		this.npc = npc;
		display.reset(npc.getLife());
	}
	
	public void scroll(Scroll scroll) {
		switch (scroll) {
		case CONFIRM :
			jeu.goToNpcDialogue(npc);
			break;
		}
	}
	
	
	
	
	
}