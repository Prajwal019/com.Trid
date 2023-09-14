package com.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FiveCountrynameWithStats {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String Xpath="(//table/tbody/tr[*]/td[2]//span[2])[position()<=10]";
		List<WebElement> names = driver.findElements(By.xpath(Xpath));
		for (WebElement w : names) {
			System.out.println(w.getText());
		}
	}
}
