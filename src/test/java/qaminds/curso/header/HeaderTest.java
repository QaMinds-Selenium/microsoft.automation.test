package qaminds.curso.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qaminds.curso.BaseTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class HeaderTest extends BaseTest {

    @Test(testName = "Validar el header de Microsft",
        description = "Validar que existan los elementos del header en la pagina principal de Microsoft")
    public void validateHeader(){
        String[] menuList = {"Microsoft 365", "Teams", "Windows", "Surface", "Xbox", "Soporte"};

        WebElement menuElement = getDriver().findElement(By.cssSelector("#uhf-g-nav > ul"));
        List<String> mylist = menuElement.findElements(By.tagName("a")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        assertThat(mylist).contains(menuList);
    }
}
