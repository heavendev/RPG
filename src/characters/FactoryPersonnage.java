package characters;

import java.util.ArrayList;
import java.util.HashMap;

public class FactoryPersonnage {
	@SuppressWarnings("unchecked")
	public static Personnage getPersonnage(HashMap info ) {
		/*
		 * jeu commence avec peter pan donc doit �tre le premi�re joueur avec le quel je dois jouer 
		 * inialiser mon joueur a peter pan;
		 * 
		 * je dois recuper les donn�es de ma hasmap
		 */
	        Personnage player=null;
	       String name = (String) info.get("name");
	       int level=(int)info.get("level");
	       String classe =(String)info.get("classe");
	       ArrayList<String[]>attacks=(ArrayList<String[]>)info.get("attacks");
	       ArrayList<String[]>criticalHit=(ArrayList<String[]>)info.get("criticalHit");
	       ArrayList<String[]>magicAttack=(ArrayList<String[]>)info.get("magicAttack");
	       ArrayList<String[]>magicCriticalHit=(ArrayList<String[]>)info.get("magicCriticalHit");
	       
	       //recup�rer tous dans une Hashmap a partir de la base de donn�es.
	   
	        
		/*
		 * je dois aller dans ma base de donner pour generer mon personnage 
		 * */
		
		return player;
	}

	
}
