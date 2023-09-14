package com.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DataProviderTest {
	@Test(dataProvider = "data")
	public void getData(String src,String dest,String price) {
		System.out.println("From====>"+src+"  To=====>"+dest+"  Price ====>"+price);
	}
	@Test(dataProvider = "data3")
	public void getDat(String v1,String v2,String v3,String v4) {
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
	}
	
	
	@DataProvider
	public Object[][] data(){
		Object[][] obj=new Object[2][3];
		
		obj[0][0]="Bengaluru";
		obj[0][1]="Mysore";
		obj[0][2]="400";
		
		obj[1][0]="Mangaluru";
		obj[1][1]="Madikeri";
		obj[1][2]="350";
		
		return obj;
	}
	
	@DataProvider
	public Object[][] data2(){
		Object[][] obj=new Object[2][3];
		
		obj[0][0]="Somwarpet";
		obj[0][1]="Madikeri";
		obj[0][2]=60;
		
		obj[1][0]="Kushalnagar";
		obj[1][1]="Virajpet";
		obj[1][2]=75;
		return obj;
	}
	
	
	@DataProvider
	public Object[][]data3(){
		Object[][]obj=new Object[2][4];
		obj[0][0]="Lamborghini";
		obj[0][1]="Mustang";
		obj[0][2]="Corvette";
		obj[0][3]="TATA";
		
		obj[1][0]="Ducati";
		obj[1][1]="Hyosung";
		obj[1][2]="Benelli";
		obj[1][3]="Aprilla";
		return obj;
	}
}
