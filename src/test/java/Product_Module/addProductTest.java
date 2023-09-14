package Product_Module;

import java.io.FileInputStream;
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

public class addProductTest {
	public static void main(String[] args) throws Throwable {
		DatabaseUtilty dLib=new DatabaseUtilty();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib= new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		// fetch the data from propertyfile
		/*	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.propreties");
				Properties p=new Properties();
				p.load(fis);
				String URL=p.getProperty("url");
				String BROWSER = p.getProperty("browser");
				String USERNAME = p.getProperty("username");
				String PASSWORD = p.getProperty("password");*/
		String BROWSER =fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url");
		String USERNAME =fLib.readDataFromPropertyFile("username");
		String PASSWORD =	fLib.readDataFromPropertyFile("password");
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
		// to get random number
		Random random=new Random();
		int ran=random.nextInt(666);

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		Alert a=driver.switchTo().alert();
		a.accept();
		//Go to product page
		driver.findElement(By.xpath("//span[contains(text(),'Product')]")).click();
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();

		//Fetch the data from excel file
		/*
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		//	Sheet sh = wb.getSheet("Product");
		Sheet s = wb.getSheet("Product");
		int count=s.getLastRowNum();

		String procode=s.getRow(0).getCell(1).getStringCellValue()+ran;
		String name=s.getRow(1).getCell(1).getStringCellValue();
		String description=s.getRow(2).getCell(1).getStringCellValue();
		String quantity=s.getRow(3).getCell(1).getStringCellValue();
		String onhand=s.getRow(4).getCell(1).getStringCellValue();
		String price=s.getRow(5).getCell(1).getStringCellValue();*/
		String procode	=eLib.readDataFromExcel("Product", 0, 1);
		String name	=eLib.readDataFromExcel("Product", 1, 1);
		String description	=eLib.readDataFromExcel("Product", 2, 1);
		String quantity	=eLib.readDataFromExcel("Product", 3, 1);
		String onhand	=eLib.readDataFromExcel("Product", 4, 1);
		String price	=eLib.readDataFromExcel("Product", 5, 1);
		
		
		
		
		eLib.getMultipleDataFromExcel("Product1", 0, 2);

		driver.findElement(By.name("prodcode")).sendKeys(procode);
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
		driver.findElement(By.name("quantity")).sendKeys(quantity);
		driver.findElement(By.name("onhand")).sendKeys(onhand);
		driver.findElement(By.name("price")).sendKeys(price);

		//storing in hash map(excel)
		/*HashMap<String,String> map=new HashMap<String,String>();
				for(int i=0;i<=count;i++) {
					String key=s.getRow(i).getCell(0).getStringCellValue();
					String value=s.getRow(i).getCell(1).getStringCellValue();
					map.put(key, value);
				}
				// Enter the values in text fields
						for (Entry<String, String> set: map.entrySet()) {	
							driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
							System.out.println(set);
						}*/
		//Select from drop down
		WebElement category=driver.findElement(By.xpath("//div[@class='form-group']/ancestor::div[@class='modal-body']/descendant::select[@name='category']"));
		/*Select s1=new Select(category);
		s1.selectByVisibleText("Others");*/
		wLib.select("Others",category);

		WebElement supplier=driver.findElement(By.name("supplier"));
	/*	Select s2=new Select(supplier);
		s2.selectByVisibleText("Strategic Technology Co.");*/
		wLib.select("Strategic Technology Co.",supplier);
		//Select from calendar
		WebElement date=driver.findElement(By.xpath("//input[@name='datestock']"));
		date.click();
		date.sendKeys("28072023");
		//Save button
		driver.findElement(By.xpath("//input[@name='datestock']/../following-sibling::button[1]")).click();

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

