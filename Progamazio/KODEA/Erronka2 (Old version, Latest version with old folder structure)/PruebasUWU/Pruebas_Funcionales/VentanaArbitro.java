package Pruebas_Funcionales;

import javax.swing.*;
import javax.swing.Timer;

import Prueba_De_Pojos.Resultado;
import Metodoak.Cerrar_Sesion;
import Metodoak.Panel_Pestaña_Tarjetas_Equipos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.*;
import java.nio.file.*;
//import java.security.SecureRandom;
import java.util.*;

public class VentanaArbitro extends JFrame {

	// private JTextArea Arbitro;

	public VentanaArbitro() {

		setTitle("Panel de el Arbitro");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane pestañas = new JTabbedPane();
		pestañas.addTab("Orri Nagusia", crearPanelPrincipal());
		pestañas.addTab("Taldeak Ikusi", Panel_Pestaña_Tarjetas_Equipos.crearPanelEquipos());
		// pestañas.addTab("Taldeak Ikusi", crearPanelEquipos());
		pestañas.addTab("Emaitzak kudeatu", crearPanelDeGestionDeResultadosDePartidos());
		pestañas.addTab("Saioa Amaitu", Cerrar_Sesion.crearPanel(this));
		// pestañas.addTab("Amaitu saioa", crearPanelCerrarSesion());

		add(pestañas);
	}

	// =======================
	// PESTAÑA PINCIPAL
	// =======================
	private JPanel crearPanelPrincipal() {

		JPanel panelPrincipal = new JPanel(new BorderLayout(20, 20));
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelPrincipal.setBackground(new Color(245, 245, 245));

		// ===== TÍTULO =====
		JLabel lblTitulo = new JLabel("Arbitroaren Panel Nagusia");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSubtitulo = new JLabel("Ongi etorri arbitroaren kudeaketa sistemara");
		lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panelTitulo = new JPanel(new GridLayout(2, 1));
		panelTitulo.setBackground(new Color(245, 245, 245));
		panelTitulo.add(lblTitulo);
		panelTitulo.add(lblSubtitulo);

		panelPrincipal.add(panelTitulo, BorderLayout.NORTH);

		// ===== PANEL CENTRAL (INFO + ACCIONES) =====
		JPanel panelCentro = new JPanel(new GridLayout(1, 2, 20, 20));
		panelCentro.setBackground(new Color(245, 245, 245));

		// ---- BLOQUE INFO ----
		JPanel panelInfo = new JPanel(new GridLayout(4, 1, 10, 10));
		panelInfo.setBackground(Color.WHITE);
		panelInfo.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Informazioa"));

		panelInfo.add(new JLabel("📅 Denboraldia: 2025/26"));
		panelInfo.add(new JLabel("⚽ Talde kopurua: 6"));
		panelInfo.add(new JLabel("📊 Jardunaldiak: 30"));
		panelInfo.add(new JLabel("🧑‍⚖️ Rol-a: Arbitroa"));

		// ---- BLOQUE ACCIONES ----
		JPanel panelAcciones = new JPanel(new GridLayout(3, 1, 15, 15));
		panelAcciones.setBackground(Color.WHITE);
		panelAcciones.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Ekintza azkarrak"));

		JButton btnEquipos = new JButton("Taldeak ikusi");
		JButton btnResultados = new JButton("Emaitzak kudeatu");
		JButton btnCerrar = new JButton("Saioa itxi");

		Font fontBoton = new Font("Arial", Font.BOLD, 14);
		btnEquipos.setFont(fontBoton);
		btnResultados.setFont(fontBoton);
		btnCerrar.setFont(fontBoton);

		panelAcciones.add(btnEquipos);
		panelAcciones.add(btnResultados);
		panelAcciones.add(btnCerrar);

		// Acciones rápidas
		btnEquipos.addActionListener(e -> {
			JTabbedPane tabs = (JTabbedPane) getContentPane().getComponent(0);
			tabs.setSelectedIndex(1);
		});

		btnResultados.addActionListener(e -> {
			JTabbedPane tabs = (JTabbedPane) getContentPane().getComponent(0);
			tabs.setSelectedIndex(2);
		});

		btnCerrar.addActionListener(e -> {
			JTabbedPane tabs = (JTabbedPane) getContentPane().getComponent(0);
			tabs.setSelectedIndex(3);
		});

		panelCentro.add(panelInfo);
		panelCentro.add(panelAcciones);

		panelPrincipal.add(panelCentro, BorderLayout.CENTER);

		// ===== PIE/FOOTER =====
		JLabel lblFooter = new JLabel("© 2026 Futbol Ligako Kudeaketa Sistema");
		lblFooter.setHorizontalAlignment(SwingConstants.CENTER);
		lblFooter.setFont(new Font("Arial", Font.ITALIC, 12));
		lblFooter.setForeground(Color.GRAY);

		panelPrincipal.add(lblFooter, BorderLayout.SOUTH);

		return panelPrincipal;
	}

	// =======================
	// PESTAÑA EQUIPOS
	// =======================

	// =======================
	// PESTAÑA RESULTADOS
	// =======================

