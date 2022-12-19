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

public class Amazon_Testcase_12 {
	
	public Amazon_Testcase_12() throws InterruptedException, NoSuchElementException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.ca/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]"));
		
		Actions act = new Actions(driver);
		Thread.sleep(3000);
	    act.moveToElement(element).click().build().perform(); 
	    
	    driver.findElement(By.id("ap_email")).sendKeys("shah16f@uwindsor.ca");
	    driver.findElement(By.id("continue")).click();
	    driver.findElement(By.id("ap_password")).sendKeys("Abcd@1234");
	    driver.findElement(By.id("signInSubmit")).click();
	    
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    String expected = "We cannot find an account with that e-mail address";
		String actual = driver.findElement(By.xpath("//span[contains(text(),'We cannot find an account with that e-mail address')]")).getText();
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


