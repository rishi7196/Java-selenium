package PracticalScnerios;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FetchTitle {
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions op= new ChromeOptions();
		op.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation"));
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		Thread.sleep(2000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		WebElement title=driver.findElement(By.xpath("(//span[text()='61,900']"
				+ "/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']"
				+ "//span[contains(text(),'Apple iPhone 15 (128 GB) - Black')])[1]"));
		System.out.println(title.getText());
		
		
//		List<WebElement>alltitle=driver.findElements(By.xpath("//span[@class='a-price-whole']/ancestor::span"
//				+ "[//*[contains(text(), 'Apple iPhone ')]]"));
//		
//		for(int i=0;i<alltitle.size();i++)
//		{
//			String title=alltitle.get(i).getText().replaceAll(",", "");
//			System.out.println(title);
//		}
	}

}