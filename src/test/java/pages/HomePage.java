package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By title = By.cssSelector(".title");

    public String getTitleText() {
        return driver.findElement(title).getText();
    }
}