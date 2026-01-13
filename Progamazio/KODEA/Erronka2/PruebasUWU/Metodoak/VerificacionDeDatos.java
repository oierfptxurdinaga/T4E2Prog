package Metodoak;

import javax.swing.JOptionPane;

public class VerificacionDeDatos {

	public static boolean verificarDatos(String usuario, String password) {

		if (usuario == null || password == null || usuario.trim().isEmpty() || password.trim().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Ezin dira eremu hutsak egon.");
			return false;
		}

		return true;
	}
}
