package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Muhendis extends User{
	
	Statement st = null;
	ResultSet rs = null;
	Connection con = conn.connDb();
	PreparedStatement preparedStatement = null;
	
	public Muhendis() {
		
		super();
	}
	
	public Muhendis(int id, String tcno, String name, String password, String type) {
		super(id,tcno,name,password,type);
	}
	
	public boolean addWhour(int muhendis_id, String muhendis_name, String wdate) throws SQLException{
		int key = 0;
		int count = 0;
		String query = "INSERT INTO whour" + "(muhendis_id, muhendis_name,wdate) VALUES" + "(?,?,?)";
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM whour WHERE status ='Aktif' AND muhendis_id =  " + muhendis_id + " AND wdate ='" + wdate + "'");
			
			while(rs.next()) {
				count++;
				break;
			}
			if(count == 0) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1, muhendis_id);
				preparedStatement.setString(2, muhendis_name);
				preparedStatement.setString(3, wdate);
				preparedStatement.executeUpdate();
			}
			key = 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(key == 1) 
			return true;
		else
			return false;
	}
	
	public ArrayList<Whour> getWhourList(int muhendis_id) throws SQLException{
		
		ArrayList<Whour> list = new ArrayList<>();
		Whour obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM whour WHERE status='Aktif' AND muhendis_id = " + muhendis_id);
			while(rs.next()) {
				
				obj = new Whour();
				obj.setId(rs.getInt("id"));
				obj.setMuhendis_id(rs.getInt("muhendis_id"));
				obj.setMuhendis_name(rs.getString("muhendis_name"));
				obj.setStatus(rs.getString("status"));
				obj.setWdate(rs.getString("wdate"));
				list.add(obj);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	

}
