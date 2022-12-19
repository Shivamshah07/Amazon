package Amazon_Testcases;

//Customer must be allowed to add payment method

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Amazon_Testcase_37 {
	
	public Amazon_Testcase_37() throws InterruptedException {
			
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
		    
		    driver.findElement(By.xpath("//a[@id='pp-GiJYuz-35']")).click();
		    driver.findElement(By.xpath("//body/div[@id='a-page']/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/input[1]")).click();
		    
		    driver.switchTo().frame(driver.findElement(By.id("a-popover-content-1")));
		    driver.findElement(By.id("pp-aJjWfP-16")).sendKeys("4242424242424242");
		    driver.findElement(By.id("pp-aJjWfP-18")).sendKeys("Bruce Wayne");
		    Select month = new Select(driver.findElement(By.id("pp-aJjWfP-22")));
		    month.selectByVisibleText("12");
		    Select year = new Select(driver.findElement(By.id("pp-aJjWfP-23")));
		    year.selectByVisibleText("2027");
		    driver.findElement(By.id("pp-aJjWfP-25")).sendKeys("777");
		    driver.findElement(By.id("pp-aJjWfP-30")).click();
		    
		    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		    
		    driver.switchTo().frame(driver.findElement(By.id("a-popover-content-1")));
		    driver.findElement(By.name("ppw-widgetEvent:SavePaymentMethodDetailsEvent")).click();
		    
		    String actual = driver.findElement(By.xpath("//span[contains(text(),'Payment method added')]")).getText();
		    String expected = "Payment method added";
		    Assert.assertEquals(actual,expected);
		    
		    Thread.sleep(2000);
			driver.quit();

}
}


