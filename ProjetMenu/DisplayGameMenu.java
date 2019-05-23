package ProjetMenu;

public class DisplayGameMenu {
	
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
	
	
	public void showMenu() {
		switch (selection) {
			case (0) :
				menu[1] = change(menu[1], 6);
				menu[2] = change(menu[2], 6);
				menu[2] = change(menu[2], 7);
				menu[3] = change(menu[3], 6);
				menu[3] = change(menu[3], 7);
				menu[3] = change(menu[3], 8);
				menu[4] = change(menu[4], 6);
				menu[4] = change(menu[4], 7);
				menu[5] = change(menu[5], 6);
				break;
			case (1) :
				menu[7] = change(menu[7], 6);
				menu[8] = change(menu[8], 6);
				menu[8] = change(menu[8], 7);
				menu[9] = change(menu[9], 6);
				menu[9] = change(menu[9], 7);
				menu[9] = change(menu[9], 8);
				menu[10] = change(menu[10], 6);
				menu[10] = change(menu[10], 7);
				menu[11] = change(menu[11], 6);
				break;
			case (2) :
				menu[13] = change(menu[13], 6);
				menu[14] = change(menu[14], 6);
				menu[14] = change(menu[14], 7);
				menu[15] = change(menu[15], 6);
				menu[15] = change(menu[15], 7);
				menu[15] = change(menu[15], 8);
				menu[16] = change(menu[16], 6);
				menu[16] = change(menu[16], 7);
				menu[17] = change(menu[17], 6);
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
		
	public String change(String str, int pos) {
		String tmp = "";
		for (int i = 0; i < pos; i++) {
			tmp = tmp + str.charAt(i);
		}
		tmp = tmp + '@';
		for (int i = (pos+1); i < str.length(); i++) {
			tmp = tmp + str.charAt(i);
		}
		return (tmp);
	}
	
	public void setSelection(int s) {
		if (s >= 0 && s <= 3) {
			selection = s;
		}
		showMenu();
	}
	
}