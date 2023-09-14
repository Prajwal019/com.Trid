package com.Practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Trid {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user")).sendKeys("test");
		driver.findElement(By.name("password")).sendKeys("test");
		driver.findElement(By.xpath("//button[.='Login']")).click();
		Alert a=driver.switchTo().alert();
		a.accept();
		List<WebElement> AllLinks = driver.findElements(By.xpath("//a"));
		int count = AllLinks.size();
		System.out.println(count);
		ArrayList<String>links=new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			String eachLink = AllLinks.get(i).getAttribute("href");
			URL url=null;
			int statusCode = 0;
			try {
				url=new URL(eachLink);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				statusCode = connection.getResponseCode();
				if (statusCode>=400) {
					links.add(eachLink+"============="+statusCode);
				}
			} catch (Exception e) {
				links.add(eachLink+"================"+statusCode);
			}
		}
		System.out.println(links);	
	}
}
