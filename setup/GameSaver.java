package setup;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import data.Equipment;
import data.EquipmentList;
import data.Squad;
import data.userData;
import npcs.NPC;
import npcs.NPCList;

public class GameSaver {
	
	private static GameSaver instance;
	private DatabaseTest db;
	
	public static GameSaver getInstance() {
		if (instance == null) {
			instance = new GameSaver();
		}
		return instance;
	}
	
	private GameSaver() {
		db = DatabaseTest.getDatabaseTest();
	}
	
	
	
	public void saveGame(int saveNumber) throws SQLException {
		
		DataHandler handler = DataHandler.getDataHandler();
		int saveID = handler.getPreviousSaveId(userData.getUserData().getUserId(), saveNumber);
		
		handler.saveEquipment(equipmentToArrayList(), saveID);
		int squadID = handler.saveSquad(squadToHashMap(), saveID);
		handler.saveSquadEquipment(squadEquipmentToArrayList(), squadID);
		handler.saveNpc(npcToArrayList(), saveID);
		
		
		handler.deletePreviousSave(saveID);
	}
	
	private ArrayList<HashMap> equipmentToArrayList(){
		ArrayList<Equipment> ar = EquipmentList.getInstance().getList();
		ArrayList<HashMap> toReturn = new ArrayList<HashMap>();
		for (Equipment e : ar) {
			HashMap hm = new HashMap();
			hm.put("name", e.getName());
			hm.put("attack", e.getAttackBonus());
			hm.put("defence", e.getDefenceBonus());
			hm.put("magic", e.getMagicBonus());
			hm.put("resistance", e.getResistanceBonus());
			hm.put("speed", e.getSpeedBonus());
			hm.put("healthPoints", e.getLifePointsBonus());
			hm.put("willPoints", e.getWillPointsBonus());
			hm.put("value", e.getValue());
			toReturn.add(hm);
		}
		return toReturn;
	}
	
	private ArrayList<HashMap> npcToArrayList() {
		ArrayList<NPC> active = NPCList.getNPCList().getNPCs();
		ArrayList<NPC> inactive = NPCList.getNPCList().getInactive();
		ArrayList<HashMap> toReturn = new ArrayList<HashMap>();
		for (NPC npc : active) {
			HashMap h = new HashMap();
			h.put("name", npc.getName());
			h.put("isTrader", npc.isTrader());
			h.put("coorX", npc.getX());
			h.put("coorY", npc.getY());
			h.put("map", npc.getMap());
			h.put("isActive", true);
			h.put("life", npc.getLife());
			h.put("portrait", npc.getPortrait());
			toReturn.add(h);
		}
		return toReturn;
	}
	
	private HashMap squadToHashMap() {
		HashMap hm = new HashMap();
		Squad squad = Squad.getInstance();
		HashMap h = squad.getCoordinates();
		hm.put("coorX", h.get("x"));
		hm.put("coorY", h.get("y"));
		hm.put("map", h.get("map"));
		hm.put("questStage", squad.getMainQuestStage());
		hm.put("gold", squad.getGold());
		return hm;
	}
	
	private ArrayList<HashMap<String,String>> squadEquipmentToArrayList() {
		ArrayList<Equipment> ar = Squad.getInstance().getEquipment();
		ArrayList<HashMap<String,String>> toReturn = new ArrayList<HashMap<String,String>>();
		for (Equipment e : ar) {
			HashMap<String,String> hm = new HashMap<String,String>();
			hm.put("name", e.getName());
			try {
				hm.put("owner", e.getOwner().getName());
			} catch (NullPointerException exception) {
				hm.put("owner", "");
			}
			toReturn.add(hm);
		}
		return toReturn;
	}
	
	
	
}
