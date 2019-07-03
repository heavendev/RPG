package combat;

import characters.Boss;
import game.Jeu;
import nonActiveClasses.Scroll;
import quest.Quest;

public class CombatAccueilController {
	
	private Jeu jeu;
	private CombatAccueilDisplay display;
	private Boss boss;
	private Quest quest;
	
	public CombatAccueilController(Jeu jeu) {
		this.jeu = jeu;
		display = new CombatAccueilDisplay();
		reset();
	}
	public CombatAccueilController(Jeu jeu, Boss boss) {
		this.jeu = jeu;
		display = new CombatAccueilDisplay();
		reset(boss);
	}
	public CombatAccueilController(Jeu jeu, Quest quest) {
		this.jeu = jeu;
		display = new CombatAccueilDisplay();
		reset(quest);
	}
	
	public void reset(Quest quest) {
		this.quest = quest;
		this.boss = null;
		display.display();
	}
	public void reset(Boss boss) {
		this.boss = boss;
		this.quest = null;
		display.display();
	}
	public void reset() {
		this.quest = null;
		this.boss = null;
		display.display();
	}
	
	public void scroll(Scroll scroll) {
		if (scroll == Scroll.CONFIRM) {
			if (quest != null) {
//				jeu.goToCombat(quest);
			} else if (boss != null) {
//				jeu.goToCombat(boss);
			} else {
//				jeu.goToCombat();
			}
		}
	}
	
	
}