package data;

import characters.Personnage;

public class Equipment implements Cloneable{
	
	private Personnage owner;
	
	private int attackBonus;
	private int defenceBonus;
	private int magicBonus;
	private int resistanceBonus;
	private int speedBonus;
	private int lifePointsBonus;
	private int willPointsBonus;
	
	private int value;

	public Equipment(int attackBonus, int defenceBonus, int magicBonus, int resistanceBonus,
			int speedBonus, int lifePointsBonus, int willPointsBonus, int value) {
		this.attackBonus = attackBonus;
		this.defenceBonus = defenceBonus;
		this.magicBonus = magicBonus;
		this.resistanceBonus = resistanceBonus;
		this.speedBonus = speedBonus;
		this.lifePointsBonus = lifePointsBonus;
		this.willPointsBonus = willPointsBonus;
		this.value = value;
	}
	
	
	public void buy() {
		Squad squad = Squad.getInstance();
		squad.setGold(squad.getGold() - value);
		squad.addEquipment(this);
	}
	
	public void sell() {
		Squad squad = Squad.getInstance();
		squad.setGold(squad.getGold() + value);
		if (this.owner != null) {
			unequip();
		}
		squad.removeEquipment(this);
	}
	
	
	
	public void equip(Personnage owner) {
		this.owner = owner;
		if (attackBonus != 0) {
			owner.setAttack(owner.getAttack() + attackBonus);
		}
		if (defenceBonus != 0) {
			owner.setDefence(owner.getDefence() + defenceBonus);
		}
		if (magicBonus != 0) {
			owner.setMagic(owner.getMagic() + magicBonus);
		}
		if (resistanceBonus != 0) {
			owner.setResistance(owner.getResistance() + resistanceBonus);
		}
		if (speedBonus != 0) {
			owner.setSpeed(owner.getSpeed() + speedBonus);
		}
		if (lifePointsBonus != 0) {
			owner.setLifePoints(owner.getLifePoints() + lifePointsBonus);
			owner.setMaxLifePoints(owner.getMaxLifePoints() + lifePointsBonus);
		}
		if (willPointsBonus != 0) {
			owner.setWillPoints(owner.getWillPoints() + willPointsBonus);
			owner.setMaxWillPoints(owner.getMaxWillPoints() + willPointsBonus);
		}
	}
	
	public void unequip() {
		this.owner = null;
		if (attackBonus != 0) {
			owner.setAttack(owner.getAttack() - attackBonus);
		}
		if (defenceBonus != 0) {
			owner.setDefence(owner.getDefence() - defenceBonus);
		}
		if (magicBonus != 0) {
			owner.setMagic(owner.getMagic() - magicBonus);
		}
		if (resistanceBonus != 0) {
			owner.setResistance(owner.getResistance() - resistanceBonus);
		}
		if (speedBonus != 0) {
			owner.setSpeed(owner.getSpeed() - speedBonus);
		}
		if (lifePointsBonus != 0) {
			owner.setLifePoints(owner.getLifePoints() - lifePointsBonus);
			owner.setMaxLifePoints(owner.getMaxLifePoints() - lifePointsBonus);
		}
		if (willPointsBonus != 0) {
			owner.setWillPoints(owner.getWillPoints() - willPointsBonus);
			owner.setMaxWillPoints(owner.getMaxWillPoints() - willPointsBonus);
		}
	}
	
	
	
	
}