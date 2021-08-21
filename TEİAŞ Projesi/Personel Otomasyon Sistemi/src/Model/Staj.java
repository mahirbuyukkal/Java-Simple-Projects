package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Staj {

	private int id;
	private String name;

	DBConnection conn = new DBConnection();
	Statement st = null;
	ResultSet rs = null;
	
	PreparedStatement preparedStatement = null;

	public Staj(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ArrayList<Staj> getList() throws SQLException {

		ArrayList<Staj> list = new ArrayList<>();
		Staj obj;
		Connection con = conn.connDb();
		
		try {
			
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM staj");
			while (rs.next()) {
				obj = new Staj();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("bolum"));
				list.add(obj);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			con.close();
		}

		return list;
	}
	
	public boolean addStaj(String bolum) throws SQLException {
		
		String query = "INSERT INTO staj" + "(bolum) VALUES" + "(?)";
		boolean key = false;
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, bolum);
			preparedStatement.executeUpdate();
			key = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(key)
			return true;
		else
			return false;
		
	}
	
	public boolean deleteStaj(int id) throws SQLException {
		
		String query = "DELETE FROM staj WHERE id = ?";
		boolean key = false;
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			key = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(key)
			return true;
		else
			return false;
		
	}
	
	public boolean updateStaj(int id, String name) throws SQLException {
		
		String query = "UPDATE staj SET name = ? WHERE id = ?";
		boolean key = false;
		Connection con = conn.connDb();
		
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			key = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(key)
			return true;
		else
			return false;
		
	}

	public Staj() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
