package Amazon_Testcases;

//For each item added, User should see a corresponding name, image, and price and total price of all items

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Amazon_Testcase_49 {

	public Amazon_Testcase_49() throws InterruptedException {
			
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
			Select qty = new Select(driver.findElement(By.xpath("//body/div[@id='a-popover-2']/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]/span[1]/input[1]")));
			qty.selectByIndex(2);
			driver.findElement(By.linkText("/gp/cart/view.html?ref_=ewc_gtc")).click();
			
			//Select qtya = new Select(driver.findElement(By.id("a-autoid-5-announce")));
			
			String actual = driver.findElement(By.className("a-truncate sc-grid-item-product-title a-size-base-plus")).getText();
			String expected = "Under Armour Men's Tech 2.0 Short-Sleeve T-Shirt";
									
			Assert.assertEquals(actual, expected);
			
			Thread.sleep(2000);
			driver.quit();
			
			}
}
