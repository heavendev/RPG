package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import nonActiveClasses.MapElements;

public class FileToMap {
	
	private static FileToMap instance;
	
	private FileToMap() {
	}
	
	public static FileToMap getFileToMap() {
		if (instance == null) {
			instance = new FileToMap();
		}
		return instance;
	}
	//"C:\\Users\\modele\\eclipse-workspace\\Git\\src\\Projet\\WorldMap.txt"
	public MapElements[][] getMapFromFile(String path) {
		return toMap(path);
	}
	
	
	public MapElements[][] toMap(String path) {
		ArrayList<String> file = new ArrayList<String>();
		try {
			FileReader file_read = new FileReader(path);
			BufferedReader reader = new BufferedReader(file_read);
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				file.add(currentLine);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("erreur");
		}
		return (toElem(file));
	}
	
	private MapElements[][] toElem(ArrayList<String> file) {
		
		MapElements[][] elems = new MapElements[file.size()]
				[file.get(0).length()];
		
		for (int i = 0; i < file.size(); i++) {
			for (int j = 0; j < file.get(i).length(); j++) {
				if (file.get(i).charAt(j) == 'T') {
					elems[i][j] = MapElements.TREE;
				} else if (file.get(i).charAt(j) == 'O') {
					elems[i][j] = MapElements.ROCK;
				} else if (file.get(i).charAt(j) == ' ') {
					elems[i][j] = MapElements.CLEAR;
				} else if (file.get(i).charAt(j) == 'U') {
					elems[i][j] = MapElements.ENTRANCE;
				} else if (file.get(i).charAt(j) == '|') {
					elems[i][j] = MapElements.HOUSE_WALL;
				} else if (file.get(i).charAt(j) == '^') {
					elems[i][j] = MapElements.HOUSE_ROOF;
				} else if (file.get(i).charAt(j) == '/') {
					elems[i][j] = MapElements.HOUSE_LEFT_WALL;
				} else if (file.get(i).charAt(j) == '\\') {
					elems[i][j] = MapElements.HOUSE_RIGHT_WALL;
				} else if (file.get(i).charAt(j) == '~') {
					elems[i][j] = MapElements.WATER;
				}
			}
		}
		file = new ArrayList<String>();
		return (elems);
	}
	
	
	
	
}