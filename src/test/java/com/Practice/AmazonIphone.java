package com.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonIphone {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		/*
		String name="//span[contains(text(),'iPhone')]";
		//String price="//span[text()='Apple iPhone 14 (128 GB) - Midnight']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']";
		String pri="//span[contains(text(),'iPhone')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']";
		*/
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole'][number(translate(text(),'₹,',' '))<70000]"));
		for (int i = 0; i < prices.size(); i++) {
			System.out.println(prices.get(i).getText());
		}
	}
}