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
			
		} else if (p.isAlive()) {
			status = Status.ENNEMY_TURN;
			ennemyTurn.reset(p);
		}
	}
	
	private void goToNextStep() {
		step++;
		try {
			Personnage p = combatOrder.get(step);
			if (team.contains(p) && p.isAlive()) {
				status = Status.ACTION_CHOICE;
				
			} else if (p.isAlive()) {
				status = Status.ENNEMY_TURN;
				ennemyTurn.reset(p);
			}
		} catch (NullPointerException e) {
			if (!isCombatEnded()) {
				combatLoop();
			}
		}
	}
	
	///////////////////////////
	private boolean isCombatEnded() {
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
		private void reset(Personnage p) {
			
		}
		private void scroll(Scroll scroll) {
			if (scroll == Scroll.CONFIRM) {
				goToNextStep();
			}
		}
	}
	
	private class ActionChoice {
		Personnage p;
		private void reset(Personnage p) {
			this.p = p;
			
		}
		private void scroll(Scroll scroll) {
			switch (scroll) {
			case UP :
				
				break;
			case DOWN :
				
				break;
			case CONFIRM :
				status = Status.TARGET_CHOICE;
				targetChoice.reset(p);
				break;
			}
		}
	}
	
	private class TargetChoice {
		private void reset(Personnage p) {
			
		}
		private void scroll(Scroll scroll) {
			
		}
	}
	
	private class ActionResolution {
		private void reset(Personnage p) {
			
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
	
}