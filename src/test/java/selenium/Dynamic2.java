package selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Dynamic2 {
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		WebDriver driver = new ChromeDriver(op);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.co.in/");

		// Enter search query
		driver.findElement(By.name("q")).sendKeys("selenium");

		// Wait for suggestions to load
		Thread.sleep(2000);

		// Locate auto-suggestions
		List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));

		// Print suggestions
		System.out.println("Search Suggestions:");
		for (WebElement option : allOptions)
			if (option.getText().equalsIgnoreCase("selenium rich foods")) {
				option.click();
				break;				
			}
		System.out.println(driver.getTitle());
	}
}