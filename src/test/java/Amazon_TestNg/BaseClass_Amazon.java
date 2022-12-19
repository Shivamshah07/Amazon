package Amazon_TestNg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class BaseClass_Amazon {

	public static Properties prop = new Properties();
	public static WebDriver driver;
	
	public BaseClass_Amazon()	{
		
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\shahs\\eclipse-workspace\\Website\\src\\Amazon_Environment\\Config.properties");
			prop.load(file);
		} 
		
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		
		catch (IOException a) 
		{
			
			a.printStackTrace();
		}			
	
	}
	

public static void initiate()	{
		
		String browser = prop.getProperty("browser");
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "ChromeDriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equals("Egde")) {
			System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

	public static void screenshots(String Filename) throws Exception	{
	
	File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File desfile = new File (("C:\\Users\\shahs\\eclipse-workspace\\Amazon")+ Filename +".jpg");
	FileUtils.copyFile(file, desfile);
	
	}
}
