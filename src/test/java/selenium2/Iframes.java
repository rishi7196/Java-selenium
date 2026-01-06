  package selenium2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Iframes {
	public static void main(String[] args) {
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--incognito");
		op.addArguments("--start-maximized");
		op.setImplicitWaitTimeout(Duration.ofSeconds(30));
		op.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		WebDriver driver= new ChromeDriver(op);
		driver.get("https://webflow.com/made-in-webflow/iframe");
		 List<WebElement>iframes=driver.findElements(By.tagName("iframe"));
		System.out.println("Total number of iframe found :"+iframes.size());
		//for loop to iterate each iframe
		for(int i=0;i<iframes.size();i++)
			
		{
			WebElement iframe=iframes.get(i);
			String title=iframe.getAttribute("title");
		    String id=	iframe.getAttribute("id");
		    System.out.println("Iframe : Title  :"+title+ "  Iframe_ID : "+id);
		}
		
		//switch to second frame
		if(iframes.size()>=2)
		{
			WebElement secondIframe = iframes.get(1);
            String title = secondIframe.getAttribute("title");
            String id = secondIframe.getAttribute("id");
            System.out.println("Switching to 2nd iframe => Title: " + title + " | ID: " + id);
            // Switch to the second iframe
            driver.switchTo().frame(secondIframe);
            driver.findElement(By.xpath("(//*[@type='text'][1])")).sendKeys("abcd");
		}
		driver.switchTo().defaultContent();
	}
}
		
	