	private JPanel crearPanelDeGestionDeResultadosDePartidos() {
		JPanel panel = new JPanel(null);

		// Labels
		JLabel lblTemporada = new JLabel("Demboraldia:");
		lblTemporada.setBounds(20, 20, 100, 25);
		panel.add(lblTemporada);

		JLabel lblJornada = new JLabel("Jornada:");
		lblJornada.setBounds(20, 60, 100, 25);
		panel.add(lblJornada);

		JLabel lblLocal = new JLabel("Talde Lokala:");
		lblLocal.setBounds(20, 100, 100, 25);
		panel.add(lblLocal);

		JLabel lblVisitante = new JLabel("Talde Bisitantea:");
		lblVisitante.setBounds(300, 100, 120, 25);
		panel.add(lblVisitante);

		JLabel lblGolesLocal = new JLabel("Golak Lokalak:");
		lblGolesLocal.setBounds(20, 140, 100, 25);
		panel.add(lblGolesLocal);

		JLabel lblGolesVisitante = new JLabel("Golak Bizitariak:");
		lblGolesVisitante.setBounds(300, 140, 120, 25);
		panel.add(lblGolesVisitante);

		// ComboBox Temporada
		String[] temporadas = { "2025/26", "2026/27", "2027/28" };
		JComboBox<String> comboTemporada = new JComboBox<>(temporadas);
		comboTemporada.setBounds(120, 20, 150, 25);
		panel.add(comboTemporada);

		// ComboBox Jornada
		Integer[] jornadas = new Integer[30]; // hasta 30 jornadas (Se que son menos, pero mejor prevenir que curar)
		for (int i = 0; i < 30; i++)
			jornadas[i] = i + 1;
		JComboBox<Integer> comboJornada = new JComboBox<>(jornadas);
		comboJornada.setBounds(120, 60, 150, 25);
		panel.add(comboJornada);

		// ComboBox Equipos
		String[] equipos = { "Ariz", "Baskonia", "Moraza", "Santutxu", "UD La Merced", "Umore Ona" };
		JComboBox<String> comboLocal = new JComboBox<>(equipos);
		comboLocal.setBounds(120, 100, 150, 25);
		panel.add(comboLocal);

		JComboBox<String> comboVisitante = new JComboBox<>(equipos);
		comboVisitante.setBounds(430, 100, 150, 25);
		panel.add(comboVisitante);

		// Evitar seleccionar el mismo equipo como visitante
		comboLocal.addActionListener(e -> {
			String seleccionadoLocal = (String) comboLocal.getSelectedItem();
			comboVisitante.removeAllItems();
			for (String equipo : equipos) {
				if (!equipo.equals(seleccionadoLocal))
					comboVisitante.addItem(equipo);
			}
		});
		comboLocal.setSelectedIndex(0); // inicializar visitante correctamente

		// Campos goles
		JTextField txtGolesLocal = new JTextField();
		txtGolesLocal.setBounds(120, 140, 150, 25);
		panel.add(txtGolesLocal);

		JTextField txtGolesVisitante = new JTextField();
		txtGolesVisitante.setBounds(430, 140, 150, 25);
		panel.add(txtGolesVisitante);

		// Botón Guardar
		JButton btnGuardar = new JButton("Guardar Resultado");
		btnGuardar.setBounds(200, 200, 200, 30);
		panel.add(btnGuardar);

		btnGuardar.addActionListener(e -> {
			String temporada = (String) comboTemporada.getSelectedItem();
			int jornada = (Integer) comboJornada.getSelectedItem();
			String local = (String) comboLocal.getSelectedItem();
			String visitante = (String) comboVisitante.getSelectedItem();

			int golesLocal, golesVisitante;
			try {
				golesLocal = Integer.parseInt(txtGolesLocal.getText());
				golesVisitante = Integer.parseInt(txtGolesVisitante.getText());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(panel, "Sartu baliozko helburuak.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Lógica de guardado / edición
			File file = new File("resultados.csv");
			List<String> lineas = new ArrayList<>();
			boolean partidoExistente = false;
			int indiceExistente = -1;

			try {
				if (file.exists()) {
					lineas = Files.readAllLines(file.toPath());
					for (int i = 0; i < lineas.size(); i++) {
						String[] partes = lineas.get(i).split(",");
						if (partes.length == 6) {
							String temp = partes[0];
							int j = Integer.parseInt(partes[1]);
							String l = partes[2];
							String v = partes[4];

							if (temp.equals(temporada) && j == jornada && ((l.equals(local) && v.equals(visitante))
									|| (l.equals(visitante) && v.equals(local)))) {
								partidoExistente = true;
								indiceExistente = i;
								break;
							}
						}
					}
				}

				if (partidoExistente) {
					int opcion = JOptionPane.showConfirmDialog(panel,
							"Partida hau dagoeneko erregistratuta dago. ¿Emaitza editatu nahi duzu?",
							"Partido existente", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

					if (opcion == JOptionPane.NO_OPTION)
						return;

					// Reemplazar línea existente
					String nuevaLinea = temporada + "," + jornada + "," + local + "," + golesLocal + "," + visitante
							+ "," + golesVisitante;
					lineas.set(indiceExistente, nuevaLinea);
				} else {
					String nuevaLinea = temporada + "," + jornada + "," + local + "," + golesLocal + "," + visitante
							+ "," + golesVisitante;
					lineas.add(nuevaLinea);
				}

				Files.write(file.toPath(), lineas);
				JOptionPane.showMessageDialog(panel, "Behar bezala gorde da emaitza.", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

				// Limpiar campos
				txtGolesLocal.setText("");
				txtGolesVisitante.setText("");

			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(panel, "Errore bat gertatu da emaitza gordetzean.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		return panel;
	}

}

// =======================
// PESTAÑA CERRAR SESIÓN
// =======================

// Esta en forma de metodo, ya que se usa más de una vez.
