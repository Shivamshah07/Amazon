package Amazon_Testcases;

//City: must be city of Canada or the region selected above Province is drop down menu

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Amazon_Testcase_28 {
	
	public Amazon_Testcase_28() throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.ca/");
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			WebElement element = driver.findElement(By.id("nav-link-accountList"));
			//	WebElement Signup = driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-newCust\"]/a"));
				
				Actions act = new Actions(driver);
				Thread.sleep(3000);
			    act.moveToElement(element).click().build().perform();
			    
			    driver.findElement(By.id("ap_email")).sendKeys("iamthebatman2508@gmail.com");
			    driver.findElement(By.id("continue")).click();
			    driver.findElement(By.id("ap_password")).sendKeys("Abcd@1234");
			    driver.findElement(By.id("signInSubmit")).click();
		    
			    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			    act.moveToElement(driver.findElement(By.id("nav-link-accountList"))).click().build().perform();
		    
		    driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[3]/div[1]/a[1]/div[1]/div[1]")).click();
		    driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]/div[1]")).click();
	
		    driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Bruce");
		    driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("123456798");
		    driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("379 Indian road");
		    driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Calgary");
		    Select province = new Select(driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[2]/form[1]/span[1]/div[1]/div[1]/div[1]/div[14]/span[1]/span[1]/span[1]/span[1]")));
		    province.selectByVisibleText("Ontario");
		    driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("X1X2X2");
		    
		    String actual = driver.findElement(By.xpath("//span[contains(text(),'Suggested Address:')]")).getText();
		    
		    String expected = "must be city of Canada or the Province selected";
		    
		    Assert.assertEquals(actual, expected);
		    
		    Thread.sleep(2000);
		    
		    driver.quit();
	
	
	}

}
