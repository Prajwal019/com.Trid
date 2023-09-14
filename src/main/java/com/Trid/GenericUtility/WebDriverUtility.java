 package com.Trid.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void implicitWait(WebDriver  driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public void waitUntilElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void select(WebElement element,int index) {
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	public void select(WebElement element,String value) {
		Select s= new Select(element);
		s.selectByValue(value);
	}
	public void select(String Text,WebElement element) {
		Select s= new Select(element);
		s.selectByVisibleText(Text);
	}
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).click().perform();
	}
	public void dragAndDrop(WebDriver driver, WebElement src,WebElement dest) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}
	public void doubleClick(WebDriver driver) {
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	public void rightClick(WebDriver driver) {
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	public void enterPressKey(WebDriver driver) {
		Actions a=new Actions(driver); 
		a.sendKeys(Keys.ENTER).perform();
	}
	public void enterKey(WebDriver driver) throws Throwable {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	public void enterRelease(WebDriver driver) throws Throwable {
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	public void switchToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void switchToWindow(WebDriver driver,String partialTitle) {
		// Step1: use get windowHandles to capture all the windows id
		Set<String> windows = driver.getWindowHandles();
		//Step 2: iterate through the windows
		Iterator<String>it=windows.iterator();
		//Step 3: check whether there is next window
		while(it.hasNext()) {
			//Step 4: capture current window id
			String winId=it.next();
			//Step 5: switch to current window and capture title
			String currentWinTitle=driver.switchTo().window(winId).getTitle();
			//Step 6: check whether current window is expected
			if (currentWinTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	public static String getScreenShot(WebDriver driver, String screenshotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshot\\"+screenshotName+".png";
		File dest=new  File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,800)");
	}
	
	public void scrollToElement(WebDriver driver,WebElement element) {
		JavascriptExecutor j=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		j.executeScript("window.scrollBy(0,"+y+")");
	}
	
	public void disabledElement(WebDriver driver,String data) {
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("document.getElementById('').value="+data+"");
	}
}
