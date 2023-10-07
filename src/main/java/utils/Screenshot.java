package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

    public static String screenshot(WebDriver driver){
        String datetime = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String dirName = "/resources/screenshot/" + datetime;

        String fileName = "screenshot_" + datetime + ".png";

        File directorio = new File(dirName);
        if(!directorio.exists()){
            directorio.mkdirs();
        }

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

//        Path screenshotPath = Paths.get("screenshot_log.png");

        try {
            Files.copy(screenshotFile.toPath(), new File(directorio, fileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new File(directorio, fileName).toPath().toString();
    }
}
