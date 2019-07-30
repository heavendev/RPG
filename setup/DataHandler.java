package setup;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DataHandler {
	
private static DataHandler instance;
	
	public static DataHandler getDataHandler() {
		if (instance == null) {
			instance = new DataHandler();
		}
		return instance;
	}
	
	private DataHandler() { }
	
	
	
	
	public ArrayList<HashMap> getEquipment(int save) throws SQLException {
		return DatabaseTest.getDatabaseTest().getEquipments(save);
	}
	
	public ArrayList<HashMap> getNPCs(int save) throws SQLException {
		return DatabaseTest.getDatabaseTest().getNPCs(save);
	}
	
	public HashMap getSquad(int save) throws SQLException {
		return DatabaseTest.getDatabaseTest().getSquad(save);
	}
	
	public HashMap<String,ArrayList<HashMap>> getCharacters(int save) throws SQLException {
		return DatabaseTest.getDatabaseTest().getCharacters(save);
	}
	
	public ArrayList<HashMap<String,String>> getSquadEquipment(int squadID) throws SQLException {
		return DatabaseTest.getDatabaseTest().getSquadEquipment(squadID);
	}
	
	public ArrayList<HashMap> getQuests(int save) throws SQLException {
		return DatabaseTest.getDatabaseTest().getQuests(save);
	}
}
