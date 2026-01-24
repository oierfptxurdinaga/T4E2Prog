package Pruebas_Funcionales;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Prueba_De_Pojos.Entranatzailea;
import Prueba_De_Pojos.Jokalari;
import Prueba_De_Pojos.Pertsona;
import Metodoak.Cerrar_Sesion;
import Metodoak.Panel_Pestaña_Tarjetas_Equipos;
import Metodoak.Pestaña_Resultados;

import java.awt.*;
import java.awt.event.ActionListener;
//import java.nio.file.*;
import java.io.*;
//import java.util.List;
import java.util.Vector;
import java.util.ArrayList;

public class VentanaUsuarios extends JFrame {

	private JTextField txtNombre, txtApellido, txtEdad, txtCorreo, txtTelefono, txtUsuario;
	private JLabel lblBienvenida;

	public VentanaUsuarios() {
		setTitle("Ventana de Usuario");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JTabbedPane pestañas = new JTabbedPane();
		pestañas.addTab("Hasiera", crearPanelInicio());
		pestañas.addTab("Taldeak Ikusi", Panel_Pestaña_Tarjetas_Equipos.crearPanelEquipos());
		// pestañas.addTab("Taldeak", crearPanelEquipos());
		pestañas.addTab("Jokalariak", crearPanelDeLosJugadores());
		pestañas.addTab("Entrenatzaileak", crearPanelDeLosEntrenadores());
		pestañas.addTab("Emaitzak", new Pestaña_Resultados());
		// pestañas.addTab("Emaitzak", crearPanelResultadosDePartidos());;
		pestañas.addTab("Sailkapena", crearPanelClasificacion());
		pestañas.addTab("Perfila", crearPanelPerfil());
		pestañas.addTab("Saioa Amaitu", Cerrar_Sesion.crearPanel(this));
		// pestañas.addTab("Saioa Amaitu", crearPanelCerrarSesion());

		getContentPane().add(pestañas);
	}

