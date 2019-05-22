package Intro;

public class DisplayStoryIntro {
	
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
	
	public void showStoryIntro() {
		for (int i = 0; i < intro.length; i++) {
			System.out.println(intro[i]);
		}
	}
	
}