package data;

import java.util.ArrayList;

public class EquipmentList {
	
	private static EquipmentList instance;
	private ArrayList<Equipment> list;
	
	public static EquipmentList getInstance() {
		if (instance == null) {
			instance = new EquipmentList();
		}
		return instance;
	}
	
	private EquipmentList() {
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