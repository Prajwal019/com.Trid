package Project_TestNG;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Trid.GenericUtility.BaseClass;
import com.Trid.GenericUtility.DatabaseUtilty;
import com.Trid.GenericUtility.ExcelUtility;
import com.Trid.GenericUtility.FileUtility;
import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;
import com.Trid.ObjectRepository.HomePage;
import com.Trid.ObjectRepository.LoginPage;
import com.Trid.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addProductTest extends BaseClass {
	@Test
	public void addProduct() throws Throwable {
		//Go to product page
		HomePage hp=new HomePage(driver);
		hp.clickProduct();
		// to click on add product page
		ProductPage pp=new ProductPage(driver);
		//Fetch the data from excel file
		String expected=eLib.readDataFromExcel("Prod", 0, 0);
		String supplier = eLib.readDataFromExcel("Prod", 1, 5);
		String category=eLib.readDataFromExcel("Prod", 0, 5);
		String date=eLib.readDataFromExcel("Prod", 2, 5);
		HashMap<String,String>map=eLib.getMultipleDataFromExcel("Prod", 1, 2);
		pp.addDetailsOnAddProductPopUp(map,driver, expected, category, supplier, date);
	}
}
