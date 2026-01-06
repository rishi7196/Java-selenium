package PracticalScnerios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Flipkart {
	
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		
		//List<WebElement> counts = driver.findElements(By.xpath("//*[@class='navFooterLine navFooterLinkLine navFooterPadItemLine']//li"));
		List<WebElement> Text = driver.findElements(By.xpath("//*[@class='_3sdu8W emupdz']//span//span"));
		
		for(WebElement wb:Text)
		{
			
			String text=wb.getText();
			System.out.println(text);
			
			boolean flag=false;
			if(text.contains("Travel"))
			{
				flag=true;
				break;				
			
			}
			Assert.assertTrue(true,"+Fashion is found");
		}
		
	}
}
			