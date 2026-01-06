/**
 * 
 */
package selenium2;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author HP
 *
 */
public class OpenNewWindow {
	public static void main(String[] args) {
		
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--incognito");
		op.addArguments("--start-maximized");
		WebDriver driver= new ChromeDriver(op);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.open();");
//		ArrayList<String> tabs= new ArrayList<>(driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(1));
//		driver.get("https://google.com");
//		WebElement input =driver.findElement(By.name("q"));
//		input.sendKeys("apple",Keys.ENTER);		
	
	}

}
