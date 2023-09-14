package com.Assignment;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.dev.ReSave;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPhones {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Phones");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String PhoneName="Motorola";
		List<WebElement> checkBox = driver.findElements(By.xpath("//span[text()='Samsung']/ancestor::div[@id='brandsRefinements']/descendant::i[@class='a-icon a-icon-checkbox']"));
		//driver.findElement(By.xpath("//li[@aria-label='Samsung']/descendant::i[@class='a-icon a-icon-checkbox']")).click();
			for (WebElement w : checkBox) {
				try {
					String result = w.getText();
					System.out.println(result);
					if (result.equalsIgnoreCase(PhoneName)) {
						w.click();
						break;
						}
				}
					catch (Exception e) {
					driver.findElement(By.xpath("//span[text()='Brand']/ancestor::div[@id='brandsRefinements']/descendant::span[@class='a-expander-prompt']")).click();
				}
			
					}
		
			//driver.findElement(By.xpath("//span[text()='Brand']/ancestor::div[@id='brandsRefinements']/descendant::span[@class='a-expander-prompt']")).click();*/
		/*try {
			driver.findElement(By.xpath("//li[@aria-label='"+PhoneName+"']/descendant::i[@class='a-icon a-icon-checkbox']")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[text()='Brand']/ancestor::div[@id='brandsRefinements']/descendant::span[@class='a-expander-prompt']")).click();
						
					}
		driver.findElement(By.xpath("//li[@aria-label='"+PhoneName+"']/descendant::i[@class='a-icon a-icon-checkbox']")).click();
		List<WebElement> Names_ = driver.findElements(By.xpath("//span[@class='a-price-whole']/ancestor::div[@class='a-section']/descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> prices_= driver.findElements(By.xpath("//span[@class='a-price-whole']/ancestor::div[@class='a-section']/descendant::span[@class='a-price-whole']"));
		Iterator<WebElement> it = Names_.iterator();
		Iterator<WebElement> it1 = prices_.iterator();
		while(it.hasNext()&& it1.hasNext()) {
			String names=it.next().getText();
			String prices=it1.next().getText();
			System.out.println(names+"-->"+prices);}
		//driver.close();*/
	
	}
}
//