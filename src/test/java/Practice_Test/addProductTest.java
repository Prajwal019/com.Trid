package Practice_Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Trid.GenericUtility.DatabaseUtilty;
import com.Trid.GenericUtility.ExcelUtility;
import com.Trid.GenericUtility.FileUtility;
import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;
import com.Trid.ObjectRepository.HomePage;
import com.Trid.ObjectRepository.LoginPage;
import com.Trid.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addProductTest {
	public static void main(String[] args) throws Throwable {
		DatabaseUtilty dLib=new DatabaseUtilty();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib= new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		// fetch the data from propertyfile
		String BROWSER =fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url");
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
		wLib.maximize(driver);
		wLib.implicitWait(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginAsAdmin(driver);
		//Go to product page
		HomePage hp=new HomePage(driver);
		hp.clickProduct();
		// to click on add product page
		ProductPage pp=new ProductPage(driver);
		//Fetch the data from excel file
		String expected=eLib.readDataFromExcel("Prod", 0, 1);
		String supplier = eLib.readDataFromExcel("Prod", 1, 5);
		String category=eLib.readDataFromExcel("Prod", 0, 5);
		String date=eLib.readDataFromExcel("Prod", 2, 5);
		HashMap<String,String>map=eLib.getMultipleDataFromExcel("Prod", 1, 2);
		pp.addDetailsOnAddProductPopUp(map,driver, expected, category, supplier, date);
		//Log-out
		//hp.logOut();
	}
}
