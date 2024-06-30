import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleCloudPricingCalculatorTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testGoogleCloudPricingCalculator() {
        driver.get("https://cloud.google.com/");

        WebElement searchButton = driver.findElement(By.xpath("//button[@aria-label='Open search bar']"));
        searchButton.click();

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
        searchInput.sendKeys(Keys.RETURN);

        WebElement calculatorLink = driver.findElement(By.xpath("//a[text()='Google Cloud Platform Pricing Calculator']"));
        calculatorLink.click();

        // Switch to the calculator iframe
        driver.switchTo().frame("myFrame");

        WebElement computeEngineTab = driver.findElement(By.xpath("//md-tab-item/div[text()='Compute Engine']"));
        computeEngineTab.click();

        // Fill the form
        fillComputeEngineForm();

        WebElement addToEstimateButton = driver.findElement(By.xpath("//button[contains(text(),'Add to Estimate')]"));
        addToEstimateButton.click();

        WebElement emailEstimateButton = driver.findElement(By.xpath("//button[contains(text(),'Email Estimate')]"));
        emailEstimateButton.click();

        // Open Yopmail in a new tab
        switchToNewTab();

        // Get the generated email address
        String generatedEmail = getYopmailEmail();

        // Switch back to the calculator tab
        switchToFirstTab();

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='description']"));
        emailInput.sendKeys(generatedEmail);

        WebElement sendEmailButton = driver.findElement(By.xpath("//button[contains(text(),'SEND EMAIL')]"));
        sendEmailButton.click();

        // Add assertions or validation as needed
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    // Implement helper methods for actions within the form, switching tabs, etc.
    // ...

}
