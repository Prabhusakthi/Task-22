package Task22;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class NestedFrames{

	    public static void main(String[] args) {
	        // Set the path for the ChromeDriver
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kaleeswari\\eclipse-workspace\\Task22\\src\\main\\java\\Task22\\chromedriver.exe");

	        // Initialize the ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Maximize the browser window
	            driver.manage().window().maximize();

	            // Navigate to the target website
	            driver.get("http://the-internet.herokuapp.com/nested_frames");

	            // Switch to the top frame using CSS Selector
	            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));

	            // Verify that there are three frames within the top frame
	            int topFrameCount = driver.findElements(By.tagName("frame")).size();
	            if (topFrameCount == 3) {
	                System.out.println("There are 3 frames within the top frame.");
	            } else {
	                System.out.println("Frame count verification failed.");
	            }

	            // Switch to the left frame using CSS Selector
	            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-left']")));

	            // Verify that the left frame has text "LEFT"
	            String leftFrameText = driver.findElement(By.tagName("body")).getText();
	            if ("LEFT".equals(leftFrameText.trim())) {
	                System.out.println("Left frame has text: " + leftFrameText);
	            } else {
	                System.out.println("Left frame text verification failed.");
	            }

	            // Switch back to the top frame
	            driver.switchTo().parentFrame();

	            // Switch to the middle frame using CSS Selector
	            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));

	            // Verify that the middle frame has text "MIDDLE"
	            String middleFrameText = driver.findElement(By.id("content")).getText();
	            if ("MIDDLE".equals(middleFrameText.trim())) {
	                System.out.println("Middle frame has text: " + middleFrameText);
	            } else {
	                System.out.println("Middle frame text verification failed.");
	            }

	            // Switch back to the top frame
	            driver.switchTo().parentFrame();

	            // Switch to the right frame using CSS Selector
	            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-right']")));

	            // Verify that the right frame has text "RIGHT"
	            String rightFrameText = driver.findElement(By.tagName("body")).getText();
	            if ("RIGHT".equals(rightFrameText.trim())) {
	                System.out.println("Right frame has text: " + rightFrameText);
	            } else {
	                System.out.println("Right frame text verification failed.");
	            }

	            // Switch back to the top frame
	            driver.switchTo().parentFrame();

	            // Switch to the bottom frame using XPath
	            driver.switchTo().defaultContent();  // Switch back to the main page
	            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-bottom']")));

	            // Verify that the bottom frame has text "BOTTOM"
	            String bottomFrameText = driver.findElement(By.tagName("body")).getText();
	            if ("BOTTOM".equals(bottomFrameText.trim())) {
	                System.out.println("Bottom frame has text: " + bottomFrameText);
	            } else {
	                System.out.println("Bottom frame text verification failed.");
	            }

	            // Switch back to the main page (outside all frames)
	            driver.switchTo().defaultContent();

	            // Verify that the page title is "Frames"
	            String pageTitle = driver.getTitle();
	            if ("Frames".equals(pageTitle))
	            {
	            	System.out.println("Page title is: " + pageTitle);
            } else {
                System.out.println("Page title verification failed.");
            }

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}


