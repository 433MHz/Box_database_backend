package pl.krystian.Box_database_backend.app.add;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.krystian.Box_database_backend.app.objects.FromFront;
import pl.krystian.Box_database_backend.app.objects.ToFrontData;

@Component
class JDBC {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement preparedStatement;

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

	public boolean addItem(FromFront data) {
		Connect();
		int boxNum = data.getBoxNum();
		String itemName = data.getItemName();
		String itemDesc = data.getItemDesc();
		int amount = data.getAmount();
		
		String query = "INSERT INTO items (name,description,amount,box_id) VALUES (?,?,?,?);";
		boolean isSended = false;
		try {
			preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setString(1, itemName);
			preparedStatement.setString(2, itemDesc);
			preparedStatement.setInt(3, amount);
			preparedStatement.setInt(4, boxNum);
			
			if(preparedStatement.executeUpdate() > 0) isSended = true;
		} catch (SQLException e) {System.out.println(e);}
		finally {
			Disconnect();
		}
		return isSended;
	}

	@Autowired
	ToFrontData toFrontData;
	
	public ArrayList<ToFrontData> getAll() {
		Connect();
		String query = "SELECT i.id, i.name AS itemName, i.description AS itemDescription, i.category, i.amount, b.name AS boxName, b.description AS boxDescription FROM items AS i INNER JOIN boxes as b ON i.box_id = b.id ORDER BY i.id ASC;";
		ArrayList<ToFrontData> list = new ArrayList<ToFrontData>();
		try {
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String iName = rs.getString(2);
				String iDesc = rs.getString(3);
				String iCategory = rs.getString(4);
				int iAmount = rs.getInt(5);
				String bName = rs.getString(6);
				String bDesc = rs.getString(7);
				
				toFrontData.setAll(id, iName, iDesc, iCategory, iAmount, bName, bDesc);
				list.add(toFrontData);
				toFrontData = new ToFrontData();
			}
		} catch (SQLException e) {e.printStackTrace();}
		finally {Disconnect();}
		return list;
	}
}
