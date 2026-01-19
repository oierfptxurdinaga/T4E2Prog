package Prueba_De_Pojos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArbitroaTest {

    private Arbitroa arbitroa;

    @BeforeEach
    void setUp() {
        arbitroa = new Arbitroa("Jon", "Perez", 35, "Principal");
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("Principal", arbitroa.getMota());
    }

    @Test
    void testSetMota() {
        arbitroa.setMota("Asistente");
        assertEquals("Asistente", arbitroa.getMota());
    }

    @Test
    void testToString() {
        String resultado = arbitroa.toString();

        assertTrue(resultado.contains("Principal"));
        assertTrue(resultado.contains("Jon"));
        assertTrue(resultado.contains("Perez"));
        assertTrue(resultado.contains("35"));
    }
}
