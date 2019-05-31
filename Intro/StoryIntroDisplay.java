package Intro;

import nonActiveClasses.Display;

public class StoryIntroDisplay implements Display{
	
	private String[] intro = {"********************************************************************************",
			"*                                                                              *",
			"*                                                                              *",
			"*                     PAGE 1                                                   *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                         * etape suivante     *",
			"*                                                                              *",
			"********************************************************************************",
			"q = selection precedente, d = selection suivante, entrer = valider              "};
	
	public void display() {
		for (int i = 0; i < intro.length; i++) {
			System.out.println(intro[i]);
		}
	}
	
}