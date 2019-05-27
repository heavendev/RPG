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
	private HashMap<String,Object> game = new HashMap<String,Object>();
	
	private MouvementKeyListener mouvementListener = new MouvementKeyListener(this);
	private ScrollKeyListener keyListener = new ScrollKeyListener(this);
	private TypingKeyListener typingListener = new TypingKeyListener(this);
	
	
	public Jeu() {
		this.setSize(50, 20);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(mouvementListener);
		this.addKeyListener(keyListener);
		this.addKeyListener(typingListener);
		init();
	}
	
	
	public void init() {
		goToMainMenu();
//		goToWelcome();
	}
	
	
	
	
	
	
//	 Le ScrollActionListener appelle cette fonction pour se deplacer dans les menus
//	 (soit partout sauf la carte)
//	 Affecte uniquement le menu actuellement utilise par la classe de jeu (var onDisplay)
	
	public void scroll(Scroll scroll) {
		switch (onDisplay) {
			case MAIN_MENU :
				((MainMenu) game.get("MainMenu")).scroll(scroll);
				break;
			case GAME_MENU :
				((GameMenu) game.get("GameMenu")).scroll(scroll);
				break;
			case DIALOGUE :
				
				break;
			case INTRO_GAMEPLAY :
				((GameplayIntro) game.get("GameplayIntro")).scroll(scroll);
				break;
			case INTRO_STORY :
				((StoryIntro) game.get("StoryIntro")).scroll(scroll);
				break;
			case MAP :
				((Map) game.get("Map")).scroll(scroll);
				break;
			case WELCOME_PAGE :
				((Welcome) game.get("Welcome")).scroll(scroll);
				break;
			case CONNECTION_PAGE :
				((Connection) game.get("Connection")).scroll(scroll);
				break;
			case LOGIN_PAGE :
				((Login) game.get("Login")).scroll(scroll);
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
				((Map) game.get("Map")).move(direction);
			break;
		}
	}
	
	
	public void type(String str) {
		switch (onDisplay) {
			case LOGIN_PAGE :
				((Login) game.get("Login")).type(str);
				break;
			default :
				break;
		}
	}
	
	
	
	
	public void goToMainMenu() {
		onDisplay = Displaying.MAIN_MENU;
		try {
			((MainMenu) game.get("MainMenu")).resetMainMenu();
		} catch (NullPointerException e) {
			game.put("MainMenu", new MainMenu(this));
		}
	}
	
	public void goToGameMenu() {
		onDisplay = Displaying.GAME_MENU;
		try {
			((GameMenu) game.get("GameMenu")).resetGameMenu();
		} catch (NullPointerException e) {
			game.put("GameMenu", new GameMenu(this));
		}
	}
	
	public void goToGameplayIntro() {
		onDisplay = Displaying.INTRO_GAMEPLAY;
		try {
			((GameplayIntro) game.get("GameplayIntro")).resetGameplayIntro();
		} catch (NullPointerException e) {
			game.put("GameplayIntro", new GameplayIntro(this));
		}
	}
	
	public void goToStoryIntro() {
		onDisplay = Displaying.INTRO_STORY;
		try {
			((StoryIntro) game.get("StoryIntro")).resetStoryIntro();
		} catch (NullPointerException e) {
			game.put("StoryIntro", new StoryIntro(this));
		}
	}
	
	public void goToMap() {
		onDisplay = Displaying.MAP;
		try {
			((Map) game.get("Map")).resetMap();
		} catch (NullPointerException e) {
			game.put("Map", new Map(this));
		}
	}
	
	public void goToWelcome() {
		onDisplay = Displaying.WELCOME_PAGE;
		try {
			((Welcome) game.get("Welcome")).reset();
		} catch (NullPointerException e) {
			game.put("Welcome", new Welcome(this));
		}
	}
	
	public void goToConnection() {
		onDisplay = Displaying.CONNECTION_PAGE;
		try {
			((Connection) game.get("Connection")).reset();
		} catch (NullPointerException e) {
			game.put("Connection", new Connection(this));
		}
	}
	
	public void goToLoginPage() {
		onDisplay = Displaying.LOGIN_PAGE;
		try {
			((Login) game.get("Login")).resetLogin();
		} catch (NullPointerException e) {
			game.put("Login", new Login(this));
		}
	}
	
	public void goToRegistrationPage() {
		onDisplay = Displaying.REGISTRATION_PAGE;
		try {
			((Registration) game.get("Registration")).resetRegistration();
		} catch (NullPointerException e) {
			game.put("Registration", new Registration(this));
		}
	}
	
	
	
	
	// PLACEHOLDERS
	
	public void loadGame() {
		System.out.println("loading game!");
		System.exit(0);
	}
	
	public void saveGame() {
		System.out.println("saving game!");
		System.exit(0);
	}
	
	public void quitGame() {
		gameOver = true;
		System.exit(0);
	}
	
	
	
	
	
	
	
	public void setOnDisplay(Displaying onDisplay) {
		this.onDisplay = onDisplay;
	}
	public Displaying getOnDisplay() {
		return onDisplay;
	}
	public boolean isGameOver() {
		return gameOver;
	}
	
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
	}

}
