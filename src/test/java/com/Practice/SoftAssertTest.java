package com.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void softAssert() {
		System.out.println("--Step1--");
		System.out.println("--Step2--");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals("a", "b");
		System.out.println("--Step3--");
		System.out.println("--Step4--");
		sa.assertAll();
	}
}
