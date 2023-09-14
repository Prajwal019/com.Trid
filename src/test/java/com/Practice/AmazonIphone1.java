package com.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonIphone1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> name = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
		for (int i = 0; i < name.size(); i++) {
			//to fetch value in the form of String
			String prices=price.get(i).getText();
			// to remove comma and spaces in the above string
			String myPrices=prices.replace(",","  ");
			Integer ActualPrice=Integer.valueOf(myPrices);
			if (ActualPrice <70000) {
				System.out.println(name.get(i).getText()+"=========>"+price.get(i).getText());
			}

		}
	}
}
