package demo2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicTable {
	public static void main(String[] args) {
		
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://seleniumpractise.blogspot.com/");
		
		List<WebElement> alldata=driver.findElements(By.xpath("//table[@id='customers']"));
		 boolean status=false;
		for(WebElement wb: alldata)
		{
			String data=wb.getText();
			System.out.println(data);
		 
		if(data.contains("Amazon Jeff Bezos USA Know More"))
		{
			System.out.println("Data persent in table");
			status=true;
			break;
		}
		
		}
		if(!status)
		{
			System.out.println("data is  not present");
			
		}
		driver.quit();
	}
}