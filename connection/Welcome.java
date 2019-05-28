package connection;

import Projet.Jeu;
import nonActiveClasses.Scroll;

public class Welcome{
	
	Jeu jeu;
	WelcomeDisplay display;
	
	public Welcome(Jeu jeu) {
		this.jeu = jeu;
		display = new WelcomeDisplay();
		display.display();
	}
	
	public void reset() {
		display.display();
	}
	
	public void scroll(Scroll scroll) {
		if (scroll == Scroll.CONFIRM) {
			jeu.goToConnection();
		}
	}
	
}