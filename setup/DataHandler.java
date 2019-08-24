package setup;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DataHandler {
	
	private static DataHandler instance;
	private DatabaseTest db;
	
	public static DataHandler getDataHandler() {
		if (instance == null) {
			instance = new DataHandler();
		}
		return instance;
	}
	
	private DataHandler() {
		db = DatabaseTest.getDatabaseTest();
	}
	
	
	
	
	public ArrayList<HashMap> getEquipment(int save) throws SQLException {
		return db.getEquipments(save);
	}
	
	public ArrayList<HashMap> getNPCs(int save) throws SQLException {
		return db.getNPCs(save);
	}
	
	public HashMap getSquad(int save) throws SQLException {
		return db.getSquad(save);
	}
	
	public HashMap<String,ArrayList<HashMap>> getCharacters(int save) throws SQLException {
		return db.getCharacters(save);
	}
	
	public ArrayList<HashMap<String,String>> getSquadEquipment(int squadID) throws SQLException {
		return db.getSquadEquipment(squadID);
	}
	
	public ArrayList<HashMap> getQuests(int save) throws SQLException {
		return db.getQuests(save);
	}
	
	
	
	
	public int getPreviousSaveId(int userID, int saveNumber) throws SQLException {
		return db.getPreviousSaveId(userID, saveNumber);
	}
	
	public void deletePreviousSave(int saveID) throws SQLException {
		db.deletePreviousSave(saveID);
	}
	
	public void saveEquipment(ArrayList<HashMap> ar, int save) throws SQLException {
		db.saveEquipment(ar, save);
	}
	
	public void saveNpc(ArrayList<HashMap> ar, int save) throws SQLException {
		db.saveNpc(ar, save);
	}
	
	public int saveSquad(HashMap hm, int save) throws SQLException {
		return db.saveSquad(hm, save);
	}
	
	public void saveSquadEquipment(ArrayList<HashMap<String,String>> ar, int squad) throws SQLException {
		db.saveSquadEquipment(ar, squad);
	}
}
