package com.Trid.ObjectRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	//Declaration
	@FindBy(xpath = "//i[@class='fas fa-fw fa-plus']")
	private WebElement addCustomerIcon;

	/*@FindBy(name = "firstname")
	private WebElement firtstNameTextBx;

	@FindBy(name = "lastname")
	private WebElement lastNameTextBx;

	@FindBy(name="phonenumber")
	private WebElement phoneNumberTextBx;

	@FindBy(xpath = "//div[@class='modal-body'])[5]/descendant::button[@type='submit']")
	private WebElement saveBtn;*/

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement searchTbx;

	@FindBy(xpath = "//div[@class='modal fade show']/descendant::input[@class='form-control'][1]")
	private WebElement firstNameTextBx;

	@FindBy(xpath = "//div[@class='modal fade show']/descendant::input[@class='form-control'][2]")
	private WebElement lastNameTextBx;

	@FindBy(xpath = "//div[@class='modal fade show']/descendant::input[@class='form-control'][3]")
	private WebElement phoneNumberTextBx;
	//Initialization
	public CustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization

	public WebElement getAddCustomerIcon() {
		return addCustomerIcon;
	}


	public WebElement getSearchTbx() {
		return searchTbx;
	}


	public WebElement getFirstNameTextBx() {
		return firstNameTextBx;
	}


	public WebElement getLastNameTextBx() {
		return lastNameTextBx;
	}


	public WebElement getPhoneNumberTextBx() {
		return phoneNumberTextBx;
	}

	// Business Libraries
	public void searchCustomer(String customer) {
		searchTbx.sendKeys(customer);
	}
	
	public void validateCreatedCustomer(String name,WebDriver driver) {
	CustomerPage cp=new CustomerPage(driver);
	cp.getSearchTbx().sendKeys(name);
	String actualname=driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
/*	if (name.contains(actualname)) {
		System.out.println("Created Customer is displayed");
	}
	else{
		System.out.println("Created Customer is not  displayed");
		}*/
		assertEquals(name, actualname, "Created Customer is not  displayed");
		System.out.println("Created Customer is displayed");
	}
}

