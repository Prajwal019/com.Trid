package com.Trid.ObjectRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	//Declaration
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTextbx;
	@FindBy(xpath = "//a[contains(text(),'Next ')]")
	private WebElement nextBtn;
	//initialization
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getSearchTextbx( ) {
		return searchTextbx;
	}
	public WebElement getNextBtn() {
		return nextBtn;
	}
	// Business Libraries
	 public void searchTransaction(String productNumber) {
		 searchTextbx.sendKeys(productNumber);
	 }
	 
	 public void toValidateProductInInventory(WebDriver driver,String ProdNum) {
		 String Actual=driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
		/*	if (Actual.equals(ProdNum)) {
				System.out.println("Product is present");
			}
			else{
				System.out.println("Product is not present");
				}*/
		 assertEquals(Actual, ProdNum, "Product is not present");
		 System.out.println("Product is present");
	 }
}