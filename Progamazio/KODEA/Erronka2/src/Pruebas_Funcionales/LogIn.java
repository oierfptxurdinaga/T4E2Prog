package Pruebas_Funcionales;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
//import java.awt.Toolkit;

import Metodoak.LoggerUtil;
import Metodoak.VerificacionDeDatos;

public class LogIn extends JFrame {

	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	// Aspecto grafico.
	public LogIn() {

		setTitle("Login de Usuario");
		setSize(350, 220);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(20, 30, 100, 20);
		getContentPane().add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(120, 30, 180, 20);
		getContentPane().add(txtUsuario);

		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(20, 70, 100, 20);
		getContentPane().add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(120, 70, 180, 20);
		getContentPane().add(txtPassword);

		JButton btnLogin = new JButton("Zartu");
		btnLogin.setBounds(110, 120, 120, 30);
		getContentPane().add(btnLogin);

		btnLogin.addActionListener(e -> verificarDatos());

	}

	// Con esto verifica si los datos ingresados coinciden con los que deberia de
	// ser
	private void verificarDatos() {

		String usuarioIngresado = txtUsuario.getText();
		String passIngresada = new String(txtPassword.getPassword());

		if (!VerificacionDeDatos.verificarDatos(usuarioIngresado, passIngresada)) {
			return;
		}

		// continuar con el login...

		// =========================================================
		// 🔥 MODO ADMINISTRADOR 🔥
		// =========================================================

		if (usuarioIngresado.equals("NotchAdmin")) {

			// 🔄 Siempre limpiar campos
			txtUsuario.setText("");
			txtPassword.setText("");

			if (!passIngresada.equals("17 de mayo de 2009")) {
				JOptionPane.showMessageDialog(this, "Administratzailearen pasahitza okerra da.");
				return;
			}

			String codigo = JOptionPane.showInputDialog(this, "Sarbide mugatua\\nSartu egiaztapen-kodea:");

			if (codigo != null && codigo.equals("Legacy Edition")) {
				new VentanaAdministrador().setVisible(true);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Kode okerra.");
			}
			return;
		}

		// =========================================================
		// ⚽ MODO ARBITRO ⚽
		// =========================================================

		if (usuarioIngresado.equals("User-Arb")) {

			// 🔄 Siempre limpiar campos
			txtUsuario.setText("");
			txtPassword.setText("");

			if (!passIngresada.equals("787b")) {
				JOptionPane.showMessageDialog(this, "Epailearen pasahitz okerra.");
				return;
			}

			String codigo = JOptionPane.showInputDialog(this, "Sarbide mugatua\\nSartu egiaztapen-kodea:");

			if (codigo != null && codigo.equals("LeMans 1991")) {
				new VentanaArbitro().setVisible(true);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Kode okerra.");
			}
			return;
		}

		// =========================================================
		// 👤 USUARIO NORMAL 👤
		// =========================================================
		try {
			List<String> lineas = Files.readAllLines(Paths.get("datos.dat"));

			for (String linea : lineas) {

				String[] datos = linea.split(";");
				if (datos.length < 8)
					continue;

				if (usuarioIngresado.equals(datos[5]) && passIngresada.equals(datos[6])) {

					// 📝 GUARDAR LOG DE INICIO DE SESIÓN
					LoggerUtil.guardarLog(datos[5], datos[1]);

					VentanaUsuarios ventana = new VentanaUsuarios();
					ventana.setDatosUsuario(datos); // Pasamos los datos del usuario
					ventana.setVisible(true);
					this.dispose(); // Cerramos el login
					return;
				}

			}
		

			JOptionPane.showMessageDialog(this, "Erabiltzaile-izen edo pasahitz okerra.");

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Ezin izan da datos.dat fitxategia irakurri");
		}
	}
	

	public static void main(String[] args) {
		new LogIn().setVisible(true);
	}
}

// =========================================================
// 🔥 MODO ADMINISTRADOR 🔥
// =========================================================
// =========================================================
// ⚽ MODO ARBITRO ⚽
// =========================================================
// =========================================================
// 👤 USUARIO NORMAL 👤
// =========================================================
