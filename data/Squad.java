package data;

import java.util.ArrayList;
import java.util.HashMap;

import characters.CharacterList;
import characters.Personnage;
import quest.Quest;

public class Squad {
	
	private static Squad instance;
	private int coorX;
	private int coorY;
	private String currentMap;
	private ArrayList<Quest> quests;
	private int mainQuestStage;
	private ArrayList<Personnage> personnages;
	private int gold;
	private ArrayList<Equipment> equipment;
	
	
	

	public static Squad getInstance() {
		if (instance == null) {
			instance = new Squad();
		}
		return instance;
	}
	
	private Squad() {
		quests = new ArrayList<Quest>();
		equipment = new ArrayList<Equipment>();
		mainQuestStage = 1;
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
	
	public void addPersonnage(Personnage p) {
		if (personnages == null) {
			personnages = new ArrayList<Personnage>();
		}
		personnages.add(p);
	}
	
	public void removePersonnage(Personnage p) {
		personnages.remove(p);
		CharacterList.getCharacterList().addPersonnage(p);
	}
	
	public void addEquipment(Equipment e) {
		if (equipment == null) {
			equipment = new ArrayList<Equipment>();
		}
		equipment.add(e);
	}
	public void removeEquipment(Equipment e) {
		this.equipment.remove(e);
	}
	
	public void addQuest(Quest quest) {
		quests.add(quest);
	}
	public void removeQuest(Quest quest) {
		quests.remove(quest);
	}
	
	
	public Personnage getPerso(String name) {
		for (Personnage p : personnages) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}
	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}
	public void setQuests(ArrayList<Quest> quests) {
		this.quests = quests;
	}
	public ArrayList<Quest> getQuests() {
		return quests;
	}
	public void setPersonnages(ArrayList<Personnage> personnages) {
		this.personnages = personnages;
	}
	public ArrayList<Personnage> getPersonnages() {
		return personnages;
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
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
}