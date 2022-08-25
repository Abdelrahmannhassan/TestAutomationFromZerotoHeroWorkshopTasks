package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class W3SchoolPage {
    // variables
    WebDriver driver;
    String URL = "https://www.w3schools.com/html/html_tables.asp";


    //Locators
    By AustriaField = By.xpath("//td[contains(.,'Austria')]");

    //Default Constructor
    public W3SchoolPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToW3SchoolPage(){
        driver.navigate().to(URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(AustriaField)).getText();
    }

    public String getCountryText(){
        return driver.findElement(AustriaField).getText();
    }
}
