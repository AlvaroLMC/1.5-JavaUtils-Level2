import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class AlphabeticalAndRecursiveDirectoryOrderTXT {

    public static void listDirectoryContents(File dir, int depth, BufferedWriter writer) throws IOException {
        if (dir.exists() && dir.isDirectory()) {
            File[] contents = dir.listFiles();

            if (contents != null) {
                Arrays.sort(contents, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));

                for (File file : contents) {
                    String indent = "  ".repeat(depth);
                    String type = file.isDirectory() ? "D" : "F";
                    String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                            .format(new Date(file.lastModified()));

                    writer.write(indent + type + " - " + file.getName() + " - " + lastModified + "\n");

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