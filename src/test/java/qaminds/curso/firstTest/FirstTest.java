package qaminds.curso.firstTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    private WebDriver driver; // Creamos una variable de tipo WebDriver, esta variable almacenará la configuracion para acceder al navegador y poder manipular el DOM

    @Test // Para crear pruebas con TestNG es necesario el utilizar la anotacion @Test
    public void firstTest(){
        // Esta linea configura manualmente el driver que se descarga, hay que tener el driver en un directorio fijo que no vaya a cambiar
        //System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

        // Sustituimos esta linea por la de arriba, así la libreria WebDriverManager se encarga de mandeter actualizado el driver en automatico.
        WebDriverManager.chromedriver().setup();

        // Creamos la instancia del navegador que vamos a utilizar.
        driver = new ChromeDriver();

        // Navegamos a la ruta donde realizaremos la prueba
        driver.get("https://www.microsoft.com/es-mx/");

        // obtenemos el titulo de la pagina
        String title = driver.getTitle();

        // Validamos el titulo
        Assert.assertEquals(title, "Microsoft: nube, equipos, aplicaciones y juegos", "The title is invalid.");

        // Cerramos el navegador.
        driver.quit();
    }
}
