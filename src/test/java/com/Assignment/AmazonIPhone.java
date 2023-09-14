package com.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonIPhone {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone");
	driver.findElement(By.id("nav-search-submit-button")).click();
	List<WebElement> Names = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	//List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-offscreen']"));
	//List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
	//List<WebElement> price = driver.findElements(By.xpath("//span[contains(text(),'iPhone')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']']"));
	List<WebElement> price = driver.findElements(By.xpath("//span[contains(text(),'iPhone')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
	int count = Names.size();
	for (int i = 0; i < count; i++) {
		System.out.println(Names.get(i).getText()+"=======>"+price.get(i).getText());
	}
}
}
