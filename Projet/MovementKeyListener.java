package Projet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import nonActiveClasses.Direction;

public class MovementKeyListener implements KeyListener, Runnable {

	private Jeu jeu;
	private Thread t;
	
	Direction directionXAxis;
	Direction directionYAxis;
	boolean up = false;
	boolean down = false;
	boolean right = false;
	boolean left = false;
	
	public MovementKeyListener(Jeu jeu) {
		this.jeu = jeu;
		t = new Thread(this);
		t.start();
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case (KeyEvent.VK_Z) :
				directionYAxis = Direction.UP;
				up = true;
				break;
			case (KeyEvent.VK_S) :
				directionYAxis = Direction.DOWN;
				down = true;
				break;
			case (KeyEvent.VK_Q) :
				directionXAxis = Direction.LEFT;
				left = true;
				break;
			case (KeyEvent.VK_D) :
				directionXAxis = Direction.RIGHT;
				right = true;
				break;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case (KeyEvent.VK_Z) :
				up = false;
				if (directionYAxis == Direction.UP) {
					if (down) {
						directionYAxis = Direction.DOWN;;
					} else {
						directionYAxis = null;
					}
				}
				break;
			case (KeyEvent.VK_S) :
				down = false;
				if (directionYAxis == Direction.DOWN) {
					if (up) {
						directionYAxis = Direction.UP;;
					} else {
						directionYAxis = null;
					}
				}
				break;
			case (KeyEvent.VK_Q) :
				left = false;
				if (directionXAxis == Direction.LEFT) {
					if (right) {
						directionXAxis = Direction.RIGHT;
					} else {
						directionXAxis = null;
					}
				}
				break;
			case (KeyEvent.VK_D) :
				right = false;
				if (directionXAxis == Direction.RIGHT) {
					if (left) {
						directionXAxis = Direction.LEFT;
					} else {
						directionXAxis = null;
					}
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
				jeu.moveChar(Direction.UP_LEFT);
			} else if (directionXAxis == Direction.RIGHT) {
				jeu.moveChar(Direction.UP_RIGHT);
			} else {
				jeu.moveChar(Direction.UP);
			}
		} else if (directionYAxis == Direction.DOWN) {
			if (directionXAxis == Direction.LEFT) {
				jeu.moveChar(Direction.DOWN_LEFT);
			} else if (directionXAxis == Direction.RIGHT) {
				jeu.moveChar(Direction.DOWN_RIGHT);
			} else {
				jeu.moveChar(Direction.DOWN);
			}
		} else {
			if (directionXAxis == Direction.LEFT) {
				jeu.moveChar(Direction.LEFT);
			} else if (directionXAxis == Direction.RIGHT) {
				jeu.moveChar(Direction.RIGHT);
			}
		}
	}
	
}