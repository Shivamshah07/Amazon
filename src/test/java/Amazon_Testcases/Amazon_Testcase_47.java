package Amazon_Testcases;	

//the shopping cart should be updated with the item with correct name, image, and price.

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Amazon_Testcase_47 {
	
	public Amazon_Testcase_47() throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.ca/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			WebElement element = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
			//	WebElement Signup = driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-newCust\"]/a"));
				
				Actions act = new Actions(driver);
				Thread.sleep(3000);
			    act.moveToElement(element).click().build().perform();
			    
			    driver.findElement(By.id("ap_email")).sendKeys("iamthebatman2508@gmail.com");
			    driver.findElement(By.id("continue")).click();
			    driver.findElement(By.id("ap_password")).sendKeys("Abcd@1234");
			    driver.findElement(By.id("signInSubmit")).click();
			
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Tshirts for Men");
			driver.findElement(By.id("nav-search-submit-button")).click();
			
			driver.findElement(By.partialLinkText("href=\"/Under-Armour-Sleeve-Overcast-XX-Large/dp/B077XN8CVK/ref=sr_1_7?crid=1FYDRAA71P1VP&keywords=t-shirts")).click();
			driver.findElement(By.id("size_name_4-announce")).click();
			driver.findElement(By.id("add-to-cart-button")).click();
			
			String actual = driver.findElement(By.xpath("//span[contains(text(),'Added to Cart')]")).getText();
			String expected = "Added to Cart" ;
			
			Assert.assertEquals(actual, expected);
			
			Thread.sleep(2000);
			driver.quit();
			
			}
}