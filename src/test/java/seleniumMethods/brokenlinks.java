package seleniumMethods;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenlinks {
	public static void verifyLinks(String urlLinks) {
		//// Sometimes we may face exception "java.net.MalformedURLException".
		// Keep the code in try catch block to continue the broken link analysis
		try {
			URL link = new URL(urlLinks);
			//// Create a connection using URL object (i.e., link)
			HttpURLConnection conn = (HttpURLConnection) link.openConnection();
			Thread.sleep(2000);
			conn.connect();
			//// use getResponseCode() to get the response code.
			if (conn.getResponseCode() == 200) {
				System.out.println(urlLinks + " -" + conn.getResponseCode());
			}
			if (conn.getResponseCode() == 400) {
				System.out.println(urlLinks + "-" + conn.getResponseCode());
			}
			}catch (Exception e) {
		}
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.selenium.dev/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("total number of links are present on web_page===========" + links.size());
		// step 2: useing for loop for iterate each links
		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			// By using "href" attribute, we could get the url of the requried link
			String url = element.getAttribute("href");
			verifyLinks(url);
		}
	}
}
