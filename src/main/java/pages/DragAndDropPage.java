package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    // variables
    WebDriver driver;

    String url = "https://jqueryui.com/resources/demos/droppable/default.html";

    //Locators
    By DragBox = By.id("draggable");
    By DropHere = By.id("droppable");

    By DroppedText = By.xpath("//p[contains(.,'Dropped!')]");
    //Default Constructor
    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
    }

    // Actions
    public void navigateToDragAndDropPage() {
        driver.navigate().to(url);
    }

    public void DragMeThere (){
        Actions Drag = new Actions(driver);
        Drag.dragAndDrop(driver.findElement(DragBox), driver.findElement(DropHere)).build().perform();

    }
    public String getDroppedText(){
        return driver.findElement(DroppedText).getText();
    }
}
