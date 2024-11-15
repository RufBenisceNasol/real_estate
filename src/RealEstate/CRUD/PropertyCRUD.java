package RealEstate.CRUD;

import RealEstate.model.Property;
import RealEstate.Util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyCRUD {

    // Create - Add a new property with enhanced validation for invalid parameters
    public void createProperty(String type, String location, String availability, double price) {
        // Validate type: it should not be null, empty, or whitespace
        if (isInvalidParameter(type)) {
            System.err.println("Invalid property type. It cannot be empty or contain only whitespace.");
            return;
        }

        // Validate location: it should not be null, empty, or whitespace
        if (isInvalidParameter(location)) {
            System.err.println("Invalid location. It cannot be empty or contain only whitespace.");
            return;
        }

        // Validate availability: it should be either 'Available' or 'Occupied'
        String[] validAvailabilityOptions = {"Available", "Occupied"};
        boolean isValidAvailability = false;
        for (String validOption : validAvailabilityOptions) {
            if (availability.equalsIgnoreCase(validOption)) {
                isValidAvailability = true;
                break;
            }
        }
        if (!isValidAvailability) {
            System.err.println("Invalid availability value. It must be 'Available' or 'Occupied'.");
            return;
        }

        // Validate price: it should be a positive number
        if (price <= 0) {
            System.err.println("Price must be a positive number.");
            return;
        }

        // If all validations pass, insert the property into the database
        String sql = "INSERT INTO Property (type, location, availability, price) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, type);
            stmt.setString(2, location);
            stmt.setString(3, availability); // Insert only valid availability
            stmt.setDouble(4, price);
            stmt.executeUpdate();
            System.out.println("Property added successfully.");
        } catch (SQLException e) {
            System.err.println("SQL error occurred: " + e.getMessage());
        }
    }


    // Read - Fetch all properties and display them (with ID)
    public void readProperties() {
        String sql = "SELECT * FROM Property";
        List<Property> properties = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");  // Fetch the ID
                String type = rs.getString("type");
                String location = rs.getString("location");
                String availability = rs.getString("availability");
                double price = rs.getDouble("price");

                // Create a Property object to hold the data, including ID
                Property property = new Property(id, type, location, availability, price);
                properties.add(property);
            }

            // Display all properties
            if (properties.isEmpty()) {
                System.out.println("No properties found.");
            } else {
                for (Property property : properties) {
                    System.out.println(property);  // Will call toString() to display the ID and other details
                }
            }

        } catch (SQLException e) {
            System.err.println("SQL error occurred: " + e.getMessage());
        }
    }

    // Update - Update an existing property by ID
    public void updateProperty(int id, String type, String location, String availability, double price) {
        if (isInvalidParameter(type)) {
            System.err.println("Invalid property type. It cannot be empty or contain only whitespace.");
            return;
        }

        if (isInvalidParameter(location)) {
            System.err.println("Invalid location. It cannot be empty or contain only whitespace.");
            return;
        }

        String[] validAvailabilityOptions = {"Available", "Occupied"};
        boolean isValidAvailability = false;
        for (String validOption : validAvailabilityOptions) {
            if (availability.equalsIgnoreCase(validOption)) {
                isValidAvailability = true;
                break;
            }
        }
        if (!isValidAvailability) {
            System.err.println("Invalid availability value. It must be 'Available' or 'Occupied'.");
            return;
        }

        if (price <= 0) {
            System.err.println("Price must be a positive number.");
            return;
        }

        String sql = "UPDATE Property SET type = ?, location = ?, availability = ?, price = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, type);
            stmt.setString(2, location);
            stmt.setString(3, availability);
            stmt.setDouble(4, price);
            stmt.setInt(5, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Property updated successfully.");
            } else {
                System.err.println("Property with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            System.err.println("SQL error occurred: " + e.getMessage());
        }
    }

    // Delete - Delete a property by ID
    public void deleteProperty(int id) {
        String sql = "DELETE FROM Property WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Property deleted successfully.");
            } else {
                System.err.println("Property with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            System.err.println("SQL error occurred: " + e.getMessage());
        }
    }

    // Helper method to check for invalid parameters (null, empty, or only whitespace)
    private boolean isInvalidParameter(String parameter) {
        return parameter == null || parameter.trim().isEmpty();
    }



}