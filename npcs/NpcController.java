package npcs;

import java.util.ArrayList;
import java.util.HashMap;

import data.Equipment;
import data.GameEquipmentList;
import data.Squad;
import game.Jeu;
import nonActiveClasses.QuestStatus;
import nonActiveClasses.Scroll;
import quest.Quest;

public class NpcController {
	
	private Status status;
	private String[] portrait;
	private boolean questAvailable;
	private boolean turnInAvailable;
	private boolean isTrader;
	private ArrayList<Quest> quests;
	private ArrayList<String> questNames;
	private ArrayList<Quest> questTurnInList;
	private ArrayList<String> questTurnInListNames;
	private Jeu jeu;
	private NpcDisplay display;
	private NPC npc;
	private DialogueController dialogue;
	private LifeController life;
	private QuestListController questList;
	private TurnInListController turnInList;
	private QuestPresentationController questPresentation;
	private MarketBuyController marketBuy;
	private MarketSellController marketSell;
	private ItemCheckController itemCheck;
	private TransactionConfirmedController transactionConfirmed;
	
	
	
	public NpcController(Jeu jeu, NPC npc) {
		this.jeu = jeu;
		display = new NpcDisplay();
		dialogue = new DialogueController();
		life = new LifeController();
		questList = new QuestListController();
		turnInList = new TurnInListController();
		questPresentation = new QuestPresentationController();
		marketBuy = new MarketBuyController();
		marketSell = new MarketSellController();
		reset(npc);
	}
	
	public void reset(NPC npc) {
		this.npc = npc;
		this.portrait = npc.getPortrait();
		this.questAvailable = questAvailable();
		this.turnInAvailable = turnInAvailable();
		this.isTrader = npc.isTrader();
		this.status = Status.DIALOGUE;
		dialogue.reset();
	}
	
	public void scroll(Scroll scroll) {
		switch (status) {
			case DIALOGUE :
				dialogue.scroll(scroll);
				break;
			case LIFE :
				life.scroll(scroll);
				break;
			case QUEST_LIST :
				questList.scroll(scroll);
				break;
			case TURN_IN_LIST :
				turnInList.scroll(scroll);
				break;
			case QUEST_PRESENTATION :
				questPresentation.scroll(scroll);
				break;
			case MARKET_BUY :
				marketBuy.scroll(scroll);
				break;
			case MARKET_SELL :
				marketSell.scroll(scroll);
				break;
			case ITEM_CHECK :
				itemCheck.scroll(scroll);
				break;
			case TRANSACTION_CONFIRMED :
				transactionConfirmed.scroll(scroll);
				break;
		}
	}
	
	private boolean questAvailable() {
		boolean toReturn = false;
		quests = new ArrayList<Quest>();
		questNames = new ArrayList<String>();
		for (Quest quest : npc.getQuests()) {
			if (quest.getMainQuestNumber() <= Squad.getInstance().getMainQuestStage()) {
				toReturn = true;
				quests.add(quest);
				questNames.add(quest.getQuestName());
			}
		}
		return toReturn;
	}
	
	private boolean turnInAvailable() {
		boolean toReturn = false;
		questTurnInList = new ArrayList<Quest>();
		questTurnInListNames = new ArrayList<String>();
		for (Quest quest : Squad.getInstance().getQuests()) {
			if (quest.getStatus() == QuestStatus.COMPLETED && quest.getQuestGiver().equals(npc)) {
				toReturn = true;
				questTurnInList.add(quest);
				questTurnInListNames.add(quest.getQuestName());
			}
		}
		return toReturn;
	}
	
	
	
	
	
