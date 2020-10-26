package com.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Reusable.Reusable;
import com.ReusableExcelReader.ExcelReader;
import com.javaProgram.javaProgram;



public class SignIn extends Reusable {
	
	ExcelReader r;
	
	@BeforeClass(groups={"regression","smoke"})
	public void signupPage() throws IOException{
		click(By.linkText("Sign in"), "Clickking on Sign in link");
			
	}
	
	@Test (priority=1,groups="smoke")
	public void verifyClickingCreateAccountwithblankEmailid() {
		String expectedError="Invalid email address.";
		click(By.id("SubmitCreate"), "clicking on create Account");
		String actualError=getText(By.cssSelector("ol > li"),"Reading error message");
		System.out.println("Actual error for blank email" + actualError);
		Assert.assertEquals(actualError, expectedError);
		
		
		
	}
	
	@Test (priority=2,groups="smoke")
	public void verifyAccountAlreadyExist() throws IOException {
		
		String expectedError="An account using this email address has already been registered. Please enter a valid password or request a new one.";
		r= new ExcelReader(System.getProperty("user.dir") +"\\src\\test\\resources\\AutomationPractice.xlsx");
		sendText(By.id("email_create"),r.getCellData("Signup",1,0),"Entering email id");
		click(By.id("SubmitCreate"), "clicking on create Account");
		String actualError=getText(By.cssSelector("ol > li"),"Reading error message");
		System.out.println("Actual error is" + actualError);
		Assert.assertEquals(actualError, expectedError);
		
		
	}
	
	@Test (priority=3,groups="regression")
	public void CreateAccountForNewUser() throws IOException, InterruptedException {
		String expectedPageHeader="YOUR PERSONAL INFORMATION";
		r= new ExcelReader(System.getProperty("user.dir") +"\\src\\test\\resources\\AutomationPractice.xlsx");
		
		ClearText(By.id("email_create"),"clearing email id text field");
		javaProgram j= new javaProgram();
		String newEmail=j.generateRandomString(6)+"@gmail.com";
		
		sendText(By.id("email_create"),newEmail,"Entering email id");
		click(By.id("SubmitCreate"), "clicking on create Account");
		String ActualpageHeader=getText(By.xpath("//*[@id='account-creation_form']/div[1]/h3"),"Reading page header");
		System.out.println("Page header is" + ActualpageHeader);
		Assert.assertEquals(ActualpageHeader, expectedPageHeader);
		
		
		sendText(By.id("customer_firstname"),r.getCellData("Signup",2,1),"Entering firstname");
		sendText(By.id("customer_lastname"),r.getCellData("Signup",2,2),"Entering lastname");
		sendText(By.id("passwd"),r.getCellData("Signup",2,3),"Entering password");
		
		selectItemFromList(By.xpath("//*[@id='days']/option"),r.getCellData("Signup",2,4),"Selecting Dayofbirth from day dropdown ");
		selectItemFromList(By.xpath("//*[@id='months']/option"),r.getCellData("Signup",2,5),"Selecting Monthofbirth from day dropdown ");
		selectItemFromList(By.xpath("//*[@id='years']/option"),r.getCellData("Signup",2,6),"Selecting Yearofbirth from day dropdown ");

		sendText(By.id("company"),r.getCellData("Signup",2,7),"Entering Company");
		sendText(By.id("address1"),r.getCellData("Signup",2,8),"Entering Address");
		sendText(By.id("city"),r.getCellData("Signup",2,9),"Entering city");
		
		dropdownSelection(By.id("id_state"),r.getCellData("Signup",2,10),"Selecting state from State dropdown ");
		
		sendText(By.id("postcode"),r.getCellData("Signup",2,11),"Entering Postal code");
		
		dropdownSelection(By.id("id_country"),r.getCellData("Signup",2,12),"Selecting country from country dropdown ");
		
		
		sendText(By.id("phone_mobile"),r.getCellData("Signup",2,13),"Entering mobile number");
		
		click(By.xpath("//*[@id='submitAccount']/span"),"clicking on Register Button");
						
		Assert.assertTrue(isDisplayed(By.linkText("Sign out"),"New User account is successfully created "));
		
		
	}
	
	@AfterClass(groups={"regression","smoke"})
	public void closeExcel() throws IOException {
		r.closeExcel();
		
	}
	
		
		
		
	}
	
	
	


