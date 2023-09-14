package com.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountryGreaterThan30 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		List<WebElement> Matches = driver.findElements(By.xpath("//table//tr[*]/td[3][@class='table-body__cell u-center-text' and text()>30]"));
		List<WebElement> Teams = driver.findElements(By.xpath("//table//tr[*]/td[3][@class='table-body__cell u-center-text' and text()>30]/preceding-sibling::td[@class='table-body__cell rankings-table__team']"));
		int count = Teams.size();
		for (int i = 0; i < count; i++) {
			System.out.println(Teams.get(i).getText()+"=====>"+Matches.get(i).getText());
		}
	}
}
