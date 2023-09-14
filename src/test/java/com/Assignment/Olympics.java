package com.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympics {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("onetrust-pc-btn-handler")).click();
		driver.findElement(By.xpath("//button[@class='ot-pc-refuse-all-handler']")).click();
		String country="Argentina";
		String xpath="//h2[contains(text(),'Olympic Games Tokyo 2020')]/ancestor::section[@class='medals__Wrapper-sc-15nhwt9-0 gnSTjB']/descendant::span[contains(text(),'"+country+"')]/ancestor::div[@class='Tablestyles__CommonGrid-sc-xjyvs9-1 Tablestyles__Content-sc-xjyvs9-3 knZfST eVgKXR']";
		String res = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(res);
	}
}