package data;

import java.util.ArrayList;
import java.util.HashMap;

public class EquipmentList {
	
	private static EquipmentList instance;
	private ArrayList<Equipment> list;
	private HashMap<String, Equipment> hList;
	
	public static EquipmentList getInstance() {
		if (instance == null) {
			instance = new EquipmentList();
		}
		return instance;
	}
	
	private EquipmentList() {
		list = new ArrayList<Equipment>();
		hList = new HashMap<String, Equipment>();
	}
	
	public void addEquipment(Equipment e) {
		list.add(e);
		hList.put(e.getName(), e);
	}
	
	public Equipment getEquipment(String name) {
		return hList.get(name);
	}
	
	public HashMap<String, Equipment> gethList() {
		return hList;
	}
	public void sethList(HashMap<String, Equipment> hList) {
		this.hList = hList;
	}
	public ArrayList<Equipment> getList() {
		return list;
	}
	public void setList(ArrayList<Equipment> list) {
		this.list = list;
	}
	
}