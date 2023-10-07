package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowsHomePage {

    private WebDriver driver;

    public WindowsHomePage(WebDriver driver){
        this.driver = driver;
    }

    public WindowsPage onClickOptionWindows(){
        buttonMenuOptionWindows().click();
        return new WindowsPage(driver);
    }

    // WebElements
    public WebElement buttonMenuOptionWindows(){
        return driver.findElement(By.id("shellmenu_2"));
    }
}
