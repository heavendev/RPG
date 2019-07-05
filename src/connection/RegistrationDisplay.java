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
	private String[] screen = {"********************************************************************************",
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
		screen[5] = insertStringAt(screen[5], username, 40);
		screen[6] = insertStringAt(screen[6], firstName, 40);
		screen[7] = insertStringAt(screen[7], lastName, 40);
		screen[8] = insertStringAt(screen[8], email, 40);
		screen[9] = insertStringAt(screen[9], password, 40);
		screen[10] = insertStringAt(screen[10], passwordConfirm, 40);
		switch (selection) {
			case (1) :
				screen[2] = insertStringAt(screen[2], "->", 10);
				break;
			case (2) :
				screen[5] = insertStringAt(screen[5], "->", 10);
				break;
			case (3) :
				screen[6] = insertStringAt(screen[6], "->", 10);
				break;
			case (4) :
				screen[7] = insertStringAt(screen[7], "->", 10);
				break;
			case (5) :
				screen[8] = insertStringAt(screen[8], "->", 10);
				break;
			case (6) :
				screen[9] = insertStringAt(screen[9], "->", 10);
				break;
			case (7) :
				screen[10] = insertStringAt(screen[10], "->", 10);
				break;
			case (8) :
				screen[13] = insertStringAt(screen[13], "->", 10);
				break;
		}
		for (int i = 0; i < screen.length; i++) {
			System.out.println(screen[i]);
		}
		screen[2] = "*              |BACK|                                                          *";
		screen[5] = "*              Username :                                                      *";
		screen[6] = "*              Firstname :                                                     *";
		screen[7] = "*              Lastname :                                                      *";
		screen[8] = "*              Email :                                                         *";
		screen[9] = "*              Password :                                                      *";
		screen[10] = "*              Confirm Password :                                              *";
		screen[13] = "*              | CONFIRM |                                                     *";
	}
	
	private String insertStringAt(String baseString, String newString, int at) {
		return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
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
