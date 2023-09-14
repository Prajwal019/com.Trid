package com.Practice;

import org.testng.annotations.Test;

import com.Trid.GenericUtility.BaseClass;

public class Supplier_Module extends BaseClass{
	@Test 
	public void createSupplier() {
		System.out.println("--CreateSupplier--");
	}

	@Test
	public void deleteSupplier() {
		System.out.println("--DeleteSupplier--");
	}
}
