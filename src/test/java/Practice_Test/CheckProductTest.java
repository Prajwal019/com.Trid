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
import com.Trid.ObjectRepository.InventoryPage;
import com.Trid.ObjectRepository.LoginPage;
import com.Trid.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckProductTest {
	public static void main(String[] args) throws Throwable {
		DatabaseUtilty dLib=new DatabaseUtilty();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib= new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();

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
		//login as admin
		LoginPage lp=new LoginPage(driver);
		lp.loginAsAdmin(driver);

		//Go to product page
		HomePage hp=new HomePage(driver);
		hp.clickProduct();
		// add deatils to the create product pop up and click on save
		ProductPage pp=new ProductPage(driver);
		HashMap<String, String>map=eLib.getMultipleDataFromExcel("Prod", 1, 2);
		String Category=eLib.readDataFromExcel("Prod", 0, 5);
		String Supplier=eLib.readDataFromExcel("Prod", 1, 5);
		String date=eLib.readDataFromExcel("Prod", 2, 5);
		//String exp="asdf";
		pp.addDetailsOnAddProductPopUps(map, driver,Category, Supplier, date);
		// click on inventory
		hp.clickInventory();
		// search the product in Inventory page
		InventoryPage ip=new InventoryPage(driver);
		ip.getSearchTextbx();
		String ProductNum=eLib.readDataFromExcel("Prod", 0, 2);
		//Validating the product 
		String Actual=driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
		if (Actual.equals(ProductNum)) {
			System.out.println("Product is present");
		}
		else
			System.out.println("Product is not present");
		//Log-out
		pp.logout(driver);
	}
}
