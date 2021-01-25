package pl.krystian.Box_database_backend.app.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class JDBC {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost/pudelka";
	
	private final String user = "root";
	private final String pass = "";
	
	public ResultSet use(String query) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) {
					stmt.close();
				}
			}
			catch (Exception e) {
				System.out.println("Error while closing Statement" + e);
			}
			
			try {
				if(conn!=null) {
					conn.close();
				}
			}
			catch (Exception e) {
				System.out.println("Error while closing connection" + e);
			}
		}
		return rs;
	}
}
