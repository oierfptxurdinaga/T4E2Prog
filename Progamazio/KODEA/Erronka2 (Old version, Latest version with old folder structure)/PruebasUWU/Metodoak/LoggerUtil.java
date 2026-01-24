package Metodoak;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {

	public static void guardarLog(String usuario, String nombre) {

		try (FileWriter fw = new FileWriter("login.log", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw)) {

			DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String fechaHora = LocalDateTime.now().format(formato);

			pw.println("Usuario: " + usuario + " | Nombre: " + nombre + " | Fecha: " + fechaHora);

		} catch (IOException e) {
			System.err.println("Error al escribir el LOG: " + e.getMessage());
		}
	}
}

//package Metodoak;

//import java.io.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

/**
 * LoggerUtil es una clase de utilidad para registrar información de usuarios en
 * un archivo de log.
 * <p>
 * El log se guarda en el archivo "login.log" en el directorio de ejecución de
 * la aplicación. Cada entrada incluye el nombre de usuario, el nombre completo
 * o alias, y la fecha y hora de registro.
 */
//public class LoggerUtil {

/**
 * Registra en el archivo "login.log" la información de un usuario, incluyendo
 * su nombre y la fecha y hora actual.
 * <p>
 * Cada entrada de log se agrega al final del archivo en formato de texto plano:
 * 
 * <pre>
 * Usuario: &lt;usuario&gt; | Nombre: &lt;nombre&gt; | Fecha: &lt;fecha y hora&gt;
 * </pre>
 * <p>
 * Si ocurre un error al escribir en el archivo, se imprimirá un mensaje en la
 * salida de error estándar.
 * 
 * <p>
 * <b>Ejemplo de uso:</b>
 * </p>
 * 
 * <pre>
 * {@code
 * LoggerUtil.guardarLog("jdoe", "John Doe");
 * // Esto agregará una línea al archivo login.log como:
 * // Usuario: jdoe | Nombre: John Doe | Fecha: 2026-01-12 15:30:45
 * }
 * </pre>
 *
 * @param usuario El nombre de usuario que se quiere registrar.
 * @param nombre  El nombre completo o alias del usuario.
 */
/*
 * public static void guardarLog(String usuario, String nombre) { try
 * (FileWriter fw = new FileWriter("login.log", true); BufferedWriter bw = new
 * BufferedWriter(fw); PrintWriter pw = new PrintWriter(bw)) {
 * 
 * DateTimeFormatter formato =
 * DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); String fechaHora =
 * LocalDateTime.now().format(formato);
 * 
 * pw.println("Usuario: " + usuario + " | Nombre: " + nombre + " | Fecha: " +
 * fechaHora);
 * 
 * } catch (IOException e) { System.err.println("Error al escribir el LOG: " +
 * e.getMessage()); } } }
 */
