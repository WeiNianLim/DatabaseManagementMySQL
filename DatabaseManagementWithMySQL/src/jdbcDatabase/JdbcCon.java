package jdbcDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCon {
	
	Statement stmt;
	/*public static void main(String args[]){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/studentmanagementsystem","root","Q1kang93");  
			
			Statement stmt=con.createStatement();  
			
			stmt.execute("INSERT INTO student VALUE("
					+ "'Alexis', 'Kang', 'q1kang93@hotmail.com',"
					+ "'4720 Blenheim St', 'vancouver', 'BC', '646341',"
					+ "'778-985-9021', '1992-11-26', 'F', NOW(), '3.50', NULL)");
			
			ResultSet rs=stmt.executeQuery("select * from student");  
			while(rs.next())  
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}  */
	
	public JdbcCon() {
		try{ 
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/client","root","Q1kang93");  		
			stmt=con.createStatement();  			
		}catch(Exception e){ System.out.println(e);}
	}
	
	public String insertIntoTable(String first_name, String last_name, String street, String city, 
			String state, String zip, String phone, String email, String birth_date, String sex) {
		try {
			stmt.execute("INSERT INTO clientinfo VALUE( NULL, '"
					+ first_name + "','" + last_name + "','" + street + "','"
					+ city + "','" + state + "','" + zip + "','" + phone + "','"
					+ email + "','" + birth_date + "','" + sex + "');");
			return "Successfully input client info";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return e.toString();
		}
	}
}
