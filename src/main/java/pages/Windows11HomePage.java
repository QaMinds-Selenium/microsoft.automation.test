package pages;

import chunks.PopUpSuscriberChunk;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Windows11HomePage {

    private WebDriver driver;

    public Windows11HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void closePopUpSescriber(){
        new PopUpSuscriberChunk(driver).onClickButtonClose();
    }

    public String labelTitleProductGetText(){
        return labelTitleProduct().getText();
    }

    // WebElements
    private WebElement labelTitleProduct(){
        return driver.findElement(By.cssSelector("div.buy-box-middle-col.col-lg-6.col-xl-7 > div > h1"));
    }
}
