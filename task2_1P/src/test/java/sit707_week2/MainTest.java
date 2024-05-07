package sit707_week2;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

/**
 * @author Ahsan Habib
 */
public class MainTest {
	
	public MainTest() {
		System.out.println("MainTest");
	}
	
	private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\New folder\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

	
	@Test
	public void testStudentIdentity() {
		String studentId = "223558537";
		Assert.assertNotNull("Student ID is not null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Niwanthi";
		Assert.assertNotNull("Student name is not null", studentName);
	}
	
	@Test
	public void testScenario1() {
	    driver.get("https://www.bunnings.com.au/login");
	    // Scenario 1: Email Field not provided, Password Field provided, Remember Me Checkbox provided, Sign In Button provided
	    // Expected Result: Failure

	    // Find the password input field
	    WebElement passwordElement = driver.findElement(RelativeLocator
	            .with(By.xpath("//input[@name='password']"))
	            .below(By.xpath("//input[@name='username']")));

	    // Enter the password
	    passwordElement.sendKeys("Wa5624feg@k5");

	    // Find the "Remember Me" checkbox using relative locator
	    WebElement rememberMeCheckbox = driver.findElement(RelativeLocator
	            .with(By.tagName("input"))
	            .above(By.id("input42")));

	    // Click the "Remember Me" checkbox
	    rememberMeCheckbox.click();

	    // Find the "Sign in" button using relative locator
	    WebElement signInButton = driver.findElement(RelativeLocator
	            .with(By.id("input42"))
	            .below(By.xpath("//input[@name='password']")));

	    // Click the "Sign In" button
	    signInButton.click();

	    // Verify redirection to failure page or any appropriate validation
	    assertTrue(driver.getCurrentUrl().contains("redirectUri"));
	}
	
	@Test
	public void testScenario2() {
	    driver.get("https://www.bunnings.com.au/login");
	    // Scenario 2: Email Field not provided, Password Field not provided, Remember Me Checkbox provided, Sign In Button provided
	    // Expected Result: Failure

	    // Find the "Remember Me" checkbox using relative locator
	    WebElement rememberMeCheckbox = driver.findElement(RelativeLocator
	            .with(By.tagName("input"))
	            .above(By.id("okta-signin-submit")));

	    // Click the "Remember Me" checkbox
	    rememberMeCheckbox.click();

	    // Find the "Sign in" button and click it without providing email and password
	    WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
	    signInButton.click();

	    // Verify redirection to failure page or any appropriate validation
	    assertTrue(driver.getCurrentUrl().contains("redirectUri"));
	}
    
    @Test
    public void testScenario3() {
        driver.get("https://www.bunnings.com.au/login");
        // Scenario 3: Email Field not provided, Password Field not provided, Remember Me Checkbox not provided, Sign In Button provided
        // Expected Result: Failure

        // Find the "Sign in" button and click it without providing email and password
        WebElement signInButton = driver.findElement(RelativeLocator
            .with(By.id("okta-signin-submit"))
            .below(By.xpath("/html/body/div[1]/div[1]/main/div/div/div[2]/div/div/div[2]/main/div[2]/div/div/form/div[1]/div[2]/div[3]/div/span/div/input")));

        signInButton.click();

        // Verify redirection to failure page or any appropriate validation
        assertTrue(driver.getCurrentUrl().contains("redirectUri"));
    }

    @Test
    public void testScenario4() {
        driver.get("https://www.bunnings.com.au/login");
        // Scenario 4: Email Field not provided, Password Field not provided, Remember Me Checkbox not provided, Sign In Button not provided
        // Expected Result: Failure

        // Find the email input field
        WebElement emailElement = driver.findElement(RelativeLocator
                .with(By.tagName("input"))
                .below(By.xpath("//label[@for='input42']")));

        // Enter the email address
        emailElement.sendKeys("example@example.com");

        // Find the password input field
        WebElement passwordElement = driver.findElement(RelativeLocator
                .with(By.xpath("//input[@name='password']"))
                .below(By.xpath("//input[@name='username']")));

        // Enter the password
        passwordElement.sendKeys("Wa5624feg@k5");

        // Find the Remember Me checkbox and click it
        WebElement rememberMeCheckbox = driver.findElement(By.id("input42"));
        rememberMeCheckbox.click();

        // Find the "Sign in" button and click it without providing email and without Remember Me checkbox
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

        // Verify redirection to failure page or any appropriate validation
        assertTrue(driver.getCurrentUrl().contains("redirectUri"));
    }
    
    @Test
    public void testScenario5() {
        driver.get("https://www.bunnings.com.au/login");
        // Scenario 4: Email Field not provided, Password Field not provided, Remember Me Checkbox not provided, Sign In Button not provided
        // Expected Result: Failure

        // Find the email input field
        WebElement emailElement = driver.findElement(RelativeLocator
                .with(By.tagName("input"))
                .below(By.xpath("//label[@for='input42']")));

        // Enter the email address
        emailElement.sendKeys("example@example.com");

        // Find the password input field
        WebElement passwordElement = driver.findElement(RelativeLocator
                .with(By.xpath("//input[@name='password']"))
                .below(By.xpath("//input[@name='username']")));

        // Enter the password
        passwordElement.sendKeys("123");

        // Find the Remember Me checkbox and click it
        WebElement rememberMeCheckbox = driver.findElement(By.id("input42"));
        rememberMeCheckbox.click();

        // Find the "Sign in" button and click it without providing email and without Remember Me checkbox
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

        // Verify redirection to failure page or any appropriate validation
        assertTrue(driver.getCurrentUrl().contains("redirectUri"));
    }
    
    @Test
    public void testScenario6() {
        driver.get("https://www.bunnings.com.au/login");
        // Scenario 4: Email Field not provided, Password Field not provided, Remember Me Checkbox not provided, Sign In Button not provided
        // Expected Result: Failure

        // Find the email input field
        WebElement emailElement = driver.findElement(By.id("okta-signin-username"));

        // Enter the email address
        emailElement.sendKeys("niwanthiedirisinghe.95@gmail.com");

        // Find the password input field
        WebElement passwordElement = driver.findElement(RelativeLocator
                .with(By.xpath("//input[@name='password']"))
                .below(By.xpath("//input[@name='username']")));

        // Enter the password
        passwordElement.sendKeys("Ado12345#");

        // Find the Remember Me checkbox and click it
        WebElement rememberMeCheckbox = driver.findElement(By.id("input42"));
        rememberMeCheckbox.click();

        // Find the "Sign in" button and click it without providing email and without Remember Me checkbox
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

        // Verify redirection to failure page or any appropriate validation
        assertTrue(driver.getCurrentUrl().contains("redirectUri"));
    }
}
