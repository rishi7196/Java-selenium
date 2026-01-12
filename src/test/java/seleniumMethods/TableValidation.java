package seleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.List;
import java.time.Duration;

public class TableValidation {
    public static void main(String[] args) {
        
              WebDriver driver = new ChromeDriver();
            driver.get("https://example.com/table-page");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Locate the table
            WebElement table = driver.findElement(By.id("tableID"));

            // Validate Row Count
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            int expectedRowCount = 5;
            Assert.assertEquals(rows.size(), expectedRowCount, "Row count does not match!");

            // Validate Specific Cell Data (2nd row, 3rd column)
            WebElement specificCell = driver.findElement(By.xpath("//table[@id='tableID']//tr[2]/td[3]"));
            Assert.assertEquals(specificCell.getText(), "Expected Value", "Cell data mismatch!");

            // Check if a Specific Value Exists
            List<WebElement> cells = table.findElements(By.tagName("td"));
            boolean valueExists = cells.stream().anyMatch(cell -> cell.getText().equals("Target Value"));
            Assert.assertTrue(valueExists, "Value not found in the table!");

            // Validate Entire Table Data (Example: Checking first row headers)
            List<WebElement> headers = driver.findElements(By.xpath("//table[@id='tableID']//th"));
            String[] expectedHeaders = {"ID", "Name", "Age"};
            for (int i = 0; i < headers.size(); i++) {
                Assert.assertEquals(headers.get(i).getText(), expectedHeaders[i], "Header mismatch at index " + i);
            }

            System.out.println("✅ Table validation successful!");

    }
}
