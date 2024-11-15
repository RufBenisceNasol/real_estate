package RealEstate.model;

import java.sql.Date;

public class Invoice {
    private int id;
    private int tenantId;
    private int propertyId;
    private double amountDue;
    private Date dueDate;
    private String status;

    // Constructors, getters and setters
    public Invoice(int id, int tenantId, int propertyId, double amountDue, Date dueDate, String status) {
        this.id = id;
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.amountDue = amountDue;
        this.dueDate = dueDate;
        this.status = status;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }
}