	private class DialogueController {
		private int selection;
		private void reset() {
			selection = 0;
			display.displayDialogue(portrait, selection, questAvailable, turnInAvailable, isTrader);
		}
		private void scroll(Scroll scroll) {
			switch (scroll) {
				case UP :
					if (selection > 0) {
						selection--;
					}
					display.displayDialogue(portrait, selection, questAvailable, turnInAvailable, isTrader);
					break;
				case DOWN :
					if (selection < 1 + (questAvailable? 1 : 0) + (turnInAvailable ? 1 : 0) + (isTrader ? 2 : 0)) {
						selection++;
					}
					display.displayDialogue(portrait, selection, questAvailable, turnInAvailable, isTrader);
					break;
				case CONFIRM :
					switch (selection) {
						case 0 :
							status = Status.LIFE;
							life.reset();
							break;
						case 1 :
							if (questAvailable) {
								status = Status.QUEST_LIST;
								questList.reset();
							} else if (turnInAvailable) {
								status = Status.TURN_IN_LIST;
								turnInList.reset();
							} else if (isTrader) {
								status = Status.MARKET_BUY;
								marketBuy.reset();
							} else {
								jeu.goToMap();
							}
							break;
						case 2 :
							if (turnInAvailable && questAvailable) {
								status = Status.TURN_IN_LIST;
								turnInList.reset();
							} else if (isTrader && questAvailable) {
								status = Status.MARKET_BUY;
								marketBuy.reset();
							} else if (isTrader && turnInAvailable) {
								status = Status.MARKET_BUY;
								marketBuy.reset();
							} else if (isTrader) {
								status = Status.MARKET_SELL;
								marketSell.reset();
							} else {
								jeu.goToMap();
							}
							break;
						case 3 :
							if (isTrader && questAvailable && turnInAvailable) {
								status = Status.MARKET_BUY;
								marketBuy.reset();
							} else if (isTrader && (questAvailable || turnInAvailable)) {
								status = Status.MARKET_SELL;
								marketSell.reset();
							} else {
								jeu.goToMap();
							}
							break;
						case 4 :
							if (isTrader && questAvailable && turnInAvailable) {
								status = Status.MARKET_SELL;
								marketSell.reset();
							} else {
								jeu.goToMap();
							}
							break;
						case 5 :
							jeu.goToMap();
							break;
					}
					break;
			}
		}
	}
	
	private class LifeController {
		private void reset() {
			display.displayLife(portrait, npc.getLife());
		}
		private void scroll(Scroll scroll) {
			if (scroll == Scroll.CONFIRM) {
				status = Status.DIALOGUE;
				dialogue.reset();
			}
		}
	}
	
	private class QuestListController {
		private int selection;
		private void reset() {
			selection = 0;
			display.displayQuestList(portrait, questNames, selection);
		}
		private void scroll(Scroll scroll) {
			switch (scroll) {
				case UP :
					if (selection > 0) {
						selection--;
					}
					display.displayQuestList(portrait, questNames, selection);
					break;
				case DOWN :
					if (selection < quests.size()) {
						selection++;
					}
					display.displayQuestList(portrait, questNames, selection);
					break;
				case CONFIRM :
					if (selection == quests.size()) {
						status = Status.DIALOGUE;
						dialogue.reset();
					} else {
						status = Status.QUEST_PRESENTATION;
						questPresentation.reset(quests.get(selection));
					}
					break;
			}
		}
	}
	
	private class TurnInListController {
		private int selection;
		private void reset() {
			selection = 0;
			display.displayQuestList(portrait, questTurnInListNames, selection);
		}
		private void scroll(Scroll scroll) {
			switch (scroll) {
				case UP :
					if (selection > 0) {
						selection--;
					}
					display.displayQuestList(portrait, questTurnInListNames, selection);
					break;
				case DOWN :
					if (selection < questTurnInList.size()) {
						selection++;
					}
					display.displayQuestList(portrait, questTurnInListNames, selection);
					break;
				case CONFIRM :
					if (selection == questTurnInList.size()) {
						status = Status.DIALOGUE;
						dialogue.reset();
					} else {
						jeu.goToQuest(questTurnInList.get(selection));
					}
					break;
			}
		}
	}
	
	private class QuestPresentationController {
		private int selection;
		private Quest quest;
		private void reset(Quest quest) {
			selection = 0;
			this.quest = quest;
			display.displayQuestPresentation(portrait, quest.getQuestPresentation(), selection);
		}
		private void scroll(Scroll scroll) {
			switch (scroll) {
				case LEFT :
					if (selection == 1) {
						selection--;
					}
					display.displayQuestPresentation(portrait, quest.getQuestPresentation(), selection);
					break;
				case RIGHT :
					if (selection == 0) {
						selection++;
					}
					display.displayQuestPresentation(portrait, quest.getQuestPresentation(), selection);
					break;
				case CONFIRM :
					if (selection == 0) {
						quest.acceptQuest(npc);
						jeu.goToQuest(quest);
					} else {
						status = Status.QUEST_LIST;
						questList.reset();
					}
					break;
			}
		}
	}
	
