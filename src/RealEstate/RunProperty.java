package RealEstate;

import  RealEstate.CRUD.PropertyCRUD;

import java.util.Scanner;

public class RunProperty {
    public static void main(String[] args) {
        // Create an instance of PropertyCRUD
        PropertyCRUD propertyCRUD = new PropertyCRUD();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Property Management System ===");
            System.out.println("1. Create Property");
            System.out.println("2. Read All Properties");
            System.out.println("3. Update Property");
            System.out.println("4. Delete Property");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character after the integer input

            switch (choice) {
                case 1:
                    // Create Property
                    System.out.print("\nEnter property type: ");
                    String type = scanner.nextLine();

                    System.out.print("Enter property location: ");
                    String location = scanner.nextLine();

                    System.out.print("Enter availability (Available/Occupied): ");
                    String availability = scanner.nextLine();

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();

                    propertyCRUD.createProperty(type, location, availability, price);
                    break;

                case 2:
                    // Read All Properties
                    System.out.println("\nFetching all properties...");
                    propertyCRUD.readProperties();
                    break;

                case 3:
                    // Update Property
                    System.out.print("\nEnter the property ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character after the integer input

                    System.out.print("Enter updated property type: ");
                    String updatedType = scanner.nextLine();

                    System.out.print("Enter updated property location: ");
                    String updatedLocation = scanner.nextLine();

                    System.out.print("Enter updated availability (Available/Occupied): ");
                    String updatedAvailability = scanner.nextLine();

                    System.out.print("Enter updated price: ");
                    double updatedPrice = scanner.nextDouble();

                    propertyCRUD.updateProperty(updateId, updatedType, updatedLocation, updatedAvailability, updatedPrice);
                    break;

                case 4:
                    // Delete Property
                    System.out.print("\nEnter the property ID to delete: ");
                    int deleteId = scanner.nextInt();

                    propertyCRUD.deleteProperty(deleteId);
                    break;

                case 5:
                    // Exit the program
                    System.out.println("\nExiting Property Management System. Goodbye!");
                    scanner.close();
                    return; // Exit the loop and program

                default:
                    System.out.println("\nInvalid choice, please try again.");
            }
        }
    }
}
