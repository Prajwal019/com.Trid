package com.Practice;

import org.testng.annotations.Test;

import com.Trid.GenericUtility.BaseClass;

public class Product_Module extends BaseClass{
	@Test
	public void createProduct() {
		System.out.println("--CreateProduct--");
	}

	@Test
	public void deleteProduct() {
		System.out.println("--DeleteProduct--");
	}
}
