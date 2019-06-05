package connection;

import nonActiveClasses.Display;

public class LoginDisplay implements Display{
	
	private int selection;
	private String username = "";
	private String password = "";
	private String[] log = {"********************************************************************************",
			"*                                                                              *", 
			"*              ------                                                          *", 
			"*              |BACK|                                                          *",  
			"*              ------                                                          *", 
			"*                                                                              *",  
			"*              Username :                                                      *",  
			"*                                                                              *", 
			"*              Password :                                                      *",  
			"*                                                                              *",  
			"*              -----------                                                     *",  
			"*              | CONFIRM |                                                     *",  
			"*              -----------                                                     *",  
			"*                                                                              *", 
			"*                                                                              *", 
			"*                                                                              *", 
			"*                                                                              *", 
			"*                                                                              *", 
			"********************************************************************************", 
			"* z = monter, s = descendre, entrer = valider, echappe = annuler               *"};
	
	
	
	public void display() {
		
		for (int i = 0; i < username.length(); i++) {
			log[6] = changeCharAt(log[6], i+30, username.charAt(i));
		}
		
		for (int i = 0; i < password.length(); i++) {
			log[8] = changeCharAt(log[8], i+30, '*');
		}
		
		switch (selection) {
			case 1 :
				log[3] = changeCharAt(log[3], 10, '-');
				log[3] = changeCharAt(log[3], 11, '>');
				break;
			case 2 :
				log[6] = changeCharAt(log[6], 10, '-');
				log[6] = changeCharAt(log[6], 11, '>');
				break;
			case 3:
				log[8] = changeCharAt(log[8], 10, '-');
				log[8] = changeCharAt(log[8], 11, '>');
				break;
			case 4 :
				log[11] = changeCharAt(log[11], 10, '-');
				log[11] = changeCharAt(log[11], 11, '>');
				break;
		}
		
		for (int i = 0; i < log.length; i++) {
			System.out.println(log[i]);
		}
		
		log[3] = "*              |BACK|                                                          *";
		log[6] = "*              Username :                                                      *";
		log[8] = "*              Password :                                                      *";
		log[11] = "*              | CONFIRM |                                                     *";
		
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
		selection = sel;
		display();
	}
	public void setUsername(String username) {
		this.username = username;
		display();
	}
	public void setPassword(int length) {
		password = "";
		for (int i = 0; i < length; i++) {
			password = password + "*";
		}
		display();
	}
	
}