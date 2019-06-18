package quest;

import java.util.HashMap;

import nonActiveClasses.QuestStatus;
import npcs.NPC;

public class Quest {
	
	String questName;
	QuestStatus status;
	int coorX;
	int coorY;
	int mainQuestNumber;
	boolean mainQuestChain;
	String map;
	String type;
//	Mob boss;
	int xpReward;
	int goldReward;
	String[] questDescription;
	String[] questPresentation;
	String[] questObjectiveReached;
	String[] questTurnIn;
	NPC questGiver;
	
	
	

	public Quest(String questName, QuestStatus status, int coorX, int coorY, String map, String type, int mainQuestNumber,
			boolean mainQuestChain, int xpReward, int goldReward, String[] questDescription, String[] questPresentation, 
			String[] questObjectiveReached, String[] questTurnIn, NPC questGiver) {
		this.questName = questName;
		this.status = status;
		this.coorX = coorX;
		this.coorY = coorY;
		this.mainQuestNumber = mainQuestNumber;
		this.mainQuestChain = mainQuestChain;
		this.map = map;
		this.type = type;
		this.xpReward = xpReward;
		this.goldReward = goldReward;
		this.questDescription = questDescription;
		this.questPresentation = questPresentation;
		this.questObjectiveReached = questObjectiveReached;
		this.questTurnIn = questTurnIn;
		this.questGiver = questGiver;
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
	public int getMainQuestNumber() {
		return mainQuestNumber;
	}
	public int getXPReward() {
		return xpReward;
	}
	public int getGoldReward() {
		return goldReward;
	}
	public NPC getQuestGiver() {
		return questGiver;
	}
	public String getType() {
		return type;
	}
	public boolean isMainQuestChain() {
		return mainQuestChain;
	}
}