package Amazon_Testcases;

//User must get an appropriate Error message regarding Full Name while adding an address must not be empty.

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Amazon_Testcase_25 {
	
	public Amazon_Testcase_25() throws InterruptedException {
			
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
		    
		    driver.findElement(By.xpath("//h2[contains(text(),'Your Addresses')]")).click();
		    driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]/div[1]")).click();
		    
		    driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("123456789");
		    driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("379 Indian road");
		    driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Windsor");
		    Select province = new Select(driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[2]/form[1]/span[1]/div[1]/div[1]/div[1]/div[14]/span[1]/span[1]/span[1]/span[1]")));
		    province.selectByVisibleText("Ontario");
		    driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("X1X2X2");
		    driver.findElement(By.id("ControlID-39")).click();
		    
		    String actual = driver.findElement(By.xpath("//div[contains(text(),'Please enter a name.')]")).getText();
		    String expected = "Please enter a name.";
		    Assert.assertEquals(actual,expected);
		    
		    Thread.sleep(2000);
		    driver.quit();

	}
}