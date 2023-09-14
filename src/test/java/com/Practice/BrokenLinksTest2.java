package com.Practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksTest2 {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get(null);
	List<WebElement> AllLinks = driver.findElements(By.xpath("//a"));
	int count=AllLinks.size();
	System.out.println(count);
	ArrayList<String>Links=new ArrayList<String>();
	for (int i = 0; i < count; i++) {
		String eachLinks = AllLinks.get(i).getAttribute("href");
		URL url=null;
		int statusCode=0;
		try {
			url=new URL(eachLinks);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			statusCode=con.getResponseCode();
			if (statusCode>=400) {
				Links.add(eachLinks+"============"+statusCode);
			}
		} 
		catch (Exception e) {
			System.out.println(eachLinks+"========"+statusCode);
		}
		System.out.println(Links);
	}
}
}