	// =======================
	// PESTAÑA INICIO
	// =======================
	private JPanel crearPanelInicio() {
		JPanel panel = new JPanel(null);

		lblBienvenida = new JLabel("¡Bienvenido!", SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBienvenida.setBounds(0, 200, 780, 40);
		panel.add(lblBienvenida);

		return panel;
	}

	// =======================
	// PESTAÑA EQUIPOS
	// =======================

	// =======================
	// PESTAÑA PERFIL
	// =======================
	private JPanel crearPanelPerfil() {
		JPanel panel = new JPanel(null);

		JLabel lblInfo = new JLabel("Profilaren informazioa");
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblInfo.setBounds(250, 20, 300, 25);
		panel.add(lblInfo);

		txtNombre = crearCampo(panel, "Emaila:", 60);
		txtApellido = crearCampo(panel, "Izena:", 100);
		txtEdad = crearCampo(panel, "Abizena1:", 140);
		txtCorreo = crearCampo(panel, "Abizena2:", 180);
		txtTelefono = crearCampo(panel, "Jaioteguna:", 220);
		txtUsuario = crearCampo(panel, "Erabiltzaile izena:", 260);

		return panel;
	}

	private JTextField crearCampo(JPanel panel, String etiqueta, int y) {
		JLabel lbl = new JLabel(etiqueta);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl.setBounds(100, y, 140, 25); // lbl.setBounds(150, y, 100, 25);
		panel.add(lbl);

		JTextField txt = new JTextField();
		txt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt.setEditable(false);
		txt.setBackground(Color.LIGHT_GRAY);
		txt.setBounds(280, y, 264, 25);
		panel.add(txt);

		return txt;
	}

	// =======================
	// RELLENAR DATOS USUARIO
	// =======================
	public void setDatosUsuario(String[] datosUsuario) {
		lblBienvenida.setText("¡Ongi Etorri, " + datosUsuario[5] + "!");
		txtNombre.setText(datosUsuario[0]);
		txtApellido.setText(datosUsuario[1]);
		txtEdad.setText(datosUsuario[2]);
		txtCorreo.setText(datosUsuario[3]);
		txtTelefono.setText(datosUsuario[4]);
		txtUsuario.setText(datosUsuario[5]);
	}

	// =======================
	// PESTAÑA DE RESULTADOS
	// =======================

	// =======================
	// PESTAÑA INFO ENTRENADORES
	// =======================

	private JPanel crearPanelDeLosEntrenadores() {

		JPanel panel = new JPanel(new BorderLayout(10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// =====================
		// CREACIÓN DE ENTRENADORES
		// =====================
		ArrayList<Pertsona> taldeaAriz = new ArrayList<>();
		taldeaAriz.add(new Entranatzailea("Eneko", "Perez", 20, new ArrayList<>()));
		taldeaAriz.add(new Entranatzailea("Aitor", "Ruiz", 22, new ArrayList<>()));

		ArrayList<Pertsona> taldeaBaskonia = new ArrayList<>();
		taldeaBaskonia.add(new Entranatzailea("Unai", "Martin", 21, new ArrayList<>()));
		taldeaBaskonia.add(new Entranatzailea("Ibai", "Mendiluze", 19, new ArrayList<>()));

		ArrayList<Pertsona> taldeaMoraza = new ArrayList<>();
		taldeaMoraza.add(new Entranatzailea("Mikel", "Lopez", 23, new ArrayList<>()));

		ArrayList<Pertsona> taldeaSantutxu = new ArrayList<>();
		taldeaSantutxu.add(new Entranatzailea("Iñaki", "Sanchez", 24, new ArrayList<>()));

		ArrayList<Pertsona> taldeaMerced = new ArrayList<>();
		taldeaMerced.add(new Entranatzailea("Asier", "Gomez", 19, new ArrayList<>()));

		ArrayList<Pertsona> taldeaUmoreOna = new ArrayList<>();
		taldeaUmoreOna.add(new Entranatzailea("Beñat", "Alonso", 25, new ArrayList<>()));

		// =====================
		// ENTRENADORES
		// =====================
		ArrayList<Entranatzailea> entrenadores = new ArrayList<>();

		entrenadores.add(new Entranatzailea("Eneko", "Perez", 20, taldeaAriz));
		entrenadores.add(new Entranatzailea("Unai", "Martin", 21, taldeaBaskonia));
		entrenadores.add(new Entranatzailea("Mikel", "Lopez", 23, taldeaMoraza));
		entrenadores.add(new Entranatzailea("Iñaki", "Sanchez", 24, taldeaSantutxu));
		entrenadores.add(new Entranatzailea("Asier", "Gomez", 19, taldeaMerced));
		entrenadores.add(new Entranatzailea("Beñat", "Alonso", 25, taldeaUmoreOna));

		// =====================
		// TABLA
		// =====================
		String[] columnas = { "Taldea", "Izena", "Abizena", "Adina", "Kide kopurua" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		String[] equipos = { "Ariz", "Baskonia", "Moraza", "Santutxu", "UD La Merced", "Umore Ona" };

		for (int i = 0; i < entrenadores.size(); i++) {
			Entranatzailea e = entrenadores.get(i);
			modelo.addRow(new Object[] { equipos[i], e.getIzena(), e.getAbz1(), e.getAdina(), e.getTaldea().size() });
		}

		JTable tabla = new JTable(modelo);
		JScrollPane scrollTabla = new JScrollPane(tabla);
		tabla.getTableHeader().setReorderingAllowed(false);

		// =====================
		// LISTA DEL EQUIPO
		// =====================
		DefaultListModel<String> modeloLista = new DefaultListModel<>();
		JList<String> listaTaldea = new JList<>(modeloLista);
		JScrollPane scrollLista = new JScrollPane(listaTaldea);
		scrollLista.setPreferredSize(new Dimension(260, 0));

		// =====================
		// EVENTO SELECCIÓN
		// =====================
		tabla.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				modeloLista.clear();
				int fila = tabla.getSelectedRow();

				if (fila >= 0) {
					Entranatzailea ent = entrenadores.get(fila);
					for (Pertsona p : ent.getTaldea()) {
						modeloLista.addElement(p.getIzena() + " " + p.getAbz1() + " - " + p.getAdina() + " urte");
					}
				}
			}
		});

		// =====================
		// LAYOUT
		// =====================
		panel.add(new JLabel("Entrenatzaileak", SwingConstants.CENTER), BorderLayout.NORTH);
		panel.add(scrollTabla, BorderLayout.CENTER);
		panel.add(scrollLista, BorderLayout.EAST);

		return panel;
	}

	private JPanel crearPanelDeLosJugadores() {
		JPanel panel = new JPanel(new BorderLayout(10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// =====================
		// EQUIPOS Y ARCHIVOS
		// =====================
		String[] equipos = { "Jokalari Libreak", "Ariz", "Baskonia", "Moraza", "Santutxu", "UD La Merced",
				"Umore Ona" };

		String[] archivos = { "Jugador LibreJugadores_Libres.dat", "ArizAriz.dat", "BaskoniaBaskonia.dat",
				"MorazaMoraza.dat", "SantutxuSantutxu.dat", "UD La MercedUD_Merced.dat", "Umore OnaUmore_Ona.dat" };

		// =====================
		// COMBO EQUIPOS
		// =====================
		JComboBox<String> comboEquipos = new JComboBox<>(equipos);
		JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelNorte.add(new JLabel("Taldea:"));
		panelNorte.add(comboEquipos);
		comboEquipos.setSelectedIndex(-1);

		// =====================
		// LISTA JUGADORES
		// =====================
		DefaultListModel<String> modeloLista = new DefaultListModel<>();
		JList<String> listaJugadores = new JList<>(modeloLista);
		JScrollPane scrollLista = new JScrollPane(listaJugadores);
		scrollLista.setPreferredSize(new Dimension(260, 0));

		// =====================
		// PANEL INFO JUGADOR
		// =====================
		JPanel panelInfo = new JPanel(null);
		panelInfo.setBorder(BorderFactory.createTitledBorder("Jokalariaren informazioa"));

		String[] etiquetas = { "Izena:", "Abizena:", "Adina:", "Dortsala:", "Posizioa:", "Taldea:" };

		JTextField[] campos = new JTextField[6];

		int y = 30;
		for (int i = 0; i < etiquetas.length; i++) {
			JLabel lbl = new JLabel(etiquetas[i]);
			lbl.setBounds(20, y, 100, 25);
			panelInfo.add(lbl);

			campos[i] = new JTextField();
			campos[i].setBounds(130, y, 200, 25);
			campos[i].setEditable(false);
			campos[i].setBackground(Color.LIGHT_GRAY);
			panelInfo.add(campos[i]);

			y += 35;
		}

		ArrayList<Jokalari> jokalariakUnekoak = new ArrayList<>();

		// =====================
		// EVENTO CAMBIO EQUIPO
		// =====================
		comboEquipos.addActionListener(e -> {
			modeloLista.clear();
			jokalariakUnekoak.clear();

			int index = comboEquipos.getSelectedIndex();

			// 🔒 Si no hay equipo seleccionado, no hace nada
			if (index == -1) {
				return;
			}

			jokalariakUnekoak.addAll(cargarJokalariak(archivos[index]));

			for (Jokalari j : jokalariakUnekoak) {
				modeloLista.addElement(j.getIzena() + " " + j.getAbz1());
			}
		});

		// =====================
		// EVENTO SELECCIÓN JUGADOR
		// =====================
		listaJugadores.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int i = listaJugadores.getSelectedIndex();
				if (i >= 0) {
					Jokalari j = jokalariakUnekoak.get(i);

					campos[0].setText(j.getIzena());
					campos[1].setText(j.getAbz1());
					campos[2].setText(String.valueOf(j.getAdina()));
					campos[3].setText(String.valueOf(j.getDortsala()));
					campos[4].setText(j.getPosizioa());
					campos[5].setText(j.getTaldea());
				}
			}
		});

		// =====================
		// LAYOUT FINAL
		// =====================
		panel.add(panelNorte, BorderLayout.NORTH);
		panel.add(scrollLista, BorderLayout.WEST);
		panel.add(panelInfo, BorderLayout.CENTER);
		return panel;
	}

