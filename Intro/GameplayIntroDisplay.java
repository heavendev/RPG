package Intro;

import nonActiveClasses.Display;

public class GameplayIntroDisplay implements Display{
	
	private int page = 1;
	private int selection = 2;
	
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
			" entrer = valider                                                               "};
	
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
			"q = selection precedente, d = selection suivante, entrer = valider              "};
	
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
	
	public void display() {
		switch (page) {
			case 1 : 
				pageOne[16] = change(pageOne[16], 59);
				for (int i = 0; i < pageOne.length; i++) {
					System.out.println(pageOne[i]);
				}
				pageOne[16] = "*                                                           prochaine page     *";
				break;
			case 2 : 
				if (selection == 1) {
					pageTwo[16] = change(pageTwo[16], 30);
				} else {
					pageTwo[16] = change(pageTwo[16], 59);
				}
				for (int i = 0; i < pageTwo.length; i++) {
					System.out.println(pageTwo[i]);
				}
				pageTwo[16] = "*                              page precedente              prochaine page     *";
				break;
			case 3 : 
				if (selection == 1) {
					pageThree[16] = change(pageThree[16], 30);
				} else {
					pageThree[16] = change(pageThree[16], 59);
				}
				for (int i = 0; i < pageThree.length; i++) {
					System.out.println(pageThree[i]);
				}
				pageThree[16] = "*                              page precedente              etape suivante     *";
				break;
		}
	}
	
	private String change(String str, int pos) {
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
	
	public void setSelection(int select) {
		this.selection = select;
		display();
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
}