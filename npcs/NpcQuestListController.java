package npcs;

import java.util.ArrayList;

import data.Squad;
import game.Jeu;
import nonActiveClasses.Scroll;
import quest.Quest;

public class NpcQuestListController {
	
	private Jeu jeu;
	private NPC npc;
	private NpcQuestListDisplay display;
	private int selection;
	private ArrayList<Quest> quests;
	private ArrayList<String> questNames;
	
	
	public NpcQuestListController(Jeu jeu, NPC npc) {
		this.jeu = jeu;
		display = new NpcQuestListDisplay();
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
			if (selection < quests.size()) {
				selection++;
			}
			display.setSelection(selection);
			break;
		case CONFIRM :
			if (selection == (quests.size() + 1)) {
				
			}
			break;
		}
	}
	
	
	
	
	private ArrayList<Quest> getQuestList() {
		ArrayList<Quest> toReturn = new ArrayList<Quest>();
		ArrayList<Quest> npcQuests = npc.getQuests();
		for (Quest quest : npcQuests) {
			if (quest.getMainQuestNumber() == 0 || quest.getMainQuestNumber() == Squad.getInstance().getMainQuestStage()) {
				toReturn.add(quest);
			}
		}
		return toReturn;
	}
	
	private void setQuestNames() {
		questNames = new ArrayList<String>();
		for (Quest quest : quests) {
			questNames.add(quest.getQuestName());
		}
	}
	
}