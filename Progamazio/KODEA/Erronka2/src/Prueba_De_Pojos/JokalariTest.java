package Prueba_De_Pojos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JokalariTest {

    private Jokalari jokalari;

    @BeforeEach
    void setUp() {
        // Crear una instancia de Jokalari antes de cada prueba
        jokalari = new Jokalari("Iker", "ABZ1234", 25, 10, "Delantero", "Athletic");
    }

    @Test
    void testGetIzena() {
        assertEquals("Iker", jokalari.getIzena(), "El nombre del jugador debería ser 'Iker'");
    }

    @Test
    void testGetDortsala() {
        assertEquals(10, jokalari.getDortsala(), "El número de dorsal debería ser 10");
    }

    @Test
    void testGetPosizioa() {
        assertEquals("Delantero", jokalari.getPosizioa(), "La posición debería ser 'Delantero'");
    }

    @Test
    void testGetTaldea() {
        assertEquals("Athletic", jokalari.getTaldea(), "El equipo debería ser 'Athletic'");
    }

    @Test
    void testSetDortsala() {
        jokalari.setDortsala(7);
        assertEquals(7, jokalari.getDortsala(), "El número de dorsal debería ser 7 después de modificarlo");
    }

    @Test
    void testSetPosizioa() {
        jokalari.setPosizioa("Defensa");
        assertEquals("Defensa", jokalari.getPosizioa(), "La posición debería ser 'Defensa' después de modificarla");
    }

    @Test
    void testSetTaldea() {
        jokalari.setTaldea("Real Madrid");
        assertEquals("Real Madrid", jokalari.getTaldea(), "El equipo debería ser 'Real Madrid' después de modificarlo");
    }

    @Test
    void testToString() {
        String expectedToString = "Jokalari [dortsala=10, posizioa=Delantero, taldea=Athletic, izena=Iker, abz1=ABZ1234, adina=25]/n";
        assertEquals(expectedToString, jokalari.toString(), "El método toString no devuelve el formato esperado");
    }
}
