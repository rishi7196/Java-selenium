package selenium2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

	    WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://seleniumpractise.blogspot.com/");
		 
		
	}

}
