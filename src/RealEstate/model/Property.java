package RealEstate.model;

public class Property {
    private int id;
    private String type;
    private String location;
    private String availability;
    private double price;

    // Constructors, getters and setters
    public Property(int id, String type, String location, String availability, double price) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.availability = availability;
        this.price = price;
    }

    // Getters and setters

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Type: " + type + ", Location: " + location + ", Availability: " + availability + ", Price: ₱" + price;
    }
}