	private class MarketBuyController {
		private int selection;
		private ArrayList<Equipment> list;
		private String[] itemNames;
		private void reset() {
			selection = 0;
			list = GameEquipmentList.getInstance().getList();
			itemNames = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				itemNames[i] = list.get(i).getName();
			}
			display.displayTrade(portrait, itemNames, selection);
		}
		private void scroll(Scroll scroll) {
			switch (scroll) {
				case UP :
					if (selection > 0) {
						selection--;
					}
					display.displayTrade(portrait, itemNames, selection);
					break;
				case DOWN :
					if (selection < list.size()-1) {
						selection++;
					}
					display.displayTrade(portrait, itemNames, selection);
					break;
				case CONFIRM :
					status = Status.ITEM_CHECK;
					itemCheck.reset(list.get(selection), true);
					break;
				case ESCAPE :
					status = Status.DIALOGUE;
					dialogue.reset();
					break;
			}
		}
	}
	
	private class MarketSellController {
		private int selection;
		private ArrayList<Equipment> list;
		private String[] itemNames;
		private void reset() {
			selection = 0;
			list = Squad.getInstance().getEquipment();
			itemNames = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				itemNames[i] = list.get(i).getName();
			}
			display.displayTrade(portrait, itemNames, selection);
		}
		private void scroll(Scroll scroll) {
			switch (scroll) {
				case UP :
					if (selection > 0) {
						selection--;
					}
					display.displayTrade(portrait, itemNames, selection);
					break;
				case DOWN :
					if (selection < list.size()-1) {
						selection++;
					}
					display.displayTrade(portrait, itemNames, selection);
					break;
				case CONFIRM :
					status = Status.ITEM_CHECK;
					itemCheck.reset(list.get(selection), false);
					break;
				case ESCAPE :
					status = Status.DIALOGUE;
					dialogue.reset();
					break;
			}
		}
	}
	
	private class ItemCheckController {
		private Equipment item;
		private int selection;
		private boolean buyingOrSelling;
		private HashMap itemDetails;
		private void reset(Equipment item, boolean buyingOrSelling) {
			this.item = item;
			selection = 0;
			this.buyingOrSelling = buyingOrSelling;
			itemDetails = item.getEquipmentDetails();
			display.displayItemDetails(itemDetails, selection, buyingOrSelling);
		}
		private void scroll(Scroll scroll) {
			switch (scroll) {
			case UP :
				if (selection > 0) {
					selection--;
				}
				display.displayItemDetails(itemDetails, selection, buyingOrSelling);
				break;
			case DOWN :
				if (selection < 1) {
					selection++;
				}
				display.displayItemDetails(itemDetails, selection, buyingOrSelling);
				break;
			case CONFIRM :
				if (selection == 0) {
					status = Status.TRANSACTION_CONFIRMED;
					boolean success = true;
					if (buyingOrSelling && Squad.getInstance().getGold() >= item.getValue()) {
						item.buy();
					} else if (buyingOrSelling) {
						success = false;
					} else {
						item.sell();
					}
					transactionConfirmed.reset(buyingOrSelling, success, item.getName());
				} else {
					if (buyingOrSelling) {
						status = Status.MARKET_BUY;
						marketBuy.reset();
					} else {
						status = Status.MARKET_SELL;
						marketSell.reset();
					}
				}
				break;
			}
		}
	}
	
	private class TransactionConfirmedController {
		private void reset(boolean buyingOrSelling, boolean transactionSuccess, String itemName) {
			display.displayItemTradeConfirmation(buyingOrSelling, transactionSuccess, itemName);
		}
		private void scroll(Scroll scroll) {
			if (scroll == Scroll.CONFIRM) {
				status = Status.DIALOGUE;
				dialogue.reset();
			}
		}
	}
	
	private enum Status {
		DIALOGUE,
		LIFE,
		QUEST_LIST,
		TURN_IN_LIST,
		QUEST_PRESENTATION,
		MARKET_BUY,
		MARKET_SELL,
		ITEM_CHECK,
		TRANSACTION_CONFIRMED;
	}
	
}