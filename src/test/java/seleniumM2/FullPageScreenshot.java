package seleniumM2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.core.Capture;

public class FullPageScreenshot {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://flipkart.com");
        Shutterbug.shootPage(driver, Capture.FULL_SCROLL, 500, true)
                 .withName("fullpage")
                 .save("./screenshots");
        driver.quit();
    }
}
