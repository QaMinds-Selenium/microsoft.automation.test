package chunks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpSuscriberChunk {

    private WebDriver driver;

    public PopUpSuscriberChunk(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(buttonClose()));
    }

    public void onClickButtonClose(){
        buttonClose().click();
    }

    // WebElemets
    private WebElement buttonClose(){
        return driver.findElement(By.cssSelector("#emailSup-modal div.modal-header > button"));
    }
}
