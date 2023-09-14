package Product_Module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Trid.GenericUtility.DatabaseUtilty;
import com.Trid.GenericUtility.ExcelUtility;
import com.Trid.GenericUtility.FileUtility;
import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddandRemoveProductTest {	
	public static void main(String[] args) throws IOException, InterruptedException {
		DatabaseUtilty dLib=new DatabaseUtilty();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib= new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		// fetch the data from propertyfile
		/*FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.propreties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username1");
		String PASSWORD = p.getProperty("password1");*/
		String BROWSER =fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username1");
		String PASSWORD =fLib.readDataFromPropertyFile("password1");
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
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wLib.maximize(driver);
		wLib.implicitWait(driver);
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		//to handle pop up
		/*Alert a=driver.switchTo().alert();
		a.accept();*/
		wLib.acceptAlert(driver);
		// to click on headset product
		driver.findElement(By.partialLinkText("Headset")).click();
		// to check selected product is displayed or not
		String expectedResult="EG1";
		String actResult=driver.findElement(By.xpath("//h6[text()='Fantech EG1']")).getAttribute("innerHTML");
		System.out.println(actResult);
		if (actResult.contains(expectedResult)) {
			System.out.println(actResult+" is displayed");
		}
		else {
			System.out.println(actResult+" is not displayed");
		}

		// add necessary quantity and clicking on add
		String Xpath="//h6[text()='Fantech EG1']/ancestor::div[@class='products']/descendant::input[@name='quantity']";
		driver.findElement(By.xpath(Xpath)).sendKeys(Keys.CONTROL+"a"+"delete");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Xpath)).sendKeys("29");
		driver.findElement(By.xpath("//h6[text()='Fantech EG1']/ancestor::div[@class='products']/descendant::input[@type='submit']")).click();
		// Verifying that selected product and added qty is displayed
		String numPath="//h4[text()='Point of Sale']/ancestor::div[@class='card shadow mb-4 col-md-12']/descendant::input[@name='quantity[]']";
		String exs = driver.findElement(By.xpath(numPath)).getAttribute("innerHTML");
		System.out.println(exs);
		String text = driver.findElement(By.xpath("//tbody/tr/td[1]")).getText();
		String text1 = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
		System.out.println(text+" : "+text1);
		// to delete the added products
		driver.findElement(By.xpath("//div[@class='btn bg-gradient-danger btn-danger']")).click();
	}
}

