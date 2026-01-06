package retryAnalyzer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestRetry {
	public static WebDriver driver;
	
	@Test
	public void login()
	{
		System.out.println("This is first login test");
	}

	@Test
	public void Home()
	{
		System.out.println("This is first home test");
	}

	@Test
	public void Search()
	{
		System.out.println("This is first Search test");
	}
	@Test
	public void Logout()
	{
		System.out.println(driver.getTitle());
	}

}
