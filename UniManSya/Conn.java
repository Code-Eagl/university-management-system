package UniManSya;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	Connection c;
	java.sql.Statement s;
	Conn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql:///university_mms", "root","Admin@123");
			s = c.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
