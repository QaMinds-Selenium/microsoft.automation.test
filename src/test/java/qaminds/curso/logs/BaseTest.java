package qaminds.curso.logs;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

@Slf4j
@Getter
public class BaseTest {

    private WebDriver driver;

    @BeforeTest()
    public void beforeTest(){
        log.debug("Entramos al BeforeTest para crear la instancia del navegaddor.");
        try{
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.addArguments("--headless");

            driver = new ChromeDriver(chromeOptions);
        }catch (Exception ex){
            log.error("Que algo paso al intentar configurar el driver del navegador: " + ex.getMessage());
        }
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    public void navigatesTo(String _url){
        log.info("No dirigimos a la pagina :" + _url);
        driver.get(_url);
    }
}