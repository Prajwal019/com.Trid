package com.Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartIPhone {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("iphone 14 plus"+Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.xpath("//div[contains(@class,'_4rR01T')]"));
		Thread.sleep(3000);
		List<WebElement> price = driver.findElements(By.xpath("//div[contains(@class,'_30jeq3 _1_WHN1')]"));
		Thread.sleep(3000);
		int count = links.size();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			System.out.println(	links.get(i).getText()+"========>"+price.get(i).getText());
		}
		//driver.close();
	}
}

