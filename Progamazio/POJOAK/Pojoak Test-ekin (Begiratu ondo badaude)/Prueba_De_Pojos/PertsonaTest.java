package Prueba_De_Pojos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PertsonaTest1 {

    private Pertsona persona;

    // Clase concreta para poder instanciar un objeto de tipo Pertsona
    class PersonaConcreta extends Pertsona {
        public PersonaConcreta(String izena, String abz1, int adina) {
            super(izena, abz1, adina);
        }
    }

    @BeforeEach
    void setUp() {
        // Antes de cada prueba, creamos una instancia de PersonaConcreta
        persona = new PersonaConcreta("Juan", "ABZ123", 30);
    }

    @Test
    void testGetIzena() {
        assertEquals("Juan", persona.getIzena(), "El nombre debería ser Juan");
    }

    @Test
    void testSetIzena() {
        persona.setIzena("Carlos");
        assertEquals("Carlos", persona.getIzena(), "El nombre debería ser Carlos después de modificarlo");
    }

    @Test
    void testGetAbz1() {
        assertEquals("ABZ123", persona.getAbz1(), "El valor de abz1 debería ser ABZ123");
    }

    @Test
    void testSetAbz1() {
        persona.setAbz1("XYZ456");
        assertEquals("XYZ456", persona.getAbz1(), "El valor de abz1 debería ser XYZ456 después de modificarlo");
    }

    @Test
    void testGetAdina() {
        assertEquals(30, persona.getAdina(), "La edad debería ser 30");
    }

    @Test
    void testSetAdina() {
        persona.setAdina(35);
        assertEquals(35, persona.getAdina(), "La edad debería ser 35 después de modificarla");
    }

    @Test
    void testToString() {
        String expected = "Pertsona [izena=Juan, abz1=ABZ123, adina=30, getIzena()=Juan, getAbz1()=ABZ123, getAdina()=30, getClass()=" 
                          + persona.getClass() + ", hashCode()=" + persona.hashCode() 
                          + ", toString()=" + persona.toString() + "]";
        assertTrue(persona.toString().contains("izena=Juan"), "El toString debería contener el nombre correcto");
        assertTrue(persona.toString().contains("abz1=ABZ123"), "El toString debería contener el valor de abz1 correcto");
        assertTrue(persona.toString().contains("adina=30"), "El toString debería contener la edad correcta");
    }
}
