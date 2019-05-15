package FileRouge;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JeuKeyListener extends KeyAdapter {

	private Jeu jeu;
	
	public JeuKeyListener(Jeu jeu) {
		this.jeu = jeu;
	}
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			jeu.mouvement(Direction.UP);
			System.out.println("Direction UP");
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			jeu.mouvement(Direction.DOWN);
			System.out.println("Direction down");
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			jeu.mouvement(Direction.LEFT);
			System.out.println("Direction left");
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			jeu.mouvement(Direction.RIGHT);
			System.out.println("Direction right");
		}

	}
}
