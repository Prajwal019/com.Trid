package com.Practice;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderpopupGoIbibo {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		String MonthandYear="October 2023";
		int date=23;
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		//driver.findElement(By.xpath("//div[text()='July 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()=22]")).click();
		String ActualDate="//div[text()='"+MonthandYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		String arrow="//span[@aria-label='Next Month']";
		//driver.findElement(By.xpath(ActualDate));	
		for (; ;) {
			try {
				driver.findElement(By.xpath(ActualDate)).click();	
				break;
			} 
			catch (Exception e) {
				driver.findElement(By.xpath(arrow)).click();
			}
		}
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		//driver.findElement(By.xpath("//a[text()='Done']"));
		//driver.close();
	}
}