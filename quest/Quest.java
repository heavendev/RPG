package quest;

import java.util.HashMap;

import nonActiveClasses.QuestStatus;

public class Quest {
	
	String questName;
	QuestStatus status;
	int coorX;
	int coorY;
	String map;
	String type;
	int xpReward;
	int goldReward;
	String[] questDescription;
	String[] questPresentation;
	String[] questObjectiveReached;
	String[] questTurnIn;
	
	
	

	public Quest(String questName, QuestStatus status, int coorX, int coorY, String map, String type, int xpReward,
			int goldReward, String[] questDescription, String[] questPresentation, String[] questObjectiveReached,
			String[] questTurnIn) {
		super();
		this.questName = questName;
		this.status = status;
		this.coorX = coorX;
		this.coorY = coorY;
		this.map = map;
		this.type = type;
		this.xpReward = xpReward;
		this.goldReward = goldReward;
		this.questDescription = questDescription;
		this.questPresentation = questPresentation;
		this.questObjectiveReached = questObjectiveReached;
		this.questTurnIn = questTurnIn;
	}



	public boolean isAtQuestionLocation(int y, int x, String map) {
		if (coorX == x && coorY == y && this.map.equals(map)) {
			return true;
		}
		return false;
	}
	
	
	public HashMap getQuestLocation() {
		HashMap coors = new HashMap();
		coors.put("x", coorX);
		coors.put("y", coorY);
		coors.put("map", map);
		return coors;
	}
	
	public String getQuestName() {
		return questName;
	}
	public void setQuestName(String questName) {
		this.questName = questName;
	}
	public QuestStatus getStatus() {
		return status;
	}
	public void setStatus(QuestStatus status) {
		this.status = status;
	}
	public String[] getQuestDescription() {
		return questDescription;
	}
	public String[] getQuestPresentation() {
		return questPresentation;
	}
	public String[] getQuestObjectiveReached() {
		return questObjectiveReached;
	}
	public String[] getQuestTurnIn() {
		return questTurnIn;
	}
	
}