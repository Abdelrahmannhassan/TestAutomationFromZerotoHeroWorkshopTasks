package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePage {
	// variable
	WebDriver driver;
	String url = "https://www.google.com/";

	// locators
	By googleLogo = By.className("lnXdpd");
	By searchTextField = By.name("q");

	// default contractors
	public GooglePage(WebDriver driver) {
		this.driver = driver;
	}

	
	//Actions / keywords
	public void navigateToHomePage() {
		driver.navigate().to(url);
	}

	public boolean checkTheGoogleLogo() {
		return driver.findElement(googleLogo).isDisplayed();

	}
	
	public String getTitleOfThePage() {
		return driver.getTitle();
	}
	
	
	public void searchForQuery(String query) {
		driver.findElement(searchTextField).sendKeys(query + Keys.ENTER);
	}

	

}
