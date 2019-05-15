package FileRouge;

/* Personnages peuvent: attaquer, parer un coup, utiliser leur pouvoir*/
public interface Combat {

	public int attaquer(Personnage personnageCible);

	public boolean Sedefendre(Personnage personnageAttaquant);

	public void utiliserPouvoir();

}
