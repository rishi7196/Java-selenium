package selenium;

import static org.junit.Assert.assertArrayEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	// ccrreating main method
	@Test(invocationCount = 5)
	public void loginTest() throws InterruptedException {
		 
		 //selenium code
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 
		 driver.findElement(By.name("username")).sendKeys("admin");
		 driver.findElement(By.name("password")).sendKeys("admin123");
		 driver.findElement(By.xpath("//*[@type='submit']")).click();
		 Thread.sleep(2000);
		 String actual="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		 String expected=driver.getCurrentUrl();
		 Assert.assertEquals(actual, expected);
		 
		 driver.close();
		 
		 
		
	}

}

