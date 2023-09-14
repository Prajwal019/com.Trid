package Project_TestNG;

import org.testng.annotations.Test;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Trid.GenericUtility.BaseClass;
import com.Trid.GenericUtility.DatabaseUtilty;
import com.Trid.GenericUtility.ExcelUtility;
import com.Trid.GenericUtility.FileUtility;
import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;
import com.Trid.ObjectRepository.HomePage;
import com.Trid.ObjectRepository.LoginPage;
import com.Trid.ObjectRepository.SupplierPage;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.Trid.GenericUtility.ListenersImpClass.class)
public class ViewASupplierTest extends BaseClass{
	@Test(groups = "Smoke")
	public void ViewASupplier() throws Throwable {
		
		// To click on Supplier Link
		HomePage hp=new HomePage(driver);
		hp.clickSupplier();
		Assert.fail();
		// to confirm that Supplier list page is dislpayed or not
		String ActualResult="Supplier ";
	/*	String expResult=driver.findElement(By.xpath("//h4[contains(text(),'Supplier')]")).getText();
		Thread.sleep(2000);
		System.out.println(expResult);
		if (expResult.equalsIgnoreCase(ActualResult)) {
			System.out.println("Supplier page is displaying");
		}
		else {
			System.out.println("Supplier page isn't displaying");
		}*/
		SupplierPage sp=new SupplierPage(driver);
		sp.toValidateSupplierPage(driver, ActualResult);
	}
}

