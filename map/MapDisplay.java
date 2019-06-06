package map;

import java.util.ArrayList;

import nonActiveClasses.Display;
import nonActiveClasses.MapBackground;
import nonActiveClasses.MapElements;

public class MapDisplay implements Display{
	
	private MapElements[][] map;
	private int x;
	private int y;
	private MapBackground mapBorder;
	private ArrayList<int[]> questLocations;
	
	public MapDisplay() {}
	
	public void resetMapDisplay(MapElements[][] map, int x, int y, MapBackground mapBorder, ArrayList<int[]> questLocations) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.mapBorder = mapBorder;
		this.questLocations = questLocations;
		display();
	}
	
	public void display() {
		
		System.out.println(questLocations.size());
		
		// affichage des coordonnes sur l'axe des X
		for (int i = 0; i < 80; i++) {
			if (i >= 0 && i < map[0].length) {
				if ((int)((x-41+i)/100) > 0) {
					System.out.print((int)((x-41+i)/100));
				} else {
					System.out.print(" ");
				}
			} else {
				System.out.print(" ");
			}
		} System.out.println();
		
		for (int i = 0; i < 80; i++) {
			if (i >= 0 && i < map[0].length) {
				if ((x-41+i) >= 100) {
					if ((int)((x-41+i)/10) >= 0) {
						System.out.print((int)((x-141+i)/10));
					} else {
						System.out.print(" ");
					}
				} else {
					if ((int)((x-41+i)/10) >= 0) {
						System.out.print((int)((x-41+i)/10));
					} else {
						System.out.print(" ");
					}
				}
			} else {
				System.out.print(" ");
			}
		} System.out.println();
		
		for (int i = 0; i < 80; i++) {
			if (i >= 0 && i < map[0].length) {
				if ((x-41+i)%10 >= 0) {
					System.out.print((x-41+i)%10);
				} else {
					System.out.print(" ");
				}
			} else {
				System.out.print(" ");
			}
		} System.out.println();
		
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		} System.out.println();
		
		for (int i = (y - 7); i < (y+7); i++) {
			
			//affichage des coordonnees sur l'axe des Y
			if (i >= 0 && i < map.length) {
				if (i < 10) {
					System.out.print(" ");
					System.out.print(i);
				} else {
					System.out.print(i);
				}
			} else {
				System.out.print("  ");
			}
			
			System.out.print("*");
			for (int j = (x - 38); j < (x + 38); j++) {
				if (i >= 0 && i < map.length && j >= 0 && j < map[i].length) {
					if (j == x && i == y) {
						System.out.print("@");
					} else if (isQuestHere(i,j)) {
						System.out.print("X");
					} else if (map[i][j] == MapElements.TREE) {
						System.out.print("T");
					} else if (map[i][j] == MapElements.ROCK) {
						System.out.print("0");
					} else if (map[i][j] == MapElements.WATER) {
						System.out.print("~");
					} else if (map[i][j] == MapElements.ENTRANCE) {
						System.out.print("U");
					} else if (map[i][j] == MapElements.CLEAR) {
						System.out.print(" ");
					} else if (map[i][j] == MapElements.HOUSE_WALL) {
						System.out.print("|");
					} else if (map[i][j] == MapElements.HOUSE_ROOF) {
						System.out.print("^");
					} else if (map[i][j] == MapElements.HOUSE_LEFT_WALL) {
						System.out.print("/");
					} else if (map[i][j] == MapElements.HOUSE_RIGHT_WALL) {
						System.out.print("\\");
					}
				} else {
					switch (mapBorder) {
						case FOREST :
							System.out.print("T");
							break;
						case DUNGEON :
							System.out.print("*");
							break;
						case HOUSE :
							System.out.print("|");
							break;
						case TOWER :
							System.out.print("+");
							break;
						case VILLAGE :
							System.out.print("T");
							break;
					}
				}
			}
			System.out.println("*");
		}
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		} System.out.println();
		System.out.println("* z,q,s,f = se deplacer, i = menu d'equipe, esc = menu, entrer = interagir     *");
	}
	
	public void setCoors(int x, int y) {
		this.x = x;
		this.y = y;
		display();
	}
	
	private boolean isQuestHere(int y, int x) {
		for (int i = 0; i < questLocations.size(); i++) {
			if (questLocations.get(i)[0] == y && questLocations.get(i)[1] == x) {
				return true;
			}
		}
		return false;
	}
	
}