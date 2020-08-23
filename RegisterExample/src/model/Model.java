package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.driver.OracleDriver;

public class Model 
{
		String name;
		String gender;
		String checkbox;
		String textarea;
		String dropdown;
		
		String url = "jdbc:oracle:thin:@//localhost:1521/XE";
		String user = "SYSTEM";
		String password = "SYSTEM";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		
		public String getName(){
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getCheckbox() {
			return checkbox;
		}
		public void setCheckbox(String checkbox) {
			this.checkbox = checkbox;
		}
		public String getTextarea() {
			return textarea;
		}
		public void setTextarea(String textarea) {
			this.textarea = textarea;
		}
		public String getDropdown() {
			return dropdown;
		}
		public void setDropdown(String dropdown) {
			this.dropdown = dropdown;
		}
		
		public Model()
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
		
	
		public boolean resultQuery()
		{
			try
			{
				String query = "INSERT INTO REGISTEREXAMPLE VALUES(?,?,?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, name);
				pstmt.setString(2, gender);
				pstmt.setString(3, checkbox);
				pstmt.setString(4, textarea);
				pstmt.setString(5, dropdown);
				
				int res = pstmt.executeUpdate();
				if(res==0)
				{
					return false;
				}
				else
				{
					return true;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return false;
		}
		
}
