package Project_TestNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Trid.GenericUtility.BaseClass;
import com.Trid.GenericUtility.DatabaseUtilty;
import com.Trid.GenericUtility.ExcelUtility;
import com.Trid.GenericUtility.FileUtility;
import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;
import com.Trid.ObjectRepository.AccountPage;
import com.Trid.ObjectRepository.HomePage;
import com.Trid.ObjectRepository.LoginPage;

public class AddAccountTest extends BaseClass{
	@Test
	public  void addUserAccountTest(){
		
		// click on Account link
		HomePage hp=new HomePage(driver);
		hp.clickAccounts();
		// to click on Add account Lookup icon
		AccountPage ap=new AccountPage(driver);
		ap.clickAddAccountLookUpIcon();
		Assert.fail();
		//verifying Add user Pop up is displaying
		//Thread.sleep(2000);
		String expected="Add User Account";
		String actual = driver.findElement(By.xpath("//h5[text()='Add User Account']")).getAttribute("innerHTML");
		System.out.println(actual);
		ap.validateAddAccount(expected,actual,driver);
		driver.navigate().refresh();
	}
}
