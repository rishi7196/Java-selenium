package seleniumM2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighlitedElement {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement btnclick=driver.findElement(By.xpath("//button[@type='submit']"));
       
        String backgroundColor = btnclick.getCssValue("background-color");
        System.out.println("Button background color: " + backgroundColor);
        JavascriptExecutor js =((JavascriptExecutor)driver);
        js.executeScript("arguments[0].setAttribute('style', 'background: orange; border: 2px solid red;')", btnclick);
        btnclick.click();
	}

}
