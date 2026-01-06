package seleniumgrid;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindElemnts {
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in");
		List<WebElement>alllinks=driver.findElements(By.tagName("dd"));
		System.out.println(alllinks.size());
		
		
		WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement login= waits.until(
				(ExpectedConditions.visibilityOfElementLocated(By.id("login"))));
		login.click();
	}

}
