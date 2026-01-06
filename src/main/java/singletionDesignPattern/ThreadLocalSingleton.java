package singletionDesignPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadLocalSingleton {
	
	public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private ThreadLocalSingleton() {}//prevent direct instantiation
	
	public static WebDriver getdriver()
	{
		if(driver.get()==null)
		{
			driver.set(new ChromeDriver());
			driver.get().manage().window().maximize();
		}
		return driver.get();
		
	}
	
	
	

}
