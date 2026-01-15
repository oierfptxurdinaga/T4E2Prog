package Pruebas_Funcionales;

import javax.swing.*;
import javax.swing.Timer;

import Prueba_De_Pojos.Jokalari;
import Metodoak.Cerrar_Sesion;
import Metodoak.Pestaña_Resultados;
import Metodoak.CodigoDeVerificacion;
import Metodoak.Traspaso_Y_Confirmacion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.io.*;
import java.nio.file.*;
import java.security.SecureRandom;
import java.util.*;

public class VentanaAdministrador extends JFrame {

	private JTextArea areaUsuarios;

	public VentanaAdministrador() {

		setTitle("Panel de Administrador");
		setSize(920, 575);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane pestañas = new JTabbedPane();
		pestañas.addTab("Erabiltzaileak ikusi", crearPanelUsuarios());
		pestañas.addTab("Erabiltzaile Sortu", crearPanelCrearUsuario());
		pestañas.addTab("Erabiltzaile Ezabatu", crearPanelEliminarUsuario());
		pestañas.addTab("Jokalari Sortu", crearPanelCrearJugador());
		pestañas.addTab("Jokalari Ezabatu", crearPanelBorrarJugador());
		pestañas.addTab("Transferitu", crearPanelTraspasoJugador());
		pestañas.addTab("Emaitzak", new Pestaña_Resultados());
		// pestañas.addTab("Emaitzak", crearPanelResultadosPartidos());
		pestañas.addTab("Saioa Amaitu", Cerrar_Sesion.crearPanel(this));
		// pestañas.addTab("Amaitu Saioa", crearPanelCerrarSesion());

		getContentPane().add(pestañas);
	}

	// =======================
	// PESTAÑA VER USUARIOS
	// =======================
	private JPanel crearPanelUsuarios() {

		JPanel panel = new JPanel(null);

		areaUsuarios = new JTextArea();
		areaUsuarios.setEditable(false);

		JScrollPane scroll = new JScrollPane(areaUsuarios);
		scroll.setBounds(20, 20, 860, 400); // más ancho y más alto
		panel.add(scroll);

		JButton btnCargar = new JButton("Cargar Usuarios");
		btnCargar.setBounds(20, 440, 180, 35); // más ancho y más abajo
		panel.add(btnCargar);

		btnCargar.addActionListener(e -> cargarUsuarios());

		return panel;
	}

