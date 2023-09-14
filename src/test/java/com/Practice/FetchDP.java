package com.Practice;

import org.testng.annotations.Test;

public class FetchDP {
	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "data")
	public void getData(String src,String dest,String price) {
		System.out.println("From====>"+src+"  To=====>"+dest+"  Price ====>"+price);
	}
	@Test(dataProviderClass =DataProviderTest.class,dataProvider = "data2" )
	public void getData(String src,String dest,int price) {
		System.out.println("From====>"+src+"  To=====>"+dest+"  Price ====>"+price);
	}
	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "data3")
	public void getData1(String brand,String name,String price) {
		System.out.println(brand);
		System.out.println(name);
		System.out.println(price);
	}
}