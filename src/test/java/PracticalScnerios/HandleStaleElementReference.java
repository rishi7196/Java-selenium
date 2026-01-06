package PracticalScnerios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleStaleElementReference {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
		WebElement doogle=driver.findElement(By.xpath("//*[@class='lnXdpd']"));		
		driver.navigate().refresh();
		try
		{
			doogle.click();
		}catch (StaleElementReferenceException st ) {
			System.out.println("StaleElementReferenceException");
			 doogle=driver.findElement(By.xpath("//*[@class='lnXdpd']"));	
			doogle.click();
			
		}
		
		

	}

}
