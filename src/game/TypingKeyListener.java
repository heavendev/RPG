package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import nonActiveClasses.Displaying;

public class TypingKeyListener implements KeyListener, Runnable{
	
	private Jeu jeu;
	private Thread t;
	
	private String typed = "";
	private boolean uppercase = false;
	
	public TypingKeyListener(Jeu jeu) {
		this.jeu = jeu;
		t = new Thread(this);
		t.start();
	}
	
	
	
	public void keyTyped(KeyEvent e) {
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case (KeyEvent.VK_SHIFT) :
			uppercase = true;
			break;
		case (KeyEvent.VK_A) :
			if (uppercase) {
				typed = typed + "A";
			} else {
				typed = typed + "a";
			}
			break;
		case (KeyEvent.VK_B) :
			if (uppercase) {
				typed = typed + "B";
			} else {
				typed = typed + "b";
			}
		break;
		case (KeyEvent.VK_C) :
			if (uppercase) {
				typed = typed + "C";
			} else {
				typed = typed + "c";
			}
		break;
		case (KeyEvent.VK_D) :
			if (uppercase) {
				typed = typed + "D";
			} else {
				typed = typed + "d";
			}
		break;
		case (KeyEvent.VK_E) :
			if (uppercase) {
				typed = typed + "E";
			} else {
				typed = typed + "e";
			}
		break;
		case (KeyEvent.VK_F) :
			if (uppercase) {
				typed = typed + "F";
			} else {
				typed = typed + "f";
			}
		break;
		case (KeyEvent.VK_G) :
			if (uppercase) {
				typed = typed + "G";
			} else {
				typed = typed + "g";
			}
		break;
		case (KeyEvent.VK_H) :
			if (uppercase) {
				typed = typed + "H";
			} else {
				typed = typed + "h";
			}
		break;
		case (KeyEvent.VK_I) :
			if (uppercase) {
				typed = typed + "I";
			} else {
				typed = typed + "i";
			}
		break;
		case (KeyEvent.VK_J) :
			if (uppercase) {
				typed = typed + "J";
			} else {
				typed = typed + "j";
			}
		break;
		case (KeyEvent.VK_K) :
			if (uppercase) {
				typed = typed + "K";
			} else {
				typed = typed + "k";
			}
		break;
		case (KeyEvent.VK_L) :
			if (uppercase) {
				typed = typed + "L";
			} else {
				typed = typed + "l";
			}
		break;
		case (KeyEvent.VK_M) :
			if (uppercase) {
				typed = typed + "M";
			} else {
				typed = typed + "m";
			}
		break;
		case (KeyEvent.VK_N) :
			if (uppercase) {
				typed = typed + "N";
			} else {
				typed = typed + "n";
			}
		break;
		case (KeyEvent.VK_O) :
			if (uppercase) {
				typed = typed + "O";
			} else {
				typed = typed + "o";
			}
		break;
		case (KeyEvent.VK_P) :
			if (uppercase) {
				typed = typed + "P";
			} else {
				typed = typed + "p";
			}
		break;
		case (KeyEvent.VK_Q) :
			if (uppercase) {
				typed = typed + "Q";
			} else {
				typed = typed + "q";
			}
		break;
		case (KeyEvent.VK_R) :
			if (uppercase) {
				typed = typed + "R";
			} else {
				typed = typed + "r";
			}
		break;
		case (KeyEvent.VK_S) :
			if (uppercase) {
				typed = typed + "S";
			} else {
				typed = typed + "s";
			}
		break;
		case (KeyEvent.VK_T) :
			if (uppercase) {
				typed = typed + "T";
			} else {
				typed = typed + "t";
			}
		break;
		case (KeyEvent.VK_U) :
			if (uppercase) {
				typed = typed + "U";
			} else {
				typed = typed + "u";
			}
		break;
		case (KeyEvent.VK_V) :
			if (uppercase) {
				typed = typed + "V";
			} else {
				typed = typed + "v";
			}
		break;
		case (KeyEvent.VK_W) :
			if (uppercase) {
				typed = typed + "W";
			} else {
				typed = typed + "w";
			}
		break;
		case (KeyEvent.VK_X) :
			if (uppercase) {
				typed = typed + "X";
			} else {
				typed = typed + "x";
			}
		break;
		case (KeyEvent.VK_Y) :
			if (uppercase) {
				typed = typed + "Y";
			} else {
				typed = typed + "y";
			}
		break;
		case (KeyEvent.VK_Z) :
			if (uppercase) {
				typed = typed + "Z";
			} else {
				typed = typed + "z";
			}
		break;
		case (KeyEvent.VK_1) :
			typed = typed + "1";
		break;
		case (KeyEvent.VK_2) :
			if (uppercase) {
				typed = typed + "@";
			} else {
				typed = typed + "2";
			}
			
		break;
		case (KeyEvent.VK_3) :
			typed = typed + "3";
		break;
		case (KeyEvent.VK_4) :
			typed = typed + "4";
		break;
		case (KeyEvent.VK_5) :
			typed = typed + "5";
		break;
		case (KeyEvent.VK_6) :
			typed = typed + "6";
		break;
		case (KeyEvent.VK_7) :
			typed = typed + "7";
		break;
		case (KeyEvent.VK_8) :
			typed = typed + "8";
		break;
		case (KeyEvent.VK_9) :
			typed = typed + "9";
		break;
		case (KeyEvent.VK_0) :
			typed = typed + "0";
		break;
		case (KeyEvent.VK_DECIMAL) :
			if (jeu.getOnDisplay() == Displaying.REGISTRATION_PAGE) {
				typed = typed + ".";
			}
		break;
		case (KeyEvent.VK_AT) :
			if (jeu.getOnDisplay() == Displaying.REGISTRATION_PAGE) {
				typed = typed + "@";
			}
		break;
		case (KeyEvent.VK_DELETE) :
			typed = typed + ".";
			break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			uppercase = false;
		}
	}
	
	
	
	public void run() {
		while (!jeu.isGameOver()) {
			if (typed != "") {
				jeu.type(typed);
				typed = "";
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				System.out.println("thread error");
			}
		}
	}
	
	
	
}
