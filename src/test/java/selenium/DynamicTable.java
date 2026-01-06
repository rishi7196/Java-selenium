package selenium;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://seleniumpractise.blogspot.com/");
		
		List<WebElement>tabledata=driver.findElements(By.xpath("//table[@id='customers']//tr//td[3]"));
		
		for(WebElement wb:tabledata)
		{
			String s=wb.getText();
			System.out.println(s);
			
			boolean status=false;
			
			if(s.contains("Bhavish "))
			{
				status=true;
				break;
			}
			
			Assert.assertTrue(true);
			
		}
		
}

}
