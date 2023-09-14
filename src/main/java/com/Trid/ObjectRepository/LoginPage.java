package com.Trid.ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Trid.GenericUtility.FileUtility;
import com.Trid.GenericUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	//WebDriver driver;
	//Declaration
	@ FindBy(name="user")
	private WebElement userNameTbx;
	@FindBy(name="password")
	private WebElement passwordTbx;
	@FindBy(name="btnlogin")
	private WebElement loginBtn;

	// Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization

	public WebElement getUserNameTbx() {
		return userNameTbx;
	}

	public WebElement getPasswordTbx() {
		return passwordTbx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	// Business Libraries
	public void loginAsAdmin(WebDriver driver) throws IOException{
		FileUtility fu=new FileUtility();
		String USERNAME = fu.readDataFromPropertyFile("username");
		String PASSWORD = fu.readDataFromPropertyFile("password");
		userNameTbx.sendKeys(USERNAME);
		passwordTbx.sendKeys(PASSWORD);
		loginBtn.click();
		acceptAlert(driver);
	}
	public void loginAsUser(WebDriver driver) throws IOException{
		FileUtility fu=new FileUtility();
		String USERNAME = fu.readDataFromPropertyFile("username1");
		String PASSWORD = fu.readDataFromPropertyFile("password1");
		userNameTbx.sendKeys(USERNAME);
		passwordTbx.sendKeys(PASSWORD);
		loginBtn.click();
		acceptAlert(driver);
	}
}
