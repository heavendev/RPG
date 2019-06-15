package map;

import java.util.HashMap;

public class MapStorage {
	
	HashMap<String,String[]> maps;
	
	public MapStorage() {
		maps = new HashMap<String,String[]>();
	}
	
	
	
	
	
	
	public String[] getMap(String map) {
		try {
			return (maps.get(map));
		} catch (NullPointerException e) {
			
		}
	}
	
}