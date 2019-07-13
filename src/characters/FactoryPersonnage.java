package characters;

import java.util.ArrayList;
import java.util.HashMap;

public class FactoryPersonnage {
	@SuppressWarnings("unchecked")
	public static Personnage getPersonnage(HashMap info ) {
		/*
		 * jeu commence avec peter pan donc doit être le première joueur avec le quel je dois jouer 
		 * inialiser mon joueur a peter pan;
		 * 
		 * je dois recuper les données de ma hasmap
		 */
	        Personnage player=null;
	       String name = (String) info.get("name");
	       int level=(int)info.get("level");
	       String classe =(String)info.get("classe");
	       ArrayList<String[]>attacks=(ArrayList<String[]>)info.get("attacks");
	       ArrayList<String[]>criticalHit=(ArrayList<String[]>)info.get("criticalHit");
	       ArrayList<String[]>magicAttack=(ArrayList<String[]>)info.get("magicAttack");
	       ArrayList<String[]>magicCriticalHit=(ArrayList<String[]>)info.get("magicCriticalHit");
	       
	       //recupérer tous dans une Hashmap a partir de la base de données.
	   
	        
		/*
		 * je dois aller dans ma base de donner pour generer mon personnage 
		 * */
		
		return player;
	}

	
}
