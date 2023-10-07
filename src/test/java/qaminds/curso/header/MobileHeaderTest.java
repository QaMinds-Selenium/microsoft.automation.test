package qaminds.curso.header;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qaminds.curso.BaseTest;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class MobileHeaderTest extends HeaderTest {

    @Test(testName = "Validar el header de Microsft", description = "Validar que existan los elementos del header en la pagina principal de Microsoft")
    public void validateHeader() {
        String[] menuList = {"Microsoft 365", "Teams", "Windows", "Surface", "Xbox", "Soporte"};
        String[] submenulist = {"Software", "PCs & Devices", "Entertainment", "Business", "Developer & IT", "Other"};

        WebElement toggleMenu = getDriver().findElement(By.cssSelector("button.c-action-trigger.c-glyph.glyph-global-nav-button"));
        toggleMenu.click();

        WebElement menuElement = getDriver().findElement(By.cssSelector("#uhf-c-nav > ul > li > div > ul > li.c-w0-contr > ul"));

        //Explicit
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));//5
        wait.until(ExpectedConditions.visibilityOfAllElements(menuElement.findElements(By.tagName("a"))));

        //Implicit
        try {
            Thread.sleep(10000);//5000
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<String> mylist = menuElement.findElements(By.tagName("a")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<WebElement> secondList = getDriver().findElements(By.cssSelector("#uhf-c-nav > ul li.f-sub-menu > button"));

        wait.until(ExpectedConditions.elementToBeClickable(secondList.get(0)));
//        scroll(secondList.get(5));

        List<String> mylist2 = secondList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        assertThat(mylist2).contains(submenulist);

        assertThat(mylist).contains(menuList);
    }

//    public void scroll(WebElement element){
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        js.executeScript("window.scrollBy(0,500)");
//        js.executeScript("arguments[0].scrollIntoView();", element);
//    }
}
