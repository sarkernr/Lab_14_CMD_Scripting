import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> csvRecords = new ArrayList<>();
        int idCounter = 1; // Start ID counter

        System.out.println("Welcome to the Data Saver Program!");
        boolean continueInput = true;

        while (continueInput) {
            // Collecting User Data
            System.out.print("Enter First Name: ");
            String firstName = in.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = in.nextLine();

            String idNumber = String.format("%06d", idCounter++); // Format ID as 6-digit number

            System.out.print("Enter Email: ");
            String email = in.nextLine();

            System.out.print("Enter Year of Birth (4-digit): ");
            int yearOfBirth = in.nextInt();
            in.nextLine(); // Consume the newline character

            // Create CSV Record
            String record = String.format("%s, %s, %s, %s, %d", firstName, lastName, idNumber, email, yearOfBirth);
            csvRecords.add(record);

            // Prompt to Continue
            System.out.print("Do you want to add another record? (yes/no): ");
            String response = in.nextLine();
            continueInput = response.equalsIgnoreCase("yes");
        }

        // File Name Input
        System.out.print("Enter the file name to save the records (e.g., records.csv): ");
        String fileName = in.nextLine();

        // Write to CSV File
        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String record : csvRecords) {
                writer.write(record + "\n");
            }
            System.out.println("Records saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + e.getMessage());
        }

        System.out.println("Program finished.");
    }
}
