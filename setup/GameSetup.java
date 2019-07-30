package setup;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import characters.CharacterList;
import characters.Ennemy;
import characters.EnnemyList;
import characters.Personnage;
import data.Equipment;
import data.EquipmentList;
import data.Squad;
import nonActiveClasses.QuestStatus;
import npcs.NPC;
import npcs.NPCList;
import quest.Quest;

public class GameSetup {
	
	private static GameSetup instance;
	
	public static GameSetup getGameSetup() {
		if (instance == null) {
			instance = new GameSetup();
		}
		return instance;
	}
	
	private GameSetup() { }
	
	
	
	public void getSave(int save) throws SQLException {
		
		DataHandler handler = DataHandler.getDataHandler();
		createEquipment(handler.getEquipment(save));
		createNPCs(handler.getNPCs(save));
		int squadID = createSquad(handler.getSquad(save));
		createCharacters(handler.getCharacters(save));
		giveEquipmentToSquad(handler.getSquadEquipment(squadID));
		createQuests(handler.getQuests(save));
		
	}
	
	
	private void createEquipment(ArrayList<HashMap> ar) {
		EquipmentList list = EquipmentList.getInstance();
		for (HashMap hm : ar) {
			Equipment e = new Equipment((String)hm.get("name"),
					(Integer)hm.get("attack"),
					(Integer)hm.get("defence"),
					(Integer)hm.get("magic"),
					(Integer)hm.get("resistance"),
					(Integer)hm.get("speed"),
					(Integer)hm.get("healthPoints"),
					(Integer)hm.get("willPoints"),
					(Integer)hm.get("value"));
			list.addEquipment(e);
		}
	}
	
	private void createNPCs(ArrayList<HashMap> ar) {
		NPCList list = NPCList.getNPCList();
		for (HashMap hm : ar) {
			NPC npc = new NPC((String)hm.get("name"),
					(boolean)hm.get("trader"),  
					hashmapArraylistToStringArray((ArrayList<HashMap>) hm.get("portrait")), 
					hashmapArraylistToStringArray((ArrayList<HashMap>) hm.get("life")), 
					(String)hm.get("map"), 
					(int)hm.get("x"), 
					(int)hm.get("y"));
			if ((boolean) hm.get("isActive")) {
				list.addActiveNPC(npc);
			} else {
				list.addInactiveNPC(npc);
			}
		}
	}
	
	private int createSquad(HashMap hm) {
		Squad squad = Squad.getInstance();
		squad.setCoordinates((int)hm.get("x"), (int)hm.get("y"), (String)hm.get("map"));
		squad.setMainQuestStage((int)hm.get("questStage"));
		squad.setGold((int)hm.get("gold"));
		return (int) hm.get("squadID");
	}
	
	private void createCharacters(HashMap<String, ArrayList<HashMap>> hm) {
		EnnemyList eList = EnnemyList.getEnnemyList();
		CharacterList cList = CharacterList.getCharacterList();
		Squad squad = Squad.getInstance();
		for (HashMap h : hm.get("boss")) {
			HashMap<String,ArrayList<ArrayList<HashMap>>> tmp = (HashMap<String, ArrayList<ArrayList<HashMap>>>) h.get("sentences");
			ArrayList<String[]> attack = new ArrayList<String[]>();
			ArrayList<String[]> criticalHit = new ArrayList<String[]>();
			ArrayList<String[]> magic = new ArrayList<String[]>();
			ArrayList<String[]> magicCriticalHit = new ArrayList<String[]>();
			for (ArrayList al : tmp.get("attack")) {
				attack.add(hashmapArraylistToStringArray(al));
			}
			for (ArrayList al : tmp.get("criticalHit")) {
				criticalHit.add(hashmapArraylistToStringArray(al));
			}
			for (ArrayList al : tmp.get("magic")) {
				magic.add(hashmapArraylistToStringArray(al));
			}
			for (ArrayList al : tmp.get("magicCriticalHit")) {
				magicCriticalHit.add(hashmapArraylistToStringArray(al));
			}
			Ennemy e = new Ennemy((String)h.get("name"),
					(int)h.get("level"),
					(int)h.get("xp"), 
					"Boss", 
					attack, 
					criticalHit, 
					magic, 
					magicCriticalHit);
			ArrayList<HashMap> t = (ArrayList<HashMap>) h.get("equipment");
			for (HashMap eh : t) {
				if ((boolean) eh.get("isForLoot")) {
					e.addLoot((Equipment)((EquipmentList.getInstance().getEquipment((String)eh.get("equipmentName"))).clone()));
				} else {
					(EquipmentList.getInstance().getEquipment((String)eh.get("equipmentName"))).clone().equip(e);
				}
			}
			eList.addBoss(e);
		}
		for (HashMap h : hm.get("ennemies")) {
			HashMap<String,ArrayList<ArrayList<HashMap>>> tmp = (HashMap<String, ArrayList<ArrayList<HashMap>>>) h.get("sentences");
			ArrayList<String[]> attack = new ArrayList<String[]>();
			ArrayList<String[]> criticalHit = new ArrayList<String[]>();
			ArrayList<String[]> magic = new ArrayList<String[]>();
			ArrayList<String[]> magicCriticalHit = new ArrayList<String[]>();
			for (ArrayList al : tmp.get("attack")) {
				attack.add(hashmapArraylistToStringArray(al));
			}
			for (ArrayList al : tmp.get("criticalHit")) {
				criticalHit.add(hashmapArraylistToStringArray(al));
			}
			for (ArrayList al : tmp.get("magic")) {
				magic.add(hashmapArraylistToStringArray(al));
			}
			for (ArrayList al : tmp.get("magicCriticalHit")) {
				magicCriticalHit.add(hashmapArraylistToStringArray(al));
			}
			Ennemy e = new Ennemy((String)h.get("name"),
					(int)h.get("level"),
					(int)h.get("xp"), 
					"Canaille", 
					attack, 
					criticalHit, 
					magic, 
					magicCriticalHit);
			ArrayList<HashMap> t = (ArrayList<HashMap>) h.get("equipment");
			for (HashMap eh : t) {
				if ((boolean) eh.get("isForLoot")) {
					e.addLoot((Equipment)((EquipmentList.getInstance().getEquipment((String)eh.get("equipmentName"))).clone()));
				} else {
					(EquipmentList.getInstance().getEquipment((String)eh.get("equipmentName"))).clone().equip(e);
				}
			}
			eList.addEnnemy(e);
		}
		for (HashMap h : hm.get("goodGuys")) {
			HashMap<String,ArrayList<ArrayList<HashMap>>> tmp = (HashMap<String, ArrayList<ArrayList<HashMap>>>) h.get("sentences");
			ArrayList<String[]> attack = new ArrayList<String[]>();
			ArrayList<String[]> criticalHit = new ArrayList<String[]>();
			ArrayList<String[]> magic = new ArrayList<String[]>();
			ArrayList<String[]> magicCriticalHit = new ArrayList<String[]>();
			for (ArrayList al : tmp.get("attack")) {
				attack.add(hashmapArraylistToStringArray(al));
			}
			for (ArrayList al : tmp.get("criticalHit")) {
				criticalHit.add(hashmapArraylistToStringArray(al));
			}
			for (ArrayList al : tmp.get("magic")) {
				magic.add(hashmapArraylistToStringArray(al));
			}
			for (ArrayList al : tmp.get("magicCriticalHit")) {
				magicCriticalHit.add(hashmapArraylistToStringArray(al));
			}
			Personnage e = new Personnage((String)h.get("name"),
					(int)h.get("level"),
					(int)h.get("xp"), 
					(String)h.get("classe"), 
					attack, 
					criticalHit, 
					magic, 
					magicCriticalHit);
			cList.addPersonnage(e);
			if ((boolean) h.get("isInSquad")) {
				Squad.getInstance().addPersonnage(e);
			}
		}
	}
	
