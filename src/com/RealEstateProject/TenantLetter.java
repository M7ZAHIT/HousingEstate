package com.RealEstateProject;

public class TenantLetter {
    private Person tenant;
    private String message;
    private Apartment apartment;


    public Apartment getApartment() {
        return apartment;
    }

    public Person getTenant() {
        return tenant;
    }

    public String getMessage() {
        return message;
    }

    public void setTenant(Person tenant) {
        this.tenant = tenant;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
