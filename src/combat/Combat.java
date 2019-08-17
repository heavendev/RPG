package combat;

import java.util.HashMap;

import characters.Personnage;

public interface Combat {

	public HashMap attaquer(Personnage p);
	
	public HashMap utiliserPouvoir(Personnage p);
	
}

