package map;

import java.util.ArrayList;
import java.util.HashMap;

import data.Squad;
import game.Jeu;
import nonActiveClasses.Direction;
import nonActiveClasses.MapBackground;
import nonActiveClasses.MapElements;
import nonActiveClasses.QuestStatus;
import nonActiveClasses.Scroll;
import npcs.NPC;
import npcs.NPCList;
import quest.Quest;

public class MapController {
	
	Jeu jeu;
	MapDisplay display;
	MapBackground mapBorder;
	MapElements[][] map;
	ArrayList<NPC> npcsInMap;
	int cx;
	int cy;
	String squadCurrentMap;
	
	
	public MapController(Jeu jeu) {
		this.jeu = jeu;
		display = new MapDisplay();
		resetMap();
	}
	
	public void resetMap() {
		HashMap tmp = Squad.getInstance().getCoordinates();
		squadCurrentMap = (String) tmp.get("map");
		cx = (int) tmp.get("x");
		cy = (int) tmp.get("y");
		switch (squadCurrentMap) {
			case "main" :
				map = FileToMap.getFileToMap().toMap("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\game\\WorldMap.txt");
				mapBorder = MapBackground.FOREST;
				break;
			case "House" :
				map = FileToMap.getFileToMap().toMap("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\game\\test.txt");
				mapBorder = MapBackground.HOUSE;
				break;
			case "SouthWest Dungeon" :
				map = FileToMap.getFileToMap().toMap("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\game\\test.txt");
				mapBorder = MapBackground.DUNGEON;
				break;
			case "Tower" :
				map = FileToMap.getFileToMap().toMap("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\game\\test.txt");
				mapBorder = MapBackground.TOWER;
				break;
			case "NorthCenter Dungeon" :
				map = FileToMap.getFileToMap().toMap("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\game\\test.txt");
				mapBorder = MapBackground.DUNGEON;
				break;
			case "SouthCenter Dungeon" :
				map = FileToMap.getFileToMap().toMap("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\game\\test.txt");
				mapBorder = MapBackground.DUNGEON;
				break;
			case "NorthEast Dungeon" :
				map = FileToMap.getFileToMap().toMap("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\game\\test.txt");
				mapBorder = MapBackground.DUNGEON;
				break;
			case "Village" :
				map = FileToMap.getFileToMap().toMap("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\game\\test.txt");
				mapBorder = MapBackground.VILLAGE;
				break;
			case "SouthEast Dungeon" :
				map = FileToMap.getFileToMap().toMap("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\game\\test.txt");
				mapBorder = MapBackground.DUNGEON;
				break;
		}
		putNpcsInMap();
		display.resetMapDisplay(map, cx, cy, mapBorder,  getQuestsLocations(squadCurrentMap));
	}
	
	
	public void scroll(Scroll scroll) {
		switch (scroll) {
		case ESCAPE :
			jeu.goToGameMenu();
			break;
		case CONFIRM :
			NPC npc = checkForChars();
			if (npc != null) {
				jeu.goToNpcDialogue(npc);
			}
			break;
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
		Quest quest;
		
		if (map[cy][cx] == MapElements.ENTRANCE) {
			teleportTo(cx,cy);
			if (squadCurrentMap != "main" && squadCurrentMap != "house" && squadCurrentMap != "village") {
				Quest q = getLocalQuest();
				if (q != null) {
					jeu.goToCombat(q);
				} else {
					jeu.goToCombat("boss");
				}
			} else {
				resetMap();
			}
		} else if ((quest = checkForQuestLocation()) != null) {
			jeu.goToQuestEvent(quest);
		} else if ((int)(Math.random()*300) == 0) {
			jeu.goToCombat();
		}
	}
	
	private boolean isClear(int x, int y) {
		if (x >= 0 && x < map[0].length && y >= 0 && y < map.length) {
			if (map[y][x] == MapElements.CLEAR || map[y][x] == MapElements.ENTRANCE) {
				return true;
			}
		}
		return false;
	}
	
	private void teleportTo(int x, int y) {
		
		if (Squad.getInstance().getCurrentMap() == "main") {
			if (x == 6 && y == 3) {
				Squad.getInstance().setCoordinates(4, 22, "House");
			} else if (x == 16 && y == 43) {
				Squad.getInstance().setCoordinates(14, 14, "SouthWest Dungeon");
			} else if (x == 50 && y == 16) {
				Squad.getInstance().setCoordinates(14, 14, "Tower");
			} else if (x == 77 && y == 7) {
				Squad.getInstance().setCoordinates(14, 14, "NorthCenter Dungeon");
			} else if (x == 70 && y == 40) {
				Squad.getInstance().setCoordinates(14, 14, "SouthCenter Dungeon");
			} else if (x == 149 && y == 4) {
				Squad.getInstance().setCoordinates(14, 14, "NorthEast Dungeon");
			} else if (x == 131 && y == 28) {
				Squad.getInstance().setCoordinates(14, 14, "Village");
			} else if (x == 151 && y == 48) {
				Squad.getInstance().setCoordinates(14, 14, "SouthEast Dungeon");
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
	
	private void putNpcsInMap() {
		npcsInMap = NPCList.getNPCList().getNpcListInMap(squadCurrentMap);
		for (int i = 0; i < npcsInMap.size(); i++) {
			map[npcsInMap.get(i).getY()][npcsInMap.get(i).getX()] = MapElements.NPC;
		}
	}
	
	private NPC checkForChars() {
		for (int i = 0; i < npcsInMap.size(); i++) {
			NPC npc = npcsInMap.get(i);
			if (cx <= npc.getX()+1 && cx>= npc.getX()-1 && cy <= npc.getY()+1 && cy >= npc.getY()-1) {
				return npc;
			}
		}
		return null;
	}
	
	
	private Quest checkForQuestLocation() {
		ArrayList<Quest> quests = Squad.getInstance().getQuests();
		for (int i = 0; i < quests.size(); i++) {
			if (quests.get(i).isAtQuestionLocation(cy, cx, squadCurrentMap) && quests.get(i).getStatus() == QuestStatus.ONGOING) {
				return quests.get(i);
			}
		}
		return null;
	}
	
	private Quest getLocalQuest() {
		ArrayList<Quest> quests = Squad.getInstance().getQuests();
		for (Quest q : quests) {
			if (q.getQuestLocation().get("map").equals(squadCurrentMap)) {
				return q;
			}
		}
		return null;
	}
	
	private ArrayList<int[]> getQuestsLocations (String currentMap) {
		ArrayList<int[]> questLocations = new ArrayList<int[]>();
		ArrayList<Quest> quests = Squad.getInstance().getQuests();
		for (Quest quest : quests) {
			HashMap tmp = quest.getQuestLocation();
			if (tmp.get("map").equals(currentMap) && quest.getStatus() == QuestStatus.ONGOING) {
				int[] coors = {(int) tmp.get("y"),(int) tmp.get("x")};
				questLocations.add(coors);
			}
		}
		return questLocations;
	}
	
}