package Amazon_Testcases;

//User must get an error message.

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Amazon_Testcase_13 {
	
	public Amazon_Testcase_13() throws InterruptedException, NoSuchElementException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.ca/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.id("nav-link-accountList"));
		
		Actions act = new Actions(driver);
		Thread.sleep(3000);
	    act.moveToElement(element).click().build().perform(); 
	    
	    
	    driver.findElement(By.id("continue")).click();
	   // driver.findElement(By.id("ap_password")).sendKeys("Abcd@1234");
	   // driver.findElement(By.id("signInSubmit")).click();
	    
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    String expected = "Enter your e-mail address or mobile phone number";
		String actual = driver.findElement(By.xpath("//div[contains(text(),'Enter your e-mail address or mobile phone number')]")).getText();
	    Assert.assertEquals(actual, expected);
					
		if (expected == actual) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");

		}
		Thread.sleep(2000);
		driver.quit();

	}

}
