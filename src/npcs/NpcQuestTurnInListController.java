package npcs;

import java.util.ArrayList;

import data.Squad;
import game.Jeu;
import nonActiveClasses.QuestStatus;
import nonActiveClasses.Scroll;
import quest.Quest;

public class NpcQuestTurnInListController {
	
	private Jeu jeu;
	private NPC npc;
	private NpcQuestTurnInListDisplay display;
	private int selection;
	private ArrayList<Quest> quests;
	private ArrayList<String> questNames;
	
	
	public NpcQuestTurnInListController(Jeu jeu, NPC npc) {
		this.jeu = jeu;
		display = new NpcQuestTurnInListDisplay();
		reset(npc);
	}
	
	public void reset(NPC npc) {
		selection = 1;
		this.npc = npc;
		quests = getQuestList();
		setQuestNames();
		display.reset(questNames, selection);
	}
	
	public void scroll(Scroll scroll) {
		switch (scroll) {
			case UP :
				if (selection != 1) {
					selection--;
				}
				display.setSelection(selection);
				break;
			case DOWN :
				if (selection <= quests.size()) {
					selection++;
				}
				display.setSelection(selection);
				break;
			case CONFIRM :
				if (selection == (quests.size() + 1)) {
					jeu.goToNpcDialogue(npc);
				} else {
					jeu.goToQuest(quests.get(selection-1));
				}
				break;
		}
	}
	
	
	
	
	private ArrayList<Quest> getQuestList() {
		System.out.println("fetching quest list....");
		ArrayList<Quest> toReturn = new ArrayList<Quest>();
		ArrayList<Quest> npcQuests = Squad.getInstance().getQuests();
		for (Quest quest : npcQuests) {
			if (quest.getQuestGiver().equals(npc) && quest.getStatus() == QuestStatus.COMPLETED) {
				toReturn.add(quest);
			}
		}
		return toReturn;
	}
	
	private void setQuestNames() {
		questNames = new ArrayList<String>();
		for (Quest quest : quests) {
			questNames.add(quest.getQuestName());
			System.out.println(quest.getQuestName());
		}
	}
	
}