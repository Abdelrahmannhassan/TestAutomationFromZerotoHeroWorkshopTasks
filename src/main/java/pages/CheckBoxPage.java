package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage {
    // variables
    WebDriver driver;
    String URL = "http://the-internet.herokuapp.com/checkboxes";


    //Locators
    By CheckBox1 = By.xpath("(//input[@type = 'checkbox'])[1]");
    By CheckBox2 = By.xpath("(//input[@type = 'checkbox'])[2]");


    //default constructor
    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions / keywords
    public void navigateToCheckBoxPage() {
        driver.navigate().to(URL);
    }

    public void clickOnCheckBox1(){
        driver.findElement(CheckBox1).click();
    }

    public boolean CB1Validation(){
        return driver.findElement(CheckBox1).isSelected();
    }
    public boolean CB2Validation(){
        return driver.findElement(CheckBox2).isSelected();
    }
}
