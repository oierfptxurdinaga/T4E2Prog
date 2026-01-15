package Metodoak;

import java.io.IOException;
import java.nio.file.*;
import java.security.SecureRandom;
import java.util.List;

public class CodigoDeVerificacion {

    private static final String ARCHIVO = "datos.dat";
    private static final String CARACTERES =
            "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz0123456789";

    // =======================
    // GENERAR CÓDIGO (14)
    // =======================
    public static String generar() {

        SecureRandom random = new SecureRandom();
        String codigo;

        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 14; i++) {
                sb.append(CARACTERES.charAt(random.nextInt(CARACTERES.length())));
            }
            codigo = sb.toString();
        } while (existe(codigo));

        return codigo;
    }

    // =======================
    // COMPROBAR SI EXISTE
    // =======================
    private static boolean existe(String codigoVerificacion) {

        try {
            if (!Files.exists(Paths.get(ARCHIVO)))
                return false;

            List<String> lineas = Files.readAllLines(Paths.get(ARCHIVO));
            for (String linea : lineas) {
                String[] partes = linea.split(";");
                if (partes.length >= 8 && partes[7].equals(codigoVerificacion)) {
                    return true;
                }
            }
        } catch (IOException ignored) {
        }

        return false;
    }
}
