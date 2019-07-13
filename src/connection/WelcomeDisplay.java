package connection;

import nonActiveClasses.Display;

public class WelcomeDisplay implements Display{
	
	String[] welcome = {"********************************************************************************",
			"*                                                                              *",
			"*           @@    @@   @   @ @@@    @   @   @@   @   @  @@@                    *",
			"*          @     @  @  @@ @@ @      @@  @  @  @  @@ @@  @                      *",
			"*          @ @@  @@@@  @ @ @ @@     @ @ @  @@@@  @ @ @  @@                     *",
			"*          @  @  @  @  @   @ @      @  @@  @  @  @   @  @                      *",
			"*           @@   @  @  @   @ @@@    @   @  @  @  @   @  @@@                    *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*             Appuyer sur entrer pout continuer                                *",
			"*                                                                              *",
			"*                                                                              *",
			"*    By : Annais Guillaume, Rouquaya Mouss, Sebastien Nielson                  *",
			"*                                                                              *",
			"********************************************************************************"};
	
	public void display() {
		for (int i = 0; i < welcome.length; i++) {
			System.out.println(welcome[i]);
		}
	}
	
}