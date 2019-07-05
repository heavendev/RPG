package combat;

import characters.Personnage;

public interface Combat {

	public int attaquer(Personnage personnageCible);

	public void utiliserObjet();

	/* Utiliser un objet contre une personne */
	public int utiliserObjet(Personnage personnageCible);

	/* Attaque defensive */
	public void utiliserPouvoir();

	/* Attaque offensive */
	public int utiliserPouvoir(Personnage personnageCible);

}

