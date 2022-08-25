package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {
	//variables
	WebDriver driver;
	
	//locators
	By resultState = By.id("result-stats");
	
	//Contractors
	public ResultPage(WebDriver driver) {
		this.driver = driver;
	}
	

	//actions / keywords
	public String SearchResults() {
		return driver.findElement(resultState).getText();
	}
	
}
