package characters;

import java.util.ArrayList;

import data.Equipment;

public class Ennemy extends Personnage implements Cloneable{
	
	ArrayList<Equipment> loot;
	ArrayList<Equipment> equipment;

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
		if (loot == null) {
			loot = new ArrayList<Equipment>();
		}
		loot.add(e);
	}
	public Equipment getRandomLoot() {
		return loot.get((int)(Math.random()*loot.size()));
	}
	public ArrayList<Equipment> getLoot() {
		return loot;
	}
	
	public void addEquipment(Equipment e) {
		if (equipment == null) {
			equipment = new ArrayList<Equipment>();
		}
		equipment.add(e);
		e.equip(this);
	}
	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}
	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}
	
	
}
