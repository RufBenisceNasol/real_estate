package RealEstate.model;

import java.sql.Date;

public class Maintenance {
    private int id;
    private int tenantId;
    private int propertyId;
    private String description;
    private String status;
    private Date requestDate;

    // Constructors, getters and setters
    public Maintenance(int id, int tenantId, int propertyId, String description, String status, Date requestDate) {
        this.id = id;
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.description = description;
        this.status = status;
        this.requestDate = requestDate;
    }

    // Getters and setters

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

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
}