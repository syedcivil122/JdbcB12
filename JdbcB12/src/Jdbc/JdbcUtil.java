package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //load the driver class
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcb12","root","root");
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
