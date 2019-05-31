package map;

import nonActiveClasses.Display;
import nonActiveClasses.MapElements;

public class MapDisplay implements Display{
	
	MapElements[][] map;
	
	public MapDisplay(MapElements[][] map, int x, int y) {
		this.map = map;
		display(x,y);
	}
	
	public void display(int x, int y) {
		
		
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
					System.out.print("*");
				}
			}
			System.out.println("*");
		}
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		} System.out.println();
		System.out.println("* z,q,s,f = se deplacer, i = menu d'equipe, esc = menu, e = interagir          *");
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
	
}