package npcs;

import java.util.ArrayList;

import quest.Quest;

public class NPC {
	
	private String name;
	private boolean trader;
	private ArrayList<Quest> quests;
	private String[] portrait;
	private String[] life;
	private String map;
	private int x;
	private int y;
	
	
	
	public NPC(String name, boolean trader, ArrayList<Quest> quests, String[] portrait, String[] life, String map, int x, int y) {
		this.name = name;
		this.trader = trader;
		this.quests = quests;
		this.portrait = portrait;
		this.life = life;
		this.map = map;
		this.x = x;
		this.y = y;
	}
	
	
	public boolean isTrader() {
		return trader;
	}
	public String getMap() {
		return map;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void addQuest(Quest quest) {
		if (quests == null) {
			quests = new ArrayList<Quest>();
		}
		quests.add(quest);
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