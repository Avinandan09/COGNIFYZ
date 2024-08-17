import java.io.*;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to choose between encryption and decryption
        System.out.print("Choose an option (e for encryption, d for decryption): ");
        char choice = scanner.next().charAt(0);

        // Prompt user for file name or path
        System.out.print("Enter the file name or path: ");
        scanner.nextLine(); // Consume newline
        String filePath = scanner.nextLine();

        // Prompt user for output file name
        System.out.print("Enter the output file name or path: ");
        String outputFilePath = scanner.nextLine();

        // Prompt user for encryption/decryption key
        System.out.print("Enter the key (a positive integer): ");
        int key = scanner.nextInt();

        if (choice == 'e' || choice == 'E') {
            encryptFile(filePath, outputFilePath, key);
        } else if (choice == 'd' || choice == 'D') {
            decryptFile(filePath, outputFilePath, key);
        } else {
            System.out.println("Invalid option.");
        }

        scanner.close();
    }

    public static void encryptFile(String inputFilePath, String outputFilePath, int key) {
        processFile(inputFilePath, outputFilePath, key, true);
    }

    public static void decryptFile(String inputFilePath, String outputFilePath, int key) {
        processFile(inputFilePath, outputFilePath, key, false);
    }

    private static void processFile(String inputFilePath, String outputFilePath, int key, boolean encrypt) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String processedLine = encrypt ? encryptLine(line, key) : decryptLine(line, key);
                writer.write(processedLine);
                writer.newLine();
            }

            System.out.println((encrypt ? "Encryption" : "Decryption") + " completed successfully. Output saved to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    private static String encryptLine(String line, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + key) % 26 + base);
            }
            encrypted.append(c);
        }
        return encrypted.toString();
    }

    private static String decryptLine(String line, int key) {
        return encryptLine(line, 26 - (key % 26));
    }
}
