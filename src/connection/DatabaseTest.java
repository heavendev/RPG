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
		String test = "TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"
				+"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"
				+"TT               TTT00                       TT             TT"
				+"TT            TTTT                     0TTT   TTT           TT"
				+"TT          0TTTTTTT                   TTT   TTT            TT"
				+"TTT           TTTT00TT                 TTT   TTT0           TT"
				+"TTTTT             TT    TTT000        T00TT   TTTTTTTT0     TT"
				+"TTTTTT00              TTTTTTTTTT0    TTTTTT      TTTTTT     TT"
				+"TTTTT            TTTTTTTTTT00TTTTT0TTTTTTTTTT      TTT      TT"
				+"TTTTTTTTTTTT       TTTTTTTTTTTTTTTTTTTT           TTTTT     TT"
				+"TTTTTTTTTTTTT     TTTTTTTTT         TTTTTTTTTT   TTTT       TT"
				+"TTTTTTTTTT          TTTTTT             TTTT        TTT      TT"
				+"TTTTTTT               TTT               TT         T        TT"
				+"TTTTTT0                T      00TT    TTTT                  TT"
				+"TTTT0000              TT       00TT     TT        TT0       TT"
				+"TT0000T           TT00T0T     TT0T0      TT        0TT      TT"
				+"TTTTTTTT0000T    TTTTTTTTT     TTTTT     TTT       TTT      TT"
				+"TTT00T         TTTTT00TT         TT0T     TTT       TTTT0T00TT"
				+"TTTTTTT   U        TTTT          TTT     TT        TT00     TT"
				+"TTT0T0T       TTTT00T0TTTT       TTTTT     TTT           TTTTT"
				+"TTTTTTTTTTTTTTTTTTT000TTTT      TTTT                 TTTTTTTTT"
				+"TT                             T0000T                       TT"
				+"TT U                          TTTTT                         TT"
				+"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"
				+"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT";
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
	
	
	
}