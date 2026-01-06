package selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IgnorChromePopup {
	public static void main(String[] args) {
		
        ChromeOptions op = new ChromeOptions();
        op.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Hide message
        op.addArguments("--incognito");       
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

}
