package Practice_Test;

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
import com.Trid.ObjectRepository.LoginPage;
import com.Trid.ObjectRepository.productCategoryPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddandRemoveProductTest {
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
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wLib.maximize(driver);
		wLib.implicitWait(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginAsUser(driver);
		// to click on headset product
		productCategoryPage pp=new productCategoryPage(driver);
		pp.clickOnHeadset();
		// to check selected product is displayed or not
		String expectedResult="EG1";
		String actResult=driver.findElement(By.xpath("//h6[text()='Fantech EG1']")).getAttribute("innerHTML");
		//System.out.println(actResult);
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
		String quantity=eLib.readDataFromExcel("Product1", 1, 8);
		String Product=eLib.readDataFromExcel("Product1", 4, 8);
		pp.toAddRequiredQuantity(driver, quantity, Product);
		// Verifying that selected product and added qty is displayed
		String numPath="//h4[text()='Point of Sale']/ancestor::div[@class='card shadow mb-4 col-md-12']/descendant::input[@name='quantity[]']";
		String exs = driver.findElement(By.xpath(numPath)).getAttribute("innerHTML");
		//System.out.println(exs);
		String text = driver.findElement(By.xpath("//tbody/tr/td[1]")).getText();
		String text1 = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
		System.out.println(text+" : "+text1);
		// to delete the added products
		pp.deleteProduct();
		//to log out 
		pp.logout(driver);
	}
}
