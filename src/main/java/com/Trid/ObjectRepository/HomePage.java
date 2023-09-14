package com.Trid.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Trid.GenericUtility.WebDriverUtility;

public class HomePage {
	WebDriver driver;
	//Declaration
	@FindBy(xpath = "//span[text()='Customer']")
	private WebElement customerLink;
	@FindBy(xpath = "//span[text()='Employee']")
	private WebElement employeeLink;
	@FindBy(xpath = "//span[text()='Product']")
	private WebElement productLink;
	@FindBy(xpath = "//span[text()='Inventory']")
	private WebElement inventoryLink;
	@FindBy(xpath = "//span[text()='Transaction']")
	private WebElement transactionLink;
	@FindBy(xpath = "//span[text()='Supplier']")
	private WebElement supplierLink;
	@FindBy(xpath = "//span[text()='Accounts']")
	private WebElement accountsLink;
	
	
	@FindBy(xpath = "//img[@class='img-profile rounded-circle']")
	private WebElement logoutLookUpImage;

	@FindBy(xpath = "//a[@data-target='#logoutModal']")
	private WebElement logoutBtn;

	@FindBy(xpath = "//div[@class='modal fade show']/descendant::a[text()='Logout']")
	private WebElement alertLogoutBtn;
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getCustomerLink() {
		return customerLink;
	}
	public WebElement getEmployeeLink() {
		return employeeLink;
	}
	public WebElement getProductLink() {
		return productLink;
	}
	public WebElement getInventoryLink() {
		return inventoryLink;
	}
	public WebElement getTransactionLink() {
		return transactionLink;
	}
	public WebElement getSupplierLink() {
		return supplierLink;
	}
	public WebElement getAccountsLink() {
		return accountsLink;
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

	
	//Business Library
	public void clickCustomer() {
		customerLink.click();
	}

	public void clickEmployee() {
		employeeLink.click();
	}

	public void clickProduct() {
		productLink.click();
	}

	public void clickInventory() {
		inventoryLink.click();
	}

	public void clickTransaction() {
		transactionLink.click();
	}

	public void clickSupplier() {
		supplierLink.click();                               
	}

	public void clickAccounts() {
		accountsLink.click();
	}
	
	public void logout(WebDriver driver) {
		logoutLookUpImage.click();
		logoutBtn.click();
		alertLogoutBtn.click();
	}
}