package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.Base.TestBase;

public class PSIHomePage extends TestBase{
	
//	public WebDriver driver;
	

	
	@FindBy(how=How.NAME, using="emailid") public WebElement emailTextBox;
	@FindBy(how=How.NAME, using="password") public WebElement password;
	@FindBy(how=How.NAME, using="Submit") public WebElement submitButton;
	@FindBy(how=How.LINK_TEXT, using="Create an Account") public WebElement createAnAccount;
	@FindBy(how=How.LINK_TEXT, using="PSI Bookstore") public WebElement PSI_Bookstore;
	
	
	public void clickOnCreateAnAccountlink() {
		click(createAnAccount);
		
		
	}
	
	public void clickonPSIBookstore() {
		click(PSI_Bookstore);
		
	}
	
	
	
	

}
