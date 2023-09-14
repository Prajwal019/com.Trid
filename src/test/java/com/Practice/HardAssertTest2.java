package com.Practice;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import  static org.testng.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertTest2 {
	@Test
	public void hardAssert() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.nick.tv/");
		String exp="Nickelodeon";
		String Actual = driver.getTitle();
		//assertEquals(exp, Actual);
		assertEquals(exp, Actual, "Let's go yeah....!");
	}
	
	@Test
	public void hardAsser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cartoonnetworkindia.com/");
		String exp="Nickelodeon";
		String Actual = driver.getTitle();
		//assertEquals(exp, Actual);
		assertEquals(exp, Actual, "Let's go yeah....!");
	}
}
