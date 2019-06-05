package Projet;

import java.util.HashMap;

public class Squad {
	
	private static Squad instance;
	private int coorX;
	private int coorY;
	private String currentMap;
	
	public static Squad getInstance() {
		if (instance == null) {
			instance = new Squad();
		}
		return instance;
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
	
	public String getCurrentMap() {
		return currentMap;
	}
	public void setCurrentMap(String map) {
		this.currentMap = map;
	}
	
}