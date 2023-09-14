package com.Practice;

import org.testng.annotations.Test;

import com.Trid.GenericUtility.BaseClass;

public class Account_Module extends BaseClass {
	@Test
	public void createAccount()  {
		System.out.println("--CreateAccount--");
	}

	@Test
	public void editAccount() {
		System.out.println("--EditAccount--");
	}


	@Test
	public void deleteAccount() {
		System.out.println("--DeleteAccount--");
	}
}
