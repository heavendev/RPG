package z.legacy;

import java.util.ArrayList;

import npcs.NPC;

public class NpcLocations {
	
	private static NpcLocations instance;
	private ArrayList<NPC> npcs;
	
	public static NpcLocations getNpcLocations() {
		if (instance == null) {
			instance = new NpcLocations();
		}
		return instance;
	}
	
	public static NpcLocations getNpcLocations(ArrayList<NPC> npcs) {
		if (instance == null) {
			instance = new NpcLocations(npcs);
		}
		return instance;
	}
	
	private NpcLocations() {}
	
	private NpcLocations(ArrayList<NPC> npcs) {
		this.npcs = npcs;
	}
	
	public void resetNpcLocations(ArrayList<NPC> np) {
		npcs = np;
	}
	
	public ArrayList<NPC> getNpcListInMap(String map) {
		ArrayList<NPC> toReturn = new ArrayList<NPC>();
		for (NPC npc : npcs) {
			if (npc.getMap().equals(map)) {
				toReturn.add(npc);
			}
		}
		return toReturn;
	}
	
	
}