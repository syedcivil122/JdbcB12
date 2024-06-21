package Jdbc;

import java.lang.constant.DynamicCallSiteDesc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

public class DynamicOperations {
	
	public void saveEmployee() throws SQLException {
		Connection con=JdbcUtil.getConnection();
		PreparedStatement ptst = con.prepareStatement("insert into employee(ename,age,salary,dept) values(?,?,?,?)");
		                  ptst.setString(1, "lokesh");   
		                  ptst.setInt(2, 22);
		                  ptst.setLong(3, 25000L);
		                  ptst.setString(4, "java");
		                  
		                  int rows=ptst.executeUpdate();
		                  System.out.println("insert rows.."+ rows);
		                  con.close();
	}
	
  public void saveEmployee2(String ename, int age, long salary,String dept ) throws SQLException {
	Connection con=JdbcUtil.getConnection();
	PreparedStatement ptst = con.prepareStatement("insert into employee(ename,age,salary,dept) values(?,?,?,?)");
	                  ptst.setString(1,ename);   
	                  ptst.setInt(2, age);
	                  ptst.setLong(3, salary);
	                  ptst.setString(4, dept);
	                  
	                  int rows=ptst.executeUpdate();
	                  System.out.println("insert rows.."+ rows);
	                  con.close();                  
	}
  
  public void saveEmployee3( ) throws SQLException {
		Connection con=JdbcUtil.getConnection();
		PreparedStatement ptst = con.prepareStatement("update employee set dept=? where eid=?");
					     
		                  ptst.setString(1, "sql");
		                  ptst.setInt(2, 6);
		                  
		                  int rows=ptst.executeUpdate();
		                  System.out.println("update rows.."+ rows);
		                  con.close();                  
		}
  
  public void saveEmployee4() throws SQLException {
		Connection con=JdbcUtil.getConnection();
		PreparedStatement ptst = con.prepareStatement("delete from employee where eid=?");
		                  ptst.setInt(1, 6);
		                  
		                  int rows=ptst.executeUpdate();
		                  System.out.println("delete rows.."+ rows);
		                  con.close();                  
		}
  
  public void getAllEmployees() throws SQLException {
	  Connection con=JdbcUtil.getConnection();
	  PreparedStatement ptst=con.prepareStatement("select * from employee");
	  ResultSet rs=ptst.executeQuery();
	  
	  while(rs.next()) {
		  int id=rs.getInt(1);
		String name= rs.getString(2);
		int age = rs.getInt(3);
		long salary = rs.getLong(4);
		String dept = rs.getString(5);
		
		System.out.println(id+ " "+name+" "+age+" "+salary+" "+dept);
	  }
  }
  
  public void getById(int id) throws SQLException {
	  Connection con=JdbcUtil.getConnection();
	  PreparedStatement ptst=con.prepareStatement("select * from employee where eid =?");
	                    ptst.setInt(1, id);
	  ResultSet rs=ptst.executeQuery();
	  
	  while(rs.next()) {
		  int eid=rs.getInt(1);
		String name= rs.getString(2);
		int age = rs.getInt(3);
		long salary = rs.getLong(4);
		String dept = rs.getString(5);
		
		System.out.println(eid+ " "+name+" "+age+" "+salary+" "+dept);
	  }
  }
  
  public void getByDept(String department) throws SQLException {
	  Connection con=JdbcUtil.getConnection();
	  PreparedStatement ptst=con.prepareStatement("select * from employee where dept =?");
	                    ptst.setString(1, department);
	  ResultSet rs=ptst.executeQuery();
	  
	  while(rs.next()) {
		  int eid=rs.getInt(1);
		String name= rs.getString(2);
		int age = rs.getInt(3);
		long salary = rs.getLong(4);
		String dept = rs.getString(5);
		
		System.out.println(eid+ " "+name+" "+age+" "+salary+" "+dept);
	  }
  }
  
  public void getAnd(String department, int eage) throws SQLException {
	  Connection con=JdbcUtil.getConnection();
	  PreparedStatement ptst=con.prepareStatement("select * from employee where dept=? and age=?");
	                    ptst.setString(1,department);
	                    ptst.setInt(2, eage);
	  ResultSet rs=ptst.executeQuery();
	  
	  while(rs.next()) {
		  int eid=rs.getInt(1);
		String name= rs.getString(2);
		int age = rs.getInt(3);
		long salary = rs.getLong(4);
		String dept = rs.getString(5);
		
		System.out.println(eid+ " "+name+" "+age+" "+salary+" "+dept);
	  }
  }
  
  public void getOr(String department) throws SQLException {
	  Connection con=JdbcUtil.getConnection();
	  PreparedStatement ptst=con.prepareStatement("select * from employee where dept=? or dept=?");
	                    ptst.setString(1,department);
	                    ptst.setString(2, department);
	                    
	  ResultSet rs=ptst.executeQuery();
	  
	  while(rs.next()) {
		  int eid=rs.getInt(1);
		String name= rs.getString(2);
		int age = rs.getInt(3);
		long salary = rs.getLong(4);
		String dept = rs.getString(5);
		
		System.out.println(eid+ " "+name+" "+age+" "+salary+" "+dept);
	  }
  }
  
