package com.Base;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;
	
	public static String url="";
	
	@BeforeTest
	public static void launchBrowser() {
		
		 url="https://candidate.psiexams.com/";
		
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get(url);	
		 driver.manage().window().maximize();
			
	}
	
	public static void click(WebElement ele) {
		
		ele.click();
			
	}
	
	public static void sendText(WebElement ele, String text) {
		ele.clear();
		ele.sendKeys(text);
		
	}
	
	public static void selectFromDropdown(WebElement ele,String value) {
		
		Select drop= new Select(ele);
		drop.selectByVisibleText(value);
		
		
	}
	
	public static String acceptAlert() {
		
		//driver.switchTo().alert().accept();
		
		// Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
       
        		
        // Accepting alert		
        alert.accept();	
        
        return alertMessage;
	}
	
	
	public static String switchWindow() {
		
		String parentWindow= driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> itr= windows.iterator();
		while(itr.hasNext()) {
			String childWindow=itr.next();
			if(!childWindow.equals(parentWindow)) {
				driver.switchTo().window(childWindow);
				
			}
			
		}
		
		return parentWindow;
	}
	
	public void switchToParentWindow(String parentwindow) {
		
		driver.switchTo().window(parentwindow);
	}
	
	
	public static void closeChildWindow() {
		
		driver.close();
	}
	
	
	public static void tearDown() {
		
		driver.quit();
	}
	

}
