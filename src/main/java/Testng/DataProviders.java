package Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import singleton.TestSingleton;
import singleton.WebDriverSingleton;

public class DataProviders {
	
	@Test (dataProvider = "datasupply")
	public void Login(String username,String password)
	{
		
		 WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println(driver.getTitle());
		driver.quit();
		System.out.println("Running test with: " + username + " | Thread: " + Thread.currentThread().getId());


	}

	
	@DataProvider(name="datasupply")
	public Object[][] dataSiplliers()
	{
		Object[][] data= {{"admin","admin123"},{"admin","admin123"},{"admin","admin123"},{"admin","admin123"}};
		return data;
	}
}
