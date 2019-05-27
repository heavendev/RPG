package connection;

import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.sql.rowset.serial.SerialBlob;

public class DatabaseConnector {
	
//		Singleton class for all database communication

	
	private static DatabaseConnector dc;
	private Connection con;
	private String database;
	
	public static DatabaseConnector getDatabaseConnector() {
		if (dc == null) {
			dc = new DatabaseConnector();
		}
		return dc;
	}	
	
	private DatabaseConnector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+ database + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
			String user = "root";
			String pwd = "Win311*";
			try {
				con = DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				dc = null;
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			dc = null;
			e.printStackTrace();
		}
	}
	
// 		Returns a HashMap containing
// 		"isValid" a boolean if the password matches the associated user password in the DB
// 		"user_id" the users primary key in the DB
	
	public HashMap checkCredentials(String nickname, String pw) throws SQLException {
		HashMap hm = new HashMap();
		String query = "SELECT password,salt,user_id " 
				+ "FROM users "
				+ "WHERE pseudo = ?;";
		PreparedStatement s = con.prepareStatement(query);
		s = con.prepareStatement(query);
		s.setString(1, nickname);
		ResultSet rs = s.executeQuery();
		while (rs.next()) {
			Blob blob = rs.getBlob("salt");
			int myblobLength = (int) blob.length();  
			byte[] salt = blob.getBytes(1, myblobLength);
			blob.free();
			boolean isValid = PasswordCrypter.getPasswordCrypter().checkPassword(pw, salt, rs.getString("password"));
			hm.put("isValid",isValid);
			if (isValid) {
				hm.put("user_id", rs.getString("user_id"));
			}
			return (hm);
		}
		return null;
	}
	
	
//		 Adds a user to the DB
// 		His nickname, first name, last name, email
// 		And password crypted with the associated salt key
	
	public void addUserToDB(HashMap<String, String> u) throws NoSuchAlgorithmException, SQLException {
		HashMap pw = PasswordCrypter.getPasswordCrypter().encryptNewPassword(u.get("password"));
		Blob blob = new SerialBlob((byte[]) pw.get("salt"));
		String password = (String) pw.get("password");
		String addUser = "INSERT INTO users" 
				+ "(firstname,lastname,email,password,salt,pseudo) VALUES"
				+ "(?,?,?,?,?,?)";
		PreparedStatement s = con.prepareStatement(addUser);
		s = con.prepareStatement(addUser);
		s.setString(1, u.get("firstName"));
		s.setString(2, u.get("lastName"));
		s.setString(3, u.get("email"));
		s.setString(4, password);
		s.setBlob(5, blob);
		s.setString(6, u.get("nickname"));
		s.execute();
	}
		
	// Checks if the nickname or email are already present in the DB
	// If one or both are, returns true
	
	public boolean checkIfIsDuplicateUser(String[] toCheck) throws SQLException {
		String query = "SELECT * "
			+ "FROM users " 
			+ "WHERE pseudo = ? AND email = ?;";
		PreparedStatement s = con.prepareStatement(query);
		s = con.prepareStatement(query);
		s.setString(1, toCheck[0]);
		s.setString(2, toCheck[1]);
		ResultSet rs = s.executeQuery();
		while(rs.next()) {
			return true;
		}
		return false;
	}
	
	
	
}