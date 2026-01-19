package Prueba_De_Pojos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PresidenteaTest {

    private Presidentea presidentea;

    @BeforeEach
    public void setUp() {
        // Inicializamos el presidentea con valores de prueba
        presidentea = new Presidentea("Carlos", "Lopez", 45);
    }

    @Test
    public void testGetTaldea() {
        // Creamos una lista de ejemplo para el taldea
        ArrayList<Pertsona> taldea = new ArrayList<>();
        // Añadimos personas de ejemplo al taldea (puedes agregar valores ficticios si prefieres)
        //taldea.add(new Pertsona("Jon", "Perez", 30));
        //taldea.add(new Pertsona("Maria", "Gomez", 28));

        // Establecemos el taldea para el presidentea
        presidentea.setTaldea(taldea);

        // Verificamos que el método getTaldea devuelve lo esperado
        assertEquals(taldea, presidentea.getTaldea(), "El taldea no coincide con el esperado");
    }

    @Test
    public void testSetTaldea() {
        // Creamos una nueva lista y la asignamos
        ArrayList<Pertsona> nuevoTaldea = new ArrayList<>();
        //nuevoTaldea.add(new Pertsona("Iker", "Garcia", 32));

        presidentea.setTaldea(nuevoTaldea);

        // Verificamos que la lista se haya actualizado correctamente
        assertEquals(nuevoTaldea, presidentea.getTaldea(), "El taldea no se actualizó correctamente");
    }

    @Test
    public void testToString() {
        // Creamos una lista de ejemplo para el taldea
        ArrayList<Pertsona> taldea = new ArrayList<>();
        //taldea.add(new Pertsona("Jon", "Perez", 30));

        // Establecemos el taldea
        presidentea.setTaldea(taldea);

        // Verificamos que el método toString devuelva la cadena esperada
        String expectedString = "Presidentea [taldea=" + taldea + ", izena=" + "Carlos" +
            ", abz1=" + "Lopez" + ", adina=" + 45 + "]";
        assertEquals(expectedString, presidentea.toString(), "El método toString no devuelve lo esperado");
    }

    @Test
    public void testConstructor() {
        // Verificamos que el constructor inicializa correctamente
        assertNotNull(presidentea);
        assertEquals("Carlos", presidentea.getIzena(), "El nombre del presidentea no es correcto");
        assertEquals("Lopez", presidentea.getAbz1(), "El apellido del presidentea no es correcto");
        assertEquals(45, presidentea.getAdina(), "La edad del presidentea no es correcta");
    }
}
