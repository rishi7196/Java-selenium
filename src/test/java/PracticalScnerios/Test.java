package PracticalScnerios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test {
	
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("");
		
		List<WebElement>text=driver.findElements(By.xpath("pass expath"));
		for(WebElement wb : text)
		{
			String st= wb.getText();
			System.out.println(st);
			
			boolean status= false;
			if(st.contains("India"))
			{
				status=true;
				break;
			}
			Assert.assertTrue(status, st);
			}
		}
	}


