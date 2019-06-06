package connection;

import game.Jeu;
import nonActiveClasses.Scroll;

public class Connection{
	
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
				jeu.goToLogin();
			} else if (selection == 2) {
				jeu.goToRegistration();
			}
			break;
		}
	}
	
	
}