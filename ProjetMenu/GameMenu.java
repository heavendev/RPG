package ProjetMenu;

import game.Jeu;
import nonActiveClasses.Scroll;

public class GameMenu{
	
	private Jeu jeu;
	private int selection = 0;
	private GameMenuDisplay display;
	
	public GameMenu(Jeu jeu) {
		this.jeu = jeu;
		display = new GameMenuDisplay();
		display.display();
	}
	
	public void resetGameMenu() {
		selection = 0;
		display.setSelection(selection);
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
						jeu.goToMap();
						break;
					case (1) :
						jeu.goToSaveGame();
						break;
					case (2) :
						jeu.goToMainMenu();
						break;
				}
				break;
		}
	}
}