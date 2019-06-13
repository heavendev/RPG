package quest;

import game.Jeu;
import nonActiveClasses.QuestStatus;
import nonActiveClasses.Scroll;

public class QuestPageController {
	
	Jeu jeu;
	QuestPageDisplay display;
	Quest currentQuest;
	String currentQuestName;
	String[] questText;
	
	
	
	public QuestPageController(Jeu jeu, Quest quest) {
		this.jeu = jeu;
		display = new QuestPageDisplay();
		reset(quest);
	}

	public void reset(Quest quest) {
		this.currentQuest = quest;
		System.out.println(quest.getStatus());
		switch (quest.getStatus()) {
			case ACCEPTED :
				quest.setStatus(QuestStatus.ONGOING);
				currentQuestName = currentQuest.getQuestName();
				questText = currentQuest.getQuestDescription();
				break;
			case ONGOING :
				quest.setStatus(QuestStatus.COMPLETED);
				currentQuestName = currentQuest.getQuestName();
				questText = currentQuest.getQuestObjectiveReached();
				break;
			case COMPLETED :
				quest.setStatus(QuestStatus.TURNED_IN);
				currentQuestName = currentQuest.getQuestName();
				questText = currentQuest.getQuestTurnIn();
				break;
		}
		display.resetDisplay(currentQuestName, questText, quest.getXPReward(), quest.getGoldReward());
	}

	public void scroll(Scroll scroll) {
		switch (scroll) {
		case CONFIRM :
			jeu.goToMap();
			break;
		}
	}
	
	
	
}