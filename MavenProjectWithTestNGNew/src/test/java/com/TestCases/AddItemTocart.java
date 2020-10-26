package com.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Reusable.Reusable;

public class AddItemTocart extends Reusable {
	
	@BeforeClass(groups={"regression","smoke"})
	public void homepage() {
		click(By.xpath("//*[@id='header_logo']/a/img"),"home page");
		
	}
	
	@Test (priority=6,groups={"regression","smoke"})
	public void addingItemTocartThroughQuickView() throws InterruptedException {
		
		mousehover(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"),"mouse hover to women section");
		mousehover(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[1]/a"),"mouse hover to Casual Dresses");
		click(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[1]/a"),"Clicking on Casual Dresses");
		
		scrollIntoView(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"),"Scrolling page to casual dress image ");
		mousehover(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"),"mouse hover Quick view image");
		click(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[2]/span"),"Clicking Quick view image");
		
		switchToFrameIndex(0, "Switching frame");
		click(By.xpath("//*[@id='add_to_cart']/button/span"),"clicking add to cart button");
		driver.switchTo().defaultContent();
		ExplicitwaitpresenceOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span"),"wait for button- continue Shopping");
		Thread.sleep(2000);
		click(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span"),"clicking continue Shopping");
		
	}
		
	@Test (priority=7,groups={"regression","smoke"})
	public void addingItemTocartThroughCartButton() throws InterruptedException{
		
		click(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a"),"Clicking on Tshirt section Dresses");
		
		scrollIntoView(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"),"Scrolling page to Tshirt image ");
		mousehover(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"),"mouse hover on Tshirt image");
		click(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span"),"clickingon add to cart button under Tshirt image");
		
		ExplicitwaitpresenceOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span"),"wait for button- continue Shopping");
		Thread.sleep(2000);
		click(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span"),"clicking continue Shopping");
		
	}
		
		
	

}
