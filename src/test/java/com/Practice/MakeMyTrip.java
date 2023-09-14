package com.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String MonthandYear="July 2024";
		int date=26;
		Actions a=new Actions(driver);
		// instead of  action class to handle the pop up or we can use below 
		//driver.navigate().refresh();
		a.moveByOffset(40, 40).click().perform();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String xpath="//div[text()='"+MonthandYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		String arrow="//span[@aria-label='Next Month']";
		for (;   ; ) {
			try {
				driver.findElement(By.xpath(xpath)).click();
				break;
			} 
			catch (Exception e) {
				driver.findElement(By.xpath(arrow)).click();
			}
		}
	}
}