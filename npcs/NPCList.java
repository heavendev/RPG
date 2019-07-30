package npcs;

import java.util.ArrayList;

public class NPCList {
	
	private static NPCList instance;
	private ArrayList<NPC> active;
	private ArrayList<NPC> inactive;
	
	public static NPCList getNPCList() {
		if (instance == null) {
			instance = new NPCList();
		}
		return instance;
	}
	
	private NPCList() {
		active = new ArrayList<NPC>();
		inactive = new ArrayList<NPC>();
	}
	
	
	public NPC getNpc(String name) {
		for (NPC npc : active) {
			if (npc.getName().equals(name)) {
				return npc;
			}
		}
		for (NPC npc : inactive) {
			if (npc.getName().equals(name)) {
				return npc;
			}
		}
		return null;
	}
	
	public ArrayList<NPC> getNPCs() {
		return active;
	}
	
	public ArrayList<NPC> getNpcListInMap(String map) {
		ArrayList<NPC> toReturn = new ArrayList<NPC>();
		for (NPC npc : active) {
			if (npc.getMap().equals(map)) {
				toReturn.add(npc);
			}
		}
		return toReturn;
	}	
	
	
	
	public void addActiveNPC(NPC npc) {
		active.add(npc);
	}
	public void addInactiveNPC(NPC npc) {
		inactive.add(npc);
	}
	public void turnNPCActive(NPC npc) {
		active.remove(npc);
		inactive.add(npc);
	}
	public void turnNPCInactive(NPC npc) {
		inactive.remove(npc);
		active.add(npc);
	}
	
}