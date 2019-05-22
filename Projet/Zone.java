package Projet;

import nonActiveClasses.Direction;
import nonActiveClasses.Elements;

public class Zone {
	
	Elements[][] zone;
	
	int cX;
	int cY;
	
	
	
	public void setZone(Elements[][] zone) {
		this.zone = zone;
	}
	
	public void setCharCoordinates (int y, int x) {
		cY = y;
		cX = x;
	}
	
	
	public void showMap() {
		for (int i = cY - 10; i < cY + 10; i++) {
			for (int j = cX - 10; j < cX + 10; j++) {
				if (i >= 0 && i < zone.length && j >= 0 && j < zone[0].length){
					if (j == cX && i == cY) {
						System.out.print("@");
					} else if (zone[i][j] == Elements.TREE) {
						System.out.print("T");
					} else if (zone[i][j] == Elements.ROCK) {
						System.out.print("0");
					} else if (zone[i][j] == Elements.WATER) {
						System.out.print("u");
					} else if (zone[i][j] == Elements.ENTRANCE) {
						System.out.print("l");
					} else if (zone[i][j] == Elements.CLEAR) {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
	
	public void move(Direction dir) {
		switch (dir) {
			case UP :
				if (zone[cY-1][cX] != Elements.TREE && zone[cY-1][cX] != Elements.ROCK) {
					setCharCoordinates(cY-1, cX);
				}
				break;
			case DOWN :
				if (zone[cY+1][cX] != Elements.TREE && zone[cY+1][cX] != Elements.ROCK) {
					setCharCoordinates(cY+1, cX);
				}
				break;
			case LEFT :
				if (zone[cY][cX-1] != Elements.TREE && zone[cY][cX-1] != Elements.ROCK) {
					setCharCoordinates(cY, cX-1);
				}
				break;
			case RIGHT :
				if (zone[cY][cX+1] != Elements.TREE && zone[cY][cX+1] != Elements.ROCK) {
					setCharCoordinates(cY, cX+1);
				}
				break;
		}
		showMap();
	}
	
	
	
}