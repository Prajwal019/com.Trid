package com.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class NoSelectQueryTest2 {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/laptops", "root", "root");
			Statement state = con.createStatement();
			String query="insert into gaminglaptops values('Dell','Aspire6',514,88547),('Dell','Q9',554,75646);";
			int res = state.executeUpdate(query);
			if (res>0) {
				System.out.println("Success");
			}
			else
				System.err.println("Failed");

		} catch (Exception e) {

		}

		con.close();
	}
}
//"insert into gaminglaptops values('Dell','Aspire',514,86547),('Dell','Q1',554,75646);";