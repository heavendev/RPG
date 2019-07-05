package data;

import java.util.ArrayList;

public class GameEquipmentList {
	
	private static GameEquipmentList instance;
	private ArrayList<Equipment> list;
	
	public static GameEquipmentList getInstance() {
		if (instance == null) {
			instance = new GameEquipmentList();
		}
		return instance;
	}
	
	private GameEquipmentList() {
		list = new ArrayList<Equipment>();
	}
	
	
	
	public void addEquipment(Equipment e) {
		list.add(e);
	}



	
	
	
	
	public ArrayList<Equipment> getList() {
		return list;
	}
	public void setList(ArrayList<Equipment> list) {
		this.list = list;
	}
	
}