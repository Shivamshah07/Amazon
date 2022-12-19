package Amazon_Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/*
User should be able to see more information about the T-shirt 
user just clicked either as a popup 
or redirecting to the product page
*/

public class Amazon_Testcase_52 {
			
	public Amazon_Testcase_52() throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.ca/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//	String oldTab = driver.getWindowHandle();
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Tshirts for Men");
			driver.findElement(By.id("nav-search-submit-button")).click();
			
			driver.findElement(By.partialLinkText("href=\"/Under-Armour-Sleeve-Overcast-XX-Large/dp/B077XN8CVK/ref=sr_1_7?crid=1FYDRAA71P1VP&keywords=t-shirts")).click();
			driver.findElement(By.id("size_name_4-announce")).click();
			driver.findElement(By.id("add-to-cart-button")).click();
			Select qty = new Select(driver.findElement(By.xpath("//body/div[@id='a-popover-2']/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]/span[1]/input[1]")));
			qty.selectByIndex(3);
			driver.findElement(By.linkText("/gp/cart/view.html?ref_=ewc_gtc")).click();
			
			driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[2]/a[1]/img[1]")).click();						
			String newTab = driver.getWindowHandle();
			driver.switchTo().window(newTab);
			
			String actual = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
			String expected = "Under Armour mens Tech 2.0 Short-sleeve T-shirt";
									
			Assert.assertEquals(actual, expected);
			
			Thread.sleep(2000);
			driver.quit();
			
			}
}
