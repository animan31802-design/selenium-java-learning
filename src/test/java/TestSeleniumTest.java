import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSeleniumTest {
    @Test
    public void loginTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        driver.findElement(By.name("login-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("app_logo")));
            System.out.println("Element found → Login successful");
        } catch (TimeoutException e) {
            System.out.println("Element NOT found → Login failed or page not loaded");
        }

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("inventory"),
                "Login failed: URL does not contain inventory");

        System.out.println("Login Successful!");

        driver.quit();
    }

    @Test
    public void loginStandardTest() {
        // loginStandardTest Test Commit
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        var userNameField = driver.findElement(By.id("user-name"));
        var passwordField = driver.findElement(By.name("password"));

        userNameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        driver.findElement(By.cssSelector("input#login-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            var testElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("app_logo")));
        }catch (TimeoutException e){
            Assert.fail("Element not visible → Login failed");
        }

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"),
                "URL does not contain inventory → Login failed");

        String pageTitle = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertTrue(pageTitle.equalsIgnoreCase("products"),
                "Login failed: Title is incorrect");

        System.out.println("Login Successful");

        driver.quit();
    }
}