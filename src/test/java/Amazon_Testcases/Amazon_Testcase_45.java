package Amazon_Testcases;

//T-shirts are displayed in Decending order of their Price.

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Amazon_Testcase_45 {
	
	public Amazon_Testcase_45() throws InterruptedException {
			
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
			
			WebElement first = driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/span[1]/span[2]/span[2]")); 
			String First = first.getText();
			int fir = Integer.parseInt(First);			
			WebElement second = driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/span[1]/span[2]/span[2]"));
			String Second = second.getText();
			int sec = Integer.parseInt(Second);
			
			 boolean actual = fir > sec ;
			 			
			Assert.assertEquals(actual, true);
			
			if (actual = true) {
				System.out.println("Passed");
			}
			else	{
				System.out.println("Failed");
			}
			
			Thread.sleep(2000);
			driver.quit();
	}
}