package connection;

import nonActiveClasses.Display;

public class ConnectionDisplay implements Display{
	
	private int selection;
	private String[] screen = {"********************************************************************************",
			"*                                                                              *", 
			"*          @      @@    @@   @@@  @   @                                        *", 
			"*          @     @  @  @      @   @@  @                                        *", 
			"*          @     @  @  @ @@   @   @ @ @                                        *", 
			"*          @     @  @  @  @   @   @  @@                                        *", 
			"*          @@@@   @@    @@   @@@  @   @                                        *", 
			"*                                                                              *", 
			"*          @@@   @@@   @@   @@@  @@@@  @@@@@  @@@  @@@                         *", 
			"*          @ @   @    @      @   @       @    @    @ @                         *", 
			"*          @@@   @@   @ @@   @   @@@@    @    @@   @@@                         *", 
			"*          @  @  @    @  @   @      @    @    @    @  @                        *", 
			"*          @  @  @@@   @@   @@@  @@@@    @    @@@  @  @                        *", 
			"*                                                                              *", 
			"*                                                                              *", 
			"*                                                                              *", 
			"*                                                                              *", 
			"*                                                                              *", 
			"********************************************************************************", 
			"* z = monter, s = descendre, entrer = valider                                  *"};
	
	
	
	public void display() {
		switch (selection) {
			case (1) :
				screen[2] = insertStringAt(screen[2], "@", 6);
				screen[3] = insertStringAt(screen[3], "@@", 6);
				screen[4] = insertStringAt(screen[4], "@@@", 6);
				screen[5] = insertStringAt(screen[5], "@@", 6);
				screen[6] = insertStringAt(screen[6], "@", 6);
				break;
			case (2) :
				screen[8] = insertStringAt(screen[8], "@", 6);
				screen[9] = insertStringAt(screen[9], "@@", 6);
				screen[10] = insertStringAt(screen[10], "@@@", 6);
				screen[11] = insertStringAt(screen[11], "@@", 6);
				screen[12] = insertStringAt(screen[12], "@", 6);
				break;
		}
		for (int i = 0; i < screen.length; i++) {
			System.out.println(screen[i]);
		}
		screen[2] =  "*          @      @@    @@   @@@  @   @                                        *";
		screen[3] =  "*          @     @  @  @      @   @@  @                                        *";
		screen[4] =  "*          @     @  @  @ @@   @   @ @ @                                        *";
		screen[5] =  "*          @     @  @  @  @   @   @  @@                                        *";
		screen[6] =  "*          @@@@   @@    @@   @@@  @   @                                        *";
		screen[8] =  "*          @@@   @@@   @@   @@@  @@@@  @@@@@  @@@  @@@                         *";
		screen[9] =  "*          @ @   @    @      @   @       @    @    @ @                         *";
		screen[10] = "*          @@@   @@   @ @@   @   @@@@    @    @@   @@@                         *";
		screen[11] = "*          @  @  @    @  @   @      @    @    @    @  @                        *";
		screen[12] = "*          @  @  @@@   @@   @@@  @@@@    @    @@@  @  @                        *";
	}
	
	private String insertStringAt(String baseString, String newString, int at) {
		return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
	}
	
	public ConnectionDisplay(int sel) {
		this.selection = sel;
		display();
	}
	
	public void setSelection(int sel) {
		this.selection = sel;
		display();
	}
	
	
}