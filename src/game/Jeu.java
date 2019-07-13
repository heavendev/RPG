package game;

import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;

import characters.Ennemy;
import data.Squad;
import nonActiveClasses.Direction;
import nonActiveClasses.Displaying;
import nonActiveClasses.QuestStatus;
import nonActiveClasses.Scroll;
import npcs.NPC;
import npcs.NpcLocations;
import quest.Quest;
import ProjetMenu.GameMenuController;
import ProjetMenu.MainMenuController;
import Intro.GameplayIntroController;
import Intro.StoryIntroController;
import map.MapController;
import connection.ConnectionController;
import connection.DatabaseConnector;
import connection.LoginController;
import connection.RegistrationController;
import connection.WelcomeController;
import quest.QuestEventController;
import quest.QuestPageController;
import npcs.NpcController;
import npcs.NpcLocations;

public class Jeu extends JFrame{
	
	private boolean gameOver = false;
	
	private Displaying onDisplay = null;
	private HashMap<String,Object> gameElements = new HashMap<String,Object>();
	
	private MovementKeyListener movementListener = new MovementKeyListener(this);
	private ScrollKeyListener scrollListener = new ScrollKeyListener(this);
	private TypingKeyListener typingListener = new TypingKeyListener(this);
	
	
	public Jeu() {
		this.setSize(50, 20);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(movementListener);
		this.addKeyListener(scrollListener);
		this.addKeyListener(typingListener);
		Squad.getInstance().setCoordinates(62, 13, "main");
		init();
	}
	
	
	public void init() {
		
		/*
		 *		PLACEHOLDER quest and NPC for tests
		 *		creating a custom quest, giving it to a custom NPC
		 */
		
		String[] portrait = {"      rqP.                            ",
							 ":Jr.iSBQQBBBQgXv.                     ",
							 "RQQgggY7JjPgMgRMQD7.                  ",
							 ":Q5XUd:rI1:77ug  gMBBv                ",
							 "jdS2qbri5R7vvr1i.vi7B5                ",
							 "sg2DP1rL77vv777SdL77S:                ",
							 ".BUgI1LvYLsvvrvvjdBX             .    ",
							 " QdgXI7L7Lsj77v7rP1:           :K:    ",
							 "jP.EM5j77rv7ri772.      .qr  iPBY.PBB.",
							 "BB. .Y2JY577uuI15        iQdgBMddBBBQ.",
							 "gQB5.  .:XMr:iirBBdi     rgXK5bPEMQEr ",
							 "EQQBBQ5virgB5.:.7BQBQZ.iBBQIYu2q5L.   ",
							 "ggQRQBBBBBBRgu::.7BBBBBBBQQgdXBB      ",
							 "gMgRRR             BQBRQRQMQQBBg      ",
							 "QgQRRM PERE CASTOR BRQQgRgMRBQB       ",
							 "ZgZgDg             BDgQMZgZgB5        "};
		String[] life = {"blabla","blubliblou","blabla"};
		NPC npc = new NPC("Pere Castor",false,null,portrait,life,"main",41,33);
		String[] description = {"blabla","blubliblou","blabla"};
		String[] presentation = {"blabla","blubliblou","blabluig"};
		String[] objectiveReached = {"blabla","blubliblou"};
		String[] turnIn = {"blabla","blubliblou","FFIIIINNNIIIII"};
		Quest questOne = new Quest("titre 1", QuestStatus.NOT_TAKEN, 44, 33, "main", null, "get", 1, true, 50, 10,
				description, presentation, objectiveReached, turnIn, npc);
		npc.addQuest(questOne);
		ArrayList<NPC> npcs = new ArrayList<NPC>();
		npcs.add(npc);
		NpcLocations.getNpcLocations(npcs);
		
//		goToMainMenu();
//		goToWelcome();
		goToMap();
		
	}
	
	
	
	
	
	/*
	 *	Le ScrollActionListener appelle cette fonction pour se deplacer dans les menus
	 *	(soit partout sauf la carte)
	 *	Affecte uniquement le menu actuellement utilise par la classe de jeu
	 */
	
	public void scroll(Scroll scroll) {
		switch (onDisplay) {
			case MAIN_MENU :
				((MainMenuController) gameElements.get("MainMenu")).scroll(scroll);
				break;
			case GAME_MENU :
				((GameMenuController) gameElements.get("GameMenu")).scroll(scroll);
				break;
			case INTRO_GAMEPLAY :
				((GameplayIntroController) gameElements.get("GameplayIntro")).scroll(scroll);
				break;
			case INTRO_STORY :
				((StoryIntroController) gameElements.get("StoryIntro")).scroll(scroll);
				break;
			case MAP :
				((MapController) gameElements.get("Map")).scroll(scroll);
				break;
			case WELCOME_PAGE :
				((WelcomeController) gameElements.get("Welcome")).scroll(scroll);
				break;
			case CONNECTION_PAGE :
				((ConnectionController) gameElements.get("Connection")).scroll(scroll);
				break;
			case LOGIN_PAGE :
				((LoginController) gameElements.get("Login")).scroll(scroll);
				break;
			case REGISTRATION_PAGE :
				((RegistrationController) gameElements.get("Registration")).scroll(scroll);
				break;
			case QUEST_PAGE :
				((QuestPageController) gameElements.get("QuestPage")).scroll(scroll);
				break;
			case NPC_DIALOGUE :
				((NpcController) gameElements.get("NpcPage")).scroll(scroll);
				break;
			default:
				
				break;
		}
	}
	
	/* 
	 *	Le MouvementKeyListener appelle	cette fonction pour se deplacer sur la carte
	 *
	 *	Ne fait rien si la carte n'est pas la classe actuelle utilise par le jeu
	*/
	
	public void moveChar(Direction direction) {
		switch (onDisplay) {
			case MAP :
				((MapController) gameElements.get("Map")).move(direction);
			break;
		}
	}
	
	
	/*
	 * 	Le TypingKeyListener appelle cette fonction pour rentrer des caracteres
	 * 
	 * 	N'envoie rien si la classe actuelle utilise n'est pas la page de login
	 * 	ou la page d'enregistrement
	 */
	
	
	public void type(String str) {
		switch (onDisplay) {
			case LOGIN_PAGE :
				((LoginController) gameElements.get("Login")).type(str);
				break;
			case REGISTRATION_PAGE :
				((RegistrationController) gameElements.get("Registration")).type(str);
				break;
		}
	}
	
	/*
	 *    fonctions pour recuperer la classe demande
	 *    nom de fonctions "goTo" suivi du nom de la classe
	 *    
	 *    mets l'attribut "onDisplay" a l'equivalent de l'enum "Displaying"
	 *    pour que les keyListeners sachent ou reorienter les commandes
	 *    
	 *    essaye d'abord de recuperer l'instance dans la HashMap d'elements du jeu
	 *    si elle existe, la reset
	 *    sinon, la creer et la met dans la HashMap 
	 *    (elle se reset elle meme dans le constructeur directement)
	 */
	
	public void goToMainMenu() {
		onDisplay = Displaying.MAIN_MENU;
		try {
			((MainMenuController) gameElements.get("MainMenu")).resetMainMenu();
		} catch (NullPointerException e) {
			gameElements.put("MainMenu", new MainMenuController(this));
		}
	}
	public void goToGameMenu() {
		onDisplay = Displaying.GAME_MENU;
		try {
			((GameMenuController) gameElements.get("GameMenu")).resetGameMenu();
		} catch (NullPointerException e) {
			gameElements.put("GameMenu", new GameMenuController(this));
		}
	}
	public void goToGameplayIntro() {
		onDisplay = Displaying.INTRO_GAMEPLAY;
		try {
			((GameplayIntroController) gameElements.get("GameplayIntro")).reset();
		} catch (NullPointerException e) {
			gameElements.put("GameplayIntro", new GameplayIntroController(this));
		}
	}
	public void goToStoryIntro() {
		onDisplay = Displaying.INTRO_STORY;
		try {
			((StoryIntroController) gameElements.get("StoryIntro")).resetStoryIntro();
		} catch (NullPointerException e) {
			gameElements.put("StoryIntro", new StoryIntroController(this));
		}
	}
	public void goToMap() {
		onDisplay = Displaying.MAP;
		try {
			((MapController) gameElements.get("Map")).resetMap();
		} catch (NullPointerException e) {
			gameElements.put("Map", new MapController(this));
		}
	}
	public void goToWelcome() {
		onDisplay = Displaying.WELCOME_PAGE;
		try {
			((WelcomeController) gameElements.get("Welcome")).reset();
		} catch (NullPointerException e) {
			gameElements.put("Welcome", new WelcomeController(this));
		}
	}
	public void goToConnection() {
		onDisplay = Displaying.CONNECTION_PAGE;
		try {
			((ConnectionController) gameElements.get("Connection")).reset();
		} catch (NullPointerException e) {
			gameElements.put("Connection", new ConnectionController(this));
		}
	}
	public void goToLogin() {
		onDisplay = Displaying.LOGIN_PAGE;
		try {
			((LoginController) gameElements.get("Login")).resetLogin();
		} catch (NullPointerException e) {
			gameElements.put("Login", new LoginController(this));
		}
	}
	public void goToRegistration() {
		onDisplay = Displaying.REGISTRATION_PAGE;
		try {
			((RegistrationController) gameElements.get("Registration")).resetRegistration();
		} catch (NullPointerException e) {
			gameElements.put("Registration", new RegistrationController(this));
		}
	}
	public void goToQuest(Quest quest) {
		onDisplay = Displaying.QUEST_PAGE;
		try {
			((QuestPageController) gameElements.get("QuestPage")).reset(quest);
		} catch (NullPointerException e) {
			gameElements.put("QuestPage", new QuestPageController(this, quest));
		}
	}
	public void goToNpcDialogue(NPC npc) {
		onDisplay = Displaying.NPC_DIALOGUE;
		try {
			((NpcController) gameElements.get("NpcPage")).reset(npc);
		} catch (NullPointerException e) {
			gameElements.put("NpcPage", new NpcController(this,npc));
		}
	}
	public void goToQuestEvent(Quest quest) {
		try {
			((QuestEventController) gameElements.get("QuestEvent")).reset(quest);
		} catch (NullPointerException e) {
			gameElements.put("QuestEvent", new QuestEventController(this,quest));
		}
	}
	
	
	
	// PLACEHOLDERS
	
	public void goToLoadGame() {
		System.out.println("loading game!");
		System.exit(0);
	}
	
	public void goToSaveGame() {
		System.out.println("saving game!");
		System.exit(0);
	}
	
	public void goToQuitGame() {
		gameOver = true;
		System.exit(0);
	}
	
	
	
	
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public Displaying getOnDisplay() {
		return onDisplay;
	}
	
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		
		
//		try {
//			DatabaseTest.getDatabaseTest().test();
//		} catch (NoSuchAlgorithmException | SQLException e) {
//			e.printStackTrace();
//		}
		
//		try {
//			DatabaseTest.getDatabaseTest().t();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}

}
