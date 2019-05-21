package Projet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ProjetMenu.Scroll;

public class ScrollingKeyListener implements KeyListener, Runnable {

	private Jeu jeu;
	private Thread t;
	
	Scroll action = null;
	
	public ScrollingKeyListener(Jeu jeu) {
		this.jeu = jeu;
		t = new Thread(this);
		t.start();
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case (KeyEvent.VK_ENTER) :
				action = Scroll.CONFIRM;
				break;
			case (KeyEvent.VK_Z) :
				action = Scroll.UP;
				break;
			case (KeyEvent.VK_S) :
				action = Scroll.DOWN;
				break;
			case (KeyEvent.VK_Q) :
				action = Scroll.LEFT;
			break;
			case (KeyEvent.VK_D) :
				action = Scroll.RIGHT;
			break;
		}
	}
	
	public void keyTyped(KeyEvent e) {
	}
	
	public void keyReleased(KeyEvent e) {
	}
	
	
	public void run() {
		while (!jeu.isGameOver()) {
			if (action != null) {
				jeu.scroll(action);
			}
			action = null;
			try {
				Thread.sleep(50);
				} catch (InterruptedException e) {
			}
		}
	}
	
}