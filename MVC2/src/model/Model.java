package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class Model 
{
	String name;
	String username;
	String password;
	String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	String un = "SYSTEM";
	String pw = "SYSTEM";
	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet res = null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Model()
	{
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			con = DriverManager.getConnection(url, un, pw);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public boolean register()
	{
		try
		{
			String s = "INSERT INTO ABC_REGISTER VALUES(?,?,?)";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, name);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			
			 int result = pstmt.executeUpdate();
			 
			 if(result==0)
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
	
	public boolean login()
	{
		boolean final_result =false;
		try
		{
			String s = "SELECT * FROM ABC_REGISTER WHERE USERNAME=? AND PASSWORD=? ";
			 pstmt = con.prepareStatement(s);
			 pstmt.setString(1, username);
			 pstmt.setString(2, password);
			 
			 res = pstmt.executeQuery();
			  final_result = res.next();
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return final_result;
	}
}
