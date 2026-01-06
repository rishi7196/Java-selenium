package singletionDesignPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
	
		    private static WebDriver driver;
		    // Private constructor to prevent instantiation
		    private WebDriverSingleton() {}

		    public static WebDriver getDriver() {
		        if (driver == null) {
		            driver = new ChromeDriver();
		        }
		        return driver;
		    }

		    public static void closeDriver() {
		        if (driver != null) {
		            driver.quit();
		            driver = null;
		        }
		    }
		
	}


