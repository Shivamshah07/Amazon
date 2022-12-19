package Amazon_Testcases;

//Password must be at least 6 Characters

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Amazon_Testcase_07 {

	public Amazon_Testcase_07() throws InterruptedException {
			
		WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.ca/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element = driver.findElement(By.xpath("//a[[contains(text(), \"Hello, sign in Account & Lists‘\")]"));
			WebElement Signup = driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-newCust\"]/a"));
			
			Actions act = new Actions(driver);
			Thread.sleep(3000);
		    act.moveToElement(element).perform(); 
		    act.moveToElement(Signup).click().build().perform();
		    
		    driver.findElement(By.id("ap_customer_name")).sendKeys("Bruce");
		    driver.findElement(By.cssSelector("#ap_email")).sendKeys("iamthebatman2508@gmail.com");
		    driver.findElement(By.id("ap_password")).sendKeys("Abcd");
		    driver.findElement(By.id("ap_password_check")).sendKeys("Abcd");
		    driver.findElement(By.id("continue")).click();
		    
		    String expected = "Minimum 6 characters required";
			String actual = driver.findElement(By.cssSelector("body.ap-locale-en_CA.a-aui_72554-c.a-aui_accordion_a11y_role_354025-c.a-aui_killswitch_csa_logger_372963-c.a-aui_launch_2021_ally_fixes_392482-t1.a-aui_pci_risk_banner_210084-c.a-aui_preload_261698-c.a-aui_rel_noreferrer_noopener_309527-c.a-aui_template_weblab_cache_333406-c.a-aui_tnr_v2_180836-c.a-meter-animate:nth-child(2) div.a-section.a-padding-medium.auth-workflow:nth-child(2) div.a-section:nth-child(2) div.a-section div.a-section.auth-pagelet-container:nth-child(2) div.a-section:nth-child(2) form.ap_ango_default.auth-validate-form-moa.auth-real-time-validation div.a-box.a-spacing-extra-large:nth-child(6) div.a-box-inner div.auth-require-fields-match-group:nth-child(5) div.a-row.a-spacing-base:nth-child(1) div.a-box.a-alert-inline.a-alert-inline-error.auth-inlined-error-message.a-spacing-top-mini:nth-child(5) div.a-box-inner.a-alert-container > div.a-alert-content")).getText();
			Assert.assertEquals(actual, expected);
						
			if (expected == actual) {
				System.out.println("Pass");
			}
			else {
				System.out.println("Fail");

			}
			Thread.sleep(1000);
			driver.quit();
	}
	
}
