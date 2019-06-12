package quest;

import nonActiveClasses.Display;

public class QuestPageDisplay implements Display{
	
	String questName;
	String[] questText;
	int xpReward;
	int goldReward;
	String[] screen = {"********************************************************************************",
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
			"*                                                                              *",
			"*                                                                              *",
			"*                                                                              *",
			"*                                                  -> Continuer                *",
			"*                                                                              *",
			"********************************************************************************",
			"* entrer = valider                                                             *"};
	
	
	
	
	
	public void display() {
		screen[2] = insertStringAt(screen[2], questName, 10);
		for (int i = 0; i < questText.length; i++) {
			screen[i+4] = insertStringAt(screen[i+4], questText[i], 10);
		}
		for (int i = 0; i < screen.length; i++) {
			System.out.println(screen[i]);
		}
		screen[14] = insertStringAt(screen[14], "Completing this quest will grant you " + xpReward + "XP and " + goldReward + " gold", 5);
		for (int i = 0; i < questText.length; i++) {
			screen[i+4] = "*                                                                              *";
		}
		screen[2] = "*                                                                              *";
		screen[14] = "*                                                                              *";
	}
	
	
	public void resetDisplay(String questName, String[] questText, int xpReward, int goldReward) {
		this.questName = questName;
		this.questText = questText;
		this.xpReward = xpReward;
		this.goldReward = goldReward;
		display();
	}
	
	private String insertStringAt(String baseString, String newString, int at) {
		for (int i = 0; i < newString.length(); i++) {
			baseString = changeCharAt(baseString, at + i, newString.charAt(i));
		}
		return baseString;
	}
	
	private String changeCharAt(String str, int charAt, char replaceBy) {
		String toReturn = "";
		for (int i = 0; i < str.length(); i++) {
			if (i == charAt-1) {
				toReturn = toReturn + replaceBy;
			} else {
				toReturn = toReturn + str.charAt(i);
			}
		}
		return toReturn;
	}
	
	
}