  public void getBetween(int eage,int eage1) throws SQLException {
	  Connection con=JdbcUtil.getConnection();
	  PreparedStatement ptst=con.prepareStatement("select * from employee where age between ? and ?");
	                    ptst.setInt(1, eage);
	                    ptst.setInt(2, eage1);
	  ResultSet rs=ptst.executeQuery();
	  
	  while(rs.next()) {
		  int eid=rs.getInt(1);
		String name= rs.getString(2);
		int age = rs.getInt(3);
		long salary = rs.getLong(4);
		String dept = rs.getString(5);
		
		System.out.println(eid+ " "+name+" "+age+" "+salary+" "+dept);
	  }
  }
  
//  
  public void getOrderBy() throws SQLException {
	  Connection con=JdbcUtil.getConnection();
	  PreparedStatement ptst=con.prepareStatement("select * from employee order by salary asc;");
	                   
	                   
	  ResultSet rs=ptst.executeQuery();
	  
	  while(rs.next()) {
		  int eid=rs.getInt(1);
		String name= rs.getString(2);
		int age = rs.getInt(3);
		long salary = rs.getLong(4);
		String dept = rs.getString(5);
		
		System.out.println(eid+ " "+name+" "+age+" "+salary+" "+dept);
	  }
  }
  
  public void getOrderByde() throws SQLException {
	  Connection con=JdbcUtil.getConnection();
	  PreparedStatement ptst=con.prepareStatement("select * from employee order by salary desc;");
	                   
	                   
	  ResultSet rs=ptst.executeQuery();
	  
	  while(rs.next()) {
		  int eid=rs.getInt(1);
		String name= rs.getString(2);
		int age = rs.getInt(3);
		long salary = rs.getLong(4);
		String dept = rs.getString(5);
		
		System.out.println(eid+ " "+name+" "+age+" "+salary+" "+dept);
	  }
  }
  
  public void getGroupBy() throws SQLException {
	  Connection con=JdbcUtil.getConnection();
	  PreparedStatement ptst=con.prepareStatement("select dept,min(salary) from employee group by dept");
	                  
	                   
	  ResultSet rs=ptst.executeQuery();
	  
	  while(rs.next()) {
		  
		  String dept = rs.getString("dept");
		long Salary = rs.getLong("salary");
		
		
		System.out.println("Dept "+dept+"Slary "+Salary);
	  }
  }
  
  
  
  public void getMinMax( String dept1) throws SQLException {
	  Connection con=JdbcUtil.getConnection();
	  PreparedStatement ptst=con.prepareStatement("SELECT MAX(salary) AS max_salary, MIN(salary) AS min_salary FROM employee WHERE dept =?");
	                   
	                    ptst.setString(1, dept1);
	  ResultSet rs=ptst.executeQuery();
	  
	  while(rs.next()) {
		  
		 
		long maxSalary = rs.getLong("max_salary");
		long minSalary = rs.getLong("min_salary");
		
//		System.out.printf("Dept: %s, Max Salary: %d, Min Salary: %d\n", dept1, maxSalary, minSalary);
		System.out.println("Dept "+dept1+"Max Salary "+maxSalary+" Min Salary "+minSalary);
	  }
  }
  
  
  public void getmin() throws SQLException {
  		Connection con=JdbcUtil.getConnection();
  		PreparedStatement ptst=con.prepareStatement("select dept,max(salary) AS max_salary from employee group by dept");
  		                 
  		                 
  		   ResultSet rs= ptst.executeQuery();
  		              
  		   while(rs.next()) {                              //next()-abstract method
  		   				
  		   				
  		   			   String dept1 = rs.getString("dept");
  		  		       long salary=rs.getLong("max_salary");
  		   				
  		   				
  		  		   System.out.println("Max Salary: " + salary+" dept " +dept1);
  		   			
  		   			}
  		               
  	}

 
  public void getgroupby() throws SQLException {
  		Connection con=JdbcUtil.getConnection();
  		PreparedStatement ptst=con.prepareStatement("select dept,min(salary) As min_salary from employee group by dept");
  		              ; 
  		   ResultSet rs= ptst.executeQuery();
  		   System.out.println(rs);
  		              
  		   while(rs.next()) {                              //next()-abstract method
  		   				
  		   				
  		   				String Dept =rs.getString("dept");
  		   			    long Salary=rs.getLong("min_salary");
  		   				
  		   				System.out.println("Dept "+Dept +"Min Salary "+Salary);
  		   			
  		   			}
  		               
  	}
  
  public void likeOperation() throws SQLException {
	  Connection con=JdbcUtil.getConnection();
	  PreparedStatement ptst=con.prepareStatement("select * from employee where ename like ?");
	                   ptst.setString(1, "%s%");
	                   
	  ResultSet rs=ptst.executeQuery();
	  
	  while(rs.next()) {
		  int eid=rs.getInt(1);
		String name= rs.getString(2);
		int age = rs.getInt(3);
		long salary = rs.getLong(4);
		String dept = rs.getString(5);
		
		System.out.println("Eid: "+eid+"Ename: "+name+"Age: "+age+"Salary: "+salary+"Dept: "+dept);
	  }
  }
  
  public static void main(String[] args) throws SQLException {
	DynamicOperations d = new DynamicOperations();
//	                  d.saveEmployee();
//	                  d.saveEmployee2("lokesh", 23, 26000L, "java");
//	                  d.saveEmployee3();
//	                  d.saveEmployee4();
//	                  d.getAllEmployees();
//	                  d.getById(4);
//	                  d.getByDept("java");
//	                  d.getAnd("java", 25);
//	                  d.getOr("sql");
//	                  d.getBetween(21,26);
//	           d.getMinMax("java");
//	           d.getOrderBy();
//	           d.getOrderByde();
//	           d.getGroupBy();
//	d.getmin();
//	d.getgroupby();;
	d.likeOperation();
	                  
}

}
