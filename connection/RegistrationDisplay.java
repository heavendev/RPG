package connection;

import nonActiveClasses.Display;

public class RegistrationDisplay implements Display{
	
	private int selection;
	private String username = "";
	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String password = "";
	private String passwordConfirm = "";
	private String[] reg = {"********************************************************************************",
			"*              ------                                                          *", 
			"*              |BACK|                                                          *",  
			"*              ------                                                          *", 
			"*                                                                              *", 
			"*              Username :                                                      *",  
			"*              Firstname :                                                     *",  
			"*              Lastname :                                                      *", 
			"*              Email :                                                         *",  
			"*              Password :                                                      *",  
			"*              Confirm Password :                                              *",  
			"*                                                                              *", 
			"*              -----------                                                     *",  
			"*              | CONFIRM |                                                     *",  
			"*              -----------                                                     *",  
			"*                                                                              *", 
			"*                                                                              *", 
			"*                                                                              *", 
			"********************************************************************************", 
			"* z = monter, s = descendre, entrer = valider, echappe = annuler               *"};
	
	
	public void display() {
		for (int i = 0; i < username.length(); i++) {
			reg[5] = changeCharAt(reg[5], i+40, username.charAt(i));
		}
		for (int i = 0; i < firstName.length(); i++) {
			reg[6] = changeCharAt(reg[6], i+40, firstName.charAt(i));
		}
		for (int i = 0; i < lastName.length(); i++) {
			reg[7] = changeCharAt(reg[7], i+40, lastName.charAt(i));
		}
		for (int i = 0; i < email.length(); i++) {
			reg[8] = changeCharAt(reg[8], i+40, email.charAt(i));
		}
		for (int i = 0; i < password.length(); i++) {
			reg[9] = changeCharAt(reg[9], i+40, password.charAt(i));
		}
		for (int i = 0; i < passwordConfirm.length(); i++) {
			reg[10] = changeCharAt(reg[10], i+40, passwordConfirm.charAt(i));
		}
		switch (selection) {
			case (1) :
				reg[2] = changeCharAt(reg[2], 10, '-');
				reg[2] = changeCharAt(reg[2], 11, '>');
				break;
			case (2) :
				reg[5] = changeCharAt(reg[5], 10, '-');
				reg[5] = changeCharAt(reg[5], 11, '>');
				break;
			case (3) :
				reg[6] = changeCharAt(reg[6], 10, '-');
				reg[6] = changeCharAt(reg[6], 11, '>');
				break;
			case (4) :
				reg[7] = changeCharAt(reg[7], 10, '-');
				reg[7] = changeCharAt(reg[7], 11, '>');
				break;
			case (5) :
				reg[8] = changeCharAt(reg[8], 10, '-');
				reg[8] = changeCharAt(reg[8], 11, '>');
				break;
			case (6) :
				reg[9] = changeCharAt(reg[9], 10, '-');
				reg[9] = changeCharAt(reg[9], 11, '>');
				break;
			case (7) :
				reg[10] = changeCharAt(reg[10], 10, '-');
				reg[10] = changeCharAt(reg[10], 11, '>');
				break;
			case (8) :
				reg[13] = changeCharAt(reg[13], 10, '-');
				reg[13] = changeCharAt(reg[13], 11, '>');
				break;
		}
		for (int i = 0; i < reg.length; i++) {
			System.out.println(reg[i]);
		}
		reg[2] = "*              |BACK|                                                          *";
		reg[5] = "*              Username :                                                      *";
		reg[6] = "*              Firstname :                                                     *";
		reg[7] = "*              Lastname :                                                      *";
		reg[8] = "*              Email :                                                         *";
		reg[9] = "*              Password :                                                      *";
		reg[10] = "*              Confirm Password :                                              *";
		reg[13] = "*              | CONFIRM |                                                     *";
	}
	
	
	private String changeCharAt(String str, int charAt, char replaceBy) {
		String toReturn = "";
		for (int i = 0; i < str.length(); i++) {
			if (i == charAt-1) {
				toReturn = toReturn + replaceBy;
			} else {
				toReturn = toReturn + str.charAt(i);
			}
		}
		return toReturn;
	}
	
	
	
	public void setSelection(int sel) {
		this.selection = sel;
		display();
	}
	
	public void setUsername(String username) {
		this.username = username;
		display();
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		display();
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		display();
	}
	public void setEmail(String email) {
		this.email = email;
		display();
	}
	public void setPassword(int length) {
		password = "";
		for (int i = 0; i < length; i++) {
			password = password + "*";
		}
		display();
	}
	public void setPasswordConfirm(int length) {
		passwordConfirm = "";
		for (int i = 0; i < length; i++) {
			passwordConfirm = passwordConfirm + "*";
		}
		display();
	}
	
	
}
