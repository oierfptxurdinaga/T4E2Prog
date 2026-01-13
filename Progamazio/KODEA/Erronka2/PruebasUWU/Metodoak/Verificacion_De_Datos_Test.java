package Metodoak;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Verificacion_De_Datos_Test {

    @Test
    void usuarioYPasswordValidos() {
        assertTrue(VerificacionDeDatos.verificarDatos("user", "1234"));
    }

    @Test
    void usuarioVacio() {
        assertFalse(VerificacionDeDatos.verificarDatos("", "1234"));
    }

    @Test
    void passwordVacia() {
        assertFalse(VerificacionDeDatos.verificarDatos("user", ""));
    }

    @Test
    void usuarioNulo() {
        assertFalse(VerificacionDeDatos.verificarDatos(null, "1234"));
    }

    @Test
    void passwordNula() {
        assertFalse(VerificacionDeDatos.verificarDatos("user", null));
    }
}
