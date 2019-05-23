package Intro;

import Projet.Jeu;
import nonActiveClasses.Scroll;
import nonActiveClasses.ScrollInterface;

public class StoryIntro implements ScrollInterface{
	
	private Jeu jeu;
	DisplayStoryIntro display;
	
	public void resetStoryIntro() {
		display.showStoryIntro();
	}
	
	public StoryIntro(Jeu jeu) {
		display = new DisplayStoryIntro();
		this.jeu = jeu;
		display.showStoryIntro();
	}
	
	public void scroll(Scroll scroll) {
		switch (scroll) {
			case CONFIRM :
				jeu.initiateMap();
				break;
		}
	}
	
}