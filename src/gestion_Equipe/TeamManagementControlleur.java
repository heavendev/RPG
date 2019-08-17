//package gestion_Equipe;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import characters.Personnage;
//import data.Equipment;
//import data.Squad;
//import game.Jeu;
//import nonActiveClasses.Scroll;
//import quest.Quest;
//
//public class TeamManagementControlleur {
//
//	private Squad s;
//	private Jeu jeu;
//	private SquadManagingDisplay display;
//	private Status status;
//	private MenuController menu;
//	private TeamController team;
//	private CharactersController character;
//	private InventoryController inventory;
//	private QuestsController quests;
//	private Equipment_DetailsController equipment;
//
//	public TeamManagementControlleur(Jeu jeu, Squad s) {
//		this.jeu = jeu;
//		display = new SquadManagingDisplay();
//
//	}
//
//	private enum Status {
//		Team, Quest, Inventory, Equip, Charactere_Details, Unequip, Ongoing, Completed, Remove, Equipment_Details;
//
//	}
//
//	private class MenuController {
//		private int selection;
//		private String[] perso;
//
//		private void reset() {
//			selection = 0;
//
//		}
//
//		public void scroll(Scroll scroll) {
//			switch (scroll) {
//			case UP:
//				if (selection <= 1) {
//					selection--;
//				}
//				display.displayMenu(this.selection);
//				break;
//			case DOWN:
//				if (selection < 1) {
//					selection++;
//				}
//				display.displayMenu(this.selection);
//				break;
//
//			case LEFT:
//				if (selection != 0) {
//					selection++;
//				}
//				display.displayMenu(this.selection);
//
//			case RIGHT:
//				if (selection != 2) {
//					selection++;
//				}
//				display.displayMenu(this.selection);
//
//			case CONFIRM:
//				switch (selection) {
//				case 0:
//					status = Status.Team;
//					team.display();
//					break;
//
//				case 1:
//					status = Status.Inventory;
//					// inventory.display();
////					selection--;
////				}
////				display.displayMenu(selection);
////				break;
////				
////			case LEFT:
////				if (selection < 0) {
////					selection ++;
////				}
////				display.displayMenu(selection);
////				break;
////				
////			case RIGHT:
////				if (selection < 2) {
////					selection --;
////				}
////				display.displayMenu(selection);
////				
////			case CONFIRM: 
////				switch(selection) {
////				case 0:
////					status =Status.Team;
////					display.displayTeam(selection, perso);
////				break;
////				
////				case 1:
////					status = Status.Inventory;
////					
////				
////			}
//
//				}
//
//			}
//		}
//	}
//
//	private class TeamController {
//		private int selection;
//		private String[] perso;
//
//		private void display() {
//			display.displayTeam(selection, perso);
//		}
//
//		private void scroll(Scroll scroll) {
//			if (scroll == Scroll.CONFIRM) {
//				status = Status.Team;
//				team.display();
//			}
//		}
//
//		private void reset() {
//			selection = 0;
//			display.displayTeam(selection, perso);
//		}
//	}
//
//	private class InventoryController {
//		// declaration de mes variables
//		int selection;
//		String[] getEquipmentTeam;
//		String[] equipmentOwner;
//		ArrayList<Equipment> e;
//
//		// fonction reset en cas d'ajout de retrait d'equipement d'un personnage
//		public void reset() {
//			selection = 0;
//			e = s.getEquipment();
//			getEquipmentTeam = new String[e.size()];
//			equipmentOwner = new String[e.size()];
//			// parcours la liste des equipements de l'equipe et je les affiches
//			for (int i = 0; i < e.size(); i++) {
//				// dans le cas si j'affiche mon equipement mais pas le personnage qui le possède
//				getEquipmentTeam[i] = e.get(i).getName();
//				try {
//					// j'affiche mon equipement plus le personnage qui le possede
//					equipmentOwner[i] = e.get(i).getOwner().getName();
//					// mon exception va être attraper dans le cas ou mon equipement n'a pas d'owner
//				} catch (NullPointerException exception) {
//					// dans le cas ou mon equipementOwner est null j'affiche une string vide.
//					// equipmentOwner[i] = "";
//				}
//			}
//			// j'affiche mon inventaire
//			display.displayInventory(selection, getEquipmentTeam, equipmentOwner);
//		}
//
//		public void Scroll(Scroll scroll) {
//			if (scroll == Scroll.CONFIRM) {
//				status = Status.Inventory;
//				inventory.reset();
//			}
//			switch (scroll) {
//			case UP:
//				if (selection > 6) {
//					selection--;
//
//				}
//				display.displayInventory(selection, getEquipmentTeam, equipmentOwner);
//				break;
//
//			case DOWN:
//				if (selection < 7) {
//					selection++;
//
//				}
//				display.displayInventory(selection, getEquipmentTeam, equipmentOwner);
//				break;
//
//			}
//		}
//
//	}
//
//	private class QuestsController {
//
//	}
//
//	private class Equipment_DetailsController {
//		private String[] getEquipmentTeam;
//		private String[] equipmentOwner;
//		private int selection;
//		private HashMap h;
//		private boolean equiped;
//
//		private void reset() {
//			selection = 0;
//		}
//
//		private void scroll(Scroll scroll) {
//			switch (scroll) {
//			case UP:
//				if (selection > 0) {
//					selection--;
//				}
//				display.displayInventory(selection, getEquipmentTeam, equipmentOwner);
//				break;
//
//			case DOWN:
//				if (selection < 1) {
//					selection++;
//				}
//				display.displayInventory(selection, getEquipmentTeam, equipmentOwner);
//				break;
//
//			case CONFIRM:
//				if (selection == 0) {
//					if (e.getOwner() != null) {
//						e.unequip();
//						status = Status.Equip;
//						inventory.reset();
//					} else {
//						// savoir chez qui je l'equipe ;
//					}
//				} else {
//					status = Status.Equip;
//					inventory.reset();
//				}
//
//			}
//		}
//
//	}
//
//	private class CharactersController {
//		private int selection;
//		private String[] perso;
//		private Personnage name;
//		private HashMap p;
//
//		private void reset() {
//			selection = 0;
//
//		}
//
//		private void scroll(Scroll scroll) {
//			switch (scroll) {
//			case UP:
//				if (selection > 0) {
//					selection--;
//				}
//				display.displayTeam(selection, perso);
//				break;
//
//			case DOWN:
//				if (selection < perso.length) {
//					selection++;
//				}
//				display.displayTeam(selection, perso);
//				break;
//			case CONFIRM:
//				switch (selection) {
//				case 0:
//					status = Status.Team;
//					team.reset();
//					break;
//
//				case 1:
//					if (selection == perso.length) {
//						status = Status.Charactere_Details;
//					}
//					display.displayCharactersTeamDdetails(selection, p, name);
//					break;
//
//				case 2:
//					if (selection == perso.length && status == Status.Remove) {
//						display.displayTeam(selection, perso);
//					}
//					team.reset();
//					break;
//
//				}
//				break;
//
//			}
//		}
//
//	}
//}
