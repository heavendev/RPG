package connection;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;

import game.Jeu;
import nonActiveClasses.Scroll;

public class RegistrationController{
	
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
	
	public RegistrationController(Jeu jeu) {
		this.jeu = jeu;
		display = new RegistrationDisplay();
		resetRegistration();
	}
	
	public void resetRegistration() {
		selection = 1;
		display.setSelection(selection);
		username = "";
		display.setUsername(username);
		firstName = "";
		display.setFirstName(firstName);
		lastName = "";
		display.setLastName(lastName);
		email = "";
		display.setEmail(email);
		password = "";
		display.setPassword(password.length());
		passwordConfirm = "";
		display.setPasswordConfirm(passwordConfirm.length());
		inUsername = false;
		inFirstName = false;
		inLastName = false;
		inEmail = false;
		inPassword = false;
		inPasswordConfirm = false;
	}

	
	
	public void scroll(Scroll scroll) {
		switch (scroll) {
		case UP :
			if (selection != 1 && !isInUse()) {
				selection--;
			}
			display.setSelection(selection);
			break;
		case DOWN :
			if (selection != 8 && !isInUse()) {
				selection++;
			}
			display.setSelection(selection);
			break;
		case CONFIRM :
			switch (selection) {
			case 1:
				jeu.goToConnection();
				break;
			case 2:
				if (inUsername) {
					inUsername = false;
				} else {
					inUsername = true;
				}
				break;
			case 3:
				if (inFirstName) {
					inFirstName = false;
				} else {
					inFirstName = true;
				}
				break;
			case 4:
				if (inLastName) {
					inLastName = false;
				} else {
					inLastName = true;
				}
				break;
			case 5 :
				if (inEmail) {
					inEmail = false;
				} else {
					inEmail = true;
				}
				break;
			case 6 :
				if (inPassword) {
					inPassword = false;
				} else {
					inPassword = true;
				}
				break;
			case 7 :
				if (inPasswordConfirm) {
					inPasswordConfirm = false;
				} else {
					inPasswordConfirm = true;
				}
				break;
			case 8 :
				String[] t = {username,email};
				try {
					System.out.println(DatabaseConnector.getDatabaseConnector().checkIfIsDuplicateUser(t));
					System.out.println(password);
					System.out.println(passwordConfirm);
					if (!DatabaseConnector.getDatabaseConnector().checkIfIsDuplicateUser(t) 
							&& password.length() >= 8 && password.equals(passwordConfirm)) {
						HashMap user = new HashMap();
						user.put("nickname", username);
						user.put("firstName", firstName);
						user.put("lastName", lastName);
						user.put("email", email);
						user.put("password", password);
						DatabaseConnector.getDatabaseConnector().addUserToDB(user);
						jeu.goToLogin();
					} else {
						jeu.goToRegistration();
					}
				} catch (SQLException | NoSuchAlgorithmException e) {
					e.printStackTrace();
					jeu.goToConnection();
				}
				break;
			}
			break;
		case ESCAPE :
			if (inUsername) {
				username = "";
				inUsername = false;
				display.setUsername(username);
			} else if (inFirstName) {
				firstName = "";
				inFirstName = false;
				display.setFirstName(firstName);
			} else if (inLastName) {
				lastName = "";
				inLastName = false;
				display.setLastName(lastName);
			} else if (inEmail) {
				email = "";
				inEmail = false;
				display.setEmail(email);
			} else if (inPassword) {
				password = "";
				inPassword = false;
				display.setPassword(password.length());
			} else if (inPasswordConfirm) {
				passwordConfirm = "";
				inPasswordConfirm = false;
				display.setPasswordConfirm(passwordConfirm.length());
			}
			break;
		}
	}
	
	private boolean isInUse() {
		if (inUsername || inFirstName || inLastName || inEmail || inPassword || inPasswordConfirm) {
			return true;
		}
		return false;
	}
	
	
	public void type(String str) {
		if (inUsername) {
			username = username + str;
			if (username.length() > 30) {
				username = username.substring(0, 30);
			}
			display.setUsername(username);
		} else if (inFirstName) {
			firstName = firstName + str;
			if (firstName.length() > 30) {
				firstName = firstName.substring(0, 30);
			}
			display.setFirstName(firstName);
		} else if (inLastName) {
			lastName = lastName + str;
			if (lastName.length() > 30) {
				lastName = lastName.substring(0, 30);
			}
			display.setLastName(lastName);
		} else if (inEmail) {
			email = email + str;
			if (email.length() > 30) {
				email = email.substring(0, 30);
			}
			display.setEmail(email);
		} else if (inPassword) {
			password = password + str;
			if (password.length() > 30) {
				password = password.substring(0, 30);
			}
			display.setPassword(password.length());
		} else if (inPasswordConfirm) {
			passwordConfirm = passwordConfirm + str;
			if (passwordConfirm.length() > 30) {
				passwordConfirm = passwordConfirm.substring(0, 30);
			}
			display.setPasswordConfirm(passwordConfirm.length());
		}
	}
	
}
