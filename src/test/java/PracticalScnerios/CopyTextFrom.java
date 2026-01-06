package PracticalScnerios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyTextFrom {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//step 1 use acction class
		Actions ac= new Actions(driver);
		//step 2 findele,nt source and taget
		WebElement source= driver.findElement(By.name("username"));
		WebElement taget= driver.findElement(By.name("password"));
		
		//Step 3 enter the text 1 
		ac.moveToElement(source).click().sendKeys("admin");
		
		ac.keyDown(Keys.CONTROL).sendKeys("a");
		ac.sendKeys("x");
		Thread.sleep(4000);
		
		//step 4 click inside text 2 and press ctrl +v 
		
		ac.moveToElement(taget).click().keyDown(Keys.CONTROL).sendKeys("v");
		Thread.sleep(4000);
		
		//step 5 realse the keys and build and perform
		
		ac.keyUp(Keys.CONTROL).build().perform();
	}

}
