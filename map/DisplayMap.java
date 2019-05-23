package map;

import nonActiveClasses.Elements;

public class DisplayMap{
	
	Elements[][] map;
	
	
	public DisplayMap(Elements[][] map, int x, int y) {
		this.map = map;
		showMap(x,y);
	}
	
	public void showMap(int x, int y) {
		for (int i = 0; i < 80; i++) {
			
			System.out.print("*");
		} System.out.println();
		for (int i = (y - 8); i < (y+8); i++) {
			if (y >= 0 && y < map.length) {
				System.out.print(y);
			} else {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int j = (x - 38); j < (x + 38); j++) {
				if (i >= 0 && i < map.length && j >= 0 && j < map[i].length) {
					if (j == x && i == y) {
						System.out.print("@");
					} else if (map[i][j] == Elements.TREE) {
						System.out.print("T");
					} else if (map[i][j] == Elements.ROCK) {
						System.out.print("0");
					} else if (map[i][j] == Elements.WATER) {
						System.out.print("~");
					} else if (map[i][j] == Elements.ENTRANCE) {
						System.out.print("U");
					} else if (map[i][j] == Elements.CLEAR) {
						System.out.print(" ");
					} else if (map[i][j] == Elements.HOUSE_WALL) {
						System.out.print("|");
					} else if (map[i][j] == Elements.HOUSE_ROOF) {
						System.out.print("^");
					} else if (map[i][j] == Elements.HOUSE_LEFT_WALL) {
						System.out.print("/");
					} else if (map[i][j] == Elements.HOUSE_RIGHT_WALL) {
						System.out.print("\\");
					}
				} else {
					System.out.print("T");
				}
			}
			System.out.println("*");
		}
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		} System.out.println();
		System.out.println("* z,q,s,f = se deplacer, i = menu d'equipe, esc = menu, e = interagir          *");
	}
	
	
}