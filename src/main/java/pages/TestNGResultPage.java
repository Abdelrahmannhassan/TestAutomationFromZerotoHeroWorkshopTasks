package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestNGResultPage {
	// variables
	WebDriver driver;
	String url = "https://www.google.com/";

	// Locators
	By searchTextField = By.name("q");
	By forthResults = By.xpath("//h3[@class = 'LC20lb MBeuO DKV0Md'][contains(., 'TestNG - Wikipedia')]");

	// default constractor
	public TestNGResultPage(WebDriver driver) {
		this.driver = driver;
	}

	// Actions
	public void navigateToGooglePage() {
		driver.navigate().to(url);
	}

	public void TestNGTask(String text) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.presenceOfElementLocated(searchTextField)).sendKeys(text + Keys.ENTER);
	}

	public String getTestNGText() {
		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(forthResults)).getText();
	}
}
