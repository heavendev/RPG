package characters;

import java.util.ArrayList;

public class CharacterList {
	
	private static CharacterList instance;
	private ArrayList<Personnage> personnage;
	
	public static CharacterList getCharacterList() {
		if (instance == null) {
			instance = new CharacterList();
		}
		return instance;
	}
	
	public Personnage getPerso(String name) {
		for (Personnage p : personnage) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	
	private CharacterList() {
		personnage = new ArrayList<Personnage>();
	}
	
	public void addPersonnage(Personnage perso) {
		personnage.add(perso);
	}
	
	public void removePersonnage(Personnage perso) {
		personnage.remove(perso);
	}
	
	
}
