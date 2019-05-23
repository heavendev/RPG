package Projet;

import java.util.HashMap;
import javax.swing.JFrame;

import Intro.*;
import ProjetMenu.*;
import map.*;
import nonActiveClasses.*;

public class Jeu extends JFrame{
	
	private boolean gameOver = false;
	
	private Displaying onDisplay;
	HashMap<String,Object> game = new HashMap<String,Object>();
	
	private MouvementKeyListener mouvementListener = new MouvementKeyListener(this);
	private OurKeyListener keyListener = new OurKeyListener(this);
	
	
	
	public Jeu() {
		this.setSize(50, 20);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(mouvementListener);
		this.addKeyListener(keyListener);
		init();
	}
	
	
	public void init() {
		onDisplay = Displaying.MAIN_MENU;
		try {
			((MainMenu) game.get("MainMenu")).resetMainMenu();
		} catch (NullPointerException e) {
			game.put("MainMenu", new MainMenu(this));
		}
	}
	
	
	
	
	
	
	// Le ScrollActionListener appele cette fonction pour se deplacer dans les menus
	// Menu principal, menu de jeu, inventaire, etc...
	// Affecte uniquement le menu actuellement utilise par la classe de jeu
	// Si aucune classe (carte,...) adequate n'est utilise actuellement, ignore la commande
	
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
			default:
				
				break;
		}
	}
	
	public void moveChar(Direction direction) {
		switch (onDisplay) {
			case MAP :
				((Map) game.get("Map")).move(direction);
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
	
	
	public void startNewGame() {
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
	
	public void initiateMap() {
		onDisplay = Displaying.MAP;
		try {
			((Map) game.get("Map")).resetMap();
		} catch (NullPointerException e) {
			game.put("Map", new Map(this));
		}
	}
	
	
	
	
	
	
	
	public void loadGame() {
		System.out.println("loading game!");
	}
	
	public void quitGame() {
		gameOver = true;
		System.exit(0);
	}
	
	
	
	
	
	
	
	
	public void setOnDisplay(Displaying onDisplay) {
		this.onDisplay = onDisplay;
	}
	public boolean isGameOver() {
		return gameOver;
	}
	
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
	}

}
