package com.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Base.TestBase;
import com.ExcelReader.ExcelReader;
import com.pages.PSIHomePage;
import com.pages.PSIBookstorePage;

public class PSIBookStoreTest extends TestBase {
	
	PSIHomePage HomePage;
	PSIBookstorePage bookstore;

	
	
	ExcelReader r;
	
	@BeforeClass
	public void NavigateToPSIBookstore() {
		HomePage=PageFactory.initElements(driver, PSIHomePage.class);
		bookstore=PageFactory.initElements(driver, PSIBookstorePage.class);
		HomePage.clickonPSIBookstore();
		
	}
	
	@Test(priority=0)
	public void PSIBookstorePage() {
		
		String parentwindow=switchWindow();
		bookstore.enterSearchItem("test");
		closeChildWindow();
		
		switchToParentWindow(parentwindow);
			
	}

}
