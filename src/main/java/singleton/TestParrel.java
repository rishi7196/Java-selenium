package singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import singletionDesignPattern.ThreadLocalSingleton;

public class TestParrel {

	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			ThreadLocalSingleton.getdriver();
			driver = new ChromeDriver();
			System.out.println("Chrome launced");
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			ThreadLocalSingleton.getdriver();
			driver= new EdgeDriver();
			System.out.println("Launch edge browser");
		}

	}
	 @Test
	    public void launchCitiBank() {
	        driver.get("https://www.citi.com");
	        String actualTitle = driver.getTitle();
	        System.out.println("Page Title: " + actualTitle);
	        
	        // Using contains() to avoid exact title mismatch issues
	        Assert.assertTrue(actualTitle.contains("Citi"), "Title does not match expected");
	    }

	    @AfterTest
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            System.out.println("Browser closed successfully");
	        }
	    }
	}