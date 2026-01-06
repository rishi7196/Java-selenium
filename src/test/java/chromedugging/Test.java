package chromedugging;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {	

		public static void main(String[] args) throws InterruptedException {

			// Set Chrome options
			ChromeOptions op = new ChromeOptions();
			op.setExperimentalOption("debuggerAddress", "localhost:9222");
			op.addArguments("--incognito");
			//op.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			WebDriver driver = new ChromeDriver(op);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.amazon.in");
			
			WebElement searchbox=driver.findElement(By.xpath("//input[@type='text']"));
			searchbox.sendKeys("iphone",Keys.ENTER);
			
		}
}


			