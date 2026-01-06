package crossBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTest {
	 WebDriver driver;
	
	@Parameters("browser")
    @BeforeTest
    public void initialize(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
            System.out.println("Launched Chrome browser");
        } 
        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions();
            driver = new EdgeDriver(edgeOptions);
            System.out.println("Launched Edge browser");
        } 
        else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
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