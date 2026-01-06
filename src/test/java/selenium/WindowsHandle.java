package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowsHandle {
	
	public static WebDriver driver;	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions op = new ChromeOptions();
        op.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		 driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
		driver.findElement(By.xpath("//button[@onclick='multiwindow()']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		//print all windows ids
		windowHandles.forEach(System.out::println);
		//switch to second windows		
		 String secondWindow = windowHandles.toArray(new String[0])[2];
		 driver.switchTo().window(secondWindow);
		 System.out.println("Swtich to is "+driver.getTitle());
		 
		 //main windoews
		String firstwindows= windowHandles.toArray(new String[0])[0];
		driver.switchTo().window(firstwindows);
		System.out.println("Parents windows "+driver.getTitle());
        
	}
}