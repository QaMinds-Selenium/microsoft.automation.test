package qaminds.curso.header;

import org.testng.annotations.Test;
import pages.Windows11HomePage;
import pages.WindowsHomePage;
import pages.WindowsPage;
import qaminds.curso.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class Windows11HomeTest extends BaseTest {

    @Test(testName = "Validar Pagina Windows 11 Home ", description = "Validar el boton de compra \"windows 11 home\" en la pagina de windows")
    public void validateWindows11HomePage(){
        //Paso 1 En home dar click en la opcion de windows
        WindowsHomePage whp = new WindowsHomePage(getDriver());
        WindowsPage wp = whp.onClickOptionWindows();

        // Paso 2: Dar click en la opcion optener Windows
        wp.onClickMenuOptionOptenerWindows();

        // Paso 3: Dar click en Comprar Windows 11 Home
        Windows11HomePage w11hp = wp.onClickOptionWindows11Home();

        // Paso 4: cerrar el PopUp
        w11hp.closePopUpSescriber();

        // Paso 5: Validar el titulo del producto
        assertThat(w11hp.labelTitleProductGetText())
                .as("El titulo del producto no es el esperado")
                .isEqualTo("Windows 11 Home (Download)");
    }

}
