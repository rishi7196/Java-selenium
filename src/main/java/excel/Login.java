package excel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		ExcelReader1 d = new ExcelReader1();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Username → Row 1, Column 0
		String username = d.getData("login", 1, 0);

		// Password → Row 1, Column 1
		String password = d.getData("login", 1, 1);

		System.out.println("Username: " + username);
		System.out.println("Password: " + password);

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(3000);

		driver.quit();
	}
}