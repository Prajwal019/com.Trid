package com.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("src")).sendKeys("Bengaluru");
		driver.findElement(By.id("dest")).sendKeys("Somwarpet");
		driver.findElement(By.id("onwardCal")).click();
		String month="Oct";
		int date=25;
		//driver.findElement(By.xpath("//div[text()='Jul']/ancestor::div[@class='sc-jzJRlG dPBSOp']/descendant::span[text()='29']")).click();
		String ActualDate="//div[text()='"+ month+"']/ancestor::div[@class='sc-jzJRlG dPBSOp']/descendant::span[text()='"+date+"']";
		//driver.findElement(By.id("search_button"));
		//driver.close();
		String next="(//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']/descendant::div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[3]";
		for ( ; ; ) {
			try {
				driver.findElement(By.xpath(ActualDate)).click();
			} 
			catch (Exception e) {
				driver.findElement(By.xpath(next)).click();
			}
		}
	}
}
