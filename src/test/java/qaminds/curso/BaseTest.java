package qaminds.curso;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=375,667");  // Tamaño de pantalla de un iPhone 6/7/8
        chromeOptions.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1");

        driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.microsoft.com/es-mx/");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
