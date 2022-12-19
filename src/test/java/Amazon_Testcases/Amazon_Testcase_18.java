package Amazon_Testcases;

//In Your Orders Module, one must get option of "Buy Again", "NOT YET SHIPPED", "Cancelled Orders".

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon_Testcase_18 {
	
	public Amazon_Testcase_18() throws InterruptedException, NoSuchElementException {
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
	    String actual = driver.findElement(By.xpath("//body/div[@id='a-page']/section[1]/div[1]/div[3]/ul[1]")).getText();
	    System.out.println(actual);
	
	    Thread.sleep(2000);
		driver.quit();
	}
}