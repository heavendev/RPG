package connection;

import game.Jeu;
import nonActiveClasses.Scroll;

public class WelcomeController{
	
	Jeu jeu;
	WelcomeDisplay display;
	
	public WelcomeController(Jeu jeu) {
		this.jeu = jeu;
		display = new WelcomeDisplay();
		reset();
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