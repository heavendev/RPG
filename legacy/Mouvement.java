package legacy;

public class Mouvement {

	private FileToMap map;
	private Zone zone;

	public Mouvement() {
		/* Inititialiser FileToMap */
		map = new FileToMap();
		// map.setPath("carte.txt");

		/* Initiliser Zone */
		zone = new Zone();
		zone.setZone(map.toMap());

		/* Coordonnée du personnage dans zone */

		zone.setCharCoordinates(4, 7);
		zone.showMap();
	}
	
	public void mouvement(Direction dir) {
	       zone.move(dir);
		}
}
