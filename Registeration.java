/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registeration;

import java.util.Scanner;
/**
 *
 * @author Karabo Leboho
 */
public class Registeration {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAuth authSystem = new UserAuth();//https://www.w3schools.com/java/java_variables.asp/
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== User Authentication System ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");

            String choice = scanner.nextLine();//https://www.w3schools.com/java/java_variables.asp

            switch (choice) {
                case "1":
                    System.out.print("Enter username: ");
                    String newUsername = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();

                    String regStatus = authSystem.registerUser(newUsername, newPassword, phone);
                    System.out.println(regStatus);
                    break;

                case "2":
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();

                    String loginStatus = authSystem.returnLoginStatus(loginUsername, loginPassword);
                    System.out.println(loginStatus);
                    break;

                case "3":
                    System.out.println("Exiting... Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
