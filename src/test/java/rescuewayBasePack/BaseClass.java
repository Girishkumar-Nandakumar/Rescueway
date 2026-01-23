package rescuewayBasePack;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

WebDriver driver;
JavascriptExecutor js = (JavascriptExecutor) driver;
	@BeforeSuite
	
   public void BrowserLaunch() {
		
		driver=new ChromeDriver();
		driver.get("https://rescueway.pythonanywhere.com/");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void setup() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    driver.get("https://rescueway.pythonanywhere.com/");
	}

	
	@AfterSuite
	public void BrowserQuit() {
		
		driver.close();
	}

}
