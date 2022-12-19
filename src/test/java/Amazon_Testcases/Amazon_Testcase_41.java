package Amazon_Testcases;

//When we search for a product, we get redirected to the Search Results Page (SRP) and User Should get Relevant Product 
//and the products should display an image, name, price and maybe customer ratings and number of reviews.

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Amazon_Testcase_41 {
	
	public Amazon_Testcase_41() throws InterruptedException {
			
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
			
			WebElement img = driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/a[1]/div[1]/img[1]"));
			
			boolean actual = img.isDisplayed();
			boolean expected = img.isDisplayed();
			
			Assert.assertEquals(actual, expected);
			
			
	}

}
