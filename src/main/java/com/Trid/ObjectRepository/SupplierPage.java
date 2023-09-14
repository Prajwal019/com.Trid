package com.Trid.ObjectRepository;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Trid.GenericUtility.ExcelUtility;
import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;

public class SupplierPage extends WebDriverUtility{
	//Declaration
	@FindBy(xpath = "//i[@class='fas fa-fw fa-plus']")
	private WebElement addSupplierIcon;

	@FindBy(id = "companyname")
	private WebElement companyNameTextBx;

	@FindBy(id="province")
	private WebElement provinceDropDown;

	@FindBy(id="city")
	private WebElement cityDropDown;

	@FindBy(name="phonenumber")
	private WebElement phoneNumberTextBx;

	@FindBy(xpath = "//div[@class='modal fade show']//div/following-sibling::button[@class='btn btn-success']")
	private WebElement saveBtn;

	@FindBy(xpath = "//div[@class='modal fade show']//div/following-sibling::button[@class='btn btn-danger']")
	private WebElement resetBtn;

	@FindBy(xpath = "//div[@class='modal fade show']//div/following-sibling::button[@class='btn btn-secondary']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//img[@class='img-profile rounded-circle']")
	private WebElement logoutLookUpImage;

	@FindBy(xpath = "//a[@data-target='#logoutModal']")
	private WebElement logoutBtn;

	@FindBy(xpath = "//div[@class='modal fade show']/descendant::a[text()='Logout']")
	private WebElement alertLogoutBtn;

	//Initialization
	public SupplierPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getAddSupplierIcon() {
		return addSupplierIcon;
	}

	public WebElement getCompanyNameTextBx() {
		return companyNameTextBx;
	}

	public WebElement getProvinceDropDown() {
		return provinceDropDown;
	}

	public WebElement getCityDropDown() {
		return cityDropDown;
	}

	public WebElement getPhoneNumberTextBx() {
		return phoneNumberTextBx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getResetBtn() {
		return resetBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
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
	//Business Libraries

	public void clickOnAddSupplierLookUpIcon() {
		addSupplierIcon.click();
	}
	public void addSupplierDetails(String company,String province,String city,String phone ) {
		companyNameTextBx.sendKeys(company);
		select(province, provinceDropDown);
		select(city, cityDropDown);
		phoneNumberTextBx.sendKeys(phone);
	}
	public void clickOnSave() {
		saveBtn.click();
	}
	public void clickOnReset() {
		resetBtn.click();
	}
	public void clickOnCancel() {
		cancelBtn.click();
	}
	public void addDetailsOnAddSupplierPopUps(HashMap<String, String> map,WebDriver driver,String province,String city) {
		clickOnAddSupplierLookUpIcon();
		for (Entry<String, String> set : map.entrySet()) {
			driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			select(province, provinceDropDown);
			select(city, cityDropDown);
			clickOnSave();
		}
	}
	public void addDetailsOnAddSupplierPopUp(HashMap<String, String> map,WebDriver driver,String expectedData,String province,String city) throws InterruptedException {
		JavaUtility j=new JavaUtility();
		clickOnAddSupplierLookUpIcon();
		for (Entry<String, String> set : map.entrySet()) {
			if (set.getKey().contains(expectedData)) {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+j.getRandomNo());
			}
			else {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			}
		}
		clickOnSave();
	}
	public void logout(WebDriver driver) {
		logoutLookUpImage.click();
		logoutBtn.click();
		alertLogoutBtn.click();
	}
	public void toValidateSupplierPage(WebDriver driver,String ActualResult ) throws Throwable {
		String expResult=driver.findElement(By.xpath("//h4[contains(text(),'Supplier')]")).getText();
		Thread.sleep(2000);
		System.out.println(expResult);
		/*if (expResult.equalsIgnoreCase(ActualResult)) {
			System.out.println("Supplier page is displaying");
		}
		else {
			System.out.println("Supplier page isn't displaying");
		}*/
		assertEquals(expResult, ActualResult, "Supplier page isn't displaying");
		System.out.println("Supplier page is displaying");
	}
}