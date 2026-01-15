package Metodoak;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Traspaso_Y_Confirmacion {

    public static boolean realizarTraspaso(
            JFrame parent,
            String jugadorId,
            String archivoOrigen,
            String archivoDestino
    ) {

        try {
            // Leer archivo origen
            List<String> origen = Files.readAllLines(Paths.get(archivoOrigen));
            String lineaJugador = null;

            Iterator<String> it = origen.iterator();
            while (it.hasNext()) {
                String linea = it.next();
                if (linea.startsWith(jugadorId + ";")) {
                    lineaJugador = linea;
                    it.remove();
                    break;
                }
            }

            if (lineaJugador == null) {
                JOptionPane.showMessageDialog(parent, "Ez da jokalaria aurkitu");
                return false;
            }

            String[] partes = lineaJugador.split(";");
            int dorsalActual = Integer.parseInt(partes[4]);

            // Comprobar dorsal repetido
            if (dorsalOcupado(archivoDestino, dorsalActual)) {

                while (true) {
                    String input = JOptionPane.showInputDialog(
                            parent,
                            "Dorsala okupatuta dago.\nSartu dorsala berria:"
                    );

                    if (input == null) return false;

                    int nuevoDorsal;
                    try {
                        nuevoDorsal = Integer.parseInt(input);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(parent, "Zenbaki balioduna sartu");
                        continue;
                    }

                    if (!dorsalOcupado(archivoDestino, nuevoDorsal)) {
                        partes[4] = String.valueOf(nuevoDorsal);
                        break;
                    }

                    JOptionPane.showMessageDialog(parent, "Dorsal hori ere okupatuta dago");
                }
            }

            // Guardar archivo origen actualizado
            Files.write(Paths.get(archivoOrigen), origen);

            // Añadir jugador al archivo destino
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoDestino, true))) {
                bw.write(String.join(";", partes));
                bw.newLine();
            }

            JOptionPane.showMessageDialog(parent, "Transferentzia behar bezala burutu da");
            return true;

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(parent, "Errorea transferentzian");
            return false;
        }
    }

    // =======================
    // MÉTODO AUXILIAR DORSAL
    // =======================
    private static boolean dorsalOcupado(String archivoEquipo, int dorsal) throws IOException {

        if (!Files.exists(Paths.get(archivoEquipo)))
            return false;

        for (String linea : Files.readAllLines(Paths.get(archivoEquipo))) {
            String[] partes = linea.split(";");
            if (Integer.parseInt(partes[4]) == dorsal) {
                return true;
            }
        }
        return false;
    }
}
