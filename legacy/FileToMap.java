package legacy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileToMap {
	
	String path = "C:\\Users\\stagiaire\\eclipse-workspace\\FileRouge\\src\\FileRouge\\carte.txt";
	ArrayList<String> file = new ArrayList<String>();
	
	public FileToMap(String path) {
		this.path = path;
	}
	public FileToMap() {
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	
	public Elements[][] toMap() {
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
		return (toElem());
	}
	
	public Elements[][] toElem() {
		
		Elements[][] elems = new Elements[file.size()][file.get(0).length()];
		
		for (int i = 0; i < file.size(); i++) {
			for (int j = 0; j < file.get(i).length(); j++) {
				if (file.get(i).charAt(j) == 'T') {
					elems[i][j] = Elements.TREE;
				} else if (file.get(i).charAt(j) == '0') {
					elems[i][j] = Elements.ROCK;
				} else if (file.get(i).charAt(j) == ' ') {
					elems[i][j] = Elements.CLEAR;
				} else if (file.get(i).charAt(j) == 'U') {
					elems[i][j] = Elements.ENTRANCE;
				}
			}
		}
		file = new ArrayList<String>();
		return (elems);
	}
	
}