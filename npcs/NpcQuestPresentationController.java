package npcs;

import data.Squad;
import game.Jeu;
import nonActiveClasses.QuestStatus;
import nonActiveClasses.Scroll;
import quest.Quest;

public class NpcQuestPresentationController {
	
	private Jeu jeu;
	private NpcQuestPresentationDisplay display;
	private Quest quest;
	private NPC npc;
	private int selection;
	
	
	public NpcQuestPresentationController(Jeu jeu, Quest quest, NPC npc) {
		this.jeu = jeu;
		display = new NpcQuestPresentationDisplay();
		reset(quest,npc);
	}
	
	public void reset(Quest quest, NPC npc) {
		this.npc = npc;
		this.quest = quest;
		selection = 1;
		display.reset(npc.getPortrait(), quest.getQuestPresentation(), selection);
	}
	
	public void scroll(Scroll scroll) {
		switch (scroll) {
			case LEFT :
				if (selection != 1) {
					selection--;
				}
				display.setSelection(selection);
				break;
			case RIGHT :
				if (selection != 2) {
					selection++;
				}
				display.setSelection(selection);
				break;
			case CONFIRM :
				if (selection == 1) {
					jeu.goToNpcQuestList(npc);
				} else {
					quest.setStatus(QuestStatus.ACCEPTED);
					Squad.getInstance().addQuest(quest);
					npc.removeQuest(quest);
					quest.removeGiver();
					jeu.goToQuest(quest);
				}
				break;
		}
	}
	
	
	
	
}