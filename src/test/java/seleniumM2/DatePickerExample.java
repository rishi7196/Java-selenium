package seleniumM2;	
	import java.time.Duration;
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	public class DatePickerExample {
	    public static void main(String[] args) {

	        // Launch browser
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	        // Navigate to sample date picker page
	        driver.get("https://demoqa.com/date-picker");

	        // Step 1: Click the input to open the calendar
	        WebElement dateInput = driver.findElement(By.id("datePickerMonthYearInput"));
	        dateInput.click();

	        // Step 2: Select Month from dropdown
	        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
	        Select selectMonth = new Select(monthDropdown);
	        selectMonth.selectByVisibleText("August");

	        // Step 3: Select Year from dropdown
	        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
	        Select selectYear = new Select(yearDropdown);
	        selectYear.selectByVisibleText("2025");

	        // Step 4: Select Day
	        List<WebElement> days = driver.findElements(By.className("react-datepicker__day"));
	        for (WebElement day : days) {
	            if (day.getText().equals("15") && day.isDisplayed()) {
	                day.click();
	                break;
	            }
	        }
	        // Optional: Print selected date
	        System.out.println("Selected Date: " + dateInput.getAttribute("value"));

	        // Close browser
	        driver.quit();
	    }
	}


