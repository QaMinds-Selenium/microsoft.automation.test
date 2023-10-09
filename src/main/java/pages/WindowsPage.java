package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitHelper;

import java.time.Duration;

public class WindowsPage {

    private WebDriver driver;
    private WaitHelper wait;

    public WindowsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitHelper(driver);
        wait.waitForElementByBy(By.id("uhfCatLogo"), Duration.ofSeconds(50), Duration.ofSeconds(5));
    }

    public void onClickMenuOptionOptenerWindows(){
        wait.waitForElementByWebElement(buttonMenuOptionOptenerWindows(), Duration.ofSeconds(50), Duration.ofSeconds(5)).click();
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
