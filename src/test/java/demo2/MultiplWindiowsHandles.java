package demo2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultiplWindiowsHandles {
	public static void main(String[] args) {

		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.naukri.com/");
		String parentId=driver.getWindowHandle();
		System.out.println(parentId);
		Set<String> allwindwos=driver.getWindowHandles();
		System.out.println(allwindwos);

	}

}
