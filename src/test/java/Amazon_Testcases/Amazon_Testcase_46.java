package Amazon_Testcases;

//Check while sorting and filtering together, 
//how many items are displayed on one page and there should not be any repetition and displayed results are relevent.

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Amazon_Testcase_46 {
	
	public Amazon_Testcase_46() throws InterruptedException {
			
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
			
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Tshirts for Men");
			driver.findElement(By.id("nav-search-submit-button")).click();
			
			Select sort = new Select(driver.findElement(By.xpath("//span[@id='a-autoid-4-announce']")));
			sort.selectByIndex(1);
			
			driver.findElement(By.xpath("//span[contains(text(),'4 Stars & Up')]")).click();
			
			List<WebElement> links = driver.findElements(By.className("s-image-padding"));
			List<WebElement> link = driver.findElements(By.className("a-link-normal s-no-outline"));
			
			int actual = links.size();
			int expected = link.size();
			
			Assert.assertEquals(actual, expected);
			
			Thread.sleep(2000);
			
			driver.quit();
	
	}
}