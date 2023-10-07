package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WindowsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public WindowsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void onClickMenuOptionOptenerWindows(){
        buttonMenuOptionOptenerWindows().click();
    }

    public Windows11HomePage onClickOptionWindows11Home(){
        wait.until(ExpectedConditions.visibilityOf(buttonOptionWindows11Home())); // Si es ta visible manda una exception
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
