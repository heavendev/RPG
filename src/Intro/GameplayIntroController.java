package Intro;

import game.Jeu;
import nonActiveClasses.Scroll;

public class GameplayIntroController{
	
	private Jeu jeu;
	private int page;
	private int selection;
	private GameplayIntroDisplay display;
	
	
	public GameplayIntroController(Jeu jeu) {
		
		// NULL string[] content for all 3 pages, temporary placeholder
		String[] pageOne = {"Page 1"};
		String[] pageTwo = {"Page 2"};
		String[] pageThree = {"Page 3"};
		display = new GameplayIntroDisplay(pageOne,pageTwo,pageThree);
		this.jeu = jeu;
		reset();
	}
	
	public void reset() {
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