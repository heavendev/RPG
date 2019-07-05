package data;

public class userData {
	
	private int userID;
	private static userData instance;
	
	public static userData getUserData() {
		if (instance == null) {
			instance = new userData();
		}
		return instance;
	}
	
	
	
	
	
	
	
	
	public void clearData() {
		instance = null;
	}
	
	public void setUserID(int id) {
		userID = id;
	}
	public int getUserId() {
		return userID;
	}
	
	
}