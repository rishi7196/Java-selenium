package selenium;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewWindow {
	public static void main(String[] args) throws InterruptedException {

		// Set Chrome options
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		op.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		WebDriver driver = new ChromeDriver(op);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");

		// Wait for iframes to load
		Thread.sleep(2000);

		// Try all iframes to find the "Stay signed out" button
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("Total iframes found: " + iframes.size());

		boolean clicked = false;

		for (WebElement iframe : iframes) {
			driver.switchTo().frame(iframe);
			try {
				WebElement btn = driver.findElement(By.xpath("//*[contains(text(),'Stay signed out')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
				System.out.println("Clicked 'Stay signed out'");
				clicked = true;
				break;
			} catch (NoSuchElementException e) {
				driver.switchTo().defaultContent(); // go back and try next frame
			}
		}

		if (!clicked) {
			System.out.println("Button not found in any iframe.");
		}

		driver.switchTo().defaultContent(); // Always return to default

		// Now continue with the search box
		driver.findElement(By.name("q")).sendKeys("iPhone", Keys.ENTER);

		// Switch to reCAPTCHA iframe (if present)
		List<WebElement> recaptchaFrames = driver.findElements(By.tagName("iframe"));
		for (WebElement iframe : recaptchaFrames) {
			// reCAPTCHA iframe usually contains "recaptcha" in its src attribute
			if (iframe.getAttribute("src").contains("recaptcha")) {
				driver.switchTo().frame(iframe);

				// Find the checkbox in reCAPTCHA iframe and click using JavaScript
				WebElement checkbox = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
				System.out.println("Clicked reCAPTCHA checkbox");

				// Return to main content
				driver.switchTo().defaultContent();
				break;
			}
		}

		System.out.println(driver.getTitle());
	}
}
