package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitHelper;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;


public class WindowsHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public WindowsHomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WindowsPage onClickOptionWindows(){
        buttonMenuOptionWindows().click();
        return new WindowsPage(driver);
    }

    public boolean isVisibleMenuList(){
        return wait.until(ExpectedConditions.visibilityOf(listMenuOptions())).isDisplayed(); //
    }

    public List<String> getListMenuOptions(){
        return listMenuOptions().findElements(By.tagName("a")).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // WebElements
    private WebElement buttonMenuOptionWindows(){
        return listMenuOptions().findElement(By.id("shellmenu_2"));
        //return driver.findElement(By.id("shellmenu_2"));
    }

    private WebElement listMenuOptions(){
        return driver.findElement(By.cssSelector("#uhf-g-nav > ul"));
    }
}
