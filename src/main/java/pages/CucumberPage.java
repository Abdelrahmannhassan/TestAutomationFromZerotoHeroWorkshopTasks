package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CucumberPage {
	// variables
	WebDriver driver;

	// Locators
	By searchTextField = By.name("q");
	By cucumberResult = By.xpath("(//h3[contains( .,'Cucumber (software) - Wikipedia')]" +
			"[@class = 'LC20lb MBeuO DKV0Md'])[2]");
	
	// default constractor
	public CucumberPage(WebDriver driver) {
		this.driver = driver;
	}

  	//Actions

	
	public void searchForQuery(String text) {
		driver.findElement(searchTextField).sendKeys(text + Keys.ENTER);
	}
	
	public void enterSecondResults() {
		driver.findElement(cucumberResult).click();
	}
	
	public  String getCurrentURL() {
		return driver.getCurrentUrl();
	}
}
