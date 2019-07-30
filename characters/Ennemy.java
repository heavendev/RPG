package characters;

import java.util.ArrayList;

import data.Equipment;

public class Ennemy extends Personnage implements Cloneable{
	
	ArrayList<Equipment> loot;

	public Ennemy(String name, int level, int xp, String classe, ArrayList<String[]> attacks,
			ArrayList<String[]> criticalHit, ArrayList<String[]> magicAttack, ArrayList<String[]> magicCriticalHit) {
		super(name, level, xp, classe, attacks, criticalHit, magicAttack, magicCriticalHit);
		loot = new ArrayList<Equipment>();
	}
	
	public int attaquerPerso(Personnage p) {
		int degats = attack - p.getDefence();
		p.setLifePoints(p.getLifePoints() - degats);
		return (degats);
	}
	
	public Ennemy clone() {
		try {
			return (Ennemy) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void addLoot(Equipment e) {
		loot.add(e);
	}
	
	public Equipment getRandomLoot() {
		return loot.get((int)(Math.random()*loot.size()));
	}
	
}
