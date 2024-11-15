package RealEstate.model;

import java.sql.Date;

public class Lease {
    private int id;
    private int tenantId;
    private int propertyId;
    private Date leaseStart;
    private Date leaseEnd;
    private double monthlyRent;

    // Constructors, getters and setters
    public Lease(int id, int tenantId, int propertyId, Date leaseStart, Date leaseEnd, double monthlyRent) {
        this.id = id;
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.leaseStart = leaseStart;
        this.leaseEnd = leaseEnd;
        this.monthlyRent = monthlyRent;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public Date getLeaseStart() {
        return leaseStart;
    }

    public void setLeaseStart(Date leaseStart) {
        this.leaseStart = leaseStart;
    }

    public Date getLeaseEnd() {
        return leaseEnd;
    }

    public void setLeaseEnd(Date leaseEnd) {
        this.leaseEnd = leaseEnd;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }
}