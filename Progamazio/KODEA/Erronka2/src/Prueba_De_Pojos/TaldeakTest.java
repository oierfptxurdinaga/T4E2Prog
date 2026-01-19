package Prueba_De_Pojos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TaldeakTest {

    private Taldeak taldea;
    private ArrayList<Jokalari> jokalariList;

    @BeforeEach
    public void setUp() {
        // Crear algunos jugadores ficticios (suponiendo que la clase Jokalari tiene un constructor adecuado)
        jokalariList = new ArrayList<>();
        //jokalariList.add(new Jokalari("Jugador 1", 25));  // Asumiendo que Jokalari tiene un constructor con nombre y edad
        //jokalariList.add(new Jokalari("Jugador 2", 30));
        
        // Crear un Taldeak
        taldea = new Taldeak("Talde A", "Presidente A", "2020", jokalariList);
    }

    @Test
    public void testGetIzena() {
        assertEquals("Talde A", taldea.getIzena());
    }

    @Test
    public void testGetPrezidentea() {
        assertEquals("Presidente A", taldea.getPrezidentea());
    }

    @Test
    public void testGetFundazioa() {
        assertEquals("2020", taldea.getFundazioa());
    }

    @Test
    public void testGetJokalaria() {
        assertNotNull(taldea.getJokalaria());
        assertEquals(2, taldea.getJokalaria().size());
    }

    @Test
    public void testSetIzena() {
        taldea.setIzena("Talde B");
        assertEquals("Talde B", taldea.getIzena());
    }

    @Test
    public void testSetPrezidentea() {
        taldea.setPrezidentea("Presidente B");
        assertEquals("Presidente B", taldea.getPrezidentea());
    }

    @Test
    public void testSetFundazioa() {
        taldea.setFundazioa("2021");
        assertEquals("2021", taldea.getFundazioa());
    }

    @Test
    public void testSetJokalaria() {
        ArrayList<Jokalari> newJokalariList = new ArrayList<>();
        //newJokalariList.add(new Jokalari("Jugador 3", 22));
        taldea.setJokalaria(newJokalariList);

        assertEquals(1, taldea.getJokalaria().size());
        assertEquals("Jugador 3", taldea.getJokalaria().get(0).getNombre());  // Asumiendo que la clase Jokalari tiene un método getNombre()
    }

    @Test
    public void testToString() {
        String expectedString = "Taldeak [izena=Talde A, prezidentea=Presidente A, fundazioa=2020, jokalaria=[Jugador 1, Jugador 2], getIzena()=Talde A, getPrezidentea()=Presidente A, getFundazioa()=2020, getJokalaria()=[Jugador 1, Jugador 2], getClass()=class Prueba_De_Pojos.Taldeak, hashCode()=" + taldea.hashCode() + ", toString()=" + super.toString() + "]";
        assertTrue(taldea.toString().contains("Talde A"));
    }
}
