package Metodoak;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class VerificacionDeDatosTest {

	@Test
	void testVerificarDatos_Nulos() {
		// Probamos cuando usuario es null
		assertFalse(VerificacionDeDatos.verificarDatos(null, "password"));

		// Probamos cuando password es null
		assertFalse(VerificacionDeDatos.verificarDatos("usuario", null));

		// Ambos son null
		assertFalse(VerificacionDeDatos.verificarDatos(null, null));
	}

	@Test
	void testVerificarDatos_Vacios() {
		// Probamos con cadenas vacías
		assertFalse(VerificacionDeDatos.verificarDatos("", "password"));
		assertFalse(VerificacionDeDatos.verificarDatos("usuario", ""));
		assertFalse(VerificacionDeDatos.verificarDatos("   ", "   ")); // espacios
	}

	@Test
	void testVerificarDatos_Correctos() {
		// Probamos con datos correctos
		assertTrue(VerificacionDeDatos.verificarDatos("usuario", "password"));
	}
}
