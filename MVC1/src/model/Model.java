package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import oracle.jdbc.driver.OracleDriver;

public class Model 
{
	/*Create Data Base Table Column*/
		String name;
		String usn;
		int marks1;
		int marks2;
		int marks3;
		
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet res = null;
		
		String url = "jdbc:oracle:thin:@//localhost:1521/XE";
		String user = "SYSTEM";
		String password = "SYSTEM";
	
		/*getters &  setters*/
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUsn() {
			return usn;
		}
		public void setUsn(String usn) {
			this.usn = usn;
		}
		public int getMarks1() {
			return marks1;
		}
		public void setMarks1(int marks1) {
			this.marks1 = marks1;
		}
		public int getMarks2() {
			return marks2;
		}
		public void setMarks2(int marks2) {
			this.marks2 = marks2;
		}
		public int getMarks3() {
			return marks3;
		}
		public void setMarks3(int marks3) {
			this.marks3 = marks3;
		}
		
		public  Model()
		{
			try
			{
				DriverManager.registerDriver(new OracleDriver());
				con = DriverManager.getConnection(url, user, password);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public void getResult()
		{
			try
			{
				String query = "SELECT * FROM STUDENT WHERE USN = ?";
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, usn); //this usn come from instanc variable usn
				
				res = pstmt.executeQuery();
				
				while(res.next()==true)
				{
					 name = res.getString(1);
					 usn = res.getString(2);
					 marks1 = res.getInt(3);
					 marks2 = res.getInt(4);
					 marks3 = res.getInt(5);
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}
