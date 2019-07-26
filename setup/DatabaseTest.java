package setup;

import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.sql.rowset.serial.SerialBlob;

public class DatabaseTest {
	
//		Singleton class for all database communication

	
	private static DatabaseTest dc;
	private Connection con;
	private String database;
	
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
	
	
	
	
	
	
	public void test() throws NoSuchAlgorithmException, SQLException {
		String test = "TT";
		String addUser = "INSERT INTO test" 
				+ "(map) VALUES"
				+ "(?)";
		PreparedStatement s = con.prepareStatement(addUser);
		s.setString(1, test);
		s.execute();
	}
	
	public void t() throws SQLException {
		String query = "SELECT * FROM test";
		PreparedStatement s = con.prepareStatement(query);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getBoolean("blyn"));
			System.out.println(rs.getInt("blyn"));
		}
	}
	
	public HashMap getEquipments(int save) throws SQLException {
		HashMap hm = new HashMap();
		String query = "SELECT * "
				+ "FROM equipment "
				+ "WHERE save = ?";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, save);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			hm.put("name", rs.getString("name"));
			hm.put("attack", rs.getInt("attack"));
			hm.put("defence", rs.getInt("defence"));
			hm.put("magic", rs.getInt("magic"));
			hm.put("resistance", rs.getInt("resistance"));
			hm.put("speed", rs.getInt("speed"));
			hm.put("healthPoints", rs.getInt("health_points"));
			hm.put("willPoints", rs.getInt("will_points"));
			hm.put("value", rs.getInt("value"));
		}
		return hm;
	}
	
	
	
	
	
	
	
	
	
	// TO FINISH
	public HashMap getNPCs(int save) throws SQLException {
		HashMap hm = new HashMap();
		String query = "SELECT * "
				+ "FROM NPC "
				+ "WHERE save = ?;";
		PreparedStatement s = con.prepareStatement(query);
		s.setInt(1, save);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			hm.put("name", rs.getString("name"));
			hm.put("trader", rs.getBoolean("is_trader"));
			hm.put("x", rs.getInt("coor_x"));
			hm.put("y", rs.getInt("coor_y"));
			hm.put("map", rs.getString("map"));
		}
		return hm;
	}
	
}