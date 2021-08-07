package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	Connection c = null;
	
	public DBConnection() {}
	
	public Connection connDb() {
		
		try {
			this.c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/teias_personel?user=root&password=362961");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return c;
	}
	

}
