import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties config = new Properties();

        try (InputStream input = new FileInputStream("config.properties")) {
            config.load(input);

            String inputDirPath = config.getProperty("input.directory");
            String outputFilePath = config.getProperty("output.file");

            File inputDir = new File(inputDirPath);
            File outputFile = new File(outputFilePath);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                AlphabeticalAndRecursiveDirectoryOrderTXT.listDirectoryContents(inputDir, 0, writer);
                System.out.println("Contenido guardado en: " + outputFile.getAbsolutePath());
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de configuración o escribir: " + e.getMessage());
        }
    }
}
