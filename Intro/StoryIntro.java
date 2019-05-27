package Intro;

import Projet.Jeu;
import nonActiveClasses.Scroll;
import nonActiveClasses.ScrollInterface;

public class StoryIntro implements ScrollInterface{
	
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