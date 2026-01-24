package Prueba_De_Pojos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultadoTest {

    private Resultado resultado;

    @BeforeEach
    void setUp() {
        // Aquí creamos un resultado de ejemplo para las pruebas
        resultado = new Resultado("2022/2023", 1, "AAA", 2, "BBB", 1);
    }

    @Test
    void testGetTemporada() {
        assertEquals("2022/2023", resultado.getTemporada(), "La temporada debe ser 2022/2023");
    }

    @Test
    void testGetJornada() {
        assertEquals(1, resultado.getJornada(), "La jornada debe ser 1");
    }

    @Test
    void testGetEquipoLocal() {
        assertEquals("FC Barcelona", resultado.getEquipoLocal(), "El equipo local debe ser FC Barcelona");
    }

    @Test
    void testGetGolesLocal() {
        assertEquals(2, resultado.getGolesLocal(), "El equipo local debe haber anotado 2 goles");
    }

    @Test
    void testGetEquipoVisitante() {
        assertEquals("Real Madrid", resultado.getEquipoVisitante(), "El equipo visitante debe ser Real Madrid");
    }

    @Test
    void testGetGolesVisitante() {
        assertEquals(1, resultado.getGolesVisitante(), "El equipo visitante debe haber anotado 1 gol");
    }

    @Test
    void testInvolucraEquipo_EquipoLocal() {
        assertTrue(resultado.involucraEquipo("AAA"), "El resultado debe involucrar al equipo FC Barcelona");
    }

    @Test
    void testInvolucraEquipo_EquipoVisitante() {
        assertTrue(resultado.involucraEquipo("BBB"), "El resultado debe involucrar al equipo Real Madrid");
    }

    @Test
    void testInvolucraEquipo_NoInvolucraEquipo() {
        assertFalse(resultado.involucraEquipo("CCC"), "El resultado no debe involucrar al equipo Atlético de Madrid");
    }

    @Test
    void testToString() {
        String expected = "2022/2023,1,AAA,2,BBB,1";
        assertEquals(expected, resultado.toString(), "El toString debe devolver el formato correcto");
    }
}
