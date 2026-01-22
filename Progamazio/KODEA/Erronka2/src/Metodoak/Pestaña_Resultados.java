package Metodoak;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.Vector;

public class Pestaña_Resultados extends JPanel {

	private JComboBox<String> comboTemporada;
	private JComboBox<String> comboEquipo;
	private DefaultTableModel modelo;

	public Pestaña_Resultados() {
		setLayout(null);
		inicializarComponentes();
	}

	private void inicializarComponentes() {

		JLabel lblTemporada = new JLabel("Demboraldia:");
		lblTemporada.setBounds(20, 20, 100, 25);
		add(lblTemporada);

		JLabel lblEquipo = new JLabel("Taldea:");
		lblEquipo.setBounds(300, 20, 100, 25);
		add(lblEquipo);

		// Combo temporadas
		String[] temporadas = { "2024/25", "2025/26", "2026/27", "2027/28" };
		comboTemporada = new JComboBox<>(temporadas);
		comboTemporada.setBounds(100, 20, 150, 25);
		add(comboTemporada);

		// Combo equipos
		String[] equipos = { "--", "Ariz", "Baskonia", "Moraza", "Santutxu", "UD La Merced", "Umore Ona" };
		comboEquipo = new JComboBox<>(equipos);
		comboEquipo.setBounds(380, 20, 150, 25);
		add(comboEquipo);

		// Tabla
		String[] columnas = { "Jornada", "Lokal", "Gola Lokal", "Bisitantea", "Gola Bisitantea" };
		modelo = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(20, 60, 740, 380);
		add(scroll);
		tabla.getTableHeader().setReorderingAllowed(false);

		JButton btnCargar = new JButton("Emaitzak Ikusi");
		btnCargar.setBounds(560, 20, 150, 25);
		add(btnCargar);

		btnCargar.addActionListener(e -> cargarResultados());
	}

	private void cargarResultados() {
		/**
		 * Hautatutako denboraldiaren eta taldearen araberako emaitzak kargatzen ditu.
		 * <br>
		 * Metodo honek erabiltzaileak aukeratutako denboraldia eta taldea hartzen ditu
		 * interfazeko {@link JComboBox} osagaietatik, eta "resultados.csv" fitxategitik
		 * datuak irakurtzen ditu. Baldintzak betetzen dituzten partidak taulan bistaratzen dira.
		 * <br>
		 * Taula kargatu aurretik hutsik uzten da, eta ondoren:
		 * <ul>
		 *   <li>Denboraldia bat datorrela egiaztatzen du</li>
		 *   <li>Aukeratutako taldea lokal edo bisitari gisa agertzen dela egiaztatzen du</li>
		 *   <li>Jardunaldien arabera ordenatzen ditu emaitzak</li>
		 * </ul>
		 * <br>
		 * Emaitzen fitxategia existitzen ez bada, informazio-mezu bat erakusten zaio erabiltzaileari.
		 * 
		 */

		String temporada = (String) comboTemporada.getSelectedItem();
		String equipo = (String) comboEquipo.getSelectedItem();

		modelo.setRowCount(0);

		File file = new File("resultados.csv");
		if (!file.exists()) {
			JOptionPane.showMessageDialog(this, "Oraindik ez da emaitzarik gorde.", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] p = linea.split(",");

				if (p.length == 6 && p[0].equals(temporada) && (p[2].equals(equipo) || p[4].equals(equipo))) {

					modelo.addRow(new Object[] { Integer.parseInt(p[1]), p[2], Integer.parseInt(p[3]), p[4],
							Integer.parseInt(p[5]) });
				}
			}

			modelo.getDataVector().sort((a, b) -> {
				int j1 = (int) ((Vector<?>) a).get(0);
				int j2 = (int) ((Vector<?>) b).get(0);
				return Integer.compare(j1, j2);
			});
			modelo.fireTableDataChanged();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
