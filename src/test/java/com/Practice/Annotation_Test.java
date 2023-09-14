package com.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotation_Test {
@BeforeSuite
public void config_BS() {
	System.out.println("--BeforeSuite--");
}

@BeforeMethod
public void config_BM() {
	System.out.println("--BeforeMethod--");
}


@Test
public void testScript3() {
	System.out.println("--TestScript3");
} 

@Test
public void testScript4() {
	System.out.println("--TestScript4");
} 

@BeforeClass
public void config_BC() {
	System.out.println("--BeforeClass--");
}

@AfterSuite
public void config_AS() {
	System.out.println("--AfterSuite--");
}

@AfterMethod
public void config_AM() {
	System.out.println("--AfterMethod--");
}

@AfterClass
public void config_AC() {
	System.out.println("--AfterClass--");
}

}
