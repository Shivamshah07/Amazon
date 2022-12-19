package Amazon_Testcases;

//User must be able to get verify Email button

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Amazon_Testcase_05 {

	public Amazon_Testcase_05() throws InterruptedException {
			
		WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.ca/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element = driver.findElement(By.id("nav-link-accountList"));
			WebElement Signup = driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-newCust\"]/a"));
			
			Actions act = new Actions(driver);
			Thread.sleep(3000);
		    act.moveToElement(element).perform(); 
		    act.moveToElement(Signup).click().build().perform();
		    
		    driver.findElement(By.id("ap_customer_name")).sendKeys("Bruce");
		    driver.findElement(By.cssSelector("#ap_email")).sendKeys("iamthebatman");
		    driver.findElement(By.id("ap_password")).sendKeys("Abcd@1234");
		    driver.findElement(By.id("ap_password_check")).sendKeys("Abcd@1234");
		    driver.findElement(By.id("continue")).click();
		    
		    String expected = "Verify email address";
		    String actual = driver.findElement(By.xpath(("//h1[contains(text(),'Verify email address')]"))).getText();
			Assert.assertEquals(actual, expected);
						
			
			Thread.sleep(1000);
			driver.quit();
	}
	

	
}
