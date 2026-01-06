package singleton;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class TestSingleton {
	
	public static void main(String[] args) {
		
	   WebDriver driver= WebDriverSingleton.getDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   driver.get("https://www.citi.com");
	   
	   WebDriverSingleton.closeDriver();
	}

}
