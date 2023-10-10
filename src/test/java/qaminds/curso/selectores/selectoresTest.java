package qaminds.curso.selectores;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class selectoresTest {

    private WebDriver driver; // Creamos una variable de tipo WebDriver, esta variable almacenará la configuracion para acceder al navegador y poder manipular el DOM

    @BeforeTest // Esta anotacion nos indica que este metodo se ejecutara antes que se ejecute el método @Test
    public void beforeTest(){
        // Sustituimos esta linea por la de arriba, así la libreria WebDriverManager se encarga de mandeter actualizado el driver en automatico.
        WebDriverManager.chromedriver().setup();

        // Creamos la instancia del navegador que vamos a utilizar.
        driver = new ChromeDriver();
    }

    @Test
    public void test(){
        // Navegamos a la ruta donde realizaremos la prueba
        driver.get("https://www.microsoft.com/es-mx/");

        String[] menuList = {"Microsoft 365", "Teams", "Windows", "Surface", "Xbox", "Soporte"};

        WebElement menuElement = driver.findElement(By.cssSelector("#uhf-g-nav > ul")); // Buscamos un elemento por By.CssSelector

        // Buscamos un conjunto de elemento por el selector By.TagName es en otras palabras, busca los elementos con el tag llamado 'a'
        List<String> mylist = menuElement.findElements(By.tagName("a")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        assertThat(mylist).contains(menuList); // Comparamos las listas y las validamos.
    }

    @AfterTest // Esta anotacion nos indica que este método se ejecutará despues que se ejecute el método @Test
    public void afterTest(){
        // Cerramos el navegador.
        driver.quit();
    }
}
