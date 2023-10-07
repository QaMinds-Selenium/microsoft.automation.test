package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowsPage {

    private WebDriver driver;

    public WindowsPage(WebDriver driver){
        this.driver = driver;
    }

    public void onClickMenuOptionOptenerWindows(){
        buttonMenuOptionOptenerWindows().click();
    }

    public Windows11HomePage onClickOptionWindows11Home(){
        buttonOptionWindows11Home().click();
        return new Windows11HomePage(driver);
    }

    // WebElements
    private WebElement buttonMenuOptionOptenerWindows(){
        return driver.findElement(By.id("c-shellmenu_58"));
    }

    private WebElement buttonOptionWindows11Home(){
        return driver.findElement(By.id("c-shellmenu_63"));
    }
}
