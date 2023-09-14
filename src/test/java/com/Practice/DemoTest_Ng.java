package com.Practice;

import org.testng.annotations.Test;

public class DemoTest_Ng {
	
	@Test
	public void  a() {
		System.out.println("1");
	}
	
	@Test
	public void  b() {
		System.out.println("2");
	}
	
	@Test(dependsOnMethods = "b")
	public void  c() {
		System.out.println("3");
	}
	
	@Test
	public void  d() {
		System.out.println("4");
	}
	
	
	@Test
	public void  z() {
		System.out.println("6");
	}
	
	@Test
	public void  e() {
		System.out.println("5");
	}
}
