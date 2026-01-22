package Metodoak;

import javax.swing.*;
import java.awt.*;

/**
 * Ekipoen fitxako panela sortzeaz arduratzen den klasea.
 * <p>
 * Txartel-lauki bat erakusten du, non txartel bakoitzak bere izena, fundazio-urtea, presidentea eta logotipoa dituen talde bat irudikatzen duen.
 * </p>
 */
public class Panel_Pestaña_Tarjetas_Equipos {

	// =======================
	// MÉTODO PÚBLICO
	// =======================

	/**
	 * Sortu eta konfiguratu ekipoen txartelak dituen panel nagusia.
	 * <p>
	 * Panelak 2 errenkada eta 3 zutabeko {@link GridLayout} bat erabiltzen du, eta
	 * txartelen eta kanpoko ertz baten artean. Txartel bakoitza metodo honen bidez sortzen da:
	 * laguntzailea {@code crearTarjetaEquipo}.
	 * </p>
	 *
	 * @return {@link JPanel} Taldeen Tarjetak dauzka
	 */
	public static JPanel crearPanelEquipos() {

		JPanel panelEquipos = new JPanel();
		panelEquipos.setBackground(new Color(220, 220, 220));
		panelEquipos.setLayout(new GridLayout(2, 3, 15, 15));
		panelEquipos.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		panelEquipos.add(
				crearTarjetaEquipo("Moraza", "1925", "Mikel", "moraza-removebg-preview.png"));

		panelEquipos.add(crearTarjetaEquipo("Baskonia", "1913", "Unai", "basconia.png"));

		panelEquipos
				.add(crearTarjetaEquipo("Umore Ona", "1982", "Beñat", "umore ona_resized.png"));

		panelEquipos.add(crearTarjetaEquipo("La Merced", "1947", "Asier", "merced.png"));

		panelEquipos.add(crearTarjetaEquipo("Santutxu", "1914", "Iñaki", "santutxu.png"));

		panelEquipos.add(crearTarjetaEquipo("Ariz", "1978", "Eneko", "ariz.png"));

		return panelEquipos;
	}

	// =======================
	// MÉTODO PRIVADO AUXILIAR
	// =======================

	/**
	 * Sortu txartel grafiko bat ekipo baten informazioa adierazteko.
	 * <p>
	 * Txartelean sartzen dira:
	 * <ul>
	 * <li>Ekipoaren logotipoa</li>
	 * <li>Taldearen izena</li>
	 * <li>Sorrera-urtea</li>
	 * <li>Lehendakariaren izena</li>
	 * </ul>
	 * </p>
	 *
	 * @param nombre: Taldearen izena
	 * @param fundacion: Taldea zortu zen urtea
	 * @param presidente: Presidentearen izena
	 * @param rutaImagen: Argazki ruta
	 * @return {@link JPanel} Tadearen "Tarjeta" errepresentatzen du
	 */
	private static JPanel crearTarjetaEquipo(String nombre, String fundacion,
	                                         String presidente, String rutaImagen) {

		JPanel tarjeta = new JPanel();
		tarjeta.setBackground(Color.WHITE);
		tarjeta.setLayout(new BorderLayout(10, 10));
		tarjeta.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

		// LOGO
		ImageIcon icono = new ImageIcon(rutaImagen);
		Image imagenEscalada = icono.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		JLabel lblImagen = new JLabel(new ImageIcon(imagenEscalada));
		lblImagen.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// TEXTO
		JPanel panelTexto = new JPanel(new GridLayout(3, 1));
		panelTexto.setBackground(Color.WHITE);

		JLabel lblNombre = new JLabel("Izena: " + nombre);
		JLabel lblFundacion = new JLabel("Fundazioa: " + fundacion);
		JLabel lblPresidente = new JLabel("Presidentea: " + presidente);

		lblNombre.setFont(new Font("Arial", Font.BOLD, 13));

		panelTexto.add(lblNombre);
		panelTexto.add(lblFundacion);
		panelTexto.add(lblPresidente);

		tarjeta.add(lblImagen, BorderLayout.WEST);
		tarjeta.add(panelTexto, BorderLayout.CENTER);

		return tarjeta;
	}
}
