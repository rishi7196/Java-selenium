package selenium2;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DatePicker {
	public static void main(String[] args) {	
		
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--incognito");
		op.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		WebDriver driver= new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		//method 1 using sendkeys 
		//method 2 : date picker
		String year="2026";
		String month="may";
		String date="8";
		driver.findElement(By.id("datepicker")).click();
		
		while(true)
		{
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (currentMonth.equalsIgnoreCase(month) && currentYear.equals(year)) {
			    break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		//select the date 
		List<WebElement>alldates=driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']//tbody/tr/td"));
		{
			for(WebElement dt:alldates)
			{
				if(dt.getText().equals(date))
				{
					dt.click();
					break;
				}
			}
		}
		
	}
}