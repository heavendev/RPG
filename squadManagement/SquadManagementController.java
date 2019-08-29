package squadManagement;

import java.util.ArrayList;
import java.util.HashMap;

import characters.Personnage;
import data.Equipment;
import data.Squad;
import game.Jeu;
import nonActiveClasses.QuestStatus;
import nonActiveClasses.Scroll;
import quest.Quest;

public class SquadManagementController {

	private Squad s;
	private Jeu jeu;
	private SquadManagementDisplay display;
	private MenuController menu;
	private TeamController team;
	private CharactersDetailsController characterDetails;
	private InventoryController inventory;
	private ItemDetailsController itemDetails;
	private EquipmentCharacterChoice characterChoice;
	private QuestsController quests;
	private QuestsDetailsController questDetails;
	
	private Status status;
	
	public SquadManagementController(Jeu jeu) {
		this.jeu = jeu;
		this.s = Squad.getInstance();
		display = new SquadManagementDisplay();
		menu = new MenuController();
		team = new TeamController();
		characterDetails = new CharactersDetailsController();
		inventory = new InventoryController();
		quests = new QuestsController();
		itemDetails = new ItemDetailsController();
		characterChoice = new EquipmentCharacterChoice();
		questDetails = new QuestsDetailsController();
		reset();
	}
	
	public void reset() {
		status = Status.MENU;
		menu.reset();
	}
	
	public void scroll(Scroll scroll) {
		switch (status) {
			case MENU :
				menu.scroll(scroll);
				break;
			case TEAM :
				team.scroll(scroll);
				break;
			case CHARACTER_DETAILS :
				characterDetails.scroll(scroll);
				break;
			case INVENTORY :
				inventory.scroll(scroll);
				break;
			case ITEM_DETAILS :
				itemDetails.scroll(scroll);
				break;
			case CHARACTER_CHOICE :
//				characterChoice.scroll(scroll);
				break;
			case QUESTS :
				quests.scroll(scroll);
				break;
			case QUEST_DETAILS :
//				questDetails.scroll(scroll);
				break;
		}
	}
	
	private class MenuController {
		int selection;
		private void reset() {
			selection = 0;
		}
		public void scroll(Scroll scroll) {
			switch (scroll) {
				case LEFT:
					if (selection > 0) {
						selection--;
					}
					display.displayMenu(selection);
					break;
				case RIGHT:
					if (selection < 2) {
						selection++;
					}
					display.displayMenu(selection);
					break;
				case CONFIRM:
					switch (selection) {
						case 0:
							status = Status.TEAM;
							team.reset();
							break;
						case 1:
							status = Status.INVENTORY;
							//////////
							break;
						case 2:
							status = Status.QUESTS;
							//////////
						break;
					}
			case ESCAPE:
				jeu.goToMap();
				break;
			}
		}
	}
	
	private class TeamController {
		private int selection;
		private String[] perso;
		private void reset() {
			selection = 0;
			ArrayList<Personnage> chars = s.getPersonnages();
			perso = new String[chars.size()];
			for (int i = 0; i < chars.size(); i++) {
				perso[i] = chars.get(i).getName();
			}
			display.displayTeam(selection, perso);
		}
		private void scroll(Scroll scroll) {
			switch (scroll) {
				case UP:
					if (selection > 0) {
						selection--;
					}
					display.displayTeam(selection, perso);
					break;
				case DOWN:
					if (selection < perso.length - 1) {
						selection++;
					}
					display.displayTeam(selection, perso);
					break;
				case CONFIRM :
					status = Status.CHARACTER_DETAILS;
					characterDetails.reset(s.getPersonnages().get(selection));
					break;
				case ESCAPE :
					status = Status.MENU;
					menu.reset();
			}
		}
	}
	

	private class CharactersDetailsController {
		int selection = 0;
		HashMap p;
		public void reset(Personnage perso) {
			selection = 0;
			p = new HashMap();
			p.put("name", perso.getName());
			p.put("attack", perso.getAttack());
			p.put("defence", perso.getDefence());
			p.put("magic", perso.getMagic());
			p.put("resistance", perso.getResistance());
			p.put("speed", perso.getSpeed());
			p.put("lifePoints", perso.getLifePoints());
			p.put("willPoints", perso.getWillPoints());
			display.displayCharactersTeamDetails(selection, p);
		}
		public void scroll(Scroll scroll) {
			switch (scroll) {
				case UP:
					if (selection > 0) {
						selection--;
					}
					display.displayCharactersTeamDetails(selection, p);
					break;
				case DOWN:
					if (selection < 1 - (p.get("name") == "Peter Pan" ? 1 : 0)) {
						selection++;
					}
					display.displayCharactersTeamDetails(selection, p);
					break;
				case CONFIRM:
					if (selection == 0) {
						status = Status.TEAM;
						team.reset();
					} else {
						s.removePersonnage(s.getPerso((String) p.get("name")));
						status = Status.TEAM;
						team.reset();
					}
			}
		}
	}

