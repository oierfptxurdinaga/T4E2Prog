package Metodoak;

import javax.swing.*;
import java.awt.*;

public class Panel_Pestaña_Tarjetas_Equipos {

	// =======================
	// MÉTODO PÚBLICO
	// =======================
	public static JPanel crearPanelEquipos() {

		JPanel panelEquipos = new JPanel();
		panelEquipos.setBackground(new Color(220, 220, 220));
		panelEquipos.setLayout(new GridLayout(2, 3, 15, 15));
		panelEquipos.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		panelEquipos.add(
				crearTarjetaEquipo("Moraza", "1925", "Mikel", "PruebasUWU/Imagenes32K/moraza-removebg-preview.png"));

		panelEquipos.add(crearTarjetaEquipo("Baskonia", "1913", "Unai", "PruebasUWU/Imagenes32K/basconia.png"));

		panelEquipos
				.add(crearTarjetaEquipo("Umore Ona", "1982", "Beñat", "PruebasUWU/Imagenes32K/umore ona_resized.png"));

		panelEquipos.add(crearTarjetaEquipo("La Merced", "1947", "Asier", "PruebasUWU/Imagenes32K/merced.png"));

		panelEquipos.add(crearTarjetaEquipo("Santutxu", "1914", "Iñaki", "PruebasUWU/Imagenes32K/santutxu.png"));

		panelEquipos.add(crearTarjetaEquipo("Ariz", "1978", "Eneko", "PruebasUWU/Imagenes32K/ariz.png"));

		return panelEquipos;
	}

	// =======================
	// MÉTODO PRIVADO AUXILIAR
	// =======================
	private static JPanel crearTarjetaEquipo(String nombre, String fundacion, String presidente, String rutaImagen) {

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
