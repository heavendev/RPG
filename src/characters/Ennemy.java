package characters;

import java.util.ArrayList;

public class Ennemy extends Personnage implements Cloneable{

	public Ennemy(String name, int level, int xp, String classe, ArrayList<String[]> attacks,
			ArrayList<String[]> criticalHit, ArrayList<String[]> magicAttack, ArrayList<String[]> magicCriticalHit) {
		super(name, level, xp, classe, attacks, criticalHit, magicAttack, magicCriticalHit);
	}
	
	public int attaquerPerso(Personnage p) {
		int degats = attack - p.getDefence();
		p.setLifePoints(p.getLifePoints() - degats);
		return (degats);
	}
	
<<<<<<< HEAD:characters/Ennemy.java
	public Ennemy clone() {
		try {
			return (Ennemy) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
=======
}
>>>>>>> 9b1c63075470fb69e05c6d5981c2b687da664a10:src/characters/Ennemy.java
