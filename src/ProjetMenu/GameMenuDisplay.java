package ProjetMenu;

import nonActiveClasses.Display;

public class GameMenuDisplay implements Display{
	
	private static int selection = 0;
	private String[] menu = {"********************************************************************************",
			"*          @@@   @@@  @@@@@  @@@  @ @  @@@       @@@@@  @@@  @ @               *",
			"*          @ @   @      @    @ @  @ @  @ @         @    @    @ @               *",
			"*          @@@   @@     @    @ @  @ @  @@@         @    @@   @ @               *",
			"*          @  @  @      @    @ @  @ @  @  @      @ @    @    @ @               *",
			"*          @  @  @@@    @    @@@  @@@  @  @      @@@    @@@  @@@               *",
			"*                                                                              *",
			"*          @@@@  @@@  @ @  @   @  @@@   @@   @@@  @@@   @@@   @@@  @@@         *",
			"*          @     @ @  @ @  @   @  @    @     @ @  @ @   @  @  @    @ @         *",
			"*          @@@@  @@@  @ @   @ @   @@   @ @@  @@@  @@@   @  @  @@   @@@         *",
			"*             @  @ @  @ @   @ @   @    @  @  @ @  @  @  @  @  @    @  @        *",
			"*          @@@@  @ @  @@@    @    @@@   @@   @ @  @  @  @@@   @@@  @  @        *",
			"*                                                                              *",
			"*           @@@    @ @  @@@  @@@@@ @@@@@  @@@  @@@                             *",
			"*          @   @   @ @   @     @     @    @    @ @                             *",
			"*          @   @   @ @   @     @     @    @@   @@@                             *",
			"*          @   @   @ @   @     @     @    @    @  @                            *",
			"*           @@@ @  @@@  @@@    @     @    @@@  @  @                            *",
			"********************************************************************************",
			"z = monter, s = descendre, entrer = valider                                     "};	
	
	
	public void display() {
		switch (selection) {
			case (0) :
				menu[1] = insertStringAt(menu[1], "@", 6);
				menu[2] = insertStringAt(menu[2], "@@", 6);
				menu[3] = insertStringAt(menu[3], "@@@", 6);
				menu[4] = insertStringAt(menu[4], "@@", 6);
				menu[5] = insertStringAt(menu[5], "@", 6);
				break;
			case (1) :
				menu[7] = insertStringAt(menu[7], "@", 6);
				menu[8] = insertStringAt(menu[8], "@@", 6);
				menu[9] = insertStringAt(menu[9], "@@@", 6);
				menu[10] = insertStringAt(menu[10], "@@", 6);
				menu[11] = insertStringAt(menu[11], "@", 6);
				break;
			case (2) :
				menu[13] = insertStringAt(menu[13], "@", 6);
				menu[14] = insertStringAt(menu[14], "@@", 6);
				menu[15] = insertStringAt(menu[15], "@@@", 6);
				menu[16] = insertStringAt(menu[16], "@@", 6);
				menu[17] = insertStringAt(menu[17], "@", 6);
				break;
		}
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
		menu[1] =  "*          @@@   @@@  @@@@@  @@@  @ @  @@@     @@@@@  @@@  @ @                 *";
		menu[2] =  "*          @ @   @      @    @ @  @ @  @ @       @    @    @ @                 *";
		menu[3] =  "*          @@@   @@     @    @ @  @ @  @@@       @    @@   @ @                 *";
		menu[4] =  "*          @  @  @      @    @ @  @ @  @  @    @ @    @    @ @                 *";
		menu[5] =  "*          @  @  @@@    @    @@@  @@@  @  @    @@@    @@@  @@@                 *";
		menu[7] =  "*          @@@@  @@@  @ @  @   @  @@@   @@   @@@  @@@   @@@   @@@  @@@         *";
		menu[8] =  "*          @     @ @  @ @  @   @  @    @     @ @  @ @   @  @  @    @ @         *";
		menu[9] =  "*          @@@@  @@@  @ @   @ @   @@   @ @@  @@@  @@@   @  @  @@   @@@         *";
		menu[10] = "*             @  @ @  @ @   @ @   @    @  @  @ @  @  @  @  @  @    @  @        *";
		menu[11] = "*          @@@@  @ @  @@@    @    @@@   @@   @ @  @  @  @@@   @@@  @  @        *";
		menu[13] = "*           @@@    @ @  @@@  @@@@@ @@@@@  @@@  @@@                             *";
		menu[14] = "*          @   @   @ @   @     @     @    @    @ @                             *";
		menu[15] = "*          @   @   @ @   @     @     @    @@   @@@                             *";
		menu[16] = "*          @   @   @ @   @     @     @    @    @  @                            *";
		menu[17] = "*           @@@ @  @@@  @@@    @     @    @@@  @  @                            *";
	}
	
	private String insertStringAt(String baseString, String newString, int at) {
		return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
	}
	
	public void setSelection(int s) {
		if (s >= 0 && s <= 3) {
			selection = s;
		}
		display();
	}
	
}