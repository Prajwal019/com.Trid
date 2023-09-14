package Practice_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Trid.GenericUtility.DatabaseUtilty;
import com.Trid.GenericUtility.ExcelUtility;
import com.Trid.GenericUtility.FileUtility;
import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;
import com.Trid.ObjectRepository.HomePage;
import com.Trid.ObjectRepository.LoginPage;
import com.Trid.ObjectRepository.SupplierPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewASupplierTest {
	public static void main(String[] args) throws IOException, InterruptedException {
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
		LoginPage lp=new LoginPage(driver);
		lp.loginAsAdmin(driver);
		// To click on Supplier Link
		HomePage hp=new HomePage(driver);
		hp.clickSupplier();
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
		//Logout
		SupplierPage sp=new SupplierPage(driver);
		sp.logout(driver);
	}
}
