package characters;

public class Class {
	
	String name;
	
	public Class(Personnage perso, String classe) {
		
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
		}
	}
	
	
}