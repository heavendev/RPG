package connection;

import Projet.Jeu;
import nonActiveClasses.Scroll;
import nonActiveClasses.ScrollInterface;

public class Connection implements ScrollInterface{
	
	Jeu jeu;
	ConnectionDisplay display;
	private int selection;
	
	public Connection(Jeu jeu) {
		this.jeu = jeu;
		selection = 1;
		display = new ConnectionDisplay(selection);
	}
	
	public void reset() {
		selection = 1;
		display.setSelection(selection);
	}
	
	public void scroll(Scroll scroll) {
		switch (scroll) {
		case UP :
			if (selection == 2) {
				selection--;
			}
			display.setSelection(selection);
			break;
		case DOWN :
			if (selection == 1) {
				selection++;
			}
			display.setSelection(selection);
			break;
		case CONFIRM :
			if (selection == 1) {
				jeu.goToLoginPage();
			} else if (selection == 2) {
				jeu.goToRegistrationPage();
			}
			break;
		}
	}
	
	
}