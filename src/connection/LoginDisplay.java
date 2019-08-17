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
		log[6] = insertStringAt(log[6], username, 30);
		log[8] = insertStringAt(log[8], password, 30);
		switch (selection) {
			case 1 :
				log[3] = insertStringAt(log[3], "->", 10);
				break;
			case 2 :
				log[6] = insertStringAt(log[6], "->", 10);
				break;
			case 3:
				log[8] = insertStringAt(log[8], "->", 10);
				break;
			case 4 :
				log[11] = insertStringAt(log[11], "->", 10);
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
	
	private String insertStringAt(String baseString, String newString, int at) {
		return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
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