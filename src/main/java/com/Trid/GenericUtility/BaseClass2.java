package com.Trid.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Trid.ObjectRepository.HomePage;
import com.Trid.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass2 {
	public DatabaseUtilty dLib=new DatabaseUtilty();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	
	public WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws Throwable {
		dLib.connectToDB();
		System.out.println("--Connect to DB--");
	}
	//@Parameters("BROWSER")
	//String BROWSER
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws Throwable {
		String BROWSER=fLib.readDataFromPropertyFile("browser");
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
		System.out.println("--Launch The Browser--");
		wLib.maximize(driver);
	}
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws Throwable {
		String URL=fLib.readDataFromPropertyFile("url");
		wLib.implicitWait(driver);
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginAsAdmin(driver);
		System.out.println("--Login to Application--");
	}
	@AfterMethod(alwaysRun = true)
	public void config_AM() throws Throwable {
		HomePage hp=new HomePage(driver);
		Thread.sleep(2000);
		hp.logout(driver);
		System.out.println("--LogOut from Application--");
	}
	@AfterClass(alwaysRun = true)
	public void config_AC() throws Throwable {
		Thread.sleep(2000);
		driver.quit();
		System.out.println("--Close the Browser--");
	}
	@AfterSuite(alwaysRun = true)
	public void config_AS() throws Throwable {
		dLib.closeDatabase();
		System.out.println("--Close the Database--");
	}
}
