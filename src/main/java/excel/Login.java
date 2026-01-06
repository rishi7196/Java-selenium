package excel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		//ExcelData d= new ExcelData();
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//String us=d.GetExcelData("login", 1, 0);
		//driver.findElement(By.xpath("//input[@name='username']")).sendKeys(us);
		
		Thread.sleep(2000);
		//String pw=d.GetExcelData("login", 1, 1);
		//driver.findElement(By.name("password")).sendKeys(pw);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
	}

}
