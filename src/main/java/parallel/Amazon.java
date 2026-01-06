package parallel;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Amazon {
	
public WebDriver driver;
	
	@Parameters({"browser","url"})
	@BeforeMethod
	public void SetUp(String browser, String url)
	{
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			if(browser.equals("edge"))
			 driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
	}
	@Test
	public void loginAmazon()
	{
		System.out.println("Amazon Login successfully***********");
		
	}
	
	@Test
	public void AmazonloginTitle()
	{
		System.out.println(driver.getTitle());
		
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}

}



