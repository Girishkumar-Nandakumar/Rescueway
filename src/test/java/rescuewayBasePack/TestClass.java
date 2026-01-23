package rescuewayBasePack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.common.io.Files;
public class TestClass extends BaseClass{



	    void scrollBy(int y) {
	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + y + ")");
	    }

	    void hover(WebElement element) {
	        new Actions(driver).moveToElement(element).perform();
	    }

	    void takeScreenshot(String name) throws IOException {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        Files.copy(src, new File("./screenshots/" + name + ".jpg"));
	    }

	    void assertRedirected(String expectedUrlPart) {
	        Assert.assertTrue(
	                driver.getCurrentUrl().contains(expectedUrlPart),
	                "Redirection failed. Current URL: " + driver.getCurrentUrl()
	        );
	    }

	    // ---------- Test Cases ----------

	    @Test
	    public void TC01_contactRescueway() {

	        driver.navigate().to("/contact/");
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	        	    By.xpath("//h1[contains(text(),'Contact')]")));


	        driver.findElement(By.id("form-floating-1")).sendKeys("Demo");
	        driver.findElement(By.id("form-floating-2")).sendKeys("demo@gmail.com");
	        driver.findElement(By.id("form-floating-3")).sendKeys("Sample Subject");
	        driver.findElement(By.id("form-floating-4")).sendKeys("Sample Message");

	        driver.findElement(By.xpath("//button[text()='Submit']")).click();

	        Assert.assertNotEquals(
	                driver.getCurrentUrl(),
	                "https://rescueway.pythonanywhere.com/contact/",
	                "Contact form submission failed"
	        );
	    }

	    @Test
	    public void TC02_mouseHoverNavigation() {

	        String[] menuItems = {"Home", "About", "Service", "Contact", "SignIn", "SignUp"};

	        for (String menu : menuItems) {
	            WebElement element = driver.findElement(By.linkText(menu));
	            hover(element);
	        }
	    }

	    @Test
	    public void TC03_aboutRedirection() {
	        driver.findElement(By.linkText("About")).click();
	        assertRedirected("/about");
	    }

	    @Test
	    public void TC04_serviceRedirection() {
	        driver.findElement(By.linkText("Service")).click();
	        assertRedirected("/service");
	    }

	    @Test
	    public void TC05_footerLinksRedirection() {

	        String[] footerLinks = {"FAQs", "Support", "Privacy", "Policy", "Career"};

	        for (String link : footerLinks) {
	            driver.findElement(By.xpath("//small[text()='" + link + "']")).click();
	            Assert.assertNotEquals(
	                    driver.getCurrentUrl(),
	                    "https://rescueway.pythonanywhere.com/",
	                    link + " redirection failed"
	            );
	            driver.navigate().back();
	        }
	    }

	    @Test
	    public void TC06_requestFreeQuote() throws IOException {

	        scrollBy(2000);

	        driver.findElement(By.id("form-floating-1")).sendKeys("Demo");
	        driver.findElement(By.id("form-floating-2")).sendKeys("demo@gmail.com");

	        Select service = new Select(driver.findElement(By.id("floatingSelect")));
	        service.selectByIndex(1);

	        driver.findElement(By.xpath("//button[contains(text(),'Request')]")).click();

	        Assert.assertNotEquals(
	                driver.getCurrentUrl(),
	                "https://rescueway.pythonanywhere.com/",
	                "Quote request failed"
	        );

	        takeScreenshot("request_quote");
	    }

	    @Test
	    public void TC07_signupFromHomePage() {
	        driver.findElement(By.linkText("SignUp")).click();
	        assertRedirected("/signup");
	    }

	    @Test
	    public void TC08_signupFromLoginPage() {

	        driver.navigate().to("/login/");
	        scrollBy(500);

	        driver.findElement(By.linkText("Sign up here")).click();
	        assertRedirected("/signup");
	    }

	    @Test
	    public void TC09_validSignup() {

	        driver.navigate().to("/signup/");

	        driver.findElement(By.name("full_name")).sendKeys("Demo User");
	        driver.findElement(By.name("email")).sendKeys("demo@gmail.com");
	        driver.findElement(By.name("phone_number")).sendKeys("9876543210");
	        driver.findElement(By.name("password")).sendKeys("demo123");
	        driver.findElement(By.name("confirm_password")).sendKeys("demo123");

	        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();

	        assertRedirected("/login");
	    }

	    @Test
	    public void TC10_signupWithEmptyFields() {

	        driver.navigate().to("/signup/");
	        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();

	        Assert.assertTrue(
	                driver.getCurrentUrl().contains("/signup"),
	                "Signup should not succeed with empty fields"
	        );
	    }
	}
