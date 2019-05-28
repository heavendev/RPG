package connection;

import Projet.Jeu;
import nonActiveClasses.Scroll;

public class Registration{
	
	private Jeu jeu;
	private RegistrationDisplay display;
	private int selection;
	private boolean inUsername = false;
	private boolean inFirstName = false;
	private boolean inLastName = false;
	private boolean inEmail = false;
	private boolean inPassword = false;
	private boolean inPasswordConfirm = false;
	private String username = "";
	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String password = "";
	private String passwordConfirm = "";
	
	public Registration(Jeu jeu) {
		this.jeu = jeu;
		display = new RegistrationDisplay();
	}
	
	public void resetRegistration() {
		
	}

	
	
	public void scroll(Scroll scroll) {
		
	}
	
	
}
