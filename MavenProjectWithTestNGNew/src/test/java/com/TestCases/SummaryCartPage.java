package com.TestCases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Reusable.Reusable;

public class SummaryCartPage extends Reusable {
	
	@BeforeClass(groups={"regression","smoke"})
	public void homepage() {
		click(By.xpath("//*[@id='header_logo']/a/img"),"home page");
		
	}
	
	@Test (priority=4,groups="regression")
	public void VerifyEmptyCartMessage() {
		ExplicitwaitpresenceOfElementLocated(By.cssSelector("b"),"wait for cart button");
		click(By.cssSelector("b"),"Clicking on cart button");
		Assert.assertTrue(isDisplayed(By.xpath("//*[@id='center_column']/p"),"empty cart validation message displayed "));
		
			
	}
	
	@Test (priority=5,groups="regression")
	public void deleteItemFromCart() throws InterruptedException {
		
		mousehover(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"),"mouse hover to women section");
		mousehover(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[1]/a"),"mouse hover to Casual Dresses");
		click(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[1]/a"),"Clicking on Casual Dresses");
		
		scrollIntoView(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"),"Scrolling page to casual dress image ");
		mousehover(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"),"mouse hover Quick view image");
		
		click(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span"),"clickingon add to cart button under Tshirt image");
				
		ExplicitwaitpresenceOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span"),"wait for button- continue Shopping");
		Thread.sleep(2000);
		click(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span"),"clicking continue Shopping");
		
		click(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a"),"Clicking on Tshirt section Dresses");
		
		scrollIntoView(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"),"Scrolling page to Tshirt image ");
		mousehover(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"),"mouse hover on Tshirt image");
		click(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span"),"clickingon add to cart button under Tshirt image");
		
		ExplicitwaitpresenceOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span"),"wait for button- continue Shopping");
		Thread.sleep(2000);
		click(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span"),"clicking continue Shopping");
		
		ExplicitwaitpresenceOfElementLocated(By.cssSelector("b"),"wait for cart button");
		click(By.cssSelector("b"),"Clicking on cart button");
		
		List<WebElement> abc=driver.findElements(By.xpath("//*[@id='cart_summary']/tbody"));
		for (int i=0;i<=abc.size();i++) {
			String text=driver.findElement(By.xpath("//*[@id='cart_summary']/tbody/tr["+(i+1)+"]/td[2]/p/a")).getText();
			System.out.println(text);
			if(text.equals("Faded Short Sleeve T-shirts")) {
				click(By.xpath("//*[@id='cart_summary']/tbody/tr["+(i+1)+"]/td[7]/div")," ");
			}
			Thread.sleep(2000);
			
		}
		
				
		
		
		
	
		
	}
	
	

}
