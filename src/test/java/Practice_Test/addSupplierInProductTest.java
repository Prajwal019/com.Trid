package Practice_Test;

import java.util.HashMap;

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
import com.Trid.ObjectRepository.SupplierPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addSupplierInProductTest {
	public static void main(String[] args) throws Throwable {
		DatabaseUtilty dLib=new DatabaseUtilty();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib= new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER =fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url");
	
		WebDriver driver;

		if(BROWSER.equalsIgnoreCase("Chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();		
		}
		
		wLib.maximize(driver);
		wLib.implicitWait(driver);
		driver.get(URL);
		//Enter the login credentials
		LoginPage lp=new LoginPage(driver);
		lp.loginAsAdmin(driver);
		//click on Supplier link 
		HomePage hp=new HomePage(driver);
		hp.clickSupplier();
		//click on add Supplier icon,add details and click on save
		String expected=eLib.readDataFromExcel("Supplier", 0, 0);
		String province=eLib.readDataFromExcel("Supplier", 1, 2);
		String city=eLib.readDataFromExcel("Supplier", 2, 2);
		HashMap<String, String>map=eLib.getMultipleDataFromExcel("Supplier", 1, 2);
		SupplierPage sp=new SupplierPage(driver);
		sp.addDetailsOnAddSupplierPopUp(map, driver, expected, province, city);
		// click on product link
		hp.clickProduct();
		//click on add product icon
		String category=eLib.readDataFromExcel("Product1", 0, 5);
		ProductPage pp=new ProductPage(driver);
		pp.clickOnAddProductLookUpIcon();
		//Log-out
	//	driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
	//	WebElement logout = driver.findElement(By.xpath("//a[@data-target='#logoutModal']"));
		/*Actions ac=new Actions(driver);
		ac.moveToElement(logout).click().perform();*/
		/*wLib.mouseHover(driver, logout);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.linkText("Logout")).click();*/
	}
}
