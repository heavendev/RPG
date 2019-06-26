package combat;

import java.util.HashMap;
import java.util.ArrayList;

import characters.Boss;
import characters.Ennemy;
import characters.Personnage;
import data.Squad;
import game.Jeu;
import nonActiveClasses.Scroll;
import quest.Quest;

public class CombatController {
	
	private Jeu jeu;
	private CombatDisplay display;
	
	private EnnemyTurn ennemyTurn;
	private ActionChoice actionChoice;
	private TargetChoice targetChoice;
	private ActionResolution actionResolution;
		
	private Quest quest;
	private Boss boss;
	
	private ArrayList<Ennemy> ennemies;
	private ArrayList<Personnage> team;
	
	private Status status;
	
	private HashMap<Integer,Personnage> combatOrder;
	private int step;
	
	
	
	
	
	
	
	public CombatController(Quest quest, Jeu jeu) {
		instantiate();
		this.jeu = jeu;
		reset(quest);
	}

	public CombatController(Boss boss, Jeu jeu) {
		instantiate();
		this.jeu = jeu;
		reset(boss);
	}

	public CombatController(Jeu jeu) {
		instantiate();
		this.jeu = jeu;
		reset();
	}
	
	private void instantiate() {
		ennemyTurn = new EnnemyTurn();
		actionChoice = new ActionChoice();
		targetChoice = new TargetChoice();
		actionResolution = new ActionResolution();
		display = new CombatDisplay();
	}
	
	
	public void reset(Quest quest) {
		this.quest = quest;
		this.boss = null;
		ennemies = getQuestBoss();
		combatInit(); 
	}

	public void reset(Boss boss) {
		this.boss = boss;
		this.quest = null;
		ennemies = getRandomBoss();
		combatInit();
	}
	
	public void reset() {
		this.quest = null;
		this.boss = null;
		ennemies = getRandomEnnemy();
		combatInit();
	}
	
	
	
	public void scroll(Scroll scroll) {
		switch (status) {
			case ENNEMY_TURN :
				ennemyTurn.scroll(scroll);
				break;
			case ACTION_CHOICE :
				actionChoice.scroll(scroll);
				break;
			case TARGET_CHOICE :
				targetChoice.scroll(scroll);
				break;
			case ACTION_COMPLETE :
				actionResolution.scroll(scroll);
				break;
		}
	}
	
	

	public void combatInit() {
		team = Squad.getInstance().getPersonnages();
		combatLoop();
	}

	public void combatLoop() {
		combatOrder = null;
		step = 1;
		Personnage p = combatOrder.get(step);
		if (team.contains(p) && p.isAlive()) {
			status = Status.ACTION_CHOICE;
			actionChoice.reset(p);
		} else if (ennemies.contains(p) && p.isAlive()) {
			Ennemy ennemy = ennemies.get(ennemies.indexOf(p));
			status = Status.ENNEMY_TURN;
			ennemyTurn.reset(ennemy);
		}
	}
	
	private void goToNextStep() {
		step++;
		try {
			Personnage p = combatOrder.get(step);
			if (team.contains(p) && p.isAlive()) {
				status = Status.ACTION_CHOICE;
				actionChoice.reset(p);
			} else if (ennemies.contains(p) && p.isAlive()) {
				Ennemy ennemy = ennemies.get(ennemies.indexOf(p));
				status = Status.ENNEMY_TURN;
				ennemyTurn.reset(ennemy);
			} else {
				goToNextStep();
			}
		} catch (NullPointerException e) {
			if (!isCombatEnded()) {
				combatLoop();
			} else {
				
			}
		}
	}
	
	public boolean isCombatEnded() {
		boolean verif = true;
		boolean verif2 = true;
		for (Personnage p : team) {
			if (p.getLifePoints()> 0 && p.getWillPoints() > 0) {
				verif = false;
				break;
			}
		}
		for (Personnage p : ennemies) {
			if (p.getLifePoints() > 0 && p.getWillPoints() > 0) {
				verif2 = false;
				break;
			}
		}
		if (!verif && !verif2) {
			return false;
		}
		return true;
	}
	
	private ArrayList<Ennemy> getRandomEnnemy() {
		return null;
	}

	private ArrayList<Ennemy> getRandomBoss() {
		return null;
	}

	private ArrayList<Ennemy> getQuestBoss() {
		return null;
	}
	
	
	
	
	
	
	private class EnnemyTurn {
		private void reset(Ennemy p) {
			Personnage target = getRandomPerso();
			p.attaquerPerso(null);
			
		}
		private Personnage getRandomPerso() {
			return team.get((int)(Math.random()*team.size()));
		}
		private void scroll(Scroll scroll) {
			if (scroll == Scroll.CONFIRM) {
				goToNextStep();
			}
		}
	}
	
	private class ActionChoice {
		Personnage p;
		int selection;
		private void reset(Personnage p) {
			this.p = p;
			selection = 0;
			display.combatPersoChoice(p.getName(), selection, team, ennemies);
		}
		private void scroll(Scroll scroll) {
			switch (scroll) {
			case UP :
				if (selection > 0) {
					selection --;
				}
				display.combatPersoChoice(p.getName(), selection, team, ennemies);
				break;
			case DOWN :
				if (selection < 1) {
					selection++;
				}
				display.combatPersoChoice(p.getName(), selection, team, ennemies);
				break;
			case CONFIRM :
				status = Status.TARGET_CHOICE;
				if (selection == 0) {
					targetChoice.reset(p, Action.ATTACK);
				} else if (selection == 1) {
					targetChoice.reset(p, Action.SPELL);
				}
				break;
			}
		}
	}
	
	private class TargetChoice {
		Personnage p;
		int selection;
		Action action;
		ArrayList<Ennemy> tmp;
		private void reset(Personnage p, Action action) {
			this.p = p;
			this.action = action;
			selection = 0;
			tmp = new ArrayList<Ennemy>();
			for (Ennemy e : ennemies) {
				if (e.isAlive()) {
					tmp.add(e);
				}
			}
			display.targetChoice(p.getName(), selection, team, ennemies);
		}
		private void scroll(Scroll scroll) {
			switch (scroll) {
			case UP :
				if (selection > 0) {
					selection--;
				}
				display.targetChoice(p.getName(), selection, team, ennemies);
				break;
			case DOWN :
				if (selection < (tmp.size()-1)) {
					selection++;
				}
				display.targetChoice(p.getName(), selection, team, ennemies);
				break;
			case CONFIRM :
				status = Status.ACTION_COMPLETE;
				actionResolution.reset(p, tmp.get(selection), action);
				break;
			}
		}
	}
	
	private class ActionResolution {
		private void reset(Personnage p, Ennemy ennemy, Action action) {
			
		}
		private void scroll(Scroll scroll) {
			
		}
	}
	
	
	
	
	private enum Status {
		ENNEMY_TURN,
		ACTION_CHOICE,
		TARGET_CHOICE,
		ACTION_COMPLETE;
	}
	
	private enum Action {
		ATTACK,
		SPELL;
	}
	
}