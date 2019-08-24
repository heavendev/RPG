package characters;

import java.util.ArrayList;

import data.Squad;

public class EnnemyList {
	
	private static EnnemyList instance;
	private ArrayList<Ennemy> ennemies;
	private ArrayList<Ennemy> boss;
	private ArrayList<Ennemy> questBoss;
	
	public static EnnemyList getEnnemyList() {
		if (instance == null) {
			instance = new EnnemyList();
		}
		return instance;
	}
	
	private EnnemyList() {
		ennemies = new ArrayList<Ennemy>();
		boss = new ArrayList<Ennemy>();
		questBoss = new ArrayList<Ennemy>();
	}
	
	public void addEnnemy(Ennemy ennemy) {
		this.ennemies.add(ennemy);
	}
	public void addBoss(Ennemy boss) {
		this.boss.add(boss);
	}
	public void addQuestBoss(Ennemy boss) {
		this.questBoss.add(boss);
	}
	
	public ArrayList<Ennemy> getEnnemies() {
		ArrayList<Ennemy> e = new ArrayList<Ennemy>();
		for (int i = 0; i < Squad.getInstance().getPersonnages().size(); i++) {
			e.add(ennemies.get((int)(Math.random()*ennemies.size())).clone());
		}
		return e;
	}
	
	public ArrayList<Ennemy> getBoss() {
		ArrayList<Ennemy> e = new ArrayList<Ennemy>();
		e.add(boss.get((int)(Math.random()*boss.size())).clone());
		return e;
	}
	
	public ArrayList<Ennemy> getQuestBoss(String name) {
		ArrayList<Ennemy> e = new ArrayList<Ennemy>();
		for (int i = 0; i < questBoss.size(); i++) {
			if (questBoss.get(i).getName().equals(name)) {
				e.add(questBoss.get(i));
				break;
			}
		}
		return e;
	}
}