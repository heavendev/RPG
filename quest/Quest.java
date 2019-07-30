package quest;

import java.util.HashMap;

import characters.Personnage;
import data.Equipment;
import data.Squad;
import nonActiveClasses.QuestStatus;
import npcs.NPC;

public class Quest {
	
	private String questName;
	private QuestStatus status;
	private int coorX;
	private int coorY;
	private int mainQuestNumber;
	private boolean mainQuestChain;
	private String map;
	private String type;
	private String boss;
	private int xpReward;
	private int goldReward;
	private Equipment equipmentReward;
	private Personnage charReward;
	private NPC npcReward;
	private String[] questDescription;
	private String[] questPresentation;
	private String[] questObjectiveReached;
	private String[] questTurnIn;
	private NPC questGiver;
	
	
	
	
	public Quest(String questName, QuestStatus status, int coorX, int coorY, String map, String type, 
			String boss, int mainQuestNumber,boolean mainQuestChain, int xpReward,Equipment equipmentReward, 
			Personnage charReward, NPC npcReward, int goldReward, String[] questDescription, String[] questPresentation,
			String[] questObjectiveReached, String[] questTurnIn, NPC questGiver) {
		this.questName = questName;
		this.status = status;
		this.coorX = coorX;
		this.coorY = coorY;
		this.mainQuestNumber = mainQuestNumber;
		this.mainQuestChain = mainQuestChain;
		this.map = map;
		this.type = type;
		this.boss = boss;
		this.xpReward = xpReward;
		this.equipmentReward = equipmentReward;
		this.goldReward = goldReward;
		this.charReward = charReward;
		this.npcReward = npcReward;
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
	
	public void acceptQuest(NPC npc) {
		this.status = QuestStatus.ACCEPTED;
		Squad.getInstance().addQuest(this);
		npc.removeQuest(this);
	}
	
	public String ifIsBossQuest() {
		if (type == "boss") {
			return boss;
		} else {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	public Equipment getEquipmentReward() {
		return equipmentReward;
	}
	public void setEquipmentReward(Equipment equipmentReward) {
		this.equipmentReward = equipmentReward;
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
	public String getBoss() {
		return boss;
	}
}