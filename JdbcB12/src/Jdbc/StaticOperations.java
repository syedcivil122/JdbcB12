package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class StaticOperations {

	public void saveEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //load the driver class
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcb12","root","root");
			Statement stmt=con.createStatement();
			int insertedRow = stmt.executeUpdate("insert into employee(ename,age,salary,dept) values('ansar',21,25000,'java'),('syed',25,27000,'java'),('prudvi',24,23000,'java')");
			System.out.println("insertedRows "+ insertedRow);
			        con.close();
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
					}catch (SQLException e) {
						e.printStackTrace();	
					}
	}
	
	public void updated() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //load the driver class
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcb12","root","root");
			Statement stmt=con.createStatement();
			int insertedRow = stmt.executeUpdate("update employee set dept='sql' where eid=3");
					System.out.println("insertedRows "+ insertedRow);
			        con.close();
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
					}catch (SQLException e) {
						e.printStackTrace();	
					}
	}
	
	public void deleteEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //load the driver class
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcb12","root","root");
			Statement stmt=con.createStatement();
			int insertedRow = stmt.executeUpdate("delete from employee where eid=2;");
					System.out.println("insertedRows "+ insertedRow);
			        con.close();
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
					}catch (SQLException e) {
						e.printStackTrace();	
					}
	}
	
	public void getEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //load the driver class
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcb12","root","root");
			Statement stmt=con.createStatement();
			int insertedRow = stmt.executeUpdate("select ename,dept from employee");
					System.out.println("insertedRows "+ insertedRow);
			        con.close();
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
					}catch (SQLException e) {
						e.printStackTrace();	
					}
	}
	
	
	
	
	
	public static void main(String[] args) {
		StaticOperations so=new StaticOperations();
		so.saveEmployee();
//		so.updated();
//		so.deleteEmployee();
//		so.getEmployee();
	}
}
