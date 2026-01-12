package seleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shadow {
	
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://letcode.in/shadow/");		 
	     WebElement shadowHost = driver.findElement(By.xpath("//*[@id='open-shadow']"));	     
	     SearchContext sc = shadowHost.getShadowRoot();	     
	     WebElement userName = sc.findElement(By.cssSelector("#fname"));
	     userName.sendKeys("Rishi");
	}

}
