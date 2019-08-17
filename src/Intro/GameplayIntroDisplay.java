package Intro;

import nonActiveClasses.Display;

public class GameplayIntroDisplay implements Display{
	
	private int page = 1;
	private int selection = 2;
	private String[] firstPage;
	private String[] secondPage;
	private String[] thirdPage;
	private String[] pageOne = {"********************************************************************************",
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
			"*                                                           prochaine page     *",
			"*                                                                              *",
			"********************************************************************************",
			"* entrer = valider                                                             *"};
	private String[] pageTwo = {"********************************************************************************",
			"*                                                                              *",
			"*                                                                              *",
			"*                     PAGE 2                                                   *",
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
			"*                              page precedente              prochaine page     *",
			"*                                                                              *",
			"********************************************************************************",
			"* q = selection precedente, d = selection suivante, entrer = valider           *q"};
	private String[] pageThree = {"********************************************************************************",
			"*                                                                              *",
			"*                                                                              *",
			"*                     PAGE 3                                                   *",
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
			"*                              page precedente              etape suivante     *",
			"*                                                                              *",
			"********************************************************************************",
			"q = selection precedente, d = selection suivante, entrer = valider              "};
	
	
	public GameplayIntroDisplay(String[] firstPage, String[] secondPage, String[] thirdPage) {
		this.firstPage = firstPage;
		this.secondPage = secondPage;
		this.thirdPage = thirdPage;
	}
	
	
	public void display() {
		switch (page) {
			case 1 : 
				for (int i = 0; i < firstPage.length; i++) {
					pageOne[2+i] = insertStringAt(pageOne[2+i], firstPage[i], 10);
				}
				pageOne[16] = insertStringAt(pageOne[16], "->", 57);
				for (int i = 0; i < pageOne.length; i++) {
					System.out.println(pageOne[i]);
				}
				pageOne[16] = "*                                                           prochaine page     *";
				break;
			case 2 : 
				for (int i = 0; i < secondPage.length; i++) {
					pageTwo[2+i] = insertStringAt(pageTwo[2+i], secondPage[i], 10);
				}
				if (selection == 1) {
					pageTwo[16] = insertStringAt(pageTwo[16], "->", 28);
				} else {
					pageTwo[16] = insertStringAt(pageTwo[16], "->", 57);
				}
				for (int i = 0; i < pageTwo.length; i++) {
					System.out.println(pageTwo[i]);
				}
				pageTwo[16] = "*                              page precedente              prochaine page     *";
				break;
			case 3 : 
				for (int i = 0; i < thirdPage.length; i++) {
					pageThree[2+i] = insertStringAt(pageThree[2+i], thirdPage[i], 10);
				}
				if (selection == 1) {
					pageThree[16] = insertStringAt(pageThree[16], "->", 28);
				} else {
					pageThree[16] = insertStringAt(pageThree[16], "->", 57);
				}
				for (int i = 0; i < pageThree.length; i++) {
					System.out.println(pageThree[i]);
				}
				pageThree[16] = "*                              page precedente              etape suivante     *";
				break;
		}
	}
	
	private String insertStringAt(String baseString, String newString, int at) {
		return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
	}
	
	public void setSelection(int select) {
		this.selection = select;
		display();
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	
}