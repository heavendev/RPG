package Projet;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JFrame;

import Intro.*;
import ProjetMenu.*;
import map.*;
import nonActiveClasses.*;
import connection.*;

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
		init();
	}
	
	
	public void init() {
//		goToMainMenu();
		goToWelcome();
	}
	
	
	
	
	
	
//	 Le ScrollActionListener appelle cette fonction pour se deplacer dans les menus
//	 (soit partout sauf la carte)
//	 Affecte uniquement le menu actuellement utilise par la classe de jeu (var onDisplay)
	
	public void scroll(Scroll scroll) {
		switch (onDisplay) {
			case MAIN_MENU :
				((MainMenu) gameElements.get("MainMenu")).scroll(scroll);
				break;
			case GAME_MENU :
				((GameMenu) gameElements.get("GameMenu")).scroll(scroll);
				break;
			case DIALOGUE :
				
				break;
			case INTRO_GAMEPLAY :
				((GameplayIntro) gameElements.get("GameplayIntro")).scroll(scroll);
				break;
			case INTRO_STORY :
				((StoryIntro) gameElements.get("StoryIntro")).scroll(scroll);
				break;
			case MAP :
				((Map) gameElements.get("Map")).scroll(scroll);
				break;
			case WELCOME_PAGE :
				((Welcome) gameElements.get("Welcome")).scroll(scroll);
				break;
			case CONNECTION_PAGE :
				((Connection) gameElements.get("Connection")).scroll(scroll);
				break;
			case LOGIN_PAGE :
				((Login) gameElements.get("Login")).scroll(scroll);
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
				((Map) gameElements.get("Map")).move(direction);
			break;
		}
	}
	
	
	public void type(String str) {
		switch (onDisplay) {
			case LOGIN_PAGE :
				((Login) gameElements.get("Login")).type(str);
				break;
			default :
				break;
		}
	}
	
	
	
	
	public void goToMainMenu() {
		onDisplay = Displaying.MAIN_MENU;
		try {
			((MainMenu) gameElements.get("MainMenu")).resetMainMenu();
		} catch (NullPointerException e) {
			gameElements.put("MainMenu", new MainMenu(this));
		}
	}
	
	public void goToGameMenu() {
		onDisplay = Displaying.GAME_MENU;
		try {
			((GameMenu) gameElements.get("GameMenu")).resetGameMenu();
		} catch (NullPointerException e) {
			gameElements.put("GameMenu", new GameMenu(this));
		}
	}
	
	public void goToGameplayIntro() {
		onDisplay = Displaying.INTRO_GAMEPLAY;
		try {
			((GameplayIntro) gameElements.get("GameplayIntro")).resetGameplayIntro();
		} catch (NullPointerException e) {
			gameElements.put("GameplayIntro", new GameplayIntro(this));
		}
	}
	
	public void goToStoryIntro() {
		onDisplay = Displaying.INTRO_STORY;
		try {
			((StoryIntro) gameElements.get("StoryIntro")).resetStoryIntro();
		} catch (NullPointerException e) {
			gameElements.put("StoryIntro", new StoryIntro(this));
		}
	}
	
	public void goToMap() {
		onDisplay = Displaying.MAP;
		try {
			((Map) gameElements.get("Map")).resetMap();
		} catch (NullPointerException e) {
			gameElements.put("Map", new Map(this));
		}
	}
	
	public void goToWelcome() {
		onDisplay = Displaying.WELCOME_PAGE;
		try {
			((Welcome) gameElements.get("Welcome")).reset();
		} catch (NullPointerException e) {
			gameElements.put("Welcome", new Welcome(this));
		}
	}
	
	public void goToConnection() {
		onDisplay = Displaying.CONNECTION_PAGE;
		try {
			((Connection) gameElements.get("Connection")).reset();
		} catch (NullPointerException e) {
			gameElements.put("Connection", new Connection(this));
		}
	}
	
	public void goToLogin() {
		onDisplay = Displaying.LOGIN_PAGE;
		try {
			((Login) gameElements.get("Login")).resetLogin();
		} catch (NullPointerException e) {
			gameElements.put("Login", new Login(this));
		}
	}
	
	public void goToRegistration() {
		onDisplay = Displaying.REGISTRATION_PAGE;
		try {
			((Registration) gameElements.get("Registration")).resetRegistration();
		} catch (NullPointerException e) {
			gameElements.put("Registration", new Registration(this));
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
	
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
	}

}
