package com.Practice;

import org.testng.annotations.Test;

import com.Trid.GenericUtility.BaseClass;

public class Customer_Module extends BaseClass{
@Test
public void createCustomer() {
	System.out.println("--CreateCustomer--");
}

@Test
public void editCustomer() {
	System.out.println("--EditCustomer--");
}


@Test
public void deleteCustomer() {
	System.out.println("--DeleteCustomer--");
}
}
