package selenium2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import singleton.WebDriverSingleton;

public class IframeTest {
	public WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=WebDriverSingleton.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo.automationtesting.in/Frames.html");
		List<WebElement>frames=driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for(int i=0;i<frames.size();i++)
		{
			WebElement iframes=frames.get(i);
			String title=iframes.getAttribute("title");
			String ids=iframes.getAttribute("id");
			System.out.println("Iframe : Title  :"+title+ "  Iframe_ID : "+ids);
		}
		
		if(frames.size()>=1)
		{
			WebElement secondIframe = frames.get(0);
			String id = secondIframe.getAttribute("id");
			driver.switchTo().frame(secondIframe);
			Thread.sleep(2000);
            driver.findElement(By.xpath("(//*[@type='text'][1])")).sendKeys("abcd");

		}
		driver.switchTo().defaultContent();


		
		
	}

}
