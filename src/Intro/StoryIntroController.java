package Intro;

import game.Jeu;
import nonActiveClasses.Scroll;

public class StoryIntroController{
	
	private Jeu jeu;
	StoryIntroDisplay display;
	
	public void resetStoryIntro() {
		display.display();
	}
	
	public StoryIntroController(Jeu jeu) {
		String[] page = {"blablibloublublebllaaa"};
		display = new StoryIntroDisplay(page);
		this.jeu = jeu;
		display.display();
	}
	
	public void scroll(Scroll scroll) {
		switch (scroll) {
			case CONFIRM :
				jeu.goToMap();
				break;
		}
	}
	
}