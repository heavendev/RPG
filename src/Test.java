package FileRouge;

public class Test {
	
	public static void main(String[] args) {
		
		
		FileToMap file = new FileToMap();
		Zone map = new Zone();
		
		map.setZone(file.toMap());
		
		map.setCharCoordinates(3, 4);
		map.showMap();
		
		for (int i = 0; i < 100; i++) {
			switch ((int)(Math.random()*4)) {
			case(0) :
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
				map.move(Direction.UP);
				break;
			case(1) :
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
			map.move(Direction.DOWN);
			break;
			case(2) :
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
			map.move(Direction.LEFT);
			break;
			case(3) :
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
			map.move(Direction.RIGHT);
			break;
			}
		}
		
	}
}