package Practice_Test;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Trid.GenericUtility.DatabaseUtilty;
import com.Trid.GenericUtility.ExcelUtility;
import com.Trid.GenericUtility.FileUtility;
import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;
import com.Trid.ObjectRepository.HomePage;
import com.Trid.ObjectRepository.LoginPage;
import com.Trid.ObjectRepository.productCategoryPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddACustomerTest {
	public static void main(String[] args) throws Throwable {
		DatabaseUtilty dLib=new DatabaseUtilty();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib= new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url");
		WebDriver driver=null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("internetexplorer")) {
			WebDriverManager.edgedriver().setup();	
			driver=new EdgeDriver();
		}
		driver.get(URL);
		wLib.maximize(driver);
		wLib.implicitWait(driver);
		//Login as user
		LoginPage lp=new LoginPage(driver);
		lp.loginAsUser(driver);
		// to click on "others"
		productCategoryPage pc=new productCategoryPage(driver);
		pc.clickOnOthers();
		// add required quantity
		String ProdName=eLib.readDataFromExcel("AddCustomer1", 0, 5);
		String expected=eLib.readDataFromExcel("AddCustomer1", 2, 0);
		String quantity=eLib.readDataFromExcel("AddCustomer1", 1, 5);
		pc.toAddRequiredQuantity(driver, quantity, ProdName);
		//to verify product  and added quantity
		// to click on add customer button
		HashMap<String,String>map=	eLib.getMultipleDataFromExcel("AddCustomer1", 1, 2);
		pc.addDetailsCreateCustomerPopUp(map,driver, expected);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		//		//logout
		pc.logout(driver);
		//		//login as admin
		lp.loginAsAdmin(driver);
		//click on customer link
				HomePage hp=new HomePage(driver);
				hp.clickCustomer();
		/*		//search  for created customer
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(pn);
		String name = driver.findElement(By.xpath("//th[text()='First Name']/ancestor::table[@id='dataTable']/descendant::td[text()='"+fn+"']")).getText();
		System.out.println(name);
		if (name.contains(fn)) {
			System.out.println("Created Customer is displayed");
		}
		else
			System.out.println("Created Customer is not  displayed");*/
	}
}