	private void cargarUsuarios() {
		areaUsuarios.setText("");
		try {
			List<String> lineas = Files.readAllLines(Paths.get("datos.dat"));
			for (String linea : lineas) {
				areaUsuarios.append(linea + "\n");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Error al leer datos.dat");
		}
	}

	// =======================
	// PESTAÑA CREAR USUARIO
	// =======================
	private JPanel crearPanelCrearUsuario() {
		JPanel panel = new JPanel(null);

		JTextField correo = crearCampo(panel, "Elbide Elektronikoa:", 30);
		JTextField nombre = crearCampo(panel, "Izena:", 70);
		JTextField ap1 = crearCampo(panel, "Abizena 1:", 110);
		JTextField ap2 = crearCampo(panel, "Abizena 2:", 150);
		JTextField fecha = crearCampo(panel, "Jaiotze data:", 190);
		JTextField usuario = crearCampo(panel, "Erabiltzaile izena:", 230);
		JTextField contraseña = crearCampo(panel, "Pasahitza:", 270); // JTextField normal

		JButton btnGuardar = new JButton("Sortu Erabiltzailea");
		btnGuardar.setBounds(180, 320, 180, 35);
		panel.add(btnGuardar);

		btnGuardar.addActionListener(e -> {

			if (correo.getText().isEmpty() || nombre.getText().isEmpty() || usuario.getText().isEmpty()
					|| contraseña.getText().isEmpty()) {

				JOptionPane.showMessageDialog(this, "Bete beharrezko eremuak.");
				return;
			}

			 String codigoVerificacion = CodigoDeVerificacion.generar();

			try (BufferedWriter bw = new BufferedWriter(new FileWriter("datos.dat", true))) {

				bw.write(correo.getText() + ";" + nombre.getText() + ";" + ap1.getText() + ";" + ap2.getText() + ";"
						+ fecha.getText() + ";" + usuario.getText() + ";" + contraseña.getText() + ";"
						+ codigoVerificacion);
				bw.newLine();

				// =======================
				// CÓDIGO VERIFICACIÓN 14 CARACTERES
				// =======================
				// Llama al metodo
				
				JOptionPane.showMessageDialog(this, "Erabiltzailea behar bezala sortu da.");

				// Limpiar campos
				correo.setText("");
				nombre.setText("");
				ap1.setText("");
				ap2.setText("");
				fecha.setText("");
				usuario.setText("");
				contraseña.setText("");

			} catch (IOException ex) {
				JOptionPane.showMessageDialog(this, "Errore bat gertatu da erabiltzailea gordetzean.");
			}
		});

		return panel;
	}

	private JTextField crearCampo(JPanel panel, String texto, int y) {
		JLabel lbl = new JLabel(texto);
		lbl.setBounds(30, y, 150, 25);
		panel.add(lbl);

		JTextField txt = new JTextField();
		txt.setBounds(180, y, 200, 25);
		panel.add(txt);

		return txt;
	}


	// =======================
	// PESTAÑA ELIMINAR USUARIOS
	// =======================
	private JPanel crearPanelEliminarUsuario() {
		JPanel panel = new JPanel(null);

		JLabel lblCodigo = new JLabel("Erabiltzailearen egiaztapen-kodea:");
		lblCodigo.setBounds(30, 50, 250, 25);
		panel.add(lblCodigo);

		JTextField txtCodigo = new JTextField();
		txtCodigo.setBounds(280, 50, 200, 25);
		panel.add(txtCodigo);

		JLabel lblFijo = new JLabel("Kode finkoa:");
		lblFijo.setBounds(30, 90, 250, 25);
		panel.add(lblFijo);

		JTextField txtFijo = new JTextField("");
		txtFijo.setBounds(280, 90, 200, 25);
		panel.add(txtFijo);

		JButton btnEliminar = new JButton("Ezabatu erabiltzailea");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setBounds(180, 150, 180, 35);
		panel.add(btnEliminar);

		btnEliminar.addActionListener(e -> {
			String codigoUsuario = txtCodigo.getText().trim();
			String codigoFijo = txtFijo.getText().trim();

			if (codigoUsuario.isEmpty() || !codigoFijo.equals("1991")) {
				JOptionPane.showMessageDialog(this, "Erabiltzaile-kode okerra edo kode finko baliogabea.");
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(this, "¿Ziur zaude erabiltzaile hau ezabatu nahi duzula?",
					"Confirmar eliminación", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				try {
					List<String> lineas = Files.readAllLines(Paths.get("datos.dat"));
					boolean encontrado = false;
					Iterator<String> it = lineas.iterator();
					while (it.hasNext()) {
						String linea = it.next();
						String[] partes = linea.split(";");
						if (partes.length >= 8 && partes[7].equals(codigoUsuario)) {
							it.remove();
							encontrado = true;
							break;
						}
					}

					if (encontrado) {
						Files.write(Paths.get("datos.dat"), lineas);
						JOptionPane.showMessageDialog(this, "Ezabatu da erabiltzailea.");
					} else {
						JOptionPane.showMessageDialog(this, "Ez da kode horrekin erabiltzailerik aurkitu.");
					}

					txtCodigo.setText("");
					txtFijo.setText("");

				} catch (IOException ex) {
					JOptionPane.showMessageDialog(this, "Errore bat gertatu da erabiltzailea ezabatzean.");
				}
			}
		});

		return panel;
	}

	// =======================
	// PESTAÑA CREAR JUGADOR
	// =======================
	private JPanel crearPanelCrearJugador() {

		JPanel panel = new JPanel(null);

		JTextField txtNombre = crearCampo(panel, "Izena:", 30);
		JTextField txtApellido = crearCampo(panel, "Abizena:", 70);
		JTextField txtEdad = crearCampo(panel, "Adina:", 110);
		JTextField txtDorsal = crearCampo(panel, "Dortsala:", 150);

		JLabel lblPos = new JLabel("Posizioa:");
		lblPos.setBounds(30, 190, 150, 25);
		panel.add(lblPos);

		JComboBox<String> cbPosicion = new JComboBox<>(
				new String[] { "PT", "DF", "LD", "LI", "MD", "MO", "EI", "ED", "DC" });
		cbPosicion.setBounds(180, 190, 200, 25);
		panel.add(cbPosicion);

		JLabel lblEquipo = new JLabel("Taldea:");
		lblEquipo.setBounds(30, 230, 150, 25);
		panel.add(lblEquipo);

		JComboBox<String> cbEquipo = new JComboBox<>(new String[] { "Jugador Libre", "Ariz", "Baskonia", "Moraza",
				"Santutxu", "UD La Merced", "Umore Ona" });
		cbEquipo.setBounds(180, 230, 200, 25);
		panel.add(cbEquipo);

		JButton btnCrear = new JButton("Sortu jokalaria");
		btnCrear.setBounds(180, 290, 180, 35);
		panel.add(btnCrear);

		btnCrear.addActionListener(e -> {

			try {
				int edad = Integer.parseInt(txtEdad.getText());
				int dorsal = Integer.parseInt(txtDorsal.getText());

				String id = txtNombre.getText() + txtApellido.getText();

				Jokalari jugador = new Jokalari(txtNombre.getText(), txtApellido.getText(), edad, dorsal,
						cbPosicion.getSelectedItem().toString(), cbEquipo.getSelectedItem().toString());

				String archivo = obtenerArchivoEquipo(cbEquipo.getSelectedItem().toString());

				BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
				bw.write(id + ";" + jugador.getIzena() + ";" + jugador.getAbz1() + ";" + jugador.getAdina() + ";"
						+ jugador.getDortsala() + ";" + jugador.getPosizioa() + ";" + jugador.getTaldea());
				bw.newLine();
				bw.close();

				JOptionPane.showMessageDialog(this, "Behar bezala sortu da jokalaria");

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Errore bat gertatu da erreproduzitzailea sortzean");
			}
		});

		return panel;
	}

	// =======================
	// Metod para la seleccion de los equipos
	// =======================
	private String obtenerArchivoEquipo(String equipo) {

		switch (equipo) {
		case "Jugador Libre":
			return equipo + "Jugadores_Libres.dat";
		case "Ariz":
			return equipo + "Ariz.dat";
		case "Baskonia":
			return equipo + "Baskonia.dat";
		case "Moraza":
			return equipo + "Moraza.dat";
		case "Santutxu":
			return equipo + "Santutxu.dat";
		case "UD La Merced":
			return equipo + "UD_Merced.dat";
		case "Umore Ona":
			return equipo + "Umore_Ona.dat";
		default:
			return equipo + "Jugadores_Libres.dat";
		}
	}

	// =======================
	// PESTAÑA TRASPASO
	// =======================
	private JPanel crearPanelTraspasoJugador() {

		JPanel panel = new JPanel(null);

		JLabel lblOrigen = new JLabel("Jatorri taldea:");
		lblOrigen.setBounds(50, 30, 150, 25);
		panel.add(lblOrigen);

		JLabel lblJugador = new JLabel("Jokalari:");
		lblJugador.setBounds(50, 70, 150, 25);
		panel.add(lblJugador);

		JLabel lblDestino = new JLabel("Helburu taldea:");
		lblDestino.setBounds(450, 30, 150, 25);
		panel.add(lblDestino);

		JComboBox<String> cbEquipoOrigen = new JComboBox<>(new String[] { "Jugador Libre", "Ariz", "Baskonia", "Moraza",
				"Santutxu", "UD La Merced", "Umore Ona" });
		cbEquipoOrigen.setBounds(200, 30, 200, 25);
		panel.add(cbEquipoOrigen);

		JComboBox<String> cbJugador = new JComboBox<>();
		cbJugador.setBounds(200, 70, 200, 25);
		panel.add(cbJugador);

		JComboBox<String> cbEquipoDestino = new JComboBox<>(new String[] { "Jugador Libre", "Ariz", "Baskonia",
				"Moraza", "Santutxu", "UD La Merced", "Umore Ona" });
		cbEquipoDestino.setBounds(600, 30, 200, 25);
		panel.add(cbEquipoDestino);

		JButton btnConfirmar = new JButton("Berretsi ekintza");
		btnConfirmar.setBounds(350, 150, 200, 35);
		panel.add(btnConfirmar);

		// =====================
		// Cargar jugadores
		// =====================
		cbEquipoOrigen.addActionListener(e -> {
			cbJugador.removeAllItems();
			String archivo = obtenerArchivoEquipo(cbEquipoOrigen.getSelectedItem().toString());

			try {
				if (Files.exists(Paths.get(archivo))) {
					for (String linea : Files.readAllLines(Paths.get(archivo))) {
						cbJugador.addItem(linea.split(";")[0]);
					}
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(this, "Errorea jokalariak kargatzean");
			}
		});

		// =====================
		// CONFIRMAR TRASPASO
		// =====================
		btnConfirmar.addActionListener(e -> {

		    String jugadorId = (String) cbJugador.getSelectedItem();
		    if (jugadorId == null) {
		        JOptionPane.showMessageDialog(this, "Hautatu jokalari bat");
		        return;
		    }

		    String archivoOrigen = obtenerArchivoEquipo(
		            cbEquipoOrigen.getSelectedItem().toString()
		    );

		    String archivoDestino = obtenerArchivoEquipo(
		            cbEquipoDestino.getSelectedItem().toString()
		    );

		    int opcion = JOptionPane.showConfirmDialog(
		            this,
		            "¿Operazio honekin jarraitu nahi al duzu?",
		            "Berretsi transferentzia",
		            JOptionPane.YES_NO_OPTION
		    );

		    if (opcion != JOptionPane.YES_OPTION)
		        return;

		    boolean correcto = Traspaso_Y_Confirmacion.realizarTraspaso(
		            this,
		            jugadorId,
		            archivoOrigen,
		            archivoDestino
		    );

		    // Refrescar jugadores si todo ha ido bien
		    if (correcto) {
		        cbEquipoOrigen.getActionListeners()[0].actionPerformed(null);
		    }
		});
		return panel;

	}

	// =======================
	// PESTAÑA BORRAR JUGADOR
	// =======================

	private JPanel crearPanelBorrarJugador() {
		JPanel panel = new JPanel(null);

		// Etiquetas
		JLabel lblEquipo = new JLabel("Taldea:");
		lblEquipo.setBounds(50, 30, 150, 25);
		panel.add(lblEquipo);

		JLabel lblJugador = new JLabel("Jokalaria:");
		lblJugador.setBounds(50, 70, 150, 25);
		panel.add(lblJugador);

		// Combo de equipos
		JComboBox<String> cbEquipo = new JComboBox<>(new String[] { "Jugador Libre", "Ariz", "Baskonia", "Moraza",
				"Santutxu", "UD La Merced", "Umore Ona" });
		cbEquipo.setBounds(200, 30, 200, 25);
		panel.add(cbEquipo);

		// Combo de jugadores según equipo seleccionado
		JComboBox<String> cbJugador = new JComboBox<>();
		cbJugador.setBounds(200, 70, 200, 25);
		panel.add(cbJugador);

		// Botón rojo borrar
		JButton btnBorrar = new JButton("Ezabatu");
		btnBorrar.setBounds(200, 120, 200, 35);
		btnBorrar.setBackground(Color.RED);
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setFocusPainted(false);
		panel.add(btnBorrar);

		// =====================
		// Llenar jugadores al cambiar equipo
		// =====================
		cbEquipo.addActionListener(e -> {
			String equipo = cbEquipo.getSelectedItem().toString();
			String archivo = obtenerArchivoEquipo(equipo);

			cbJugador.removeAllItems();
			try {
				if (Files.exists(Paths.get(archivo))) {
					List<String> lineas = Files.readAllLines(Paths.get(archivo));
					for (String linea : lineas) {
						String[] partes = linea.split(";");
						if (partes.length > 0) {
							cbJugador.addItem(partes[0]); // Primer campo = ID jugador
						}
					}
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(this, "Errore bat gertatu da jokalariak kargatzean");
			}
		});

		// =====================
		// Acción botón borrar
		// =====================
		btnBorrar.addActionListener(e -> {
			String jugadorId = (String) cbJugador.getSelectedItem();
			if (jugadorId == null) {
				JOptionPane.showMessageDialog(this, "Hautatu jokalari bat");
				return;
			}

			String equipo = cbEquipo.getSelectedItem().toString();
			String archivo = obtenerArchivoEquipo(equipo);

			// 1️⃣ Pedir código secreto
			String codigo = JOptionPane.showInputDialog(this, "Jarraitzeko, sartu kodea:");
			if (!"/datapack disable vanilla".equals(codigo)) {
				JOptionPane.showMessageDialog(this, "Kode okerra, eragiketa bertan behera utzi da");
				return;
			}

			// 2️⃣ Confirmación final
			int opcion = JOptionPane.showConfirmDialog(this, "¿Operazio honekin jarraitu nahi al duzu?",
					"Berretsi ezabatzea", JOptionPane.YES_NO_OPTION);

			if (opcion == JOptionPane.YES_OPTION) {
				try {
					List<String> lineas = Files.readAllLines(Paths.get(archivo));
					boolean encontrado = false;
					Iterator<String> it = lineas.iterator();
					while (it.hasNext()) {
						String linea = it.next();
						if (linea.startsWith(jugadorId + ";")) {
							it.remove();
							encontrado = true;
							break;
						}
					}

					if (!encontrado) {
						JOptionPane.showMessageDialog(this, "Ez da jokalaria aurkitu");
						return;
					}

					// Guardar archivo actualizado
					Files.write(Paths.get(archivo), lineas);
					JOptionPane.showMessageDialog(this, "Ezabatu da jokalaria");

					// Refrescar combo
					cbEquipo.getActionListeners()[0].actionPerformed(null);

				} catch (IOException ex) {
					JOptionPane.showMessageDialog(this, "Errore bat gertatu da erreproduzitzailea ezabatzean");
				}
			}
		});

		// Inicializar combo de jugadores
		cbEquipo.getActionListeners()[0].actionPerformed(null);

		return panel;
	}

	/*
	 * private JPanel crearPanelResultadosPartidos() { return new JPanel(); }
	 */
	// Objetivo o planteamiento: Filtrado por temporada (El año o temporada,
	// delimitara que resultados tiene que mostrar).
	// Despues de selecionar temporada, se selecionara el equipo mediante un menu
	// desplegable.
	// Al selecionar uno de los equipos, se desolegara una lista o tabla, con los
	// resultados que a tenido, ordenado por jornadas.

}

// =======================
// PESTAÑA CERRAR SESIÓN
// =======================

// Esta en forma de metodo, ya que se usa más de una vez.
