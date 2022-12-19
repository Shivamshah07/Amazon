package Amazon_Testcases;			

import java.util.List;

//The cart balance should be zero, no items should be displayed in the cart

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Amazon_Testcase_51 {
	

	public Amazon_Testcase_51() throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.ca/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("t-shirts for men");
			driver.findElement(By.id("nav-search-submit-button")).click();
			
			WebElement tshirt = driver.findElement(By.linkText("/Under-Armour-Sleeve-Overcast-XX-Large/dp/B077XN8CVK/ref=sr_1_7?crid=3ADGZ0QL4AAUY&keywords=t-shirts+for+men&qid=1671410965&sprefix=t-shirts+for+men%2Caps%2C111&sr=8-7"));
			tshirt.click();
			driver.findElement(By.id("size_name_4-announce")).click();
			driver.findElement(By.id("add-to-cart-button")).click();
			Select qty = new Select(driver.findElement(By.xpath("//body/div[@id='a-popover-2']/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]/span[1]/input[1]")));
			qty.selectByIndex(3);
			driver.findElement(By.linkText("/gp/cart/view.html?ref_=ewc_gtc")).click();
			
			Select qtya = new Select(driver.findElement(By.id("a-autoid-5-announce")));
			qtya.selectByIndex(0);
			
			
			
			
			
			
			String act = driver.findElement(By.xpath("//h1[contains(text(),'Your Amazon Cart is empty.')]")).getText();
			String exp = "Your Amazon Cart is empty.";
									
			Assert.assertEquals(act, exp);
			
			Thread.sleep(2000);
			driver.quit();
			
			}

}
