package Metodoak;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoggerUtilTest {

    private static final String LOG_FILE = "login.log";

    @BeforeEach
    void setUp() throws IOException {
        // Limpiar el archivo antes de cada prueba
        Files.deleteIfExists(Paths.get(LOG_FILE));
    }

    @Test
    void testGuardarLog() throws IOException {
        String usuario = "testUser";
        String nombre = "Test Nombre";

        // Llamar al método a probar
        LoggerUtil.guardarLog(usuario, nombre);

        // Verificar que el archivo exista
        assertTrue(Files.exists(Paths.get(LOG_FILE)), "El archivo de log debe existir");

        // Leer el contenido del archivo
        List<String> lineas = Files.readAllLines(Paths.get(LOG_FILE));
        assertFalse(lineas.isEmpty(), "El archivo de log no debe estar vacío");

        // Verificar que la línea contiene los datos esperados
        String ultimaLinea = lineas.get(lineas.size() - 1);
        assertTrue(ultimaLinea.contains("Usuario: " + usuario), "La línea debe contener el usuario");
        assertTrue(ultimaLinea.contains("Nombre: " + nombre), "La línea debe contener el nombre");
        assertTrue(ultimaLinea.contains("Fecha: "), "La línea debe contener la fecha");
    }
}
