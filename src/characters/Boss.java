package characters;

import java.util.ArrayList;

public class Boss extends Ennemy{

	public Boss(String name, int level, int xp, String classe, ArrayList<String[]> attacks,
			ArrayList<String[]> criticalHit, ArrayList<String[]> magicAttack, ArrayList<String[]> magicCriticalHit) {
		super(name, level, xp, classe, attacks, criticalHit, magicAttack, magicCriticalHit);
	}

}