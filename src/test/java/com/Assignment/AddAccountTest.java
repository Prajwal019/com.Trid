package com.Assignment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Trid.GenericUtility.BaseClass;
import com.Trid.ObjectRepository.AccountPage;
import com.Trid.ObjectRepository.HomePage;

public class AddAccountTest extends BaseClass {
	@Test(groups = "Smoke")
	public  void addUserAccountTest(){
		
		// click on Account link
		HomePage hp=new HomePage(driver);
		hp.clickAccounts();
		// to click on Add account Lookup icon
		AccountPage ap=new AccountPage(driver);
		ap.clickAddAccountLookUpIcon();
		//verifying Add user Pop up is displaying
		//Thread.sleep(2000);
		String expected="Add User Account";
		String Actual = driver.findElement(By.xpath("//h5[text()='Add User Account']")).getAttribute("innerHTML");
		System.out.println(Actual);
		if (Actual.equalsIgnoreCase(expected)) {
			System.out.println(expected+" Pop up is displayed");
		}
		else {
			System.out.println(expected+" Pop up is not displayed");
		}
		driver.navigate().refresh();
	}
}
