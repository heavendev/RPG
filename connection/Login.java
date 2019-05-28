package connection;

import java.sql.SQLException;
import java.util.HashMap;

import Projet.Jeu;
import data.userData;
import nonActiveClasses.Scroll;

public class Login{
	
	private Jeu jeu;
	private LoginDisplay display;
	private int selection;
	private boolean inName = false;
	private boolean inPassword = false;
	private String username = "";
	private String password = ""; 
	
	
	public Login(Jeu jeu) {
		this.jeu = jeu;
		display = new LoginDisplay();
		selection = 1;
		display.setSelection(1);
	}
	
	public void resetLogin() {
		selection = 1;
		display.setSelection(1);
		username = "";
		password = "";
		inName = false;
		inPassword = false;
	}
	
	public void scroll(Scroll scroll) {
		switch (scroll) {
			case UP :
				if (selection != 1 && !inName && !inPassword) {
					selection--;
					display.setSelection(selection);
				}
				break;
			case DOWN :
				if (selection != 4 && !inName && !inPassword) {
					selection ++;
					display.setSelection(selection);
				}
				break;
			case CONFIRM :
				switch (selection) {
					case 1 :
						jeu.goToConnection();
						break;
					case 2 :
						if (inName) {
							inName = false;
						} else {
							inName = true;
							display.setUsername(username);
						}
						break;
					case 3 :
						if (inPassword) {
							inPassword = false;
						} else {
							inPassword = true;
							display.setPassword(password.length());
						}
						break;
					case 4 :
						try {
							HashMap check = DatabaseConnector.getDatabaseConnector().checkCredentials(username, password);
							if ((boolean) check.get("isValid")) {
								userData.getUserData().setUserID((int) check.get("user_id"));
								jeu.goToMainMenu();
							} else {
								jeu.goToLogin();
							}
						} catch (SQLException e) {
							e.printStackTrace();
							jeu.goToLogin();
						}
						break;
				}
				break;
			case ESCAPE :
				if (inName) {
					username = "";
					inName = false;
					display.setUsername(username);
				} else if (inPassword) {
					password = "";
					inPassword = false;
					display.setPassword(password.length());
				}
				break;
		}
	}
	
	
	public void type(String str) {
		if (inName) {
			username = username + str;
			if (username.length() > 30) {
				username = username.substring(0, 30);
			}
			display.setUsername(username);
		} else if (inPassword) {
			password = password + str;
			if (password.length() > 30) {
				password = password.substring(0, 30);
			}
			display.setPassword(password.length());
		}
	}
	
}
