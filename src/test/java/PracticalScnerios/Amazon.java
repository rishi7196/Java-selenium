package PracticalScnerios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in");
		
		List<WebElement> countryName=driver.findElements(By.xpath("//*[@id='nav-xshop-container']"));
		
		for(WebElement wb :countryName)
		{
			System.out.println(wb.getText());
			
		}
	}

}
