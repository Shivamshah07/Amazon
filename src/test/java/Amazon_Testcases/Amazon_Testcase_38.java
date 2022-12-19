package Amazon_Testcases;

//Customer must have option to choose default payment method

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Amazon_Testcase_38 {
	public Amazon_Testcase_38() throws InterruptedException {
			
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
		    act.moveToElement(element).click().build().perform();
		    
		    WebElement element2 = driver.findElement(By.xpath("//h2[contains(text(),'Your Payments')]"));
		    act.moveToElement(element2).click().build().perform();
		    driver.findElement(By.xpath("//a[contains(text(),'Settings')]")).click();
		    driver.findElement(By.xpath("//a[contains(text(),'Change Preference')]")).click();
		    
		    String expected = "Your purchase preferences";
		    String actual = driver.findElement(By.xpath("//span[contains(text(),'Your purchase preferences')]")).getText();
		    Assert.assertEquals(actual, expected);
		    
		    Thread.sleep(2000);
			driver.quit();

	}
}