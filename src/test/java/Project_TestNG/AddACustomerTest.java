package Project_TestNG;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Trid.GenericUtility.BaseClass;
import com.Trid.GenericUtility.BaseClass2;
import com.Trid.GenericUtility.WebDriverUtility;
import com.Trid.ObjectRepository.CustomerPage;
import com.Trid.ObjectRepository.HomePage;
import com.Trid.ObjectRepository.LoginPage;
import com.Trid.ObjectRepository.productCategoryPage;

public class AddACustomerTest extends BaseClass {
	@Test
	public  void  AddACustomer() throws Throwable{
		//logout as admin
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.implicitWait(driver);
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginAsUser(driver);
		// to click on "others"
		productCategoryPage pc=new productCategoryPage(driver);
		pc.clickOnOthers();
		// add required quantity
		String ProdName=eLib.readDataFromExcel("AddCustomer1", 0, 5);
		String expected=eLib.readDataFromExcel("AddCustomer1", 2, 0);
		String quantity=eLib.readDataFromExcel("AddCustomer1", 1, 5);
		String name=eLib.readDataFromExcel("AddCustomer1", 0, 2);
		pc.toAddRequiredQuantity(driver, quantity, ProdName);
		//to verify product  and added quantity
		// to click on add customer button
		HashMap<String,String>map=	eLib.getMultipleDataFromExcel("AddCustomer1", 1, 2);
		pc.addDetailsCreateCustomerPopUp(map,driver, expected);
		Thread.sleep(2000);
		//WebDriverUtility wLib=new WebDriverUtility();
		wLib.acceptAlert(driver);
		//logout
		hp.logout(driver);
		//login as admin
		lp.loginAsAdmin(driver);
		//click on customer link
			hp.clickCustomer();
			CustomerPage cp=new CustomerPage(driver);
			cp.validateCreatedCustomer(name, driver);
			/*	CustomerPage cp=new CustomerPage(driver);
				cp.getSearchTbx().sendKeys(name);
				String actualname=driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
				if (name.contains(actualname)) {
					System.out.println("Created Customer is displayed");
				}
				else
					System.out.println("Created Customer is not  displayed");
			}*/
		}
}
		

