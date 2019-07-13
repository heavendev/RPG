package ProjetMenu;

import game.Jeu;
import nonActiveClasses.Scroll;

public class MainMenuController{
	
	private Jeu jeu;
	private  int selection;
	private MainMenuDisplay display;
	
	public MainMenuController(Jeu jeu) {
		this.jeu = jeu;
		this.display = new MainMenuDisplay();
		display.display();
	}
	
	public void resetMainMenu() {
		selection = 0;
		display.setSelection(this.selection);
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
						jeu.goToGameplayIntro();
						break;
					case (1) :
						jeu.goToLoadGame();
						break;
					case (2) :
						jeu.goToQuitGame();
						break;
				}
				break;
		}
	}
	
}