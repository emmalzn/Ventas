import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {
    private static final int NUM_VENDORS = 10; // Número de vendedores a simular
    private static final int NUM_PRODUCTS = 5; // Número de productos a simular

    // Métodos para generar documentos y ventas aleatorias
    private static String generateRandomDocumentType() {
        String[] types = {"CC", "CE", "TI"}; // Ejemplo de tipos de documento
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }

    private static String generateRandomDocumentNumber() {
        Random rand = new Random();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < 10; i++) { // Número de dígitos del documento
            number.append(rand.nextInt(10));
        }
        return number.toString();
    }

    private static String generateRandomProductID() {
        Random rand = new Random();
        return "P" + (rand.nextInt(NUM_PRODUCTS) + 1); // IDs de producto P1, P2, ...
    }

    private static int generateRandomQuantity() {
        Random rand = new Random();
        return rand.nextInt(10) + 1; // Cantidad entre 1 y 10
    }

    // Método para generar información de ventas de un vendedor y escribir en un archivo
    private static void generateVendorFile(int vendorNumber) {
        try {
            File file = new File("vendor_" + vendorNumber + ".txt");
            FileWriter writer = new FileWriter(file);
            writer.write(generateRandomDocumentType() + ";" + generateRandomDocumentNumber() + "\n");

            for (int i = 0; i < NUM_PRODUCTS; i++) {
                writer.write(generateRandomProductID() + ";" + generateRandomQuantity() + "\n");
            }

            writer.close();
            System.out.println("Archivo generado para el vendedor " + vendorNumber);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo para el vendedor " + vendorNumber + ": " + e.getMessage());
        }
    }

    // Método principal para generar los archivos de información de vendedores
    public static void main(String[] args) {
        for (int i = 1; i <= NUM_VENDORS; i++) {
            generateVendorFile(i);
        }
    }
}
