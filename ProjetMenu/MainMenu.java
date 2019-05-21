package ProjetMenu;

import java.io.IOException;

import Projet.Jeu;


public class MainMenu {
	
	private Jeu jeu;
	private  int selection = 0;
	DisplayMainMenu display;
	
	public MainMenu(Jeu jeu) {
		this.jeu = jeu;
		this.display = new DisplayMainMenu();
		display.showMenu();
	}
	
	
	public void scroll (Scroll scroll) {
		switch (scroll) {
			case UP :
				if (selection != 0) {
					selection--;
				}
				display.setSelection(this.selection);
				break;
			case DOWN :
				if (selection != 2) {
					selection++;
				}
				display.setSelection(this.selection);
				break;
			case CONFIRM :
				switch (selection) {
					case (0) :
						jeu.startNewGame();
						break;
					case (1) :
						jeu.loadGame();
						break;
					case (2) :
						jeu.quitGame();
						break;
				}
				break;
		}
		
	}
	
}