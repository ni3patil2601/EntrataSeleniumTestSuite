package Entrata.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Test
public class entrataTestCaase {

	private WebDriver driver;

	// Open Chrome
	@BeforeMethod
	public void setup() {
	
		driver = new ChromeDriver();
		driver.manage().window().maximize(); //Maximize the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 

	}

	@AfterMethod
	// Close Chrome	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit(); //Close the driver
		}
	}

		@Test
	  //TestCase1 - Verify the title page of Entrata 
	  public void verifyTitle() {
	  driver.get("https://www.entrata.com"); 
	  String actualTitle=driver.getTitle();
	  String expectedTitle = "Property Management Software | Entrata";
	  AssertJUnit.assertEquals("Title is Match", actualTitle, expectedTitle);
	  
	  }
		@Test
	  //TestCase2 Navigate to watch Demo & Fill Basic details
	  public void watchDemo() throws InterruptedException {
	  driver.get("https://www.entrata.com/");
	  
	  WebElement watchDemoButton = driver.findElement(By.xpath("//div[text()='Watch Demo']")); 
	  Actions actions =  new Actions(driver);
	  actions.moveToElement(watchDemoButton).click().perform();
	  
	  driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("Nitin");
	  driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("Patil");
	  driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("nitin@test.com");
	  driver.findElement(By.xpath("//*[@id=\"Company\"]")).sendKeys("Entrata");
	  driver.findElement(By.xpath("//*[@id=\"Phone\"]")).sendKeys("9879879870");
	  driver.findElement(By.xpath("//select[@id='Unit_Count__c']")).sendKeys("1-10" );
	  driver.findElement(By.xpath("//*[@id=\"Title\"]")).sendKeys("Automation QA");
	  driver.findElement(By.xpath("//*[@id=\"demoRequest\"]")).
	  sendKeys("an Owner/Operator or Property Manager"); 
	  Thread.sleep(7000); // Purpose of this we can look for second what data we send to field.
	  }
		@Test
	  //TestCase3 - Sign in to Entrata  
	  public void signInToEntrata() throws InterruptedException {
	  
	  driver.get("https://www.entrata.com/");
	  
	  WebElement signInButton =  driver.findElement(By.xpath("//a[text()='Sign In']"));
	  Actions actions = new Actions(driver); 
	  actions.moveToElement(signInButton).click().perform();
	  
	  WebElement loginButton = driver.findElement(By.xpath("//div[@class='black_btn-text' and text()='Property Manager Login']"));
	  actions.moveToElement(loginButton).doubleClick().perform();
	  
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin"); //Enter Your Dummy Username
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Admin@123"); //Enter Password
	  driver.findElement(By.xpath("//button[contains(.,'Sign In')]")).click();
	    }
	 
		@Test
	// TestCase4 - Testing/verifying Dynamic Content on Page
	public void testDynamicContentOnPage() throws InterruptedException {

		driver.get("https://web.cvent.com/event/031e5bb8-73cf-4a31-8501-d71a587221f0/regProcessStep1?rt=eE-x7qgzMk2nGPaPFqHUFA");
		Thread.sleep(5000);
		String days = driver.findElement(By.xpath("//*[@id=\"widget:a6e203f6-e698-4375-9bb4-3df387b301be\"]/div/ul/li[1]/div/div/div[2]/div/span")).getText();
		String hours = driver.findElement(By.xpath("//*[@id=\"widget:a6e203f6-e698-4375-9bb4-3df387b301be\"]/div/ul/li[2]/div/div/div[4]/div/span")).getText();
		String minute = driver.findElement(By.xpath("//*[@id=\"widget:a6e203f6-e698-4375-9bb4-3df387b301be\"]/div/ul/li[3]/div/div/div[4]/div")).getText();
		String second = driver.findElement(By.xpath("//*[@id=\"widget:a6e203f6-e698-4375-9bb4-3df387b301be\"]/div/ul/li[4]/div/div/div[3]/div/span")).getText();

		System.out.println("Current Waiting Time: " + days + " days, " + hours + " hours, " + minute + " minutes, "+ second + " seconds");

	}
	
	

}





















