package com.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest3 {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/laptops\", \"root\", \"root");
			Statement state = con.createStatement();
			String query="select * from gaminglaptops;";
			ResultSet res = state.executeQuery(query);
			while (res.next()) {
				System.out.println(res.getString(1)+"========= "+res.getString(2)+"========= "+res.getString(3)+" ========="+res.getString(4));
			}	
		}
		catch (Exception e) {
			
		}
		finally {
			con.close();
		}
	}
}
