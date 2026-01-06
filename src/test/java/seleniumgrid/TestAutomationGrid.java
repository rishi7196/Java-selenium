package seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestAutomationGrid {
	
	public WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browserType) throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if(browserType.equalsIgnoreCase("chrome"))
		{
			capabilities.setBrowserName("chrome");
			System.out.println("################Test case execution started ===>");
		}
		else if (browserType.equalsIgnoreCase("firefox")) {
			capabilities.setBrowserName("firefox");
			System.out.println("################Test case execution started ===>"+browserType);
		}
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	}
	
	@Test
	public void getOnChromeTest()
	{
		driver.get("https://www.google.com");
		Assertion a= new Assertion();
		a.assertEquals(driver.getTitle(), "Google","WRONG PAGE TITLE");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void flipkart()
	{
		driver.get("https://www.google.com");
		Assertion a= new Assertion();
		a.assertEquals(driver.getTitle(), "Google","WRONG PAGE TITLE");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void flipkart1()
	{
		driver.get("https://www.google.com");
		Assertion a= new Assertion();
		a.assertEquals(driver.getTitle(), "Google","WRONG PAGE TITLE");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void closeDriver()
	{
		System.out.println("################## TEST CASE EXECUTION ENDED!!!!!!!!!!!!!");
		if (driver != null) {
            driver.quit();
        }
	}

}