	private class InventoryController {
		int selection;
		String[] equipmentName;
		String[] equipmentOwner;
		ArrayList<Equipment> equipment;
		public void reset() {
			selection = 0;
			equipment = s.getEquipment();
			equipmentName = new String[equipment.size()];
			equipmentOwner = new String[equipment.size()];
			for (int i = 0; i < equipment.size(); i++) {
				equipmentName[i] = equipment.get(i).getName();
				try {
					equipmentName[i] = equipment.get(i).getOwner().getName();
				} catch (NullPointerException exception) {
					equipmentOwner[i] = "";
				}
			}
			display.displayInventory(selection, equipmentName, equipmentOwner);
		}
		public void scroll(Scroll scroll) {
			switch (scroll) {
				case UP:
					if (selection > 0) {
						selection--;
					}
					display.displayInventory(selection, equipmentName, equipmentOwner);
					break;
				case DOWN:
					if (selection < equipmentName.length - 1) {
						selection++;
					}
					display.displayInventory(selection, equipmentName, equipmentOwner);
					break;
				case CONFIRM :
					status = Status.ITEM_DETAILS;
					itemDetails.reset(equipment.get(selection));
					break;
				case ESCAPE :
					status = Status.MENU;
					menu.reset();
			}
		}
	}
	

	private class ItemDetailsController {
		int selection;
		boolean equiped;
		HashMap h;
		Equipment e;
		public void reset(Equipment e) {
			this.e = e;
			selection = 0;
			h = new HashMap();
			if (e.getOwner() != null) {
				equiped = false;
				h.put("equipmentOwner", e.getOwner());
			} else {
				equiped = true;
				h.put("equipmentOwner", "");
			}
			h.put("attackBonus", e.getAttackBonus());
			h.put("defenceBonus", e.getDefenceBonus());
			h.put("magicBonus", e.getMagicBonus());
			h.put("resistanceBonus", e.getResistanceBonus());
			h.put("speedBonus", e.getSpeedBonus());
			h.put("lifePointsBonus", e.getLifePointsBonus());
			h.put("willPointsBonus", e.getWillPointsBonus());
			h.put("value", e.getValue());
			display.displayEquipmentDetails(selection, h, equiped);
		}
		public void scroll(Scroll scroll) {
			switch (scroll) {
				case UP:
					if (selection > 0) {
						selection--;
					}
					display.displayEquipmentDetails(selection, h, equiped);
					break;
				case DOWN:
					if (selection < 1) {
						selection++;
					}
					display.displayEquipmentDetails(selection, h, equiped);
					break;
				case CONFIRM:
					if (selection == 0) {
						if (equiped) {
							status = Status.INVENTORY;
							e.unequip();
							inventory.reset();
						} else {
							status = Status.CHARACTER_CHOICE;
							characterChoice.reset(e);
						}
					} else {
						status = Status.INVENTORY;
						inventory.reset();
					}
					break;
			}
		}
	}
	
	private class EquipmentCharacterChoice {
		private int selection;
		private String[] perso;
		Equipment e;
		private void reset(Equipment e) {
			this.e = e;
			selection = 0;
			ArrayList<Personnage> chars = s.getPersonnages();
			perso = new String[chars.size()];
			for (int i = 0; i < chars.size(); i++) {
				perso[i] = chars.get(i).getName();
			}
			display.displayTeam(selection, perso);
		}
		private void scroll(Scroll scroll) {
			switch (scroll) {
				case UP:
					if (selection > 0) {
						selection--;
					}
					display.displayTeam(selection, perso);
					break;
				case DOWN:
					if (selection < perso.length - 1) {
						selection++;
					}
					display.displayTeam(selection, perso);
					break;
				case CONFIRM :
					e.equip(s.getPersonnages().get(selection));
					status = Status.INVENTORY;
					inventory.reset();
					break;
				case ESCAPE :
					status = Status.ITEM_DETAILS;
					itemDetails.reset(e);
			}
		}
	}
	

	private class QuestsController {
		int selection;
		String[] questName;
		ArrayList<Quest> q;
		
		public void reset() {
			selection = 0;
			ArrayList<Quest> tmp = s.getQuests();
			q = new ArrayList<Quest>();
			for (int i = 0; i < tmp.size(); i++) {
				QuestStatus qStatus = tmp.get(i).getStatus()
				if (qStatus == QuestStatus.COMPLETED || qStatus == QuestStatus.ONGOING) {
					tmp.add(tmp.get(i));
				}
			}
			questName = new String[q.size()];
			for (int i = 0; i < q.size(); i++) {
				questName[i] = q.get(i).getQuestName();
			}
			display.displayQuest(selection, questName);
		}
		public void scroll(Scroll scroll) {
			switch (scroll) {
				case UP:
					if(selection > 0) {
						selection --;
					}
					display.displayQuest(selection, questName);
					break;
				case DOWN:
					if(selection < questName.length - 1) {
						selection++;
					}
					display.displayQuest(selection, questName);
					break;
				case CONFIRM :
					status = Status.QUEST_DETAILS;
					questDetails.reset(q.get(selection));
					break;
				case ESCAPE :
					status = Status.MENU;
					menu.reset();
					break;
			}
		}
	}
	

	private class QuestsDetailsController {
		private void reset(Quest quest) {
			String[] questDescription;
			if (quest.getStatus() == QuestStatus.COMPLETED) {
				questDescription = quest.getQuestObjectiveReached();
			} else {
				questDescription = quest.getQuestDescription();
			}
			display.displayQuestDetails(quest.getStatus(), quest.getQuestName(), questDescription);
		}
		private void scroll(Scroll scroll) {
			switch (scroll) {
				case ESCAPE :
					status = Status.QUESTS;
					quests.reset();
					break;
				case CONFIRM :
					status = Status.QUESTS;
					quests.reset();
					break;
			}
		}
	}

	private enum Status {
		MENU,
		TEAM,
		CHARACTER_DETAILS,
		INVENTORY,
		ITEM_DETAILS,
		CHARACTER_CHOICE,
		QUESTS,
		QUEST_DETAILS;
	}

}