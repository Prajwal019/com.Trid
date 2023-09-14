package com.Practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksTest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		List<WebElement> AllLinks = driver.findElements(By.xpath("//a"));
		System.out.println(AllLinks.size());
		ArrayList<String> links=new ArrayList<String>();
		for (int i = 0; i < AllLinks.size(); i++) {
			String eachLink = AllLinks.get(i).getAttribute("href");
			URL url=null;
			int statusCode=0;
			try {
				url=new URL(eachLink);
				HttpURLConnection Connection=(HttpURLConnection) url.openConnection();
				statusCode=Connection.getResponseCode();
				if (statusCode>=400) {
					links.add(eachLink+"=============="+statusCode);
				}
			}
			catch (Exception e) {
				//links.add(eachLink+"================"+statusCode);
				System.out.println(eachLink+"=============="+statusCode);
			}
		}
		System.out.println(links);
	}
}