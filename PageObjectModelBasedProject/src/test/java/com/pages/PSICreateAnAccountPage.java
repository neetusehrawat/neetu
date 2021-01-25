package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.Base.TestBase;



public class PSICreateAnAccountPage extends TestBase {
	
//	WebDriver driver;
	
	@FindBy(how=How.NAME, using="emailid") public WebElement Email_Address;
	@FindBy(how=How.NAME, using="firstname") public WebElement First_Name;
	@FindBy(how=How.NAME, using="lastname") public WebElement Last_Name;
	@FindBy(how=How.NAME, using="password") public WebElement Create_a_password;
	@FindBy(how=How.NAME, using="confirmpassword") public WebElement Confirm_password;
	@FindBy(how=How.NAME, using="hintquestion") public WebElement chooseSecurityQuestion;
	@FindBy(how=How.NAME, using="hintanswer") public WebElement securityAnswer;
	@FindBy(how=How.NAME, using="Submit") public WebElement submitButton;
	
	
	
	public void enterEmailAddress(String inputdata) throws IOException {
		sendText(Email_Address,inputdata);
		
		//Email_Address.sendKeys(inputdata);
	}
	
	public void enterFirstName(String inputdata) {
		
		sendText(First_Name,inputdata);
		//First_Name.sendKeys(inputdata);
	}
	
	public void enterLastName(String inputdata) {
		
		sendText(Last_Name,inputdata);
		
		//Last_Name.sendKeys(inputdata);
		
	}
	
	public void enterpassword(String inputdata) {
		
		sendText(Create_a_password,inputdata);
		
		//Create_a_password.sendKeys(inputdata);
	}
	
	public void confirmPassword(String inputdata) {
		sendText(Confirm_password,inputdata);
		//Confirm_password.sendKeys(inputdata);
		
		
	}
	public void selectSecurityQuestionFromDropdown(String value) {
		
		selectFromDropdown(chooseSecurityQuestion, value);
		//Select drop=new Select(chooseSecurityQuestion);
		//drop.selectByValue(value);
	}
	

	public void enterSecurityAnswer(String inputdata) {
		sendText(securityAnswer,inputdata);
		//securityAnswer.sendKeys(inputdata);
		
		
	}
	
	public void clickOnSubmitButton() {
		click(submitButton);
			//submitButton.click();
		
	}

}
