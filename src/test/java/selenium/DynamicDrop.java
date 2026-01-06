package selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicDrop {
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver= new ChromeDriver();
		
		
		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.amazon.in/");
	
	WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

     Thread.sleep(3000);
	search.sendKeys("Apple");
	Thread.sleep(2000);
	for(int i=0;i<=2;i++)
	{
	     search.sendKeys(Keys.ARROW_DOWN);
	}
	search.sendKeys(Keys.ENTER);
	System.out.println(driver.getTitle());
	
	
	}
}