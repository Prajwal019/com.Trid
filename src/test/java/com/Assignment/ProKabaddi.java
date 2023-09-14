package com.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProKabaddi {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String Team="Bulls";
		//List<WebElement> Stats = driver.findElements(By.xpath("//p[text()='Team']/ancestor::div[@class='table standings-table']/div[2]/descendant::div[@class='row-head']"));
		String text = driver.findElement(By.xpath("//p[text()='Team']/ancestor::div[@class='table-responsive']/descendant::p[contains(text(),'"+Team+"')]/ancestor::div[@class='table-row qualifier']")).getText();
		System.out.println(text);
	}
}