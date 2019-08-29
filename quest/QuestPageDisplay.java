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
		for (int i = 0; i < questText.length; i++) {
			System.out.println(questText[i]);
		}
		screen[2] = insertStringAt(screen[2], questName, 10);
		for (int i = 0; i < questText.length; i++) {
			screen[i+4] = insertStringAt(screen[i+4], questText[i], 10);
		}
		screen[14] = insertStringAt(screen[14], "Completing this quest will grant you " + xpReward + "XP and " + goldReward + " gold", 5);
		for (int i = 0; i < screen.length; i++) {
			System.out.println(screen[i]);
		}
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
		return (baseString.substring(0, at) + newString + baseString.substring(newString.length()+at));
	}
	
	
}