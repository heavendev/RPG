package map;

import Projet.Jeu;
import nonActiveClasses.Direction;
import nonActiveClasses.MapElements;
import nonActiveClasses.Scroll;

public class Map {
	
	Jeu jeu;
	DisplayMap display;
	
	MapElements[][] map;
	
	int cx;
	int cy;
	
	
	public Map(Jeu jeu) {
		// placeholder
		// on recupere normallement les coordonnes du personnage
		// et sur quel carte il est en ce moment
		// et on genere la carte approprie
		this.jeu = jeu;
		resetMap();
	}
	
	public void resetMap() {
		map = FileToMap.getFileToMap().getMapFromFile("C:\\Users\\modele\\eclipse-workspace\\Git\\src\\Projet\\WorldMap.txt");
		cx = 62; 
		cy = 13;
		display = new DisplayMap(map,cx,cy);
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
		display.showMap(cx, cy);
//		if (map[cy][cx] == MapElements.ENTRANCE) {
//			
//		}
//		if ((int)(Math.random()*1000) == 0) {
//			jeu.startRandomCombat();
//		}
	}
	
	public boolean isClear(int x, int y) {
		if (x >= 0 && x < map[0].length && y >= 0 && y < map.length) {
			if (map[y][x] == MapElements.CLEAR || map[y][x] == MapElements.ENTRANCE) {
				return true;
			}
		}
		return false;
	}
	
}