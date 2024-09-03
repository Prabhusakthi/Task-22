package Task22;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import java.util.Set;

	public class WindowHandling {

	    public static void main(String[] args) {
	        // Set the path for the ChromeDriver
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kaleeswari\\eclipse-workspace\\Task22\\src\\main\\java\\Task22\\chromedriver.exe");

	        // Initialize the ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Maximize the browser window
	            driver.manage().window().maximize();

	            // Navigate to the target website
	            driver.get("https://the-internet.herokuapp.com/windows");

	            // Store the original window handle
	            String originalWindow = driver.getWindowHandle();

	            // Locate the "Click Here" button and click it
	            WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
	            clickHereButton.click();

	            // Wait for the new window to open
	            Thread.sleep(10000000);

	            // Switch to the newly opened window
	            Set<String> allWindows = driver.getWindowHandles();
	            for (String windowHandle : allWindows) {
	                if (!windowHandle.equals(originalWindow)) {
	                    driver.switchTo().window(windowHandle);
	                    break;
	                }
	            }

	            // Verify the text "New Window" is present on the page
	            WebElement newWindowText = driver.findElement(By.tagName("h3"));
	            String text = newWindowText.getText();
	            if ("New Window".equals(text)) {
	                System.out.println("Text 'New Window' is present on the new window.");
	            } else {
	                System.out.println("Text verification failed.");
	            }

	            // Close the new window
	            driver.close();

	            // Switch back to the original window
	            driver.switchTo().window(originalWindow);

	            // Verify the original window is active by checking the page title
	            String pageTitle = driver.getTitle();
	            if ("The Internet".equals(pageTitle)) {
	                System.out.println("Successfully switched back to the original window.");
	            } else {
	                System.out.println("Failed to switch back to the original window.");
	            }

	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }
	}



