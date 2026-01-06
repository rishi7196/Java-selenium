package Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testng {
	
	public static WebDriver driver;
	
	public void test()
	{
		System.out.println("abc");
	}
	
	@Test(priority = -1)
	public void Login()
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
	}
	
	@Test(priority = 1)
	public void Login1()
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
	}
	@Test(priority = 0)
	public void Login2()
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
	}

}
