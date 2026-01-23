package rescuewayBasePack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class BasicNavigation extends BaseClass{
	
	@Test
	
	 public void contactRescueway() throws InterruptedException {
			

			driver=new ChromeDriver();
			driver.get("https://rescueway.pythonanywhere.com/");
			driver.manage().window().maximize();
			driver.navigate().to("https://rescueway.pythonanywhere.com/contact/");
			
			WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='display-5 mb-4']")));
			
			driver.findElement(By.id("form-floating-1")).sendKeys("demo");
			driver.findElement(By.id("form-floating-2")).sendKeys("demo123@gmail.com");
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scroll(0,800)");
			
			
			driver.findElement(By.id("form-floating-3")).sendKeys("sample demo");
			driver.findElement(By.id("form-floating-4")).sendKeys("this is a sample for the demo");
					
			String beforeSubmiturl = driver.getCurrentUrl();
			
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			
			Thread.sleep(3000); 

			String afterSubmiturl = driver.getCurrentUrl();

			if (!beforeSubmiturl.equals(afterSubmiturl)) {
			    System.out.println("Contact form submitted (URL changed)");
			} else {
			    System.out.println("No URL change. submission status uncertain");
			}
			}
			
			@Test
			public void mouseHoveringInHomePage() throws InterruptedException {
				
				
				WebElement home= driver.findElement(By.xpath("(//a[text()='Home'])[1]"));
				Actions h1= new Actions(driver);
				h1.moveToElement(home).build().perform();
				
				Thread.sleep(10);
				
		        WebElement about= driver.findElement(By.xpath("//a[text()='About']"));
				Actions h2= new Actions(driver);
				h2.moveToElement(about).build().perform();
				Thread.sleep(10);
				
		        WebElement service= driver.findElement(By.xpath("//a[text()='Service']"));
				Actions h3= new Actions(driver);
				h3.moveToElement(service).build().perform();
				Thread.sleep(10);
				
		        WebElement pages= driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
				Actions h4= new Actions(driver);
				h4.moveToElement(pages).build().perform();
				Thread.sleep(10);
				
		        WebElement contact= driver.findElement(By.xpath("//a[text()='Contact']"));
				Actions h5= new Actions(driver);
				h5.moveToElement(contact).build().perform();
				Thread.sleep(10);
				
				WebElement signin= driver.findElement(By.xpath("//a[text()='SignIn']"));
				Actions h6= new Actions(driver);
				h6.moveToElement(signin).build().perform();
				Thread.sleep(10);
				
				WebElement signup= driver.findElement(By.xpath("//a[text()='SignUp']"));
				Actions h7= new Actions(driver);
				h7.moveToElement(signup).build().perform();
				Thread.sleep(10);
				
				
			}
			//TC15
			@Test
			
			public void aboutRedirection() {
				
					
				WebElement about=driver.findElement(By.xpath("//a[text()='About']"));
				about.click();
				String currentURL1= driver.getCurrentUrl();
				
				if(currentURL1.contains("https://rescueway.pythonanywhere.com/about/")) {
					System.out.println("redirection is succesfull on clicking About button");
				}
				else {
					System.out.println("redirection is failed");
				}
			}	
			
			//TC16
			@Test
			public void serviceRedirection() {
			WebElement service=driver.findElement(By.xpath("//a[text()='Service']"));
			service.click();
			String currentURL2= driver.getCurrentUrl();
			
			if(currentURL2.contains("https://rescueway.pythonanywhere.com/service/")) {
				System.out.println("redirection is succesfull on clicking service button");
			}
			else {
				System.out.println("redirection is failed");
			}
		}
			//TC17
			@Test
			
			public void fAQRedirection() {
				
			driver.findElement(By.xpath("//small[text()='FAQs']")).click();
			
			String currentURL3= driver.getCurrentUrl();
			
			if(currentURL3.equals("https://rescueway.pythonanywhere.com/")) {
				System.out.println("redirection is failed on clicking FAQS button");
			}
			else {
				System.out.println("redirection is sucessfull");
			}
		}	
			//TC18
			@Test
			
			public void supportRedirection() {
			
			driver.findElement(By.xpath("//small[text()='Support']")).click();
			
			String currentURL4= driver.getCurrentUrl();
			
			if(currentURL4.equals("https://rescueway.pythonanywhere.com/")) {
				System.out.println("redirection is failed on clicking support button");
			}
			else {
				System.out.println("redirection is sucessfull");
			}
		}
			//TC19
			@Test
			
			public void privacyRedirection() {
			
			driver.findElement(By.xpath("//small[text()='Privacy']")).click();
			
			String currentURL5= driver.getCurrentUrl();
			
			if(currentURL5.equals("https://rescueway.pythonanywhere.com/")) {
				System.out.println("redirection is failed on clicking privacy button");
			}
			else {
				System.out.println("redirection is sucessfull");
			}
		}
			//TC20
			@Test
			
			public void policyRedirection() {

			driver.findElement(By.xpath("//small[text()='Policy']")).click();
			
			String currentURL6= driver.getCurrentUrl();
			
			if(currentURL6.equals("https://rescueway.pythonanywhere.com/")) {
				System.out.println("redirection is failed on clicking Policy button");
			}
			else {
				System.out.println("redirection is sucessfull");
			}
		}
			//TC21
			@Test
			
			public void careerRedirection() {
			
			driver.findElement(By.xpath("//small[text()='Career']")).click();
			
			String currentURL7= driver.getCurrentUrl();
			
			if(currentURL7.equals("https://rescueway.pythonanywhere.com/")) {
				System.out.println("redirection is failed on clicking Career button");
			}
			else {
				System.out.println("redirection is sucessfull");
			}
		}
			//TC22
			@Test

			public void requestAfreeQuote() throws IOException {
				
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,2100)");
				
				driver.findElement(By.xpath("//input[@id='form-floating-1']")).sendKeys("Demoname");
				driver.findElement(By.xpath("//input[@id='form-floating-2']")).sendKeys("demoname@gmail.com");
				WebElement element=driver.findElement(By.xpath("//select[@id='floatingSelect']"));
				Select s1=new Select(element);
				s1.selectByValue("2");
				driver.findElement(By.xpath("//button[@class='btn btn-primary w-100 h-100']")).click();
				
				String currentURL8= driver.getCurrentUrl();
				if(currentURL8.equals("https://rescueway.pythonanywhere.com/")) {
					System.out.println("Request is failed");
				}
				else {
					System.out.println("Request is sucessfull");
				
				TakesScreenshot ts=(TakesScreenshot)driver;
				File F=ts.getScreenshotAs(OutputType.FILE);
				Files.copy(F, new File("D:\\project\\requestquote.jpg"));
			
				}
			
}
			public void websiteLogin() {
				
				driver =new ChromeDriver();
				driver.get("https://rescueway.pythonanywhere.com/login/");
				driver.manage().window().maximize();
				
				driver.findElement(By.id("loginEmail")).sendKeys("admin123@gmail.com");
				driver.findElement(By.id("loginPassword")).sendKeys("admin123");
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");
				
				WebElement button= driver.findElement(By.xpath("//button[@type='submit' and text()='Login']"));
				button.click();
				
			}
			
			//TC23
			@Test
			
			public void reportDisaster() throws InterruptedException {
				
				driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[1]")).click();
				
				WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
						
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Report Disaster']")));
				
				driver.findElement(By.xpath("//a[text()='Report Disaster']")).click();
				
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Report a Disaster']")));
				
				WebElement select1=driver.findElement(By.xpath("//select[@id='type']"));
				Select s1=new Select(select1);
				s1.selectByValue("Fire");
				 
				 driver.findElement(By.xpath("//input[@placeholder='Enter the disaster name']")).sendKeys("demodisaster");
				 
				 JavascriptExecutor Js=(JavascriptExecutor)driver;
				 Js.executeScript("window.scroll(0,700)");
				  
				 WebElement location=driver.findElement(By.xpath("//button[text()='Use Current Location']"));
				
				 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", location);
				 Thread.sleep(500); 
				 location.click();
				 
				 WebElement datefield= driver.findElement(By.xpath("//input[@id='date']"));
				
				 Js.executeScript(("arguments[0].value='2025-06-11 15:30';"), datefield);
				 driver.findElement(By.id("description")).sendKeys("this is a demo for automation");
				
				 Js.executeScript("window.scroll(0,1000)");
				 
				 WebElement status=driver.findElement(By.xpath("//select[@id='status']"));
				 Select s2=new Select(status);
				 s2.selectByValue("Resolved");
				 
				 driver.findElement(By.xpath("//button[text()='Submit Report']")).click();
				 
				 String currentURL=driver.getCurrentUrl();
				 

					if(currentURL.contains("https://rescueway.pythonanywhere.com/disaster_list/")) {
						System.out.println("sucessfully Reported disaster Form");
					}
					else {
						System.out.println("Reporting disaster form is failed");
					}	
			}
			
			//TC24
			@Test
			
			public void createAlert() {
				
		       		
				driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[1]")).click();
				
				WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Create Alert']")));
				
				driver.findElement(By.xpath("//a[text()='Report Disaster']")).click();
				
				WebElement selectdisaster= driver.findElement(By.xpath("//select[@name='disaster_id']"));
				Select s1= new Select(selectdisaster);
				s1.selectByValue("6");
				
				driver.findElement(By.xpath("//textarea[@name='alert_message']")).sendKeys("demo alert create");
				driver.findElement(By.xpath("//button[text()='Create Alert']")).click();
				
				String currentURL=driver.getCurrentUrl();
				
				if(currentURL.equals("https://rescueway.pythonanywhere.com/alerts/")) {
					
					System.out.println("alert is created succesfully");
				}
				else {
					System.out.println("alert is not created");
				}
				
			}
			
			//TC25
			@Test
			 
			public void startNewCampaign() {
				

				driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[1]")).click();
				
				WebDriverWait Wait=new WebDriverWait(driver,Duration.ofSeconds(5));
				
				Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Campaign']")));
				driver.findElement(By.xpath("//a[text()='Campaign']")).click();
				
				Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Start a New Fundraising Campaign']")));
				
				driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Demo");
				driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("checking the demo");
				driver.findElement(By.xpath("//input[@id='goal_amount']")).sendKeys("123000");
				
				driver.findElement(By.xpath("//input[@id='end_date']")).sendKeys("23-MAR-2025");
				driver.findElement(By.xpath("//button[text()='Create Campaign']")).click(); 
				
				String currentURL=driver.getCurrentUrl();
				
				if(currentURL.equals("https://rescueway.pythonanywhere.com/campaign_list/")) {
					
					System.out.println("New Campaign is submitted succesfully");
				}
				else {
					System.out.println("New Campaign is not Submitted");
				}
				
				}
			@Test

			public void signupFromHomepage() throws InterruptedException {
			
			driver.findElement(By.xpath("//a[text()='SignUp']")).click();
			
			Thread.sleep(20);
			
			String currentURL=driver.getCurrentUrl();
			
			if (currentURL.contains("https://rescueway.pythonanywhere.com/signup/")) {
			    System.out.println("Redirection successful to SignUp page from Home Page button.");
			} else {
			    System.out.println("Redirection failed to SignUp page from Home Page button . Current URL: " + currentURL);
			}
			}
			
			//TC10
			@Test
			public void signupFromLoginpage() {
				
				driver .navigate().to("https://rescueway.pythonanywhere.com/login/");
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)");
				driver.findElement(By.xpath("//a[text()='Sign up here']")).click();
				
				String currentURL=driver.getCurrentUrl();
				
				if (currentURL.contains("https://rescueway.pythonanywhere.com/signup/")) {
				    System.out.println("Redirection successful to SignUp page.");
				} else {
				    System.out.println("Redirection failed. Current URL: " + currentURL);
				}
				
			}
				//TC11
				@Test
			public void Validsignupfill() {
				
				driver.navigate().to("https://rescueway.pythonanywhere.com/signup/");
			
				driver.findElement(By.name("full_name")).sendKeys("Entridemo");
				driver.findElement(By.name("email")).sendKeys("entridemo@gmail.com");
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)");
				
				driver.findElement(By.name("phone_number")).sendKeys("23456754");
				driver.findElement(By.name("password")).sendKeys("entridemo123");
				driver.findElement(By.name("confirm_password")).sendKeys("entridemo123");
				driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
				
				String currentURL=driver.getCurrentUrl();
				
				if (currentURL.contains("https://rescueway.pythonanywhere.com/login/")) {
				    System.out.println("signup is succesfull");
				} else {
				    System.out.println("signup failed "+ currentURL);
				}
			}
				//TC12
				@Test
			public void signupWithMismatchPasswords() {
				
				driver.navigate().to("https://rescueway.pythonanywhere.com/signup/");
				
				driver.findElement(By.name("full_name")).sendKeys("demo");
				driver.findElement(By.name("email")).sendKeys("demo@gmail.com");
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)");
				
				driver.findElement(By.name("phone_number")).sendKeys("2345456754");
				driver.findElement(By.name("password")).sendKeys("demo123");
				driver.findElement(By.name("confirm_password")).sendKeys("demo9876");
				driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
				
				String currentURL=driver.getCurrentUrl();
				
				if (currentURL.contains("https://rescueway.pythonanywhere.com/login/")) {
				    System.out.println("signup is succesfull");
				} else {
				    System.out.println("signup failed "+currentURL);
				}
			}
				//TC13
				@Test
			public void signupWithEmptyFields() {
				
				driver.navigate().to("https://rescueway.pythonanywhere.com/signup/");
							
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)");
				
				driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
				
				String currentURL=driver.getCurrentUrl();
				
				if (currentURL.contains("https://rescueway.pythonanywhere.com/login/")) {
				    System.out.println("signup is succesfull");
				} else {
				    System.out.println("signup failed "+currentURL);
				}
			}
}