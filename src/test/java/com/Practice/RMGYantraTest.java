package com.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RMGYantraTest {
	
	
	static boolean flag;
	public static void main(String[] args) throws InterruptedException, SQLException {
		Connection con=null;
		try {
			String expdata= "VR48";
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("http://rmgtestingserver:8084/");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			RemoteWebDriver r=(RemoteWebDriver) driver;
			r.executeScript("document.getElementById('usernmae').value='rmgyantra'");
			r.executeScript("document.getElementById('inputPassword').value='rmgy@9999'");
			//driver.findElement(By.xpath("//label[text()='Username']")).sendKeys("rmgyantra");
			//driver.findElement(By.xpath("//label[text()='Password']")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[text()='Sign in']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Projects']")).click();
			driver.findElement(By.xpath("//span[.='Create Project']")).click();
			driver.findElement(By.name("projectName")).sendKeys("VR48");
			driver.findElement(By.name("createdBy")).sendKeys("Rahul");
			WebElement drop = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
			Select s=new Select(drop);
			s.selectByVisibleText("Created");
			driver.findElement(By.xpath("//input[@value='Add Project']")).click();
			//Database
			Driver drive=new Driver();
			DriverManager.registerDriver(drive);
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%","root");
			Statement state = con.createStatement();
			String query="Select * from project;";
			ResultSet res = state.executeQuery(query);
			//boolean flag=false;
			while(res.next()) {
				String actual = res.getString(4);
				if (actual.equalsIgnoreCase(expdata)) {
					flag=true;
					break;
				}
			}
				if (flag) {
					System.out.println("success");
				}
				else
					System.out.println("fail");
	}
		catch (Exception e) {
		}
		finally {
		con.close();
		}
}
}
