package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Base.TestBase;

public class PSIBookstorePage extends TestBase {
	
	@FindBy(how=How.XPATH, using="//*[@id='search_queryispbxi_']") public WebElement searchBox;
	
	public void enterSearchItem(String inputdata) {
		sendText(searchBox,inputdata);
		
		
		
	}

}
