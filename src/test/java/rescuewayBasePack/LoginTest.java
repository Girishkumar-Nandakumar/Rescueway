package rescuewayBasePack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class LoginTest extends BaseClass {

    WebDriverWait wait;

    @BeforeMethod
    public void openLoginPage() {
        driver.navigate().to("https://rescueway.pythonanywhere.com/login/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------- Reusable Methods ----------

    private void login(String email, String password) {
        driver.findElement(By.id("loginEmail")).clear();
        driver.findElement(By.id("loginEmail")).sendKeys(email);

        driver.findElement(By.id("loginPassword")).clear();
        driver.findElement(By.id("loginPassword")).sendKeys(password);

        driver.findElement(By.xpath("//button[@class='btn btn-secondary w-100']")).click();
    }

    private void waitForErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'alert')]")));
    }

    // ---------- Test Cases ----------

    @Test
    public void TC01_validLogin() {
        login("admin123@gmail.com", "admin123");

        // Example validation – update locator based on actual app behavior
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),
                "Login failed for valid credentials");
    }

    @Test
    public void TC02_invalidUsernameAndPassword() {
        login("wrong@gmail.com", "wrongpass");
        waitForErrorMessage();
    }

    @Test
    public void TC03_validUsernameInvalidPassword() {
        login("admin123@gmail.com", "wrongpass");
        waitForErrorMessage();
    }

    @Test
    public void TC04_invalidUsernameValidPassword() {
        login("wrong@gmail.com", "admin123");
        waitForErrorMessage();
    }

    @Test
    public void TC05_emptyUsernameAndPassword() {
        login("", "");
        waitForErrorMessage();
    }

    @Test
    public void TC06_caseSensitiveUsername() {
        login("ADMIN123@gmail.com", "admin123");
        waitForErrorMessage();
    }

    @Test
    public void TC07_caseSensitivePassword() {
        login("admin123@gmail.com", "ADMIN123");
        waitForErrorMessage();
    }

    @Test
    public void TC08_forgotPasswordFlow() throws IOException {

        driver.findElement(By.linkText("Forgot Password?")).click();

        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control']")));
        emailField.sendKeys("admin123@gmail.com");

        driver.findElement(By.xpath("//button[text()='Send OTP']")).click();

        takeScreenshot("forgot_password");
    }

    // ---------- Utility ----------

    private void takeScreenshot(String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        Files.copy(src, new File("./screenshots/" + fileName + ".jpg"));
    }
}
