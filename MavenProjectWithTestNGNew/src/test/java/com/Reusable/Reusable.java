package com.Reusable;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.CustomizedReportTestNG.ExtentCustomizedReports;
import com.Properties.ReuseProperties;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reusable extends ExtentCustomizedReports  {

	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;
	
	ExtentCustomizedReports ecr=new ExtentCustomizedReports();
	@BeforeTest(groups={"regression","smoke"})
	 public static void launchBrowser() throws IOException {
		test=report.startTest("Automation Practice");
		 //String browser =System.getProperty("Browsername");
		 String browser="";
		 String url="";
		 try {
		 
			 ReuseProperties prop= new ReuseProperties(System.getProperty("user.dir") +"\\config.properties");
     		 browser=prop.getProperty("browser");
			 url=prop.getProperty("url");
			 System.out.println(browser);
			 
			 try {
				 if(browser.equalsIgnoreCase("chrome")==true) {
					 //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\chromedriver.exe");
					 WebDriverManager.chromedriver().setup();
					 driver = new ChromeDriver();
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					 driver.get(url);	
					 driver.manage().window().maximize();
			
			
				 } else if(browser.equalsIgnoreCase("firefox")==true){
					 //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\geckodriver.exe");
					 WebDriverManager.firefoxdriver().setup();
					 driver =new FirefoxDriver();
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					 driver.get(url);
					 driver.manage().window().maximize();
			
			
		 
					 }else if(browser.equalsIgnoreCase("edge")==true){
				 	//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +"\\msedgedriver.exe");
				    WebDriverManager.edgedriver().setup();
				    driver= new EdgeDriver();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get(url);
					driver.manage().window().maximize();
		 	}try{
		 		prop.closePropertiesFile();
		 		}catch(Exception e) {
		 			e.printStackTrace();
		 	}}catch(Exception e) {
		 		e.printStackTrace();
		 	}
		 }catch(Exception e) {
			 e.printStackTrace();
		 }

	 }
	 	 
 


		public static void click(By locator,String testCaseStep) {
			try {
			driver.findElement(locator).click();
			test.log(LogStatus.PASS, testCaseStep);
		}catch(Exception e) {
			Reporter.log(testCaseStep +" failed");
			test.log(LogStatus.FAIL, testCaseStep);
		}
			
		}
		
		public static String getTitle(String testCaseStep ) {
			String titlename="";
			try {
			titlename=driver.getTitle();
			test.log(LogStatus.PASS, testCaseStep);
			}catch(Exception e) {
				Reporter.log("Unable to get Page title");
				test.log(LogStatus.FAIL, testCaseStep);
						}
			return titlename;
			
		}
		
		public static void dropdownSelection(By locator,String Value,String testcaseStep) {
			try {
			
			Select dropdown=new Select(driver.findElement(locator));
			dropdown.selectByVisibleText(Value);
			test.log(LogStatus.PASS, testcaseStep);
			}catch(Exception e) {
				Reporter.log("dropdown selection failed");
				test.log(LogStatus.FAIL, testcaseStep);
				
			}
		}
		
		public static void selectItemFromList(By locator,String Value,String testcaseStep) {
			try {
			List<WebElement> li= driver.findElements(locator);
			for(int i=0;i<li.size();i++) {
				String text=li.get(i).getText();
				//System.out.println(text);
				if(text.equalsIgnoreCase(Value)) {
					li.get(i).click();
					break;
				}
			}
			test.log(LogStatus.PASS, testcaseStep);
			}catch(Exception e) {
					Reporter.log("unable to select item from list");
					test.log(LogStatus.FAIL, testcaseStep);
					
				}
				
			}
		
		
		public static void sendText(By locator ,String inputData,String testcaseStep) {
			try {
			driver.findElement(locator).sendKeys(inputData);
			test.log(LogStatus.PASS, testcaseStep);
		}catch(Exception e) {
			Reporter.log("error while enterting data");
			test.log(LogStatus.FAIL, testcaseStep);
		}
			
		}
		
		public static void ClearText(By locator,String testcaseStep) {
			try {
			driver.findElement(locator).clear();
			test.log(LogStatus.PASS, testcaseStep);
			}catch(Exception e) {
				Reporter.log("error while clearing textbox");
				test.log(LogStatus.FAIL, testcaseStep);
			}
			
			
		}
		
		public static String getText(By locator ,String testcaseStep) {
			String text="";
			try {
				text= driver.findElement(locator).getText();
				test.log(LogStatus.PASS, testcaseStep);
				}catch(Exception e) {
				Reporter.log("error while reading text");
				test.log(LogStatus.FAIL, testcaseStep);
			}
			return text;
			
		}
		
		public static boolean isDisplayed(By locator,String testcaseStep) {
			boolean status=false;
			try {
			status=driver.findElement(locator).isDisplayed();
			test.log(LogStatus.PASS, testcaseStep);
			}catch(Exception e) {
				Reporter.log("Webelement not displayed");
				test.log(LogStatus.FAIL, testcaseStep);
			}
			return status;
			
		}
		
		public static void mousehover(By locator,String testcaseStep) {
			try {
			action= new Actions(driver);
			action.moveToElement(driver.findElement(locator)).perform();
			test.log(LogStatus.PASS, testcaseStep);
		}catch(Exception e) {
			Reporter.log("Failed to perform mouse hover action");
			test.log(LogStatus.FAIL, testcaseStep);
			
		}
		}
		
		public static void switchToFrameIndex(int index, String testcaseStep) {
			try {
			driver.switchTo().frame(index);
			test.log(LogStatus.PASS, testcaseStep);
			}catch(Exception e) {
				Reporter.log("Failed while switching frame");
				test.log(LogStatus.FAIL, testcaseStep);
				
			}
		}
		
		public static void ExplicitwaitpresenceOfElementLocated(By locator,String testcaseStep) {
			try {
			wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			test.log(LogStatus.PASS, testcaseStep);
			
			}catch(Exception e) {
				Reporter.log("unable to locate element with explicit wait");
				test.log(LogStatus.FAIL, testcaseStep);
				
			}
			
		}
		
		public static void Explicitwait(int index,String testcaseStep) {
			try {
			wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
			test.log(LogStatus.PASS, testcaseStep);
			
			}catch(Exception e) {
				Reporter.log("unable to switch frame with explicit wait");
				test.log(LogStatus.FAIL, testcaseStep);
				
			}
			
		}
		
		
		public static void scrollIntoView(By locator,String testcaseStep ) {
			try {
			WebElement ele=driver.findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",ele);
			test.log(LogStatus.PASS, testcaseStep);
			}
			catch(Exception e) {
				Reporter.log("Page Scroll failed.");
				test.log(LogStatus.FAIL, testcaseStep);
				
			}
			
			
		}
		
		public void assertEqual(String one,String two, String testCaseStep) {
			try {
				Assert.assertEquals(one, two);
				test.log(LogStatus.PASS, testCaseStep);
			}catch(Exception e) {
				test.log(LogStatus.FAIL, testCaseStep);
				
			}
			
		}
		@AfterTest(groups={"regression","smoke"})
		public static void closeApp() {
			try {
			driver.quit();
			report.flush();
			report.endTest(test);
			}catch(Exception e) {
				Reporter.log("Script failed while closing browser ");
				
			}
			
			
		}
		
}

