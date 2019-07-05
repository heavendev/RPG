package combat;

import java.util.ArrayList;

import characters.Boss;
import characters.Ennemy;
import characters.Personnage;
import game.Jeu;
import nonActiveClasses.Scroll;
import quest.Quest;

public class CombatController {

	private Jeu jeu;
	private CombatDisplay display;
	private Quest quest;
	private Boss boss;
	private ArrayList<Ennemy> ennemies;
	private ArrayList<Personnage> persogentil;
	
	public CombatController(Quest quest, Jeu jeu) {
		display = new CombatDisplay();
		this.jeu = jeu;
		reset(quest);
	}

	public CombatController(Boss boss, Jeu jeu) {
		display = new CombatDisplay();
		this.jeu = jeu;
		reset(boss);
	}

	public CombatController(Jeu jeu) {
		display = new CombatDisplay();
		this.jeu = jeu;
		reset();
	}

	public void reset(Quest quest) {
		this.quest = quest;
		ennemies = getQuestBoss();
		combatInit(); 
	}

	public void reset(Boss boss) {
		this.boss = boss;
		ennemies = getRandomBoss();
		combatInit();
		
	}

	/* r�cup�re une liste d'ennemi al�atoire */
	public void reset() {
		ennemies = getRandomEnnemy();
	}
	

	public void scroll(Scroll scroll) {

	}

	public void combatInit() {
       //persogentil = squad.getPersonnage(); 
		/* Les personnes s'afronte � tour de r�le: celui qui attaque est celui qui a le plus de vitesse ou devoir d�finir une 
		 *  un autre trigger pour faire affronter les joueurs */
		//selectionner la personne � attaquer
		
		
		
	}

	public void combatLoop() {

	}

	public void solveEnnemyAction(Personnage c) {

	}

	public void solveAction(Personnage c) {

	}

	// TODO
	public ArrayList<Ennemy> getRandomEnnemy() {
		return null;
	}

	public ArrayList<Ennemy> getRandomBoss() {
		return null;
	}

	public ArrayList<Ennemy> getQuestBoss() {
		return null;
		// return quest.getBoss(); // TODO
	}
	
	
	
	
	public class CombatChoice {
		
	}
	
	public class ActionTarget {
		
	}
}