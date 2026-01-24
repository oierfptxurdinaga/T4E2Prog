package Prueba_De_Pojos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class EntranatzaileaTest {

    @Test
    void testConstructorAndGetters() {
        ArrayList<Pertsona> taldea = new ArrayList<>();
        //taldea.add(new Pertsona("Juan", "ABZ1", 25));
        Entranatzailea entrenador = new Entranatzailea("Pedro", "ABZ2", 40, taldea);

        assertEquals("Pedro", entrenador.getIzena());
        assertEquals("ABZ2", entrenador.getAbz1());
        assertEquals(40, entrenador.getAdina());
        assertEquals(taldea, entrenador.getTaldea());
    }

    @Test
    void testSetters() {
        ArrayList<Pertsona> taldea = new ArrayList<>();
        //taldea.add(new Pertsona("Juan", "ABZ1", 25));
        Entranatzailea entrenador = new Entranatzailea("Pedro", "ABZ2", 40, taldea);

        ArrayList<Pertsona> newTaldea = new ArrayList<>();
        //newTaldea.add(new Pertsona("Ana", "ABZ3", 28));
        entrenador.setTaldea(newTaldea);

        assertEquals(newTaldea, entrenador.getTaldea());
    }

    @Test
    void testToString() {
        ArrayList<Pertsona> taldea = new ArrayList<>();
        //taldea.add(new Pertsona("Juan", "ABZ1", 25));
        Entranatzailea entrenador = new Entranatzailea("Pedro", "ABZ2", 40, taldea);

        String expectedString = "Entranatzailea [taldea=" + taldea + ", izena=Pedro, abz1=ABZ2, adina=40]";
        assertTrue(entrenador.toString().contains("Pedro"));
        assertTrue(entrenador.toString().contains("ABZ2"));
        assertTrue(entrenador.toString().contains("40"));
    }
}

