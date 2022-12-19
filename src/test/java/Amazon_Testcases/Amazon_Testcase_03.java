package Amazon_Testcases;	

//Mobile number or email field cannot be empty, if left blank must throw appropriate error message

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Amazon_Testcase_03 {

	public Amazon_Testcase_03() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.ca/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		WebElement Signup = driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-newCust\"]/a"));
		
		Actions act = new Actions(driver);
		Thread.sleep(3000);
	    act.moveToElement(element).perform(); 
	    act.moveToElement(Signup).click().build().perform();
	    
	    driver.findElement(By.id("ap_customer_name")).sendKeys("Bruce");
	    driver.findElement(By.id("ap_password")).sendKeys("Abcd@1234");
	    driver.findElement(By.id("ap_password_check")).sendKeys("Abcd@1234");
	    driver.findElement(By.id("continue")).click();
		
	
			String expected = "Enter your e-mail address or mobile phone number";
			String actual = driver.findElement(By.xpath("//div[contains(text(),'Enter your e-mail address or mobile phone number')]")).getText();
			Assert.assertEquals(actual, expected);
			
			if (actual == expected) {
		    	System.out.println("Passed");
		    }
		    else	{
		    	System.out.println("Failed");
		    }
			
			Thread.sleep(2000);
			driver.quit();
}
}
