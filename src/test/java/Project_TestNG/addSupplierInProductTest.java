package Project_TestNG;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.Trid.ObjectRepository.SupplierPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addSupplierInProductTest extends BaseClass {
	@Test
	public  void addSupplierInProduct() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.clickSupplier();
		SupplierPage sp=new SupplierPage(driver);
		sp.clickOnAddSupplierLookUpIcon();
		//Fetch the data from excel file for supplier
		String company=eLib.readDataFromExcel("Supplier", 0, 2)+jLib.getRandomNo();
		System.out.println(company);
		String province=eLib.readDataFromExcel("Supplier", 1, 2);
		String city=eLib.readDataFromExcel("Supplier", 2, 2);
		String phone=eLib.readDataFromExcel("Supplier", 3, 2);
		//Enter the values in text fields
		driver.findElement(By.xpath("//input[@name='companyname']")).sendKeys(company);
		//Enter values in drop down
		WebElement pro=driver.findElement(By.name("province"));
		Thread.sleep(2000);
		wLib.select(province, pro);
		WebElement ci=driver.findElement(By.name("city"));
		wLib.select(city, ci);
		driver.findElement(By.name("phonenumber")).sendKeys(phone);
		//Save button
		sp.clickOnSave();
		//Product link
		hp.clickProduct();
		//Fetch the data from excel file
		ProductPage pp=new ProductPage(driver);
		pp.clickOnAddProductLookUpIcon();
		String procode=eLib.readDataFromExcel("Product", 0,1 )+jLib.getRandomNo();
		String name=eLib.readDataFromExcel("Product", 1,1 );
		String description=eLib.readDataFromExcel("Product", 2,1 );
		String quantity=eLib.readDataFromExcel("Product", 3,1 );
		String onhand=eLib.readDataFromExcel("Product", 4,1 );
		String price=eLib.readDataFromExcel("Product", 5,1 );
		driver.findElement(By.name("prodcode")).sendKeys(procode);
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
		driver.findElement(By.name("quantity")).sendKeys(quantity);
		driver.findElement(By.name("onhand")).sendKeys(onhand);
		driver.findElement(By.name("price")).sendKeys(price);
		WebElement category = driver.findElement(By.name("category"));
		wLib.select("Others", category);
		WebElement supplier=driver.findElement(By.name("supplier"));
		wLib.select(company, supplier);
		
		/*
		List<WebElement> data = driver.findElements(By.xpath("//h5[text()='Add Product']/../following-sibling::div/descendant::select[@name='supplier']"));
		for (WebElement webElement : data) {
			String h = webElement.getText();
			Thread.sleep(6000);
			if (h.contains(company)) {
				System.out.println("Created Supplier is Present");
			}
			else {
				System.out.println("Created Supplier is not Present");
			}
		}*/
		pp.toValidateSupplierInProductPage(driver, company);
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
}
