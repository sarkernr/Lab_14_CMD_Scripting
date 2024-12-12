import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileScan
{public static void main(String[] args) {
    JFileChooser fileChooser = new JFileChooser("src"); // Open JFileChooser in src directory
    fileChooser.setDialogTitle("Select a Text File");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int result = fileChooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        String fileName = file.getName();
        System.out.println("Processing file: " + fileName);

        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            String line;
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Echo the line to the screen
                lineCount++;
                wordCount += line.split("\\s+").length; // Count words
                charCount += line.length(); // Count characters
            }

            // Print summary report
            System.out.println("\nSummary Report:");
            System.out.println("File Name: " + fileName);
            System.out.println("Number of lines: " + lineCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of characters: " + charCount);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    } else {
        System.out.println("No file selected.");
    }
}
}