	private ArrayList<Jokalari> cargarJokalariak(String ruta) {

		ArrayList<Jokalari> jokalariak = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] d = linea.split(";");

				String izena = d[1];
				String abz1 = d[2];
				int adina = Integer.parseInt(d[3]);
				int dortsala = Integer.parseInt(d[4]);
				String posizioa = d[5];
				String taldea = d[6];

				jokalariak.add(new Jokalari(izena, abz1, adina, dortsala, posizioa, taldea));
			}

		} catch (IOException e) {
			System.err.println("Errorea fitxategia irakurtzean: " + ruta);
		}

		return jokalariak;
	}

	// ==============
	// PESTAÑA CLASIFICACION
	// ==============

	private JPanel crearPanelClasificacion() {

		JPanel panel = new JPanel(new BorderLayout(10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// =====================
		// SELECCIONAR TEMPORADA
		// =====================
		JPanel panelTop = new JPanel(new BorderLayout(5, 5));
		JLabel lblTitulo = new JLabel("Sailkapena", SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelTop.add(lblTitulo, BorderLayout.CENTER);

		// Combo temporadas existentes
		String[] temporadas = { "2024/25", "2025/26", "2026/27", "2027/28" };
		JComboBox<String> comboTemporadas = new JComboBox<>(temporadas);
		panelTop.add(comboTemporadas, BorderLayout.EAST);
		panel.add(panelTop, BorderLayout.NORTH);

		// =====================
		// TABLA CLASIFICACIÓN
		// =====================
		String[] columnas = { "Pos", "Taldea", "PJ", "DG", "Puntuak" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable tabla = new JTable(modelo);
		tabla.setRowHeight(24);
		tabla.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		tabla.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll = new JScrollPane(tabla);
		panel.add(scroll, BorderLayout.CENTER);

		// =====================
		// PANEL DETALLE EQUIPO
		// =====================
		JPanel panelDetalle = new JPanel(new GridLayout(2, 5, 10, 5));
		panelDetalle.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				"Taldearen estatistikak"));

		JLabel[] lblDatos = new JLabel[5];
		String[] textos = { "PG", "PE", "PP", "GF", "GC" };
		for (int i = 0; i < lblDatos.length; i++) {
			lblDatos[i] = new JLabel(textos[i] + ": -", SwingConstants.CENTER);
			lblDatos[i].setFont(new Font("Tahoma", Font.BOLD, 14));
			panelDetalle.add(lblDatos[i]);
		}
		panel.add(panelDetalle, BorderLayout.SOUTH);

		// =====================
		// MODELO EQUIPO
		// =====================
		class Equipo {
			String nombre;
			int pj, pg, pe, pp, gf, gc, puntos;

			Equipo(String n) {
				nombre = n;
			}

			int dg() {
				return gf - gc;
			}
		}

		String[] equipos = { "Ariz", "Baskonia", "Moraza", "Santutxu", "UD La Merced", "Umore Ona" };
		ArrayList<Equipo> clasificacion = new ArrayList<>();

		// =====================
		// LIST SELECTION LISTENER
		// =====================
		tabla.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int fila = tabla.getSelectedRow();
				if (fila >= 0 && fila < clasificacion.size()) {
					Equipo eq = clasificacion.get(fila);
					lblDatos[0].setText("PG: " + eq.pg);
					lblDatos[1].setText("PE: " + eq.pe);
					lblDatos[2].setText("PP: " + eq.pp);
					lblDatos[3].setText("GF: " + eq.gf);
					lblDatos[4].setText("GC: " + eq.gc);
				}
			}
		});

		// =====================
		// MÉTODO PARA CARGAR TABLA SEGÚN TEMPORADA
		// =====================
		ActionListener cargarTemporada = evt -> {
			String temporadaSeleccionada = (String) comboTemporadas.getSelectedItem();
			modelo.setRowCount(0); // limpiar tabla
			clasificacion.clear();

			for (String e : equipos)
				clasificacion.add(new Equipo(e));

			// LEER RESULTADOS
			File file = new File("resultados.csv");
			if (file.exists()) {
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					String linea;
					while ((linea = br.readLine()) != null) {
						String[] p = linea.split(",");
						if (p.length == 6) {
							// crear Resultado
							String temporada = p[0];
							int jornada = Integer.parseInt(p[1]);
							String local = p[2];
							int gl = Integer.parseInt(p[3]);
							String visitante = p[4];
							int gv = Integer.parseInt(p[5]);

							// filtrar por temporada
							if (!temporada.equals(temporadaSeleccionada))
								continue;

							// actualizar estadísticas de los equipos
							Equipo el = null, ev = null;
							for (Equipo eq : clasificacion) {
								if (eq.nombre.equals(local))
									el = eq;
								if (eq.nombre.equals(visitante))
									ev = eq;
							}

							if (el != null && ev != null) {
								el.pj++;
								ev.pj++;
								el.gf += gl;
								el.gc += gv;
								ev.gf += gv;
								ev.gc += gl;
								if (gl > gv) {
									el.pg++;
									el.puntos += 3;
									ev.pp++;
								} else if (gl < gv) {
									ev.pg++;
									ev.puntos += 3;
									el.pp++;
								} else {
									el.pe++;
									ev.pe++;
									el.puntos++;
									ev.puntos++;
								}
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			// ORDENAR
			clasificacion.sort((a, b) -> {
				if (b.puntos != a.puntos)
					return b.puntos - a.puntos;
				if (b.dg() != a.dg())
					return b.dg() - a.dg();
				return b.gf - a.gf;
			});

			// rellenar tabla
			int pos = 1;
			for (Equipo e : clasificacion)
				modelo.addRow(new Object[] { pos++, e.nombre, e.pj, e.dg(), e.puntos });

			// limpiar detalle
			for (JLabel l : lblDatos)
				l.setText(l.getText().split(":")[0] + ": -");

			tabla.clearSelection();
		};

		// cargar inicialmente
		cargarTemporada.actionPerformed(null);

		// escuchar cambios de temporada
		comboTemporadas.addActionListener(cargarTemporada);

		return panel;
	}

}
// =======================
// PESTAÑA CERRAR SESIÓN
// =======================

// Esta en forma de metodo, ya que se usa más de una vez.
