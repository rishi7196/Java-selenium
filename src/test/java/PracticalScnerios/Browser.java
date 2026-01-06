package PracticalScnerios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();	
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.get("https://www.selenium.dev/selenium/web/alerts.html#");		
		driver.findElement(By.xpath("//*[@id='alert']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		
		
		
		
	
	}

}
