package Amazon_Testcases;	//Your Name field cannot be empty, if left blank must throw appropriate error message

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Amazon_Testcase_01 {
	
	WebDriver driver;

	
	public Amazon_Testcase_01() throws InterruptedException {
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.ca/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
			WebElement Signup = driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-newCust\"]/a"));
			
			Actions act = new Actions(driver);
			Thread.sleep(3000);
		    act.moveToElement(element).perform(); 
		    act.moveToElement(Signup).click().build().perform();
		    
		    
		    driver.findElement(By.cssSelector("#ap_email")).sendKeys("iamthebatman2508@gmail.com");
		    driver.findElement(By.id("ap_password")).sendKeys("Abcd@1234");
		    driver.findElement(By.id("ap_password_check")).sendKeys("Abcd@1234");
		    driver.findElement(By.id("continue")).click();
		    
		    String expected = "Enter your name";
		    String actual = driver.findElement(By.xpath("//div[contains(text(),'Enter your name')]")).getText();
			System.out.println(actual);
			Assert.assertEquals(actual, "Enter your name");	
		   
			if (actual == expected) {
		    	System.out.println("Passed");
		    }
		    else	{
		    	System.out.println("Failed");
		    }
		    
		    Thread.sleep(3000);
		    driver.quit();
		    			 	
		}
		    
	}


