package RealEstate.model;

import java.sql.Date;

public class Payment {
    private int id;
    private int tenantId;
    private int propertyId;
    private double amountPaid;
    private Date paidDate;

    // Constructors, getters and setters
    public Payment(int id, int tenantId, int propertyId, double amountPaid, Date paidDate) {
        this.id = id;
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.amountPaid = amountPaid;
        this.paidDate = paidDate;
    }

    // Getters and setters

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}