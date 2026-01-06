package selenium2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Alert {
	
	public static void main(String[] args) throws InterruptedException {
		
		  ChromeOptions op = new ChromeOptions();
	        op.addArguments("--incognito");
	        op.addArguments("--start-maximized");

	        WebDriver driver = new ChromeDriver(op);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.get("https://practice.expandtesting.com/js-dialogs");
	        Thread.sleep(2000);
	        WebElement alrt=driver.findElement(By.xpath("//button[@id='js-alert']"));
	        JavascriptExecutor js=(JavascriptExecutor)driver;
	        js.executeScript("arguments[0].click();", alrt);
	        driver.switchTo().alert().accept();
	        Thread.sleep(2000);
	        WebElement alertconfirm=driver.findElement(By.id("js-confirm"));
	        js.executeScript("arguments[0].click();", alertconfirm);
	        driver.switchTo().alert().dismiss();
	        
	        //sendkeys
	        WebElement alertPrompt=driver.findElement(By.id("js-prompt"));
	        js.executeScript("arguments[0].click();", alertPrompt);
	        org.openqa.selenium.Alert alert = driver.switchTo().alert();	    
	     alert.sendKeys("Hello from Selenium!");
	     alert.accept();

	       
	        
	        
	}

}
