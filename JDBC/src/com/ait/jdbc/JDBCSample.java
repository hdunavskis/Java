package com.ait.jdbc;
import java.sql.*;

public class JDBCSample {

	public static void main(String[] args) throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "movies";
		String userName = "helmuts@localhost";
		String password = "root";
		
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url+dbName, userName, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select moviename, releasedate from article");
			
			while(rs.next()) {
				System.out.println("Name = " + rs.getString("moviename"));
			}		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(rs !=null) {
				try {
					rs.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(stmt !=null) {
				try {
					stmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(con !=null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
