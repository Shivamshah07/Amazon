package Amazon_Testcases;

//Customer must have option to Check out as Guest User

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Amazon_Testcase_39 {
	
	public Amazon_Testcase_39() throws InterruptedException {
			
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
			    
			
			    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Tshirt for Men");
			    driver.findElement(By.id("nav-search-submit-button")).click();
			    driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/a[1]/div[1]/img[1]")).click();
			    driver.findElement(By.id("size_name_1-announce")).click();
			    driver.findElement(By.id("add-to-cart-button")).click();
			    driver.findElement(By.id("proceed-to-checkout-action")).click();
			
			String expected = "Check out as Guest User";
			String actual = driver.findElement(By.xpath("//h1[contains(text(),'Sign in')]")).getText();
			Assert.assertEquals(actual, expected);
			
			Thread.sleep(2000);
			driver.quit();

	}
}