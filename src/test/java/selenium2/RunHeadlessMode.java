package selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunHeadlessMode {
	static WebDriver driver;
	public static void main(String[] args) {
		
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--headless");
		op.addArguments("--window-size=1920,1080");
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(op);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
	}

}
