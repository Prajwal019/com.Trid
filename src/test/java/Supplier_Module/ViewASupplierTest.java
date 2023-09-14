package Supplier_Module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.Trid.GenericUtility.DatabaseUtilty;
import com.Trid.GenericUtility.ExcelUtility;
import com.Trid.GenericUtility.FileUtility;
import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewASupplierTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		DatabaseUtilty dLib=new DatabaseUtilty();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib= new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		// fetch the data from propertyfile
	/*	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.propreties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");*/
		String BROWSER =fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url");
		String USERNAME =fLib.readDataFromPropertyFile("username");
		String PASSWORD =	fLib.readDataFromPropertyFile("password");
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		driver.get(URL);
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wLib.maximize(driver);
		wLib.implicitWait(driver);
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		/*Alert a=driver.switchTo().alert();
		a.accept();*/
		wLib.acceptAlert(driver);
		// To click on Supplier Link
		driver.findElement(By.xpath("//span[text()='Supplier']")).click();
		// to confirm that Supplier list page is dislpayed or not
		String ActualResult="Supplier ";
		String expResult=driver.findElement(By.xpath("//h4[contains(text(),'Supplier')]")).getText();
		Thread.sleep(2000);
		System.out.println(expResult);
		if (expResult.equalsIgnoreCase(ActualResult)) {
			System.out.println("Supplier page is displaying");
		}
		else {
			System.out.println("Supplier page isn't displaying");
		}
		driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		WebElement target = driver.findElement(By.xpath("//a[@data-target='#logoutModal']"));
		/*Actions act= new Actions(driver);
	act.moveToElement(target).click().perform();*/
		wLib.mouseHover(driver, target);
	driver.findElement(By.partialLinkText("Logout")).click();
	driver.findElement(By.partialLinkText("Logout")).click();
	}
}