package npcs;

import java.util.ArrayList;

import data.Squad;
import game.Jeu;
import nonActiveClasses.QuestStatus;
import nonActiveClasses.Scroll;
import quest.Quest;

public class NpcDialogueController {
	
	
	private Jeu jeu;
	NPC npc;
	private NpcDialogueDisplay display;
	private int selection;
	private boolean questAvailable;
	private boolean turnInAvailable;
	
	public NpcDialogueController(Jeu jeu, NPC npc) {
		this.jeu = jeu;
		display = new NpcDialogueDisplay();
		reset(npc);
	}
	
	public void reset(NPC npc) {
		selection = 0;
		this.npc = npc;
		questAvailable = isQuestAvailable();
		turnInAvailable = isTurnInAvailable();
		display.resetDisplay(npc.getPortrait(), selection, turnInAvailable, questAvailable);
	}
	
	
	public void scroll(Scroll scroll) {
		switch (scroll) {
			case UP :
				if (selection != 0) {
					selection--;
				}
				display.setSelection(selection);
				break;
			case DOWN :
				if (selection < (4 - (questAvailable ? 0 : 1) - (turnInAvailable ? 0 : 1))) {
					selection++;
				}
				display.setSelection(selection);
				break;
			case CONFIRM :
				switch (selection) {
				case 1 :
					// PLACEHOLDER     jeu.goToNpcLife(?)
					break;
				case 2 :
					if (questAvailable) {
						// PLACEHOLDER jeu.goToNpcQuestList(?)
					} else if (turnInAvailable) {
						// PLACEHOLDER jeu.goToQuestTurnIn(?)
					} else {
						jeu.goToMap();
					}
					break;
				case 3 :
					if (turnInAvailable) {
						// PLACEHOLDER jeu.goToQuestTurnIn(?)
					} else {
						jeu.goToMap();
					}
					break;
				case 4 :
					jeu.goToMap();
					break;
				}
				break;
		}
	}
	
	private boolean isTurnInAvailable() {
		ArrayList<Quest> quests = Squad.getInstance().getQuests();
		for (Quest quest : quests) {
			if (quest.getStatus() == QuestStatus.COMPLETED && quest.getQuestGiver().equals(npc)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isQuestAvailable() {
		ArrayList<Quest> quests = npc.getQuests();
		for (Quest quest : quests) {
			if (quest.getMainQuestNumber() == 0 || quest.getMainQuestNumber() == Squad.getInstance().getMainQuestStage()) {
				return true;
			}
		}
		return false;
	}
	
}