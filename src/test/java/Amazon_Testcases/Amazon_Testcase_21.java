package Amazon_Testcases;

//"Cancelled Orders" Must display any cancelled order in the past 6 months

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Amazon_Testcase_21 {
	
	public Amazon_Testcase_21() throws InterruptedException, NoSuchElementException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.ca/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		
		Actions act = new Actions(driver);
		Thread.sleep(3000);
	    act.moveToElement(element).click().build().perform(); 
	    
	    driver.findElement(By.id("ap_email")).sendKeys("iamthebatman2508@gmail.com");
	    driver.findElement(By.id("continue")).click();
	    driver.findElement(By.id("ap_password")).sendKeys("Abcd@1234");
	    driver.findElement(By.id("signInSubmit")).click();
	    
	    WebElement element2 = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
	    Actions actu = new Actions(driver);
		Thread.sleep(3000);
	    actu.moveToElement(element2).perform();
	    
	    WebElement element3 = driver.findElement(By.xpath("//span[contains(text(),'Your Orders')]"));
	    actu.moveToElement(element3).click();
	    
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//span[contains(text(),'Cancelled Orders')]")).click();
	    String actual = driver.getCurrentUrl();
	    String expected = "https://www.amazon.ca/gp/your-account/order-history/ref=ppx_yo_dt_b_cancelled_orders?ie=UTF8&orderFilter=cancelled";
	    Assert.assertEquals(actual, expected);
	
	    Thread.sleep(2000);
		driver.quit();
	    
	}

}
