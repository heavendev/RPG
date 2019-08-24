package setup;

import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.sql.rowset.serial.SerialBlob;

public class DatabaseTest {
	
//		Singleton class for all database communication

	
	private static DatabaseTest dc;
	private Connection con;
	
	public static DatabaseTest getDatabaseTest() {
		if (dc == null) {
			dc = new DatabaseTest();
		}
		return dc;
	}	
	
	private DatabaseTest() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://137.74.118.171/sta26";
			String user = "sta26";
			String pwd = "8xs77a";
			try {
				System.out.println("attempting connection");
				con = DriverManager.getConnection(url, user, pwd);
				System.out.println("success");
			} catch (SQLException e) {
				System.out.println("failed");
				dc = null;
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			dc = null;
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<HashMap> getEquipments(int save) throws SQLException {
		ArrayList<HashMap> ar = new ArrayList<HashMap>();
		String query = "SELECT * "
				+ "FROM equipment "
				+ "WHERE id_save = ?";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, save);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			HashMap hm = new HashMap();
			hm.put("name", rs.getString("name"));
			hm.put("attack", rs.getInt("attack"));
			hm.put("defence", rs.getInt("defence"));
			hm.put("magic", rs.getInt("magic"));
			hm.put("resistance", rs.getInt("resistance"));
			hm.put("speed", rs.getInt("speed"));
			hm.put("healthPoints", rs.getInt("health_points"));
			hm.put("willPoints", rs.getInt("will_points"));
			hm.put("value", rs.getInt("value"));
			ar.add(hm);
		}
		return ar;
	}
	
	public ArrayList<HashMap> getNPCs(int save) throws SQLException {
		ArrayList<HashMap> ar = new ArrayList<HashMap>();
		String query = "SELECT * "
				+ "FROM NPC "
				+ "WHERE id_save = ?;";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, save);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			HashMap hm = new HashMap();
			hm.put("name", rs.getString("name"));
			hm.put("trader", rs.getBoolean("is_trader"));
			hm.put("x", rs.getInt("coor_x"));
			hm.put("y", rs.getInt("coor_y"));
			hm.put("map", rs.getString("map"));
			HashMap<String, ArrayList<HashMap>> tmp = getNPCStringArray(rs.getInt("id_npc"));
			hm.put("portrait", tmp.get("portrait"));
			hm.put("life", tmp.get("life"));
			hm.put("isActive", rs.getBoolean("is_active"));
			ar.add(hm);
		}
		return ar;
	}
	private HashMap<String, ArrayList<HashMap>> getNPCStringArray(int npc) throws SQLException {
		HashMap<String, ArrayList<HashMap>> hm = new HashMap<String, ArrayList<HashMap>>();
		String query = "SELECT * "
				+ "FROM npc_list "
				+ "WHERE id_npc = ?;";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, npc);
		ResultSet rs = s.executeQuery();
		ArrayList<HashMap> portrait = new ArrayList<HashMap>();
		ArrayList<HashMap> life = new ArrayList<HashMap>();
		while (rs.next()) {
			if (rs.getString("type") == "portrait") {
				portrait = getNPCStringArrayLines(rs.getInt("id_npc_list"));
			} else {
				life = getNPCStringArrayLines(rs.getInt("id_npc_list"));
			}
		}
		hm.put("portrait", portrait);
		hm.put("life", life);
		return hm;
	}
	private ArrayList<HashMap> getNPCStringArrayLines(int list) throws SQLException {
		ArrayList<HashMap> ar = new ArrayList<HashMap>();
		String query = "SELECT * " 
				+ "FROM npc_line_list "
				+ "WHERE id_npc_list = ?;";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, list);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			HashMap hm = new HashMap();
			hm.put("lineNumber", rs.getInt("line"));
			hm.put("lineText", rs.getString("texte"));
			ar.add(hm);
		}
		return ar;
	}
	
	public HashMap getSquad(int save) throws SQLException {
		HashMap hm = new HashMap();
		String query = "SELECT * "
				+ "FROM squad "
				+ "WHERE id_save = ?;";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, save);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			hm.put("x", rs.getInt("coor_x"));
			hm.put("y", rs.getInt("coor_y"));
			hm.put("map", rs.getString("map"));
			hm.put("gold", rs.getInt("gold"));
			hm.put("questStage", rs.getInt("quest_stage"));
			hm.put("squadID", rs.getInt("id_squad"));
		}
		return hm;
	}
	
	public HashMap<String,ArrayList<HashMap>> getCharacters(int save) throws SQLException {
		HashMap<String,ArrayList<HashMap>> hm = new HashMap<String,ArrayList<HashMap>>();
		ArrayList<HashMap> goodGuys = new ArrayList<HashMap>();
		ArrayList<HashMap> ennemies = new ArrayList<HashMap>();
		ArrayList<HashMap> boss = new ArrayList<HashMap>();
		String query = "SELECT * "
				+ "FROM character "
				+ "WHERE id_save = ?;";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, save);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			HashMap tmp = new HashMap();
			String classe = rs.getString("class");
			tmp.put("name", rs.getString("name"));
			tmp.put("class", classe);
			tmp.put("level", rs.getInt("level"));
			tmp.put("xp", rs.getInt("xp"));
			tmp.put("sentences", getCharacterStringArray(rs.getInt("id_character")));
			if (classe == "Boss") {
				tmp.put("equipment", getMobEquipment(rs.getInt("id_character")));
				boss.add(tmp);
			} else if (classe == "Canaille") {
				tmp.put("equipment", getMobEquipment(rs.getInt("id_character")));
				ennemies.add(tmp);
			} else {
				tmp.put("isInSquad", rs.getBoolean("is_in_squad"));
				goodGuys.add(tmp);
			}
		}
		hm.put("goodGuys", goodGuys);
		hm.put("boss", boss);
		hm.put("ennemies", ennemies);
		return hm;
	}
	private HashMap<String,ArrayList<ArrayList<HashMap>>> getCharacterStringArray(int character) throws SQLException {
		HashMap<String,ArrayList<ArrayList<HashMap>>> toReturn = new HashMap<String,ArrayList<ArrayList<HashMap>>>();
		ArrayList<ArrayList<HashMap>> attack = new ArrayList<ArrayList<HashMap>>();
		ArrayList<ArrayList<HashMap>> criticalHit = new ArrayList<ArrayList<HashMap>>();
		ArrayList<ArrayList<HashMap>> magicAttack = new ArrayList<ArrayList<HashMap>>();
		ArrayList<ArrayList<HashMap>> magicCriticalHit = new ArrayList<ArrayList<HashMap>>();
		String query = "SELECT * " 
				+ "FROM character_list "
				+ " WHERE id_character = ?;";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, character);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			switch (rs.getString("type")) {
			case "attack" :
				attack.add(getCharacterArrayLines(rs.getInt("id_character_list")));
				break;
			case "criticalHit" :
				criticalHit.add(getCharacterArrayLines(rs.getInt("id_character_list")));
				break;
			case "magicAttack" :
				magicAttack.add(getCharacterArrayLines(rs.getInt("id_character_list")));
				break;
			case "magicCriticalHit" :
				magicCriticalHit.add(getCharacterArrayLines(rs.getInt("id_character_list")));
				break;
			}
		}
		toReturn.put("attack", attack);
		toReturn.put("criticalHit", criticalHit);
		toReturn.put("magicAttack", magicAttack);
		toReturn.put("magicCriticalHit", magicCriticalHit);
		return toReturn;
	}
	private ArrayList<HashMap> getCharacterArrayLines(int id) throws SQLException{
		ArrayList<HashMap> ar = new ArrayList<HashMap>();
		String query = "SELECT * " 
				+ "FROM character_line_list "
				+ " WHERE id_character_list = ?;";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, id);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			HashMap hm = new HashMap();
			hm.put("lineNumber", rs.getInt("line"));
			hm.put("lineText", rs.getString("texte"));
			ar.add(hm);
		}
		return ar;
	}
	private ArrayList<HashMap> getMobEquipment(int mob) throws SQLException {
		ArrayList<HashMap> ar = new ArrayList<HashMap>();
		String query = "SELECT * "
				+ "FROM mob_equipment "
				+ "WHERE id_character = ?";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, mob);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			HashMap hm = new HashMap();
			hm.put("equipmentName", rs.getString("equipment_name"));
			hm.put("isForLoot", rs.getBoolean("is_for_loot"));
			ar.add(hm);
		}
		return ar;
	}
	
	public ArrayList<HashMap<String,String>> getSquadEquipment(int squadID) throws SQLException {
		ArrayList<HashMap<String,String>> ar = new ArrayList<HashMap<String,String>>();
		String query = "SELECT * "
				+ "FROM squad_equipment "
				+ "WHERE id_squad = ?;";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, squadID);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			HashMap<String,String> hm = new HashMap<String,String>();
			hm.put("owner", rs.getString("owner"));
			hm.put("equipmentName", rs.getString("equipment_name"));
			ar.add(hm);
		}
		return ar;
	}
	
	public ArrayList<HashMap> getQuests(int save) throws SQLException {
		ArrayList<HashMap> ar = new ArrayList<HashMap>();
		String query = "SELECT * "
				+ "FROM quest "
				+ "WHERE id_quest = ?";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, save);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			HashMap hm = new HashMap();
			hm.put("name", rs.getString("name"));
			hm.put("x", rs.getInt("coor_x"));
			hm.put("y", rs.getInt("coor_y"));
			hm.put("map", rs.getString("map"));
			hm.put("questStage", rs.getInt("quest_stage"));
			hm.put("isMainQuest", rs.getBoolean("is_main_chain"));
			hm.put("type", rs.getString("type"));
			hm.put("bossName", rs.getString("boss_name"));
			hm.put("charReward", rs.getString("char_reward"));
			hm.put("npcReward", rs.getString("npc_reward"));
			hm.put("goldReward", rs.getString("gold_reward"));
			hm.put("xpReward", rs.getString("xp_reward"));
			hm.put("equipmentReward", rs.getString("equipment_reward"));
			hm.put("status", rs.getString("status"));
			hm.put("questGiver", rs.getString("npc_giver"));
			HashMap<String,ArrayList<HashMap>> h = getQuestStringArray(rs.getInt("id_quest"));
			hm.put("questDescription", h.get("questDescription"));
			hm.put("questPresentation", h.get("questPresentation"));
			hm.put("questObjectiveReached", h.get("questObjectiveReached"));
			hm.put("questTurnIn", h.get("questTurnIn"));
			ar.add(hm);
		}
		return ar;
	}
	public HashMap<String,ArrayList<HashMap>> getQuestStringArray(int quest) throws SQLException {
		HashMap<String,ArrayList<HashMap>> hm = new HashMap<String,ArrayList<HashMap>>();
		String query = "SELECT * "
				+ "FROM quest_list "
				+ "WHERE id_quest = ?";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, quest);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			switch (rs.getString("type")) {
				case "questDescription" :
					hm.put("questDescription", getQuestArrayLines(rs.getInt("id_quest_list")));
					break;
				case "questPresentation" :
					hm.put("questPresentation", getQuestArrayLines(rs.getInt("id_quest_list")));
					break;
				case "questObjectiveReached" :
					hm.put("questObjectiveReached", getQuestArrayLines(rs.getInt("id_quest_list")));
					break;
				case "questTurnIn" :
					hm.put("questTurnIn", getQuestArrayLines(rs.getInt("id_quest_list")));
					break;
			}
		}
		return hm;
	}
	public ArrayList<HashMap> getQuestArrayLines(int id) throws SQLException {
		ArrayList<HashMap> ar = new ArrayList<HashMap>();
		String query = "SELECT * "
				+ "FROM quest_line_list "
				+ "WHERE id_quest_list = ?";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, id);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			HashMap hm = new HashMap();
			hm.put("lineNumber", rs.getInt("line"));
			hm.put("lineText", rs.getString("texte"));
			ar.add(hm);
		}
		return ar;
	}
	
	
	
	
	
	public Integer getPreviousSaveId(int userID, int saveNumber) throws SQLException {
		Integer saveID = null;
		String query = "SELECT * "
				+ "FROM save "
				+ "WHERE id_user = ? && save_number = ?;";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, userID);
		s.setInt(2, saveNumber);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			return rs.getInt("id_save");
		}
		return saveID;
	}
	
	public void deletePreviousSave(int saveID) throws SQLException {
		String q = "DELETE "
				+ "FROM save "
				+ "WHERE id_save = ?;";
		PreparedStatement s = con.prepareStatement(q);
		s.setInt(1,saveID);
		s.execute();
		s.close();
	}
	
	public void saveEquipment(ArrayList<HashMap> ar, int save) throws SQLException {
		String insert = "INSERT INTO "
				+ "equipment(name, attack, defence, magic, resistance, speed, health_points, will_points, value, id_save) "
				+ "values(?,?,?,?,?,?,?,?,?);";
		PreparedStatement s = con.prepareStatement(insert);
		for (HashMap hm : ar) {
			s.setString(1, (String) hm.get("name"));
			s.setInt(2, (int) hm.get("attack"));
			s.setInt(3, (int) hm.get("defence"));
			s.setInt(4, (int) hm.get("magic"));
			s.setInt(5, (int) hm.get("resistance"));
			s.setInt(6, (int) hm.get("speed"));
			s.setInt(7, (int) hm.get("healthPoints"));
			s.setInt(8, (int) hm.get("willPoints"));
			s.setInt(9, (int) hm.get("value"));
			s.setInt(10, save);
			s.addBatch();
		}
		s.executeBatch();
		s.close();
	}
	
	public void saveNpc(ArrayList<HashMap> ar, int save) throws SQLException {
		String insert = "INSERT INTO "
				+ "npc(name, is_trader, coor_x, coor_y, map, is_active, id_save) "
				+ "values(?,?,?,?,?,?,?);";
		PreparedStatement s = con.prepareStatement(insert);
		for (HashMap hm : ar) {
			s.setString(1, (String) hm.get("name"));
			s.setBoolean(2, (boolean) hm.get("isTrader"));
			s.setInt(3, (int) hm.get("coorX"));
			s.setInt(4, (int) hm.get("coorY"));
			s.setString(5, (String) hm.get("map"));
			s.setBoolean(6, (boolean) hm.get("isActive"));
			s.setInt(7, save);
			s.addBatch();
		}
		s.executeBatch();
		s.close();
		
		String query = "SELECT * "
				+ "FROM npc "
				+ "WHERE id_save = ?;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, save);
		ResultSet rs = ps.executeQuery();
		ps.close();
		
		ArrayList<HashMap> npcInfo = new ArrayList<HashMap>();
		while (rs.next()) {
			HashMap tmp = new HashMap();
			tmp.put("id", rs.getObject("id_npc"));
			tmp.put("name", rs.getObject("name"));
			npcInfo.add(tmp);
		}
		
		insert = "INSERT INTO "
				+ "npc_list(type, id_npc) "
				+ "values(?,?);";
		PreparedStatement pps = con.prepareStatement(insert);
		for (HashMap h : npcInfo) {
			s.setString(1, "portrait");
			s.setInt(2, (int) h.get("id"));
			s.addBatch();
			s.setString(1, "life");
			s.setInt(2, (int) h.get("id"));
			s.addBatch();
			break;
		}
		pps.executeBatch();
		pps.close();
		
		query = "SELECT * "
				+ "FROM npc_list "
				+ "WHERE ";
		for (int i = 0; i < npcInfo.size(); i++) {
			if (i == 0) {
				query = query + "id_npc = " + npcInfo.get(i).get("id_npc");
			} else {
				query = query + " OR id_npc = " + npcInfo.get(i).get("id_npc");
			}
		}
		query = query + ";";
		PreparedStatement ppps = con.prepareStatement(query);
		ResultSet set = ppps.executeQuery();
		
		
		insert = "INSERT INTO "
				+ "npc_line_list(id_npc_list,line,texte) "
				+ "values(?,?,?);";
		PreparedStatement pppps = con.prepareStatement(insert);
		while (set.next()) {
			for (HashMap h : npcInfo) {
				if (set.getInt("id_list") == (int)h.get("id")) {
					HashMap npc = getHashMapFromName((String) h.get("name"), ar);
					if (set.getString("type") == "portrait") {
						String[] portrait = (String[]) npc.get("portrait");
						for (int i = 0; i < portrait.length; i++) {
							pppps.setInt(1, (int) h.get("id"));
							pppps.setInt(2, i);
							pppps.setString(3, portrait[i]);
							pppps.addBatch();
						}
					} else {
						String[] life = (String[]) npc.get("portrait");
						for (int i = 0; i < life.length; i++) {
							pppps.setInt(1, (int) h.get("id"));
							pppps.setInt(2, i);
							pppps.setString(3, life[i]);
							pppps.addBatch();
						}
					}
					break;
				}
			}
		}
		pppps.executeBatch();
		pppps.close();
	}
	private HashMap getHashMapFromName(String name, ArrayList<HashMap> ar) {
		for (HashMap h : ar) {
			if (h.get("name").equals(name)) {
				return h;
			}
		}
		return null;
	}
	
	public int saveSquad(HashMap hm, int save) throws SQLException {
		String insert = "INSERT INTO "
				+ "squad(id_save, coor_x, coor_y, map, quest_stage, gold) "
				+ "values(?,?,?,?,?,?);";
		PreparedStatement s = con.prepareStatement(insert);
		s.setInt(1, save);
		s.setInt(2, (int) hm.get("coorX"));
		s.setInt(3, (int) hm.get("coorY"));
		s.setString(4, (String) hm.get("map"));
		s.setInt(5, (int) hm.get("questStage"));
		s.setInt(6, (int) hm.get("gold"));
		s.execute();
		s.close();
		String query = "SELECT * "
				+ "FROM squad "
				+ "WHERE id_save = ?;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, save);
		ResultSet rs = ps.executeQuery();
		int idSquad = 999999;
		while (rs.next()) {
			idSquad = rs.getInt("id_squad");
		}
		return idSquad;
	}
	
	public void saveSquadEquipment(ArrayList<HashMap<String,String>> ar, int squad) throws SQLException {
		String insert = "INSERT INTO "
				+ "squad_equipment(id_squad, equipment_name, owner) "
				+ "values(?,?,?);";
		PreparedStatement s = con.prepareStatement(insert);
		for (HashMap<String,String> hm : ar) {
			s.setInt(1, squad);
			s.setString(2, hm.get("name"));
			s.setString(3, hm.get("owner"));
			s.addBatch();
		}
		s.executeBatch();
	}
	
