package characters;

import java.util.ArrayList;
import java.util.HashMap;

import combat.Combat;
import data.Equipment;
import nonActiveClasses.AttackTypes;

public class Personnage implements Combat{
	
	protected String name;
	
	protected int maxLifePoints = 100;
	protected int lifePoints = 100;
	protected int maxWillPoints = 100;
	protected int willPoints = 100;
	protected int attack = 10;
	protected int magic = 5;
	protected int defence = 5;
	protected int resistance = 5;
	protected int speed = 5;
	
	protected int level = 0;
	protected int xp = 0;
	protected Class charClass;
	protected AttackTypes attackType = AttackTypes.PHYSICAL;
	
	protected ArrayList<String[]> attacks;
	protected ArrayList<String[]> criticalHit;
	protected ArrayList<String[]> magicAttack;
	protected ArrayList<String[]> magicCriticalHit;
	
	protected ArrayList<Equipment> equipment;
	
	
	public Personnage(String name, int level, int xp, String classe, ArrayList<String[]> attacks,
			ArrayList<String[]> criticalHit, ArrayList<String[]> magicAttack, ArrayList<String[]> magicCriticalHit) {
		this.attacks = attacks;
		this.criticalHit = criticalHit;
		this.magicAttack = magicAttack;
		this.magicCriticalHit = magicCriticalHit;
		this.name = name;
		this.xp = xp;
		this.charClass = new Class(this,classe);
		while (this.level < level) {
			levelUp();
			this.level++;
		}
	}
	
	
	
	public HashMap attaquer(Personnage p) {
		HashMap toReturn = new HashMap();
		if (Math.random() > 0.9) {
			if(attackType == AttackTypes.PSYCHOLOGICAL) {
				p.setWillPoints(p.getWillPoints() - (getAttack()*2));
				toReturn.put("text", criticalHit.get((int)(Math.random()*criticalHit.size())));
				toReturn.put("damage", getAttack()*2);
			} else {
				p.setLifePoints(p.getLifePoints() - (getAttack()*2 - p.getDefence()));
				toReturn.put("text", criticalHit.get((int)(Math.random()*criticalHit.size())));
				toReturn.put("damage", getAttack()*2 - p.getDefence());
			}
		} else {
			if(attackType == AttackTypes.PSYCHOLOGICAL) {
				p.setWillPoints(p.getWillPoints() - getAttack());
				toReturn.put("text", attacks.get((int)(Math.random()*attacks.size())));
				toReturn.put("damage", getAttack());
			} else {
				p.setLifePoints(p.getLifePoints() - (getAttack() - p.getDefence()));
				toReturn.put("text", attacks.get((int)(Math.random()*attacks.size())));
				toReturn.put("damage", getAttack() - p.getDefence());
			}
		}
		return toReturn;
	}
	
	public HashMap utiliserPouvoir(Personnage p) {
		HashMap toReturn = new HashMap();
		if (Math.random() > 0.9) {
			p.setLifePoints(p.getLifePoints() - (getMagic()*2 - p.getResistance()));
			toReturn.put("text", magicCriticalHit.get((int)(Math.random()*magicCriticalHit.size())));
			toReturn.put("damage", getMagic()*2 - p.getResistance());
		} else {
			p.setLifePoints(p.getLifePoints() - (getMagic() - p.getResistance()));
			toReturn.put("text", magicAttack.get((int)(Math.random()*magicAttack.size())));
			toReturn.put("damage", getMagic() - p.getResistance());
		}
		return toReturn;
	}
	
	public void levelUp() {
		
	}
	
	public void addEquipment(Equipment equip) {
		if (equipment == null) {
			equipment = new ArrayList<Equipment>();
		}
		equipment.add(equip);
	}
	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}
	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}
	public void removeEquipment(Equipment equip) {
		equipment.remove(equip);
	}
	public int getMaxLifePoints() {
		return maxLifePoints;
	}
	public void setMaxLifePoints(int maxLifePoints) {
		this.maxLifePoints = maxLifePoints;
	}
	public int getMaxWillPoints() {
		return maxWillPoints;
	}
	public void setMaxWillPoints(int maxWillPoints) {
		this.maxWillPoints = maxWillPoints;
	}
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	public int getWillPoints() {
		return willPoints;
	}
	public void setWillPoints(int willPoints) {
		this.willPoints = willPoints;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getMagic() {
		return magic;
	}
	public void setMagic(int magic) {
		this.magic = magic;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public int getResistance() {
		return resistance;
	}
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
	public int getSpeed() {
		if (speed > 15) {
			return 15;
		} else if (speed < 0) {
			return 0;
		} else {
			return speed;
		}
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	public boolean isAlive() {
		if (lifePoints > 0 && willPoints > 0) {
			return true;
		} else {
			return false;
		}
	}
	public Class getCharClass() {
		return charClass;
	}
	public void setCharClass(Class charClass) {
		this.charClass = charClass;
	}
	public AttackTypes getAttackType() {
		return attackType;
	}
	public void setAttackType(AttackTypes attackType) {
		this.attackType = attackType;
	}
	public ArrayList<String[]> getAttacks() {
		return attacks;
	}
	public void setAttacks(ArrayList<String[]> attacks) {
		this.attacks = attacks;
	}
	public ArrayList<String[]> getCriticalHit() {
		return criticalHit;
	}
	public void setCriticalHit(ArrayList<String[]> criticalHit) {
		this.criticalHit = criticalHit;
	}
	public ArrayList<String[]> getMagicAttack() {
		return magicAttack;
	}
	public void setMagicAttack(ArrayList<String[]> magicAttack) {
		this.magicAttack = magicAttack;
	}
	public ArrayList<String[]> getMagicCriticalHit() {
		return magicCriticalHit;
	}
	public void setMagicCriticalHit(ArrayList<String[]> magicCriticalHit) {
		this.magicCriticalHit = magicCriticalHit;
	}
}