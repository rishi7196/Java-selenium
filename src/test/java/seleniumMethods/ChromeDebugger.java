package seleniumMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDebugger {
	
	public static void main(String[] args) {
		
		ChromeOptions op = new ChromeOptions();
        op.setExperimentalOption("debuggerAddress", "localhost:9222");  // 

        WebDriver driver = new ChromeDriver(op);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");  // 
    }
}
