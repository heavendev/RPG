package npcs;

import java.util.ArrayList;

import quest.Quest;

public class NPC {
	
	private String name;
	private ArrayList<Quest> quests;
	private String[] portrait;
	
	
	
	public NPC(String name, ArrayList<Quest> quests, String[] portrait) {
		this.name = name;
		this.quests = quests;
		this.portrait = portrait;
	}
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public ArrayList<Quest> getQuests() {
		return quests;
	}
	public String[] getPortrait() {
		return portrait;
	}
	
	
	
}