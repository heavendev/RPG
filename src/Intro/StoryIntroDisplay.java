package Intro;

import nonActiveClasses.Display;

public class StoryIntroDisplay implements Display{
	
	private String[] page;
	private String[] screen = {"********************************************************************************",
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
			"*                                                        -> etape suivante     *",
			"*                                                                              *",
			"********************************************************************************",
			"* entrer = valider                                                             *"};
	
	public StoryIntroDisplay(String[] page) {
		this.page = page;
	}
	
	public void display() {
		for (int i = 0; i < page.length; i++) {
			screen[2+i] = insertStringAt(screen[2+i], page[i], 10);
		}
		for (int i = 0; i < screen.length; i++) {
			System.out.println(screen[i]);
		}
		for (int i = 0; i < page.length; i++) {
			screen[2+i] = "*                                                                              *";
		}
	}
	
	private String insertStringAt(String baseString, String newString, int at) {
		return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
	}
	
}