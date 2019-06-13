package quest;

import game.Jeu;

public class QuestEventController {
	
	private Jeu jeu;
	
	public QuestEventController(Jeu jeu, Quest quest) {
		this.jeu = jeu;
		reset(quest);
	}
	
	public void reset(Quest quest) {
		if (quest.getType() == "get") {
			jeu.goToQuest(quest);
		} else {
			System.out.println("AAHHHH");
			jeu.goToQuest(quest);
		}
	}
	
	
	
	
	
	
}