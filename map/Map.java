package map;

import java.util.HashMap;

import Projet.Jeu;
import Projet.Squad;
import nonActiveClasses.Direction;
import nonActiveClasses.MapBackground;
import nonActiveClasses.MapElements;
import nonActiveClasses.Scroll;

public class Map {
	
	Jeu jeu;
	MapDisplay display;
	MapBackground mapBorder;
	MapElements[][] map;
	
	int cx;
	int cy;
	
	
	public Map(Jeu jeu) {
		this.jeu = jeu;
		display = new MapDisplay();
		resetMap();
	}
	
	public void resetMap() {
		
		HashMap tmp = Squad.getInstance().getCoordinates();
		cx = (int) tmp.get("x");
		cy = (int) tmp.get("y");
		if (tmp.get("map") == "main") {
			map = FileToMap.getFileToMap().getMapFromFile("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\Projet\\WorldMap.txt");
			mapBorder = MapBackground.FOREST;
		} else if (tmp.get("map") == "House"){
			map = FileToMap.getFileToMap().getMapFromFile("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\Projet\\test.txt");
			mapBorder = MapBackground.HOUSE;
		}
		
		//  PLACEHOLDER FOR DUNGEONS/VILLAGES/HOUSES
//		else if (tmp.get("map") == "SouthWest Dungeon"){
//			map = FileToMap.getFileToMap().getMapFromFile("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\Projet\\test.txt");
//			mapBorder = MapBackground.DUNGEON;
//		} else if (tmp.get("map") == "Tower"){
//			map = FileToMap.getFileToMap().getMapFromFile("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\Projet\\test.txt");
//			mapBorder = MapBackground.TOWER;
//		} else if (tmp.get("map") == "NorthCenter Dungeon"){
//			map = FileToMap.getFileToMap().getMapFromFile("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\Projet\\test.txt");
//			mapBorder = MapBackground.DUNGEON;
//		} else if (tmp.get("map") == "SouthCenter Dungeon"){
//			map = FileToMap.getFileToMap().getMapFromFile("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\Projet\\test.txt");
//			mapBorder = MapBackground.DUNGEON;
//		} else if (tmp.get("map") == "NorthEast Dungeon"){
//			map = FileToMap.getFileToMap().getMapFromFile("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\Projet\\test.txt");
//			mapBorder = MapBackground.DUNGEON;
//		} else if (tmp.get("map") == "Village"){
//			map = FileToMap.getFileToMap().getMapFromFile("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\Projet\\test.txt");
//			mapBorder = MapBackground.VILLAGE;
//		} else if (tmp.get("map") == "SouthEast Dungeon"){
//		map = FileToMap.getFileToMap().getMapFromFile("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\Projet\\test.txt");
//		mapBorder = MapBackground.DUNGEON;
//	}
		
		
		//  coors quests
		
		display.resetMapDisplay(map, cx, cy, mapBorder);
	}
	
	
	public void scroll(Scroll scroll) {
		 if (scroll == Scroll.ESCAPE) {
			 jeu.goToGameMenu();
		 }
	}
	
	public void move(Direction dir) {
		switch (dir) {
			case UP :
				if (isClear(cx,cy-1)) {
					cy--;
				}
				break;
			case DOWN :
				if (isClear(cx,cy+1)) {
					cy++;
				}
				break;
			case LEFT :
				if (isClear(cx-1,cy)) {
					cx--;
				}
				break;
			case RIGHT :
				if (isClear(cx+1,cy)) {
					cx++;
				}
				break;
			case UP_RIGHT :
					if (isClear(cx+1,cy) && isClear(cx,cy-1) && isClear(cx+1,cy-1)) {
						cy--;
						cx++;
					} else if (isClear(cx+1,cy) && isClear(cx,cy-1)) {
						if ((int)(Math.random()*2) == 0) {
							cy--;
						} else {
							cx++;
						}
					} else if (isClear(cx+1,cy)) {
						cx++;
					} else if (isClear(cx,cy-1)) {
						cy--;
					}
					break;
			case UP_LEFT :
				if (isClear(cx-1,cy) && isClear(cx,cy-1) && isClear(cx-1,cy-1)) {
					cy--;
					cx--;
				} else if (isClear(cx-1,cy) && isClear(cx,cy-1)) {
					if ((int)(Math.random()*2) == 0) {
						cy--;
					} else {
						cx--;
					}
				} else if (isClear(cx-1,cy)) {
					cx--;
				} else if (isClear(cx,cy-1)) {
					cy--;
				}
				break;
			case DOWN_LEFT :
				if (isClear(cx-1,cy) && isClear(cx,cy+1) && isClear(cx-1,cy+1)) {
					cy++;
					cx--;
				} else if (isClear(cx-1,cy) && isClear(cx,cy+1)) {
					if ((int)(Math.random()*2) == 0) {
						cy++;
					} else {
						cx--;
					}
				} else if (isClear(cx-1,cy)) {
					cx--;
				} else if (isClear(cx,cy+1)) {
					cy++;
				}
				break;
			case DOWN_RIGHT :
				if (isClear(cx+1,cy) && isClear(cx,cy+1) && isClear(cx+1,cy+1)) {
					cy++;
					cx++;
				} else if (isClear(cx+1,cy) && isClear(cx,cy+1)) {
					if ((int)(Math.random()*2) == 0) {
						cy++;
					} else {
						cx++;
					}
				} else if (isClear(cx+1,cy)) {
					cx++;
				} else if (isClear(cx,cy+1)) {
					cy++;
				}
				break;
		}
		
		display.setCoors(cx, cy);
		
		Squad.getInstance().setCoordinates(cx, cy);
		
		if (map[cy][cx] == MapElements.ENTRANCE) {
			teleportTo(cx,cy);
			resetMap();
		} /*else if ((int)(Math.random()*1000) == 0) {
			jeu.startRandomCombat();
		}*/
	}
	
	public boolean isClear(int x, int y) {
		if (x >= 0 && x < map[0].length && y >= 0 && y < map.length) {
			if (map[y][x] == MapElements.CLEAR || map[y][x] == MapElements.ENTRANCE) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public void teleportTo(int x, int y) {
		
		if (Squad.getInstance().getCurrentMap() == "main") {
			
			if (x == 6 && y == 3) {
				Squad.getInstance().setCoordinates(4, 22, "House");
			} else if (x == 16 && y == 43) {
				Squad.getInstance().setCoordinates(1, 1, "SouthWest Dungeon");
			} else if (x == 50 && y == 16) {
				Squad.getInstance().setCoordinates(1, 1, "Tower");
			} else if (x == 77 && y == 7) {
				Squad.getInstance().setCoordinates(1, 1, "NorthCenter Dungeon");
			} else if (x == 70 && y == 40) {
				Squad.getInstance().setCoordinates(1, 1, "SouthCenter Dungeon");
			} else if (x == 149 && y == 4) {
				Squad.getInstance().setCoordinates(1, 1, "NorthEast Dungeon");
			} else if (x == 131 && y == 28) {
				Squad.getInstance().setCoordinates(1, 1, "Village");
			} else if (x == 151 && y == 48) {
				Squad.getInstance().setCoordinates(1, 1, "SouthEast Dungeon");
			}
			
		} else if (Squad.getInstance().getCurrentMap() == "House") {
			Squad.getInstance().setCoordinates(6, 4, "main");
		} else if (Squad.getInstance().getCurrentMap() == "SouthWest Dungeon") {
			Squad.getInstance().setCoordinates(16, 44, "main");
		} else if (Squad.getInstance().getCurrentMap() == "Tower") {
			Squad.getInstance().setCoordinates(50, 17, "main");
		} else if (Squad.getInstance().getCurrentMap() == "NorthCenter Dungeon") {
			Squad.getInstance().setCoordinates(77, 8, "main");
		} else if (Squad.getInstance().getCurrentMap() == "SouthCenter Dungeon") {
			Squad.getInstance().setCoordinates(70, 41, "main");
		} else if (Squad.getInstance().getCurrentMap() == "NorthEast Dungeon") {
			Squad.getInstance().setCoordinates(149, 5, "main");
		} else if (Squad.getInstance().getCurrentMap() == "Village") {
			Squad.getInstance().setCoordinates(131, 29, "main");
		} else if (Squad.getInstance().getCurrentMap() == "SouthEast Dungeon") {
			Squad.getInstance().setCoordinates(151, 49, "main");
		}
		
	}
	
	
}