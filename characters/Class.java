package characters;

import nonActiveClasses.AttackTypes;

public class Class {
	
	String name;
	Personnage perso;
	
	public Class(Personnage perso, String classe) {
		
		this.perso = perso;
		this.name = classe;
		
		switch (classe) {
			case "Bagarreur" : 
				perso.setAttack(perso.getAttack()+5);
				perso.setMaxLifePoints(perso.getMaxLifePoints() + 20);
				perso.setLifePoints(perso.getLifePoints() + 20);
				perso.setDefence(perso.getDefence() + 5);
				break;
			case "Piqueuse" :
				perso.setSpeed(perso.getSpeed()+5);
				perso.setAttack(perso.getAttack()+3);
				perso.setDefence(perso.getDefence()+3);
				perso.setMaxLifePoints(perso.getMaxLifePoints() - 10);
				perso.setLifePoints(perso.getLifePoints() - 10);
				break;
			case "Jeteur de cailloux" :
				perso.setSpeed(perso.getSpeed()+2);
				perso.setAttack(perso.getAttack()+5);
				perso.setMaxWillPoints(perso.getMaxWillPoints()+20);
				perso.setWillPoints(perso.getMaxWillPoints()+20);
				break;
			case "Enchanteresse" :
				perso.setAttackType(AttackTypes.PSYCHOLOGICAL);
				perso.setMagic(perso.getMagic()+10);
				perso.setResistance(perso.getResistance()+10);
				perso.setMaxWillPoints(perso.getMaxWillPoints()+50);
				perso.setWillPoints(perso.getMaxWillPoints()+50);
				break;
			case "Boss" :
				perso.setAttack(perso.getAttack()+20);
				perso.setDefence(perso.getDefence()+10);
				perso.setMaxLifePoints(perso.getMaxLifePoints()+150);
				perso.setLifePoints(perso.getLifePoints()+150);
				perso.setMaxWillPoints(perso.getMaxWillPoints()+50);
				perso.setWillPoints(perso.getWillPoints()+50);
				perso.setResistance(perso.getResistance()+5);
				break;
			case "Canaille" :
				perso.setAttack(perso.getAttack()+2);
				perso.setMaxLifePoints(perso.getMaxLifePoints() + 10);
				perso.setLifePoints(perso.getLifePoints() + 10);
				perso.setDefence(perso.getDefence() + 2);
				perso.setSpeed(perso.getSpeed()+1);
				perso.setMaxWillPoints(perso.getMaxWillPoints()-30);
				perso.setWillPoints(perso.getMaxWillPoints()-30);
				break;
		}
	}
	
	
}