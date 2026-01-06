package selenium;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleOfLinks {
	public static void main(String[] args) {
       
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.linkedin.com/"); // Replace with actual URL
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        // Loop through first 10 links
        for (int i = 0; i < Math.min(links.size(), 10); i++) {
        	 WebElement link = driver.findElements(By.tagName("a")).get(i);
             String linkUrl = link.getAttribute("href");

            // Open in the same window (without clicking)
            driver.navigate().to(linkUrl);
            try {
            	 WebElement closeBtn = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
            	    closeBtn.click();
            } catch (NoSuchElementException e) {
                // No popup found — ignore
            }
            System.out.println("Title of link " + (i + 1) + ": " + driver.getTitle());

            // Go back to original page
            driver.navigate().back();
        }

        driver.quit();
    }
}