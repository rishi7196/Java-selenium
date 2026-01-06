package PracticalScnerios;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FetchPriceLowestAndHighest {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		Thread.sleep(2000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		List<WebElement>priceName=driver.findElements(By.xpath("//*[@class='a-price-whole']"));
		Map<WebElement, Integer> map= new HashMap<>();
		for(int i=0;i<priceName.size();i++)
		{
			map.put(priceName.get(i), Integer.parseInt(priceName.get(i).getText().replaceAll(",", "")));
		}
		//convert map to list for sorting
		
		List<java.util.Map.Entry<WebElement, Integer>> le= new ArrayList<Map.Entry<WebElement,Integer>>(map.entrySet());
		le.sort(java.util.Map.Entry.comparingByValue());
		
		//using enhanced loop
		for(java.util.Map.Entry<WebElement, Integer> e: le)
		{
			System.out.println(e.getValue());
		}
		le.get(0).getKey().click();
	     System.out.println(driver.getTitle());
	     driver.quit();
	}
}