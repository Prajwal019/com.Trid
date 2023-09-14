package com.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NoSelectQueryTest {
	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/laptops", "root","root");
		Statement state = con.createStatement();
		String query = "insert into gaminglaptops values('Dell','Aspire',514,86547),('Dell','Q1',554,75646);";
		int result = state.executeUpdate(query);
		if (result>0) {
			System.out.println("Data updated Successfully");
		}
		else
			System.err.println("Data not inserted");
		con.close();
	}

}
