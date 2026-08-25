package excel;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class Login2 {

    public static void main(String[] args) throws IOException {

        ExcelReader1 excel = new ExcelReader1();

        for (int i = 1; i <= excel.getRowCount("login"); i++) {

            String user = excel.getData("login", i, 0);
            String pass = excel.getData("login", i, 1);

            WebDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            try {
                driver.manage().window().maximize();

                driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.name("username"))).sendKeys(user);

                driver.findElement(By.name("password")).sendKeys(pass);

                driver.findElement(By.cssSelector("button[type='submit']")).click();

                wait.until(ExpectedConditions.urlContains("dashboard"));

                System.out.println("Test " + i + " PASS : " + user);

            } finally {
                driver.quit();
            }
        }
    }
}