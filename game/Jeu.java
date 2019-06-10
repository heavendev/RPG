package game;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JFrame;

import Intro.*;
import ProjetMenu.*;
import map.*;
import nonActiveClasses.*;
import quest.Quest;
import quest.QuestPageController;
import connection.*;
import data.Squad;

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
		goToMainMenu();
//		goToWelcome();
//		goToMap();
	}
	
	
	
	
	
	
//	 Le ScrollActionListener appelle cette fonction pour se deplacer dans les menus
//	 (soit partout sauf la carte)
//	 Affecte uniquement le menu actuellement utilise par la classe de jeu (var onDisplay)
	
	public void scroll(Scroll scroll) {
		switch (onDisplay) {
			case MAIN_MENU :
				((MainMenuController) gameElements.get("MainMenu")).scroll(scroll);
				break;
			case GAME_MENU :
				((GameMenuController) gameElements.get("GameMenu")).scroll(scroll);
				break;
			case DIALOGUE :
				
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
				((QuestPageController) gameElements.get("QuestActionResolver")).scroll(scroll);
				break;
			default:
				
				break;
		}
	}
	
//	Le MouvementKeyListener appelle	cette fonction pour se deplacer sur la carte
//	Ne fait rien si la carte n'est pas la classe actuelle utilise par le jeu
	
	public void moveChar(Direction direction) {
		switch (onDisplay) {
			case MAP :
				((MapController) gameElements.get("Map")).move(direction);
			break;
		}
	}
	
	
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
			((GameplayIntroController) gameElements.get("GameplayIntro")).resetGameplayIntro();
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
	
	public void goToQuestPage(Quest quest) {
		onDisplay = null;
		try {
			((QuestPageController) gameElements.get("QuestPage")).reset(quest);
		} catch (NullPointerException e) {
			gameElements.put("QuestPage", new QuestPageController(this, quest));
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
	}

}
