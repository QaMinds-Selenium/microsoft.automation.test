package qaminds.curso.header;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pages.Windows11HomePage;
import pages.WindowsHomePage;
import pages.WindowsPage;
import qaminds.curso.BaseTest;
import utils.Screenshot;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Windows11HomeTest extends BaseTest {

    @Test(testName = "Validar Pagina Windows 11 Home ", description = "Validar el boton de compra \"windows 11 home\" en la pagina de windows")
    public void validateWindows11HomePage(){
        WindowsHomePage whp = new WindowsHomePage(getDriver());
        log.info("Step assert: Validar que el menu del home, este visible");
//        String[] menuList = {"Microsoft 365", "Teams", "Windows", "Surface", "Xbox", "Soporte"};
//        assertThat(whp.getListMenuOptions()).contains(menuList);
        assertThat(whp.isVisibleMenuList()).isTrue();
        log.info("Step result: El menu del home esta disponible.");

        //Paso 1 En home dar click en la opcion de windows
        log.info("Paso 1: En home dar click en la opción de windows");
        System.out.println(Screenshot.screenshot(getDriver()));
        WindowsPage wp = whp.onClickOptionWindows();

        // Paso 2: Dar click en la opcion optener Windows
        log.info("Paso 2: Dar click en la opcion optener Windows");
        wp.onClickMenuOptionOptenerWindows();

        // Paso 3: Dar click en Comprar Windows 11 Home
        log.info("Paso 3: Dar click en Comprar Windows 11 Home");
        Windows11HomePage w11hp = wp.onClickOptionWindows11Home();

        // Paso 4: cerrar el PopUp
        log.info("Paso 4: cerrar el PopUp");
        w11hp.closePopUpSescriber();

        // Paso 5: Validar el titulo del producto
        log.info("Paso 5: Validar el titulo del producto");
        assertThat(w11hp.labelTitleProductGetText())
                .as("El titulo del producto no es el esperado")
                .isEqualTo("Windows 11 Home (Download)");
    }

}
