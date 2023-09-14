package com.Trid.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtilty {
	Connection con=null;
	/**
	 * This method is used to get connection with database
	 * @author Prajwal
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.dURL,IpathConstants.dUsername,IpathConstants.dPassword);
	}
	/**
	 * This method is used to exeute query and fetch the data
	 * @param query
	 * @param columnNo
	 * @param ExpData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query,int columnNo,String ExpData) throws SQLException {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag= false;
		while (result.next()) {
			String data = result.getString(columnNo);
			if (data.equalsIgnoreCase(ExpData)) {
				flag=true;
				break;
			}
		}
		if (flag) {
			System.out.println("--Data is verified");
			return ExpData;
		}
		else {
			System.out.println("--Data is  not verified");
			return " ";
		}
	}
	public void closeDatabase() throws Throwable {
		con.close();
	}
}
