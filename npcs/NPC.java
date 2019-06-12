package npcs;

import java.util.ArrayList;

import quest.Quest;

public class NPC {
	
	private String name;
	private ArrayList<Quest> quests;
	private String[] portrait;
	private String[] life;
	
	
	
	public NPC(String name, ArrayList<Quest> quests, String[] portrait, String[] life) {
		this.name = name;
		this.quests = quests;
		this.portrait = portrait;
		this.life = life;
	}
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public ArrayList<Quest> getQuests() {
		return quests;
	}
	public void removeQuest(Quest quest) {
		quests.remove(quest);
	}
	public String[] getPortrait() {
		return portrait;
	}
	public String[] getLife() {
		return life;
	}
	
	
	
	
}