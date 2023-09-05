import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WsecuLogin {

	public static void main(String[] args)throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		

		// Launch The  Chrome Browser and Navigate to website
		driver.get("http://www.wsecu.com");
		driver.manage().window().maximize();

		// Enter incorrect username
		driver.findElement(By.name("username")).sendKeys("thisuserwillnotwork");
		// click Sign in button
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(5000); 

		// Verifying URL is matching
		String actualURLtext = driver.getCurrentUrl();
		String expectedURLtext = "https://digital.wsecu.org/banking/signin";
		if (actualURLtext.equals(expectedURLtext)) {
			System.out.println("Verifiying user is redirected to WSECU website");
		} else {
			System.out.println("URL does NOT match");
		}

			
		driver.findElement(By.name("password"))
		.sendKeys("thisuserwillnotwork");
		// click sign in button
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sign-in ng-binding']")).click();
	
		Thread.sleep(5000);

		// Get the text from website
		String expectedMessage = "Sorry, incorrect username.";
		String actualMessage = driver.findElement(By.xpath("//div[@class='ng-binding ng-scope']")).getText();
		Thread.sleep(5000);
		// Verify "Sorry, incorrect username." message
		if (expectedMessage.equals(actualMessage)) {
			System.out.println("Verify error message recieved  ---->" + expectedMessage);
		} else {
			System.out.println("Error Message does NOT recieved");
		}

		driver.close();

	}
	

	}


