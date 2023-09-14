package Account_Module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Trid.GenericUtility.DatabaseUtilty;
import com.Trid.GenericUtility.ExcelUtility;
import com.Trid.GenericUtility.FileUtility;
import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;
import com.Trid.ObjectRepository.AccountPage;
import com.Trid.ObjectRepository.HomePage;
import com.Trid.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddAccountTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		DatabaseUtilty dLib=new DatabaseUtilty();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib= new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		// fetch the data from propertyfile
		String BROWSER =fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url");
		String USERNAME =fLib.readDataFromPropertyFile("username");
		String PASSWORD =fLib.readDataFromPropertyFile("password");
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
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		wLib.acceptAlert(driver);
		// click on Account link
		HomePage hp=new HomePage(driver);
		hp.clickAccounts();
		// to click on Add account Lookup icon
		AccountPage ap=new AccountPage(driver);
		ap.clickAddAccountLookUpIcon();
		//verifying Add user Pop up is displaying
		String expected="Add User Account";
		String Actual = driver.findElement(By.xpath("//h5[text()='Add User Account']")).getAttribute("innerHTML");
		System.out.println(Actual);
		if (Actual.equalsIgnoreCase(expected)) {
			System.out.println(expected+" Pop up is displayed");
		}
	}
}