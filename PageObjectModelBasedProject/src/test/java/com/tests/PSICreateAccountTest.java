package com.tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Base.TestBase;
import com.ExcelReader.ExcelReader;
import com.pages.PSICreateAnAccountPage;
import com.pages.PSIHomePage;

public class PSICreateAccountTest extends TestBase {
	
	PSIHomePage HomePage;

	PSICreateAnAccountPage createAccountPage;
	
	ExcelReader r;
	
	@BeforeClass
	public void NavigateToCreatePage() {
		HomePage=PageFactory.initElements(driver, PSIHomePage.class);
		createAccountPage=PageFactory.initElements(driver, PSICreateAnAccountPage.class);
		HomePage.clickOnCreateAnAccountlink();
		
	}
	
	
	@Test(priority=0)
	public void verifyAlertOnSubmittingPageWithoutEnteringPassword() throws IOException {
		
		r=new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\AutomationPractice.xlsx");
		createAccountPage.enterEmailAddress(r.getCellData("CreateAccount", 1, 0));
		createAccountPage.enterFirstName(r.getCellData("CreateAccount", 1, 1));
		createAccountPage.enterLastName(r.getCellData("CreateAccount", 1, 2));
		
		createAccountPage.clickOnSubmitButton();
		
		String alertmsg=acceptAlert();
		Assert.assertEquals(alertmsg, "Password field cannot be left blank");
		
		
		
		
		
	}
	
	
	@Test(priority=1)
	public void createAccount() throws IOException {
		
		r=new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\AutomationPractice.xlsx");
		createAccountPage.enterEmailAddress(r.getCellData("CreateAccount", 1, 0));
		createAccountPage.enterFirstName(r.getCellData("CreateAccount", 1, 1));
		createAccountPage.enterLastName(r.getCellData("CreateAccount", 1, 2));
		createAccountPage.enterpassword(r.getCellData("CreateAccount", 1, 3));
		createAccountPage.confirmPassword(r.getCellData("CreateAccount", 1, 4));

		createAccountPage.selectSecurityQuestionFromDropdown(r.getCellData("CreateAccount", 1, 5));
		createAccountPage.enterSecurityAnswer(r.getCellData("CreateAccount", 1, 6));
		//createAccountPage.clickOnSubmitButton();
	
	
	
	}
	
	
	
}
	
	
	
	
	
	
	
	
	
	


