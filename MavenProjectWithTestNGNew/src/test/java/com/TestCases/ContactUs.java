package com.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Reusable.Reusable;

public class ContactUs extends Reusable  {
	
	@BeforeClass
	public void contactuspage() {
		click(By.linkText("Contact us")," clicking on contact us link");
	
	}
	
		
	@Test(priority=4)
	public void verifytitlePage() {
		String expectedTitle="Contact us - My Store";
		String actualTitle=getTitle("Getting Page Title");
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
			
	}
	
	@Test(priority=5)
	public void verifysendMessageToCustomerService() {
		dropdownSelection(By.id("id_contact"),"Webmaster","Selecting Webmaster from Subject Heading dropdown ");
		sendText(By.id("email"),"test@gmail.com","Enetering email id");
		
	}
	
	
	
		
}


