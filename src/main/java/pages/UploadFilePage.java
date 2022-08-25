package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadFilePage {
    // variables
    WebDriver driver;
    String URL = "http://the-internet.herokuapp.com/upload";

    //locators
    By ChooseFile = By.xpath("//input[@id = 'file-upload']");
    By UploadBtn = By.xpath("//input[@id = 'file-submit']");
    By UploadText = By.xpath("//div[@class = 'example']//h3[contains(.,'File Uploaded!')]");


    //Default constructor
    public UploadFilePage (WebDriver driver){
        this.driver = driver;
    }

    /////////////////////////////////////////////////////////
    //////////////Business Actions//////////////////////////
    ///////////////////////////////////////////////////////

    public void navigateToUploadPage(){
        driver.navigate().to(URL);
    }

    public void clickToUpload(){
        driver.findElement(ChooseFile).sendKeys("C:\\Users\\Engab\\Desktop\\Squido.PNG");
    }

    public void clickUploadBtn (){
        driver.findElement(UploadBtn).click();
    }

    public String uploadVerification (){
        return driver.findElement(UploadText).getText();
    }

}

