package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Helper.DBConnection;

public class Whour {
	private int id, muhendis_id;
	private String muhendis_name, wdate, status;
	
	DBConnection conn = new DBConnection();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	public Whour() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMuhendis_id() {
		return muhendis_id;
	}

	public void setMuhendis_id(int muhendis_id) {
		this.muhendis_id = muhendis_id;
	}

	public String getMuhendis_name() {
		return muhendis_name;
	}

	public void setMuhendis_name(String muhendis_name) {
		this.muhendis_name = muhendis_name;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Whour(int id, int muhendis_id, String muhendis_name, String wdate, String status) {
		
		this.id = id;
		this.muhendis_id = muhendis_id;
		this.muhendis_name = muhendis_name;
		this.wdate = wdate;
		this.status = status;
	}
	
	
	

}
