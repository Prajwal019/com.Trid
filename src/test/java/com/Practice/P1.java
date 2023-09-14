package com.Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.protocol.HTTP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class P1 {
public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://ksrtc.in/oprs-web/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
	int count = allLinks.size();
	System.out.println(count);
	ArrayList<String>links=new ArrayList<String>();
	for (int i = 0; i <count; i++) {
		String eachLink = allLinks.get(i).getAttribute("href");
		URL url=null;
		int statusCode=0;
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			statusCode=con.getResponseCode();
			if (statusCode>400) {
				links.add(eachLink);
			}
		} catch (Exception e) {
			System.out.println((eachLink+"==========="+statusCode));
		}
		}
	System.out.println(links);
	}
}

			
		
	
