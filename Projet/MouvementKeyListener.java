package Projet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MouvementKeyListener implements KeyListener, Runnable {

	private Jeu jeu;
	private Thread t;
	
	Direction directionXAxis;
	Direction directionYAxis;
	
	public MouvementKeyListener(Jeu jeu) {
		this.jeu = jeu;
		t = new Thread(this);
		t.start();
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case (KeyEvent.VK_Z) :
				directionYAxis = Direction.UP;
				break;
			case (KeyEvent.VK_S) :
				directionYAxis = Direction.DOWN;
				break;
			case (KeyEvent.VK_Q) :
				directionXAxis = Direction.LEFT;
				break;
			case (KeyEvent.VK_D) :
				directionXAxis = Direction.RIGHT;
				break;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case (KeyEvent.VK_Z) :
				if (directionYAxis == Direction.UP) {
					directionYAxis = null;
				}
				break;
			case (KeyEvent.VK_S) :
				if (directionYAxis == Direction.DOWN) {
					directionYAxis = null;
				}
				break;
			case (KeyEvent.VK_Q) :
				if (directionXAxis == Direction.LEFT) {
					directionXAxis = null;
				}
				break;
			case (KeyEvent.VK_D) :
				if (directionXAxis == Direction.RIGHT) {
					directionXAxis = null;
				}
				break;
		}
	}
	
	
	public void run() {
		while (!jeu.isGameOver()) {
			move();
			try {
				Thread.sleep(50);
				} catch (InterruptedException e) {
				System.out.println(e);	
			}
		}
	}
	
	private void move() {
		
		if (directionYAxis == Direction.UP) {
			if (directionXAxis == Direction.LEFT) {
//				jeu.moveChar(Direction.UP_LEFT);
			} else if (directionXAxis == Direction.RIGHT) {
//				jeu.moveChar(Direction.UP_RIGHT);
			} else {
				System.out.println("up");
//				jeu.moveChar(Direction.UP);
			}
		} else if (directionYAxis == Direction.DOWN) {
			if (directionXAxis == Direction.LEFT) {
//				jeu.moveChar(Direction.DOWN_LEFT);
			} else if (directionXAxis == Direction.RIGHT) {
//				jeu.moveChar(Direction.DOWN_RIGHT);
			} else {
				System.out.println("down");
//				jeu.moveChar(Direction.DOWN);
			}
		} else {
			if (directionXAxis == Direction.LEFT) {
//				jeu.moveChar(Direction.LEFT);
			} else if (directionXAxis == Direction.RIGHT) {
//				jeu.moveChar(Direction.RIGHT);
			}
		}
		
	}
	
}