package com.Practice;

import org.testng.annotations.Test;

public class demoTestNG {
	
	@Test(dependsOnMethods = "a", invocationCount = 2)
	public void b() {
		System.out.println("----SupplierCreated--------");
	}
	
	@Test
	public void c() {
		System.out.println("----SupplierEdited--------");
	}
	@Test
	public void a() {
		System.out.println("----SupplierDeleted --------");
	}
}
