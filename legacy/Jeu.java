package legacy;
 
import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Jeu extends JFrame implements Runnable {

	private Thread thread;
	private Mouvement mouvement; // ajouter méthode
	private JeuKeyListener listener = new JeuKeyListener(this);

	/* Manage déplacement des joueurs */

	public Jeu() {
		this.setSize(50, 20);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(listener);
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		mouvement = new Mouvement();
		// this.removeKeyListener(listener);
	}

	public void mouvement(Direction direction) {
		mouvement.mouvement(direction);
	}

	/* Simulation de Combat TODO créer une classe spécialement pour gérer le combat dans un future proche */

	public void jouerCombat(Personnage personnage1, Personnage personnage2) {

		int degat1 = 0;
		int degat2 = 0;
		boolean parer1 = false;
		boolean parer2 = false;
		int choix1 = 0;
		int choix2 = 0;
		boolean finCombat = false;

		// TODO créer fonction choix action pour personnage 1 ou personnage 2
		while (finCombat != false) {
			switch (choix1) {
			case 1:
				degat1 = personnage1.attaquer(personnage2);
				break;
			case 2:
				parer1 = personnage1.Sedefendre(personnage2);
				break;
			case 3:
				personnage1.utiliserPouvoir();
				break;
			default:
				System.out.println("errror pour combat perso 1");
			}
			switch(choix2) {
			case 1 : 
				degat2 = personnage2.attaquer(personnage1);
				break;
			case 2 : 
				parer2 = personnage2.Sedefendre(personnage1); 
			}
		}
	}

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
	}

}
