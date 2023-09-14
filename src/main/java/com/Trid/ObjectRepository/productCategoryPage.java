package com.Trid.ObjectRepository;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Trid.GenericUtility.JavaUtility;
import com.Trid.GenericUtility.WebDriverUtility;

public class productCategoryPage extends WebDriverUtility {

	//Declaration
	@ FindBy(name="user")
	private WebElement userNameTbx;

	@FindBy(name="password")
	private WebElement passwordTbx;

	@FindBy(name="btnlogin")
	private WebElement loginBtn;

	@FindBy(xpath = "//a[text()='Keyboard']")
	private WebElement keyboardLink;

	@FindBy(xpath = "//a[text()='Mouse']")
	private WebElement MouseLink;

	@FindBy(xpath = "//a[text()='Headset']")
	private WebElement headsetLink;

	@FindBy(xpath = "//a[text()='CPU']")
	private WebElement cpuLink;

	@FindBy(xpath = "//a[text()='Monitor']")
	private WebElement monitorLink;

	@FindBy(xpath = "//a[text()='Motherboard']")
	private WebElement motherboardLink;

	@FindBy(xpath = "//a[text()='Processor']")
	private WebElement processorLink;

	@FindBy(xpath = "//a[contains(text(),'Power')]")
	private WebElement powerSupplyLink;

	@FindBy(xpath = "//a[text()='Others']")
	private WebElement othersLink;

	@FindBy(xpath = "//a[text()='SUBMIT']")
	private WebElement submitBtn;

	@FindBy(xpath = "//a[@class='btn btn-primary bg-gradient-primary']")
	private WebElement addCustomerLookUpIcon;

	@FindBy(xpath = "//div[@class='modal fade show']//div[1]/descendant::input[@placeholder='First Name']")
	private WebElement firstNameTextBx;

	@FindBy(xpath = "//div[@class='modal fade show']//div[1]/descendant::input[@placeholder='Last Name']")
	private WebElement lastNameTextBx;

	@FindBy(xpath =" //div[@class='modal fade show']//div[1]/descendant::input[@placeholder='Phone Number']")
	private WebElement phoneNumTextBx;

	@FindBy(xpath =" //div[@class='modal fade show']//div[1]/descendant::button[@type='submit']")
	private WebElement saveBtn;

	@FindBy(xpath =" //div[@class='modal fade show']//div[1]/descendant::button[@type='reset']")
	private WebElement resetBtn;

	@FindBy(xpath =" //div[@class='modal fade show']//div[1]/descendant::button[text()='Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//i[@class='fas fa-fw fa-trash']")
	private WebElement deleteBtn;

	@FindBy(xpath = "//img[@class='img-profile rounded-circle']")
	private WebElement logoutLookUpImage;

	@FindBy(xpath = "//a[@data-target='#logoutModal']")
	private WebElement logoutBtn;

	@FindBy(xpath = "//div[@class='modal fade show']/descendant::a[text()='Logout']")
	private WebElement alertLogoutBtn;

	// Initialization

	public productCategoryPage(WebDriver driver) {
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

	public WebElement getKeyboardLink() {
		return keyboardLink;
	}

	public WebElement getMouseLink() {
		return MouseLink;
	}

	public WebElement getHeadsetLink() {
		return headsetLink;
	}

	public WebElement getCpuLink() {
		return cpuLink;
	}

	public WebElement getMonitorLink() {
		return monitorLink;
	}

	public WebElement getMotherboardLink() {
		return motherboardLink;
	}

	public WebElement getProcessorLink() {
		return processorLink;
	}

	public WebElement getPowerSupplyLink() {
		return powerSupplyLink;
	}

	public WebElement getOthersLink() {
		return othersLink;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public WebElement getAddCustomerLookUpIcon() {
		return addCustomerLookUpIcon;
	}

	public WebElement getFirstNameTextBx() {
		return firstNameTextBx;
	}

	public WebElement getLastNameTextBx() {
		return lastNameTextBx;
	}

	public WebElement getPhoneNumTextBx() {
		return phoneNumTextBx;
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
	public WebElement getDeleteBtn() {
		return deleteBtn;
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


	public void clickOnKeyBoard(){
		keyboardLink.click();
	}
	public void clickOnMouse(){
		MouseLink.click();
	}
	public void clickOnHeadset(){
		headsetLink.click();
	}
	public void clickOnCPU(){
		cpuLink.click();
	}
	public void clickOnMonitor(){
		monitorLink.click();
	}
	public void clickOnMotherBoard(){
		motherboardLink.click();
	}
	public void clickOnProcessor(){
		processorLink.click();
	}
	public void clickOnPowerSupply(){
		powerSupplyLink.click();
	}
	public void clickOnOthers(){
		othersLink.click();
	}
	public void clickOnSubmit(){
		submitBtn.click();
	}
	public void clickOnAddCustomerLookUpIcon() {
		addCustomerLookUpIcon.click();
	}
	public void toAddRequiredQuantity(WebDriver driver,String quantity,String ProdName) throws InterruptedException {
		String qty="//h6[text()='"+ProdName+"']/ancestor::div[@class='products']/descendant::input[@name='quantity']";
		driver.findElement(By.xpath(qty)).sendKeys(Keys.CONTROL+"a"+"delete");
		driver.findElement(By.xpath(qty)).sendKeys(quantity);
		driver.findElement(By.xpath("//h6[text()='"+ProdName+"']/ancestor::div[@class='products']/descendant::input[@name='addpos']")).click();
	}
	public void addDetailsCreateCustomerPopUp(HashMap<String, String> map,WebDriver driver,String expectedData) throws Throwable {

		clickOnAddCustomerLookUpIcon();
		JavaUtility j=new JavaUtility();
		for (Entry<String, String> set : map.entrySet()) {
			if (set.getKey().contains(expectedData)) {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+j.getRandomNo());
			}
			else {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			}
			saveBtn.click();
			//Thread.sleep(2000);
			//acceptAlert(driver);
		}
	}


	//			catch (Exception e) {
	//			acceptAlert(driver);
	//		}




	public void deleteProduct() {
		deleteBtn.click();
	}

	public void logout(WebDriver driver) {
		logoutLookUpImage.click();
		logoutBtn.click();
		alertLogoutBtn.click();
	}

	public void toValidateProductAndQuantity(WebDriver driver,String quantity,String product) {
		String text = driver.findElement(By.xpath("//tbody/tr/td[1]")).getText();
		String text1 = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
		System.out.println(text+" : "+text1);
		assertEquals(product, text, product+" is not displayed");
		System.out.println(product+" is diplayed");
		assertEquals(quantity, text1, quantity+" is not displayed");
		System.out.println(quantity+" is diplayed");
	}
}