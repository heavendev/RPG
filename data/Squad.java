package data;

import java.util.ArrayList;
import java.util.HashMap;

import quest.Quest;

public class Squad {
	
	private static Squad instance;
	private int coorX;
	private int coorY;
	private String currentMap;
	private ArrayList<Quest> quests;
	private int mainQuestStage;
	
	
	
	public static Squad getInstance() {
		if (instance == null) {
			instance = new Squad();
		}
		return instance;
	}
	
	private Squad() {
		quests = new ArrayList<Quest>();
	}
	
	
	
	
	public void setCoordinates(int x, int y, String map) {
		this.coorX = x;
		this.coorY = y;
		this.currentMap = map;
	}
	public void setCoordinates(int x, int y) {
		this.coorX = x;
		this.coorY = y;
	}
	
	public HashMap getCoordinates() {
		HashMap toReturn = new HashMap();
		toReturn.put("x", coorX);
		toReturn.put("y", coorY);
		toReturn.put("map",currentMap);
		return toReturn;
	}
	
	
	
	
	public void addQuest(Quest quest) {
		quests.add(quest);
	}
	public void removeQuest(Quest quest) {
		quests.remove(quest);
	}
	public void setQuests(ArrayList<Quest> quests) {
		this.quests = quests;
	}
	public ArrayList<Quest> getQuests() {
		return quests;
	}
	
	
	
	
	
	public String getCurrentMap() {
		return currentMap;
	}
	public void setCurrentMap(String map) {
		this.currentMap = map;
	}
	public int getMainQuestStage() {
		return mainQuestStage;
	}
	public void setMainQuestStage(int stage) {
		this.mainQuestStage = stage;
	}
	
}