import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;

public class AlphabeticalAndRecursiveDirectoryOrderTXT {

    public static void listDirectoryContents(File dir, int depth, BufferedWriter writer) throws IOException {
        if (dir.exists() && dir.isDirectory()) {
            File[] contents = dir.listFiles();

            if (contents != null) {
                // Ordenamos los archivos de forma alfabética (ignorando mayúsculas/minúsculas)
                Arrays.sort(contents, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));

                // Creamos el formateador con el patrón deseado una sola vez
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                for (File file : contents) {
                    String indent = "  ".repeat(depth);
                    String type = file.isDirectory() ? "D" : "F";

                    // Obtener la marca de tiempo de la última modificación del archivo
                    long lastModifiedMillis = file.lastModified();
                    LocalDateTime lastModifiedDateTime = LocalDateTime.ofInstant(
                            Instant.ofEpochMilli(lastModifiedMillis), ZoneId.systemDefault()
                    );

                    // Formatear la fecha
                    String formattedDate = formatter.format(lastModifiedDateTime);

                    writer.write(indent + type + " - " + file.getName() + " - " + formattedDate + "\n");

                    if (file.isDirectory()) {
                        listDirectoryContents(file, depth + 1, writer);
                    }
                }
            } else {
                writer.write("  ".repeat(depth) + "[No se pudo leer el contenido]\n");
            }
        } else {
            writer.write("[Ruta no válida o no es un directorio]\n");
        }
    }
}