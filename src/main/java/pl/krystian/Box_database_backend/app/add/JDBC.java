package pl.krystian.Box_database_backend.app.add;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
class JDBC {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost/pudelka";

	private final String user = "root";
	private final String pass = "";

	private void Connect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
		} catch (Exception e) {
			Disconnect();
		}
	}

	private void Disconnect() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("Error while closing ResultSet" + e);
		}

		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			System.out.println("Error while closing Statement" + e);
		}

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("Error while closing Connection" + e);
		}

	}

	public int CountBoxes() {
		Connect();
		String query = "SELECT COUNT(id) AS count FROM boxes";
		int count = 0;
		try {
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {e.printStackTrace();}
		finally {Disconnect();}
		return count;
	}
}
