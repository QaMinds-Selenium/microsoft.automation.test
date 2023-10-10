package qaminds.curso.implementAnnotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsTest {

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

        // obtenemos el titulo de la pagina
        String title = driver.getTitle();

        // Validamos el titulo
        Assert.assertEquals(title, "Microsoft: nube, equipos, aplicaciones y juegos", "The title is invalid.");
    }

    @AfterTest // Esta anotacion nos indica que este método se ejecutará despues que se ejecute el método @Test
    public void afterTest(){
        // Cerramos el navegador.
        driver.quit();
    }
}
