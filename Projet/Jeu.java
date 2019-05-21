package Projet;

import java.util.HashMap;
import javax.swing.JFrame;

import Intro.GameplayIntro;
import ProjetMenu.*;

public class Jeu extends JFrame{
	
	private boolean gameOver = false;
	
	HashMap<String,Object> game = new HashMap<String,Object>();
	private MouvementKeyListener mouvementListener = new MouvementKeyListener(this);
	private ScrollingKeyListener menuListener = new ScrollingKeyListener(this);
	private Displaying onDisplay;
	
	
	public Jeu() {
		this.setSize(50, 20);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
//		this.addKeyListener(mouvementListener);
		this.addKeyListener(menuListener);
		init();
	}
	
	
	public void init() {
		game.put("MainMenu", new MainMenu(this));
		onDisplay = Displaying.MAIN_MENU;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void startNewGame() {
		onDisplay = Displaying.INTRO_GAMEPLAY;
		game.put("GameplayIntro", new GameplayIntro(this));
	}
	
	public void goToStoryIntro() {
		onDisplay = Displaying.INTRO_STORY;
	}
	
	public void loadGame() {
		System.out.println("loading game!");
	}
	
	public void quitGame() {
		gameOver = true;
		System.out.println("exiting");
		System.exit(0);
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
				
				break;
			case DIALOGUE :
				
				break;
			case INTRO_GAMEPLAY :
				((GameplayIntro) game.get("GameplayIntro")).scroll(scroll);
				break;
			case INTRO_STORY :
				
				break;
			default:
				break;
		}
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
