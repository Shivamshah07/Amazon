package Amazon_Testcases;

//Provincies should match the country selected.

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Amazon_Testcase_29 {
	
	@SuppressWarnings({ "unlikely-arg-type" })
	public Amazon_Testcase_29() throws InterruptedException {
			
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
		    act.moveToElement(element).click().build().perform();
		    
		    driver.findElement(By.xpath("//h2[contains(text(),'Your Addresses')]")).click();
		    driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]/div[1]")).click();
	
		    driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Bruce");
		    driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("123456798");
		    driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("379 Indian road");
		    driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Calgary");
		    Select province = new Select(driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[2]/form[1]/span[1]/div[1]/div[1]/div[1]/div[14]/span[1]/span[1]/span[1]/span[1]")));
		    List<WebElement> list =province.getOptions();
		    
		    System.out.println(list.size());
		    
		    String[] prov = {"Ontario", "Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland", "Northwest Territories", "Nova Scotia", "Nunavut", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon"};
		    
	        for (WebElement webElement : list) {
	        	for(int i = 0; i<=prov.length;i++) {
	            String name = webElement.getText();
	            System.out.println(name);
	            if(((WebElement) list).getText().equals(prov)) {
                    System.out.println("Matched");
	        
	            }
	          }
	        }
		  }
		}
