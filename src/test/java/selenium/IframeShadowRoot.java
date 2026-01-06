package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeShadowRoot {
	
public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		
		//swtich the iframe
		//driver.switchTo().frame("pact1");
		JavascriptExecutor js= (JavascriptExecutor)driver;		
		WebElement fna=(WebElement) js.executeScript("return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")");
		
		fna.sendKeys("Rishi Kumar");
}


		

}
