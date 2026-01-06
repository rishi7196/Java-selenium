package Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class Parameterized {
	
	@Parameters({"URL"})
	public void openUrl(String appUrl)
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("appUrl");
		
	}

}
