package gestion_Equipe;

import java.util.ArrayList;
import java.util.HashMap;

import characters.Personnage;
import data.Equipment;
import data.Squad;
import game.Jeu;
import nonActiveClasses.Scroll;
import quest.Quest;

public class ManagementTeamController {

	private Squad s;
	private Jeu jeu;
	private SquadManagingDisplay display;
	private Equipment e;
	private Personnage perso;
	private Status status;
	private MenuController menu;
	private TeamController team;
	private Characters_DetailsController character;
	private InventoryController inventory;
	private QuestsController quests;
	private Inventory_DetailsController equipment;

	public ManagementTeamController(Jeu jeu, Squad s) {
		this.jeu = jeu;
		display = new SquadManagingDisplay();
		// display.displayAndRec(screen);
	}

	private class MenuController {
		int selection;
		String[] screen;
		String[] perso;
		String[] getEquipmentTeam;
		String[] equipmentOwner;
		String[] questName;

		private void reset() {
			selection = 0;
			this.screen = SquadManagingDisplay.getScreen();

		}

		public void scroll(Scroll scroll) {
			switch (scroll) {
			case UP:
				if (selection > 0) {
					selection--;
				}
				display.displayMenu(selection);
				break;

			case DOWN:
				if (selection < 2) {
					selection++;
				}
				display.displayMenu(selection);
				break;

			case LEFT:
				if (selection == 1) {
					selection--;
				}
				display.displayMenu(selection);
				break;

			case RIGHT:
				if (selection == 0) {
					selection++;
				}
				display.displayMenu(selection);
				break;

			case CONFIRM:
				switch (selection) {
				case 0:
					if (selection == 0) {
						status = Status.Team;
					}
					display.displayTeam(selection, perso);
					break;

				case 1:
					if (selection == 1) {
						status = Status.Inventory;

					}
					display.displayInventory(selection, getEquipmentTeam, equipmentOwner);
					break;

				case 2:
					if (selection == 2) {
						status = Status.Quest;
					}

					display.displayQuest(selection, questName);
					break;
				}

			case ESCAPE:

			}
		}

		/*
		 * je développe le cas ou je scroll up donc ma selection est sup a 2 je monte
		 */
	}

	private class TeamController {

		int selection;
		String[] perso;

		public void scroll(Scroll scroll) {
			if (scroll == Scroll.CONFIRM) {
				status = Status.Team;
				display.displayTeam(selection, perso);

			}

			switch (scroll) {
			case UP:
				if (selection > 0) {
					selection--;

				}
				display.displayTeam(selection, perso);
				break;

			case DOWN:
				if (selection < perso.length) {
					selection++;

				}
				display.displayTeam(selection, perso);
				break;

			}

		}

	}

	private class Characters_DetailsController {
		int selection = 0;
		ArrayList<Personnage> character;
		HashMap p;
		String[] perso;
		Personnage name;
		String[] screen;

		// fct reset de l'equipe en cas de retrait ou en cas d'ajout

		public void reset() {
			selection = 0;
			character = s.getPersonnages();
			perso = new String[character.size()];
			p = new HashMap();
			for (int i = 0; i < character.size(); i++) {
				display.displayTeam(i, perso);
			}

		}

		public void scroll(Scroll scroll) {
			if (scroll == Scroll.CONFIRM) {
				status = Status.Team;
				display.displayTeam(selection, perso);
			}

			switch (scroll) {

			case UP:
				if (selection > 0) {
					selection--;

				}
				display.displayTeam(selection, perso);
				break;

			case DOWN:
				if (selection < perso.length) {
					selection++;

				}
				display.displayTeam(selection, perso);
				break;

			case CONFIRM:

				if (selection == perso.length) {
					status = Status.Team;
					display.displayCharactersTeamDdetails(selection, p, name);
				} else {
					jeu.goToGameMenu();
				}
				if (selection > p.size() && screen.equals(screen[14])) {
					status = Status.Remove;
					// calcul pour n'affiche que deux personnage au reset
					// s= perso.length -1;
					display.reset();

				}

			case ESCAPE:
				if (selection > p.size() && screen.equals(screen[12])) {
					status = Status.Back;
					display.displayTeam(selection, perso);
				}

			}

		}
	}

