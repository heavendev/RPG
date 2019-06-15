package Personnages;

public abstract class Metier {
	protected int Xp=0;
	protected int level=1;
	
	public int getXp() {
		return Xp;
			
	}
	
	public int getLevel() {
		return level;
	}
	
	public void level() {
		level++;
	}h

}
