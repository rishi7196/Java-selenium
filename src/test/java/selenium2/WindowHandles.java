package selenium2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandles {
	public static void main(String[] args) throws InterruptedException {		
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--incognito");
		op.addArguments("--start-maximized");		
		op.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		WebDriver driver= new ChromeDriver(op);
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Click the link that opens new windows (simulate two clicks for 2 windows)
        WebElement windclick=driver.findElement(By.id("windowButton"));
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click()", windclick);		
        	
        Set<String>windowhandles=driver.getWindowHandles();
        List<String>windows=new ArrayList<>(windowhandles);
        System.out.println("Total Windows  "+windows.size());
        
        //print all titel and window id 
        for(int i=0;i<windows.size();i++)
        {
        	driver.switchTo().window(windows.get(i));
        	System.out.printf("Title: %s | Window ID: %s%n", driver.getTitle(), windows.get(i));

        }
        
        //Switch to the third windows 
        if(windows.size()>=2)
        {
        	driver.switchTo().window(windows.get(1));
        	System.out.println("Wwitch to the third window : "+driver.getTitle());
        }
        //driver.quit();
	}

}
