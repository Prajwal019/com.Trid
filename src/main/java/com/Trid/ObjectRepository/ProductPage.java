package com.Trid.ObjectRepository;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;

public class ProductPage extends  WebDriverUtility{

	//Declaration
	@FindBy(xpath = "//i[@class='fas fa-fw fa-plus']")
	private WebElement addProductIcon;

	@FindBy(xpath =  "//input[@name='prodcode']")
	private WebElement productCodeTextBx;

	@FindBy(xpath  = "//input[@name='name']")
	private WebElement nameTextBx;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement descriptionTextBx;

	@FindBy(xpath  = "//input[@name='quantity']")
	private WebElement quantityTextBx;

	@FindBy(xpath  = "//input[@name='onhand']")
	private WebElement onhandTextBx;

	@FindBy(xpath  = "//input[@name='price']")
	private WebElement priceTextBx;

	@FindBy(name="category")
	private WebElement categoryDropDown;

	@FindBy(name="supplier")
	private WebElement supplierDropDown;

	@FindBy(name="datestock")
	private WebElement datestockTbx;

	@FindBy(xpath ="//input[@name='datestock']/../following-sibling::button[1]")
	private WebElement saveBtn;

	@FindBy(xpath ="//input[@name='datestock']/../following-sibling::button[2]")
	private WebElement resetBtn;

	@FindBy(xpath ="//input[@name='datestock']/../following-sibling::button[3]")
	private WebElement closeBtn;

	@FindBy(xpath = "//img[@class='img-profile rounded-circle']")
	private WebElement logoutLookUpImage;

	@FindBy(xpath = "//a[@data-target='#logoutModal']")
	private WebElement logoutBtn;

	@FindBy(xpath = "//div[@class='modal fade show']/descendant::a[text()='Logout']")
	private WebElement alertLogoutBtn;

	// Initialization
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Utilization
	public WebElement getAddProductIcon() {
		return addProductIcon;

	}
	public WebElement getProductCodeTextBx() {
		return productCodeTextBx;
	}
	public WebElement getNameTextBx() {
		return nameTextBx;
	}
	public WebElement getDescriptionTextBx() {
		return descriptionTextBx;
	}
	public WebElement getQuantityTextBx() {
		return quantityTextBx;
	}
	public WebElement getOnhandTextBx() {
		return onhandTextBx;
	}
	public WebElement getPriceTextBx() {
		return priceTextBx;
	}
	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}
	public WebElement getSupplierDropDown() {
		return supplierDropDown;
	}
	public WebElement getDatestockTbx() {
		return datestockTbx;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getResetBtn() {
		return resetBtn;
	}
	public WebElement getCloseBtn() {
		return closeBtn;
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


	public void clickOnAddProductLookUpIcon() {
		addProductIcon.click();
	}
	public void clickOnSave() {
		saveBtn.click();
	}
	public void addDetailsOnAddProductPopUp(HashMap<String, String> map,WebDriver driver,String expectedData,String category,String supplier,String date) {
		JavaUtility j=new JavaUtility();
		clickOnAddProductLookUpIcon();
		for (Entry<String, String> set : map.entrySet()) {
			if (set.getKey().contains(expectedData)) {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+j.getRandomNo());
			}
			else {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			}
		}
		select(category, categoryDropDown);
		select(supplier, supplierDropDown);
		datestockTbx.click();
		datestockTbx.sendKeys(date);
		clickOnSave();
	}

	public void clickOnReset() {
		resetBtn.click();
	}
	public void clickOnClose() {
		closeBtn.click();
	}

	public void addDetailsOnAddProductPopUps(HashMap<String, String> map,WebDriver driver,String category,String supplier,String date) {
		clickOnAddProductLookUpIcon();
		for (Entry<String, String> set : map.entrySet()) {
			driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
		}
		select(category, categoryDropDown);
		select(supplier, supplierDropDown);
		datestockTbx.click();
		datestockTbx.sendKeys(date);
		clickOnSave();
	}

	public void logout(WebDriver driver) {
		logoutLookUpImage.click();
		logoutBtn.click();
		alertLogoutBtn.click();
	}

	public void addDetailsOnAddProductPop(HashMap<String, String> map,WebDriver driver,String category,String supplier) {
		clickOnAddProductLookUpIcon();
		for (Entry<String, String> set : map.entrySet()) {
			driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
		}
		select(category, categoryDropDown);
		select(supplier, supplierDropDown);
	}


	public void toValidateSupplierInProductPage(WebDriver driver,String company) throws InterruptedException {
		List<WebElement> data = driver.findElements(By.xpath("//h5[text()='Add Product']/../following-sibling::div/descendant::select[@name='supplier']"));
		for (WebElement webElement : data) {
			String h = webElement.getText();
			Thread.sleep(6000);
			/*if (h.contains(company)) {
				System.out.println("Created Supplier is Present");
			}
			else {
				System.out.println("Created Supplier is not Present");
			}*/
			assertEquals(h, company, "Created Supplier is not Present");
			System.out.println("Created Supplier is  Present");
		}
	}
}