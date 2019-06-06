package Intro;

import game.Jeu;
import nonActiveClasses.Scroll;

public class StoryIntro{
	
	private Jeu jeu;
	StoryIntroDisplay display;
	
	public void resetStoryIntro() {
		display.display();
	}
	
	public StoryIntro(Jeu jeu) {
		display = new StoryIntroDisplay();
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