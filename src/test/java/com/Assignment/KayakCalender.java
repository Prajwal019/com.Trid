package com.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KayakCalender {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.kayak.co.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Flights")).click();
		driver.findElement(By.xpath("//h2[@class='title dark']/ancestor::div[@class='primary-content']/descendant::input[@aria-controls='flight-origin-smarty-input-list']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//h2[@class='title dark']/ancestor::div[@class='primary-content']/descendant::input[@aria-controls='flight-destination-smarty-input-list']")).sendKeys("Mangaluru");
		
	}
}
