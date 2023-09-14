package com.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class P5 {
public static void main(String[] args) throws SQLException {
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection(null, null, null);
		Statement state = con.createStatement();
		String query="select * from gaminglaptops;";
		ResultSet res = state.executeQuery(query);
		while (res.next()) {
			
		}
	}
	catch (Exception e) {
	}
}
}
