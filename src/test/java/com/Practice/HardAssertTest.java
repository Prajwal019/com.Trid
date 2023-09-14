package com.Practice;

import static org.testng.Assert.assertNotNull;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class HardAssertTest {
	@Test
	public void hardAssert() {
		System.out.println("--Step1--");
		System.out.println("--Step2--");
		//Assert.assertEquals("A", "B");
		int a=20;
		assertNotNull(a);
		System.out.println("--Step3--");
		System.out.println("--Step4--");
	}
}