package com.exponent.cms.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDesignpattern {
private void ConnectionDesignPattern() {
		
	}
	private static Connection con=null;
	
	public static Connection generateConnection() throws ClassNotFoundException, SQLException {
		
		if(con==null) {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/batch57","root","root");
			
		}
		return con;
	}


}
