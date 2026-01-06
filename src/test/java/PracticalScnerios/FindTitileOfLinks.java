package PracticalScnerios;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindTitileOfLinks {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		List<String> LinkTest= new ArrayList<>();
		for(WebElement link:links)
		{
			String href=link.getAttribute("href");
			if(href!=null && href.startsWith("https"))
			{
				LinkTest.add(href);
				if(LinkTest.size()==10)break;
			}
		}
		//
		for(String link : LinkTest)
		{
			driver.navigate().to(link);
			System.out.println("Title of page "+driver.getTitle());
			driver.navigate().back();
		}
		driver.quit();

	}
}