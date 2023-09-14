package com.Practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		List<WebElement> allLinks = driver.findElements(By.id("//a"));
		int count = allLinks.size();
		System.out.println(count);
		ArrayList<String>links=new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			String eachLinks = allLinks.get(i).getAttribute("href");
			URL url=null;
			int statusCode = 0;
			try {
				url=new URL(eachLinks);
				HttpsURLConnection connection=(HttpsURLConnection) url.openConnection();
				statusCode=connection.getResponseCode();
				if (statusCode>=400) {
					links.add(eachLinks);
				}
			} catch (Exception e) {
				//links.add(eachLinks);
			}
		}
		
		System.out.println(links);
	}
}
