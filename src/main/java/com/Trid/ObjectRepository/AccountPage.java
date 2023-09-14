package com.Trid.ObjectRepository;

import static org.testng.Assert.assertEquals;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	//Declaration
	@FindBy(xpath = "//a[@data-target='#supplierModal']")
	private WebElement addAccountIcon;

	@FindBy(name = "empid")
	private WebElement selectEmployeeDropDown;

	@FindBy(name = "username")
	private WebElement usernameTextBx;

	@FindBy(name="password")
	private WebElement passwordTextBx;

	@FindBy(xpath = "//img[@class='img-profile rounded-circle']")
	private WebElement logoutLookUpImage;

	@FindBy(xpath = "//a[@data-target='#logoutModal']")
	private WebElement logoutBtn;

	@FindBy(xpath = "//div[@class='modal fade show']/descendant::a[text()='Logout']")
	private WebElement alertLogoutBtn;

	// initialization
	public AccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getAddAccountIcon() {
		return addAccountIcon;
	}
	public WebElement getSelectEmployeeDropDown() {
		return selectEmployeeDropDown;
	}
	public WebElement getUsernameTextBx() {
		return usernameTextBx;
	}
	public WebElement getPasswordTextBx() {
		return passwordTextBx;
	}

	public WebElement getLogoutLookUpImage() {
		return logoutLookUpImage;
	}
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	public WebElement getAlertLogoutBtn() {
		return alertLogoutBtn;
	}
	// Business Libraries
	public void clickAddAccountLookUpIcon() {
		addAccountIcon.click();
	}

	public void logout(WebDriver driver) {
		driver.navigate().refresh();
		logoutLookUpImage.click();
		logoutBtn.click();
		alertLogoutBtn.click();
	}
	public void validateAddAccount(String expected,String actual,WebDriver driver) {
	/*	if (actual.equalsIgnoreCase(expected)) {
			System.out.println(expected+" Pop up is displayed");
		}
		else {
			System.out.println(expected+" Pop up is not displayed");
		}*/
		
		assertEquals(expected, actual, expected+ " Pop up is not displayed");
		System.out.println(expected+" Pop up is displayed");
		
		driver.navigate().refresh();
	}
}
