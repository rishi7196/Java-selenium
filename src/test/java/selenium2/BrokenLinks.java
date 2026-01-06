package selenium2;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	public static void verifyLinks(String urlLinks) throws IOException, InterruptedException {
		
		URL url=new URL(urlLinks);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		Thread.sleep(2000);
		con.connect();
		if(con.getResponseCode()==200)
		{
			System.out.println(urlLinks + " -" + con.getResponseCode());
		}
		if(con.getResponseCode()==400)
		{
			System.out.println(urlLinks + " -" + con.getResponseCode());
		}
		
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        List<WebElement> urlinks=driver.findElements(By.tagName("a"));
        for(int i=0;i<urlinks.size();i++)
        {
             WebElement elemnt=urlinks.get(i);
            String url= elemnt.getAttribute("href");  
            verifyLinks(url);
        }
	}
	
	

}