//	public void saveNpc(ArrayList<HashMap> ar, int save) throws SQLException {
//		String insert = "INSERT INTO "
//				+ "npc(name, is_trader, coor_x, coor_y, map, is_active, id_save) "
//				+ "values(?,?,?,?,?,?,?);";
//		PreparedStatement s = con.prepareStatement(insert);
//		for (HashMap hm : ar) {
//			s.setString(1, (String) hm.get("name"));
//			s.setBoolean(2, (boolean) hm.get("isTrader"));
//			s.setInt(3, (int) hm.get("coorX"));
//			s.setInt(4, (int) hm.get("coorY"));
//			s.setString(5, (String) hm.get("map"));
//			s.setBoolean(6, (boolean) hm.get("isActive"));
//			s.setInt(7, save);
//			s.addBatch();
//		}
//		s.executeBatch();
//		s.close();
//		
//		String query = "SELECT * "
//				+ "FROM npc "
//				+ "WHERE id_save = ?;";
//		PreparedStatement ps = con.prepareStatement(query);
//		ps.setInt(1, save);
//		ResultSet rs = ps.executeQuery();
//		ps.close();
//		
//		ArrayList<HashMap> npcInfo = new ArrayList<HashMap>();
//		while (rs.next()) {
//			HashMap tmp = new HashMap();
//			tmp.put("id", rs.getObject("id_npc"));
//			tmp.put("name", rs.getObject("name"));
//			npcInfo.add(tmp);
//		}
//		
//		insert = "INSERT INTO "
//				+ "npc_list(type, id_npc) "
//				+ "values(?,?);";
//		PreparedStatement pps = con.prepareStatement(insert);
//		for (HashMap h : npcInfo) {
//			s.setString(1, "portrait");
//			s.setInt(2, (int) h.get("id"));
//			s.addBatch();
//			s.setString(1, "life");
//			s.setInt(2, (int) h.get("id"));
//			s.addBatch();
//			break;
//		}
//		pps.executeBatch();
//		pps.close();
//		
//		query = "SELECT * "
//				+ "FROM npc_list "
//				+ "WHERE ";
//		for (int i = 0; i < npcInfo.size(); i++) {
//			if (i == 0) {
//				query = query + "id_npc = " + npcInfo.get(i).get("id_npc");
//			} else {
//				query = query + " OR id_npc = " + npcInfo.get(i).get("id_npc");
//			}
//		}
//		query = query + ";";
//		PreparedStatement ppps = con.prepareStatement(query);
//		ResultSet set = ppps.executeQuery();
//		
//		
//		insert = "INSERT INTO "
//				+ "npc_line_list(id_npc_list,line,texte) "
//				+ "values(?,?,?);";
//		PreparedStatement pppps = con.prepareStatement(insert);
//		while (set.next()) {
//			for (HashMap h : npcInfo) {
//				if (set.getInt("id_list") == (int)h.get("id")) {
//					HashMap npc = getHashMapFromName((String) h.get("name"), ar);
//					if (set.getString("type") == "portrait") {
//						String[] portrait = (String[]) npc.get("portrait");
//						for (int i = 0; i < portrait.length; i++) {
//							pppps.setInt(1, (int) h.get("id"));
//							pppps.setInt(2, i);
//							pppps.setString(3, portrait[i]);
//							pppps.addBatch();
//						}
//					} else {
//						String[] life = (String[]) npc.get("portrait");
//						for (int i = 0; i < life.length; i++) {
//							pppps.setInt(1, (int) h.get("id"));
//							pppps.setInt(2, i);
//							pppps.setString(3, life[i]);
//							pppps.addBatch();
//						}
//					}
//					break;
//				}
//			}
//		}
//		pppps.executeBatch();
//		pppps.close();
//	}
}