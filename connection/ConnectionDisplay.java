package connection;

import nonActiveClasses.Display;

public class ConnectionDisplay implements Display{
	
	private int selection;
	private String[] con = {"********************************************************************************",
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
				con[2] = change(con[2], 6);
				con[3] = change(con[3], 6);
				con[3] = change(con[3], 7);
				con[4] = change(con[4], 6);
				con[4] = change(con[4], 7);
				con[4] = change(con[4], 8);
				con[5] = change(con[5], 6);
				con[5] = change(con[5], 7);
				con[6] = change(con[6], 6);
				break;
			case (2) :
				con[8] = change(con[8], 6);
				con[9] = change(con[9], 6);
				con[9] = change(con[9], 7);
				con[10] = change(con[10], 6);
				con[10] = change(con[10], 7);
				con[10] = change(con[10], 8);
				con[11] = change(con[11], 6);
				con[11] = change(con[11], 7);
				con[12] = change(con[12], 6);
				break;
		}
		for (int i = 0; i < con.length; i++) {
			System.out.println(con[i]);
		}
		con[2] =  "*          @      @@    @@   @@@  @   @                                        *";
		con[3] =  "*          @     @  @  @      @   @@  @                                        *";
		con[4] =  "*          @     @  @  @ @@   @   @ @ @                                        *";
		con[5] =  "*          @     @  @  @  @   @   @  @@                                        *";
		con[6] =  "*          @@@@   @@    @@   @@@  @   @                                        *";
		con[8] =  "*          @@@   @@@   @@   @@@  @@@@  @@@@@  @@@  @@@                         *";
		con[9] =  "*          @ @   @    @      @   @       @    @    @ @                         *";
		con[10] = "*          @@@   @@   @ @@   @   @@@@    @    @@   @@@                         *";
		con[11] = "*          @  @  @    @  @   @      @    @    @    @  @                        *";
		con[12] = "*          @  @  @@@   @@   @@@  @@@@    @    @@@  @  @                        *";
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
	
	public ConnectionDisplay(int sel) {
		this.selection = sel;
		display();
	}
	
	public void setSelection(int sel) {
		this.selection = sel;
		display();
	}
	
	
}