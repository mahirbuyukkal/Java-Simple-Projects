package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Yetkili extends User{
	Statement st = null;
	ResultSet rs = null;
	Connection con = conn.connDb();
	PreparedStatement preparedStatement = null;
	

	public Yetkili(int id, String tcno, String name, String password, String type) {
		super(id, tcno, name, password, type);
		
	}
	
	public Yetkili() {}
	
	public ArrayList<User> getMuhendisList() throws SQLException{
		
		ArrayList<User> list = new ArrayList<>();
		
		User obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE type = 'Mühendis'");
			while(rs.next()) {
				
				obj = new User(rs.getInt("id"),rs.getString("tcno"),rs.getString("name"),rs.getString("password"),rs.getString("type"));
				rs.getString("type");
				list.add(obj);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean addPersonel(String tcno,String password, String name) throws SQLException {
		
		String query = "INSERT INTO user" + "(tcno,password,name,type) VALUES" + "(?,?,?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tcno);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, "muhendis");
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
	
	public boolean deletePersonel(int id) throws SQLException {
		
		String query = "DELETE FROM user WHERE id = ?";
		boolean key = false;
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
	
	public boolean updatePersonel(int id, String tcno, String password, String name) throws SQLException {
		
		String query = "UPDATE user SET name = ?, tcno = ?, password = ? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, tcno);
			preparedStatement.setString(3, password);
			preparedStatement.setInt(4, id);
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
	
	

}
