package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class Model
{
		String acc_no;
		String cust_id;
		String password;
		int balance;
		String email;
		String name;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		public String getAcc_no() {
			return acc_no;
		}
		public void setAcc_no(String acc_no) {
			this.acc_no = acc_no;
		}
		public String getCust_id() {
			return cust_id;
		}
		public void setCust_id(String cust_id) {
			this.cust_id = cust_id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getBlance() {
			return balance;
		}
		public void setBlance(int blance) {
			this.balance = blance;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
				
		public Model()
		{
			try
			{
				DriverManager.registerDriver(new OracleDriver());
				con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "SYSTEM", "SYSTEM");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public boolean login()
		{
			try
			{
				String s = "SELECT * FROM BANKAPP WHERE CUST_ID = ? AND PASSWORD=?";
				pstmt = con.prepareStatement(s);
				pstmt.setString(1, cust_id);
				pstmt.setString(2, password);
				
				res = pstmt.executeQuery();
				
				while(res.next())
				{
					acc_no = res.getString(1);
					return true;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return  false;
		}	
		
		public boolean checkBalance()
		{
			try
			{
				String s = "SELECT BALANCE FROM BANKAPP WHERE ACC_NO=?";
				pstmt = con.prepareStatement(s);
				pstmt.setString(1, acc_no);
				
				res = pstmt.executeQuery();
				
				while(res.next())
				{
					balance = res.getInt(1);
					return true;
				}			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return false;
		}
		
	public int changePassword()
	{
		int result=0;
		try
		{
			String s = "UPDATE BANKAPP SET PASSWORD=? WHERE ACC_NO = ?";
			pstmt =  con.prepareStatement(s);
			pstmt.setString(1, password);
			pstmt.setString(2, acc_no);
			
			result = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean transfer(String toacc_no)
	{
		try
		{
			String s = "UPDATE BANKAPP SET BALANCE = BALANCE - ?  WHERE ACC_NO = ?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, balance);
			pstmt.setString(2, acc_no);
			
			int result = pstmt.executeUpdate();
			
			
			
			if(result==1)
			{
				String s1 = "UPDATE BANKAPP SET BALANCE = BALANCE+? WHERE ACC_NO=?";
				pstmt = con.prepareStatement(s1);
				pstmt.setInt(1,balance);
				pstmt.setString(2,toacc_no);
				int result1  = pstmt.executeUpdate();
				
				if(result1==1)
				{
					
					String s2 = "INSERT INTO BANK_STATUS VALUES(?,?,?)";
					pstmt = con.prepareStatement(s2);
					pstmt.setString(1, toacc_no);
					pstmt.setString(2, acc_no);
					pstmt.setInt(3, balance);
					
					int result2 = pstmt.executeUpdate();
					if(result2==1)
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList getstmt()
	{
		ArrayList al = new ArrayList();
		try
		{
			String s = "SELECT * FROM BANK_STATUS WHERE FROMACC_NO = ?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, acc_no);
			res = pstmt.executeQuery();
			
			while(res.next())
			{
				String a = res.getString(1);
				String b = res.getString(2);
				int c = res.getInt(3);
				al.add(a);
				al.add(b);
				al.add(c);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}
