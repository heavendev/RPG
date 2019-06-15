package Personnages;

public class PersonnageFactory {
	
	public static Personnage getPersonnage(String personnage) {
		Personnage people = null;
		switch(personnage) {
		
		case "Humain":
			people= new Humain(people.setNom());
			break;
			
		}
	}

}
