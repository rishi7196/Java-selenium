package seleniumM2;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

import singletionDesignPattern.DriverManager;

import java.util.List;

	public class AmazonSearchTest {

	    public static void main(String[] args) {
	       
	        WebDriver driver = DriverManager.INSTANCE.getDriver();

	        try {
	            // 2. Open website
	            driver.get("https://www.amazon.in");
	            driver.manage().window().maximize();

	            // 3. Search for a product
	            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	            searchBox.sendKeys("laptop");
	            searchBox.submit();

	            // 4. Wait for results to load
	            Thread.sleep(3000); // Replace with WebDriverWait for real tests

	            // 5. Apply filter (e.g., brand "HP")
	            // NOTE: This selector may need adjusting based on the page layout
	            try {
	                WebElement hpFilter = driver.findElement(By.xpath("//span[text()='HP']"));
	                hpFilter.click();
	                Thread.sleep(3000);
	            } catch (Exception e) {
	                System.out.println("⚠️ HP filter not found or clickable.");
	            }

	            // 6. Collect and display results
	            List<WebElement> productTitles = driver.findElements(By.cssSelector("h2 a span"));
	            List<WebElement> productPrices = driver.findElements(By.cssSelector(".a-price-whole"));

	            System.out.println("\n📦 Search Results:");
	            for (int i = 0; i < Math.min(productTitles.size(), productPrices.size()); i++) {
	                System.out.println("Product: " + productTitles.get(i).getText());
	                System.out.println("Price: $" + productPrices.get(i).getText());
	                System.out.println("-------------------------");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // 7. Close browser
	            driver.quit();
	        }
	    }
	
}
