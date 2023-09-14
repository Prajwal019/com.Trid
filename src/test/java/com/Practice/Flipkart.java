package com.Practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.protocol.HTTP;
import org.apache.poi.ss.formula.functions.Count;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManagerException;

public class Flipkart {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeOptions op=new ChromeOptions();
	op.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(op);
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
	int Count = allLinks.size();
	System.out.println(Count);
	ArrayList<String>links=new ArrayList<String>();
	int statusCode = 0;
	String eachLink=null;
	for (int i = 0; i < Count; i++) {
		 eachLink = allLinks.get(i).getAttribute("href");
		URL url=null;
		
		try {
			url=new URL(eachLink);
			HttpsURLConnection connection=(HttpsURLConnection) url.openConnection();
			statusCode=connection.getResponseCode();
			if (statusCode<400) {
				links.add(eachLink+"==============="+statusCode);
			}
		} catch (Exception e) {
			//links.add(eachLink+"==============="+statusCode);	
		}
	}
	System.out.println(eachLink+"==============="+statusCode);
	System.out.println(links);
	}
}