	private void giveEquipmentToSquad(ArrayList<HashMap<String,String>> ar) {
		for (HashMap<String,String> hm : ar) {
			String owner = hm.get("owner");
			String equipmentName = hm.get("equipmentName");
			Equipment e = EquipmentList.getInstance().getEquipment(equipmentName).clone();
			Squad.getInstance().addEquipment(e);
			if (owner != "" && owner != null) {
				Squad.getInstance().getPerso(owner).addEquipment(e);
			}
		}
	}
	
	private void createQuests(ArrayList<HashMap> ar) {
		for (HashMap h : ar) {
			String s = (String) h.get("status");
			QuestStatus qs = null;
			switch(s) {
				case "notTaken" :
					qs = QuestStatus.NOT_TAKEN;
					break;
				case "accepted" :
					qs = QuestStatus.ACCEPTED;
					break;
				case "ongoing" :
					qs = QuestStatus.ONGOING;
					break;
				case "completed" :
					qs = QuestStatus.COMPLETED;
					break;
				case "turnedIn" :
					qs = QuestStatus.TURNED_IN;
					break;
			}
			Quest q = new Quest((String) h.get("name"), 
					qs, 
					(int)h.get("x"), 
					(int)h.get("y"), 
					(String)h.get("map"), 
					(String)h.get("type"),
					(String)h.get("bossName"), 
					(int)h.get("questStage"), 
					(boolean)h.get("isMainQuest"), 
					(int)h.get("xpReward"),
					EquipmentList.getInstance().getEquipment((String)h.get("type")).clone(),
					CharacterList.getCharacterList().getPerso((String) h.get("charReward")),
					NPCList.getNPCList().getNpc((String) h.get("npcReward")), 
					(int)h.get("goldReward"), 
					hashmapArraylistToStringArray((ArrayList<HashMap>) h.get("questDescription")), 
					hashmapArraylistToStringArray((ArrayList<HashMap>) h.get("questPresentation")), 
					hashmapArraylistToStringArray((ArrayList<HashMap>) h.get("questObjectiveReached")), 
					hashmapArraylistToStringArray((ArrayList<HashMap>) h.get("questTurnIn")), 
					NPCList.getNPCList().getNpc((String)h.get("questGiver")));
			if (q.getStatus() != QuestStatus.NOT_TAKEN) {
				Squad.getInstance().addQuest(q);
			} else {
				q.getQuestGiver().addQuest(q);
			}
		}
	}
	
	
	
	private String[] hashmapArraylistToStringArray(ArrayList<HashMap> ar) {
		String[] s = new String[ar.size()];
		for (HashMap hm : ar) {
			s[(int) hm.get("lineNumber")] = (String) hm.get("lineText");
		}
		return s;
	}
	
}