	private class InventoryController {
		int selection;
		String[] getEquipmentTeam;
		String[] equipmentOwner;
		ArrayList<Equipment> e;

		// fct reset apres tous les action eventeullement fait equiper desequiper

		public void reset() {
			selection = 0;
			e = s.getEquipment();
			getEquipmentTeam = new String[e.size()];
			equipmentOwner = new String[e.size()];
			// parcours la liste des equipement et je les affiches
			for (int i = 0; i < e.size(); i++) {
				getEquipmentTeam[i] = e.get(i).getName();
				try {
					// j'affiche mon equipment plus le personnage qui le possede
					getEquipmentTeam[i] = e.get(i).getOwner().getName();
					// mon exception va etre emise pour attraper dans le cas ou mon jouer n'a pas de
					// owner

				} catch (NullPointerException exception) {
					equipmentOwner[i] = "";

				}
			}
			display.displayInventory(selection, getEquipmentTeam, equipmentOwner);

		}

		public void scroll(Scroll scroll) {
			if (scroll == Scroll.CONFIRM) {
				status = Status.Inventory;
				inventory.reset();
			}

			switch (scroll) {

			case UP:
				if (selection > 0) {
					selection--;
				}
				display.displayInventory(selection, getEquipmentTeam, equipmentOwner);
				break;

			case DOWN:
				if (selection < getEquipmentTeam.length) {
					selection++;
				}
				display.displayInventory(selection, getEquipmentTeam, equipmentOwner);
				break;

			}
		}

	}

	private class Inventory_DetailsController {
		int selection;
		boolean equiped;
		String[] screen;
		HashMap h;
		String[] equipmentOwner;
		String[] getEquipmentTeam;
		ArrayList<Equipment> e;

		// fct reset des details

		public void reset() {
			selection = 0;
			inventory.reset();

		}

		public void scroll(Scroll scroll) {

			if (scroll == Scroll.CONFIRM) {
				status = Status.Inventory;
				inventory.reset();
			}
			switch (scroll) {
			case UP:
				if (selection > 0) {
					selection--;
				}
				display.displayInventory(selection, getEquipmentTeam, equipmentOwner);
				break;
			case DOWN:
				if (selection < getEquipmentTeam.length) {
					selection++;
				}
				display.displayInventory(selection, getEquipmentTeam, equipmentOwner);

			case CONFIRM:
				if (selection == getEquipmentTeam.length) {
					status = Status.Inventory;
					display.displayTeamEquipmentDetails(selection, h, equiped);

				} else {
					jeu.goToGameMenu();
				}
				if (selection > h.size() && screen.equals(screen[14])) {
					status = Status.Equip;
					inventory.reset();
				}
				break;

			case ESCAPE:
				if (selection > h.size() && screen.equals(screen[20])) {
					status = Status.Back;
					display.displayInventory(selection, getEquipmentTeam, equipmentOwner);
				}
			}

		}

	}

	private class QuestsController {
		int selection;
		String[] questName;
		ArrayList<Quest> q;

		public void reset() {
			selection = 0;
			q = s.getQuests();
			questName = new String[q.size()];
			for (int i = 0; i < q.size(); i++) {
				questName[i] = q.get(i).getQuestName();
				try {
				 if(status == Status.Ongoing || status == Status.Completed) {
				display.displayQuest(selection, questName);
				
				}
			
				
			}catch(NullPointerException exception) {
				questName[i]= "";
			}
		}
		}
		public void scroll(Scroll scroll) {

			if (scroll == Scroll.CONFIRM) {
				status = Status.Quest;
				quests.reset();
			}
			switch (scroll) {
			case UP:
				if(selection > 0) {
					selection --;
					
				}
				display.displayQuest(selection, questName);
				break;
				
			case DOWN:
				if(selection < questName.length) {
					selection++;
				}
				display.displayQuest(selection, questName);
				break;

			}
		}
	}

	private class Quests_DetailsController {

	}

	private enum Status {
		Back, Remove, Team, Quest, Inventory, Equip, Chacatere_Details, Unequipe, Ongoing, Completed, Equipment_Details;

	}

}
