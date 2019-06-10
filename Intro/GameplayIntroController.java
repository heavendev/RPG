package Intro;

import game.Jeu;
import nonActiveClasses.Scroll;

public class GameplayIntroController{
	
	private Jeu jeu;
	private int page;
	private int selection;
	GameplayIntroDisplay display;
	
	
	public GameplayIntroController(Jeu jeu) {
		display = new GameplayIntroDisplay();
		this.jeu = jeu;
		resetGameplayIntro();
	}
	
	public void resetGameplayIntro() {
		page = 1;
		selection = 2;
		display.setPage(page);
		display.setSelection(selection);
	}
	
	public void scroll(Scroll scroll) {
		switch (scroll) {
			case LEFT :
				if (selection == 2 && page != 1) {
					selection--;
				}
				display.setPage(page);
				display.setSelection(selection);
				break;
			case RIGHT :
				if (selection == 1) {
					selection++;
				}
				display.setPage(page);
				display.setSelection(selection);
				break;
			case CONFIRM :
				switch (page) {
					case 1 :
						page = 2;
						selection = 1;
						display.setPage(page);
						display.setSelection(selection);
						break;
					case 2 :
						switch (selection) {
							case 1 :
								page = 1;
								selection = 2;
								display.setPage(page);
								display.setSelection(selection);
								break;
							case 2 :
								page = 3;
								selection = 1;
								display.setPage(page);
								display.setSelection(selection);
								break;
						}
						break;
					case 3 :
						switch (selection) {
							case 1 :
								page = 2;
								selection = 1;
								display.setPage(page);
								display.setSelection(selection);
								break;
							case 2 :
								jeu.goToStoryIntro();
								break;
					}
						break;
				}
				break;
		}
	}
	
	
}