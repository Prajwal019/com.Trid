package Customer_Module;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.Trid.GenericUtility.DatabaseUtilty;
import com.Trid.GenericUtility.ExcelUtility;
import com.Trid.GenericUtility.FileUtility;
import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddACustomerTest {
	public static void main(String[] args) throws Throwable {
		DatabaseUtilty dLib=new DatabaseUtilty();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib= new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		//FileInputStream fis= new FileInputStream(".//src/test/resources/Commondata.propreties");
		//To fetch data from property
		/*Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME1 = p.getProperty("username1");
		String PASSWORD1 = p.getProperty("password1");*/
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url");
		String USERNAME1=fLib.readDataFromPropertyFile("username1");
		String PASSWORD1 =fLib.readDataFromPropertyFile("password1");
		WebDriver driver=null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("internetexplorer")) {
			WebDriverManager.edgedriver().setup();	
			driver=new EdgeDriver();
		}

		driver.get(URL);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wLib.maximize(driver);
		wLib.implicitWait(driver);
		driver.findElement(By.name("user")).sendKeys(USERNAME1);
		driver.findElement(By.name("password")).sendKeys(PASSWORD1);
		driver.findElement(By.name("btnlogin")).click();
		// To handle pop up
		/*	Alert a=driver.switchTo().alert();
		a.accept();*/
		wLib.acceptAlert(driver);
		// to add required qty
		driver.findElement(By.partialLinkText("Others")).click();
		String qty="//h6[text()='apple iphon 14']/ancestor::div[@class='products']/descendant::input[@name='quantity']";
		driver.findElement(By.xpath(qty)).sendKeys(Keys.CONTROL+"a"+"delete");
		Thread.sleep(2000);
		driver.findElement(By.xpath(qty)).sendKeys("5");
		driver.findElement(By.xpath("//h6[text()='apple iphon 14']/ancestor::div[@class='products']/descendant::input[@name='addpos']")).click();

		//to verify prod and qty
		// to click on add customer button
		//driver.findElement(By.xpath("//select[@class='form-control']/ancestor::div[@class='col-sm-12 text-primary btn-group']/descendant::a[@data-toggle='modal']")).click();
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
		// to verify add customer pop up
		//	String popup = driver.findElement(By.xpath("//span[text()='×']/ancestor::div[@id='poscustomerModal']/descendant::h5[text()='Add Customer']")).getText();
		//System.out.println(popup);
		Thread.sleep(2000);
		/*
		Random random=new Random();
		int ran=random.nextInt(899);
		 */
		jLib.getRandomNo();
		// to add necessary details to add Customer pop up
		/*FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		 Sheet sh = wb.getSheet("AddCustomer");*/
		/*
		int count=sh.getLastRowNum();
		HashMap<String, String> map=new HashMap<String, String>();
		// to get data from excel and store it in map
		for (int i = 0; i <=count; i++) {
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		// Enter the values to the text fields
		for (Entry<String, String> set:map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		 */
		/*String fn = sh.getRow(0).getCell(1).getStringCellValue();
		String ln = sh.getRow(1).getCell(1).getStringCellValue();
		String pn = sh.getRow(2).getCell(1).getStringCellValue();*/
		String fn=eLib.readDataFromExcel("AddCustomer", 0, 1);
		String ln =eLib.readDataFromExcel("AddCustomer", 1, 1);
		String pn=eLib.readDataFromExcel("AddCustomer", 2, 1);
		pn=pn+jLib.getRandomNo();
		/*System.out.println(fn);
		System.out.println(ln);
		System.out.println(pn);*/

	/*	String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);*/
		//String Add = driver.findElement(By.xpath("//span[text()='×']/ancestor::div[@id='poscustomerModal']/descendant::h5[text()='Add Customer']")).getText();
		//	System.out.println(Add);
		//driver.findElement(By.name("firstname")).sendKeys(fn);
		driver.findElement(By.xpath("(//div[@class='modal-body'])[5]/descendant::input[@name='firstname']")).sendKeys(fn);
		/*driver.findElement(By.name("lastname")).sendKeys(ln);
			driver.findElement(By.name("phonenumber")).sendKeys(pn);
			driver.findElement(By.xpath("(//input[@name='firstname']/ancestor::div[@class='form-group']/following-sibling::button[@type='submit'])[2]")).click();*/
		driver.findElement(By.xpath("(//div[@class='modal-body'])[5]/descendant::input[@placeholder='Last Name']")).sendKeys(ln);
		driver.findElement(By.xpath("(//div[@class='modal-body'])[5]/descendant::input[@placeholder='Phone Number']")).sendKeys(pn);
		driver.findElement(By.xpath("(//div[@class='modal-body'])[5]/descendant::button[@type='submit']")).click();
		// to handle pop up
		/*Alert a1=driver.switchTo().alert();
			a1.accept();*/
		wLib.acceptAlert(driver);
		driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		/*	Actions act= new Actions(driver);
		WebElement target = driver.findElement(By.xpath("//a[@data-target='#logoutModal']"));
		act.moveToElement(target).click().perform();*/
		WebElement target = driver.findElement(By.xpath("//a[@data-target='#logoutModal']"));
		wLib.mouseHover(driver, target);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		//login as admin
		/*String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");*/
		String USERNAME =fLib.readDataFromPropertyFile("username");
		String PASSWORD =fLib.readDataFromPropertyFile("password");
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		// to handle pop up
		/*Alert a2=driver.switchTo().alert();
		a2.accept();*/
		wLib.acceptAlert(driver);
		//click on customer link
		driver.findElement(By.xpath("//span[text()='Customer']")).click();
		//search  for created customer
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(pn);
		String name = driver.findElement(By.xpath("//th[text()='First Name']/ancestor::table[@id='dataTable']/descendant::td[text()='"+fn+"']")).getText();
		System.out.println(name);
		if (name.contains(fn)) {
			System.out.println("Created Customer is displayed");
		}
		else
			System.out.println("Created Customer is not  displayed");
	}
}