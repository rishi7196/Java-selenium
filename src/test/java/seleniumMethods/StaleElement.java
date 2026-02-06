package seleniumMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaleElement {

    @Test
    public void staleElement() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.google.com");

        WebElement textarea = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));

        driver.navigate().refresh();

        try {
            textarea.sendKeys("apple");   // ❌ stale
        } catch (StaleElementReferenceException e) {

            // Re-locate and REASSIGN
            textarea = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
            textarea.sendKeys("apple");   // 
        }

        driver.quit();
    }
}
