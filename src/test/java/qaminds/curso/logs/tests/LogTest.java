package qaminds.curso.logs.tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import qaminds.curso.logs.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LogTest extends BaseTest {

    /**
     * Crear un Test con logs
     * 1.- www.microsoft.com/es-MX/windows
     * 2.- Usar driver para optener el titulo de la pagina
     * 3.- Validar el titulo
     * 4.- Van dar click sobre 'Optener Windows'
     * 5.- Dar click sobre 'Optener windows 11'
     * 6.- Validar que se vea pagina 'Windows 11'
     */
    @Test
    public void test(){
        log.info("Paso 1: Navegamos a la pagina de Windows en Microsoft");
        navigatesTo("http://www.microsoft.com/es-MX/windows");

        log.info("Paso 2: Validamos el titulo de la pagina");
        assertThat(getDriver().getTitle()).as("El titulo de la pagina no es el esperado.").isEqualTo("Disfruta del poder del SO, computadoras y apps Windows 11 | Microsoft");
        log.info("Resultado paso 2: El titulo de la pagina es correcto.");


    }
}
