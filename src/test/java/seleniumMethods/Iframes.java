package seleniumMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://practice.expandtesting.com/iframe");
		driver.switchTo().frame("mce_0_ifr");
		Thread.sleep(2000);
		String text=driver.findElement(By.xpath("//*[@id='tinymce']")).getText();
		System.out.println(text);
	}
}
