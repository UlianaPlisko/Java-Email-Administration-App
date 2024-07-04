package EmailApp;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) throws InterruptedException{
        System.out.print("Enter your first name and last name: ");
        String firstName;
        String lastName;
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] parts = line.split(" ");
        firstName = parts[0];
        lastName = parts[1];
        Email em1 = new Email(firstName, lastName);
        int choice = 0;
        while (choice != 4) {
            System.out.println("\nMENU OF ACTIONS:");
            System.out.println("1. Set up alternate email");
            System.out.println("2. Change the password");
            System.out.println("3. Show your information");
            System.out.println("4. Exit");
            System.out.println("Your choice: ");

            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                scan.nextLine(); // Consume the newline character
                if (choice >= 1 && choice <= 3) {
                    em1.menuOfActions(choice);
                } else if (choice == 4) {
                    break;
                } else {
                    System.out.println("Invalid choice, please enter a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input, please enter a number.");
            }
        }
        Thread.sleep(500);
        System.out.println("Exiting the program. Goodbye!");
        scan.close();
    }
}