package Supplier_Module;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Trid.GenericUtility.DatabaseUtilty;
import com.Trid.GenericUtility.ExcelUtility;
import com.Trid.GenericUtility.FileUtility;
import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addSupplierInProductTest  {
	public static void main(String[] args) throws Throwable {
		DatabaseUtilty dLib=new DatabaseUtilty();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib= new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		//Get the data from property file
		/*FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Commondata.propreties");
		Properties p= new Properties();
		p.load(fis);
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		String URL = p.getProperty("url");
		String BROWSER=p.getProperty("browser");*/
		String BROWSER =fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url");
		String USERNAME =fLib.readDataFromPropertyFile("username");
		String PASSWORD =	fLib.readDataFromPropertyFile("password");
		WebDriver driver;

		if(BROWSER.equalsIgnoreCase("Chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();		
		}
		
		wLib.maximize(driver);
		wLib.implicitWait(driver);
		driver.get(URL);
		//Enter the login credentials
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	/*	Alert a=driver.switchTo().alert();
		a.accept();*/
		wLib.acceptAlert(driver);
		driver.findElement(By.xpath("//span[text()='Supplier']")).click();
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();

	

		//Fetch the data from excel file for supplier
		/*FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		//Sheet sh=wb.getSheet("Supplier");
		Sheet sh=wb.getSheet("Supplier");
		String company=sh.getRow(1).getCell(0).getStringCellValue()+jLib.getRandomNo();
		String province=sh.getRow(1).getCell(1).getStringCellValue();
		String city=sh.getRow(1).getCell(2).getStringCellValue();
		String phone=sh.getRow(1).getCell(3).getStringCellValue();*/
		String company=eLib.readDataFromExcel("Supplier", 1, 0);
		String province=eLib.readDataFromExcel("Supplier", 1, 1);
		String city=eLib.readDataFromExcel("Supplier", 1, 2);
		String phone=eLib.readDataFromExcel("Supplier", 1, 3);
		
		//Enter the values in text fields
		driver.findElement(By.name("companyname")).sendKeys(company);
		//Enter values in drop down
		WebElement pro=driver.findElement(By.name("province"));
		Thread.sleep(2000);
		//Select s=new Select(pro);
	//	s.selectByVisibleText(province);
		wLib.select(province, pro);
		WebElement ci=driver.findElement(By.name("city"));
		/*Select ss=new Select(ci);
		ss.selectByVisibleText(city);*/
		wLib.select(city, ci);
		driver.findElement(By.name("phonenumber")).sendKeys(phone);
		//Save button
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
		//Product link
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();


		//Fetch the data from excel file
		
		
		/*FileInputStream fi1=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb1=WorkbookFactory.create(fi1);
		//	Sheet sh = wb.getSheet("Product");
		Sheet s1 = wb1.getSheet("Product");
		int count=s1.getLastRowNum();

		String procode=s1.getRow(0).getCell(1).getStringCellValue()+jLib.getRandomNo();
		String name=s1.getRow(1).getCell(1).getStringCellValue();
		String description=s1.getRow(2).getCell(1).getStringCellValue();
		String quantity=s1.getRow(3).getCell(1).getStringCellValue();
		String onhand=s1.getRow(4).getCell(1).getStringCellValue();
		String price=s1.getRow(5).getCell(1).getStringCellValue();*/
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
	/*	Select s2=new Select(category);
		s2.selectByVisibleText("Others");*/
		wLib.select("Others", category);
		WebElement supplier=driver.findElement(By.name("supplier"));
		/*Select s3=new Select(supplier);
		s3.selectByVisibleText(company);*/
		wLib.select(company, supplier);
		Thread.sleep(2000);
	/*	WebElement date=driver.findElement(By.xpath("//input[@name='datestock']"));
		date.click();
		date.sendKeys("29072023");
		// save
		driver.findElement(By.xpath("//input[@name='datestock']/../following-sibling::button[1]")).click();*/
		driver.navigate().refresh();
		//Log-out
		driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		WebElement logout = driver.findElement(By.xpath("//a[@data-target='#logoutModal']"));
		/*Actions ac=new Actions(driver);
		ac.moveToElement(logout).click().perform();*/
		wLib.mouseHover(driver, logout);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
}


