package com.RealEstateProject;

import java.util.Date;
import java.util.UUID;

public class Apartment {
    private UUID ID;
    private final int cubicMeter;
    private Person tenant;
    private boolean isExpired;
    private Date startDate;
    private Date endDate;
    private int dayCount;

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }
    public Apartment(int volume) {
        this.ID = UUID.randomUUID();
        this.cubicMeter = volume;
    }
    public UUID getID() {
        return ID;
    }
    public int getCubicMeter() {
        return cubicMeter;
    }
    public Person getTenant() {
        return tenant;
    }
    public void setTenant(Person tenant) {
        this.tenant = tenant;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public boolean isExpired() {
        return isExpired;
    }
    public int getDayCount() {
        return dayCount;
    }
    public void setExpired(boolean expired) {
        isExpired = expired;
    }
    @Override
    public String toString() {

            return "Apartment{" +
                    " ID=" + ID.toString().substring(0,5) +
                    ", cubicMeter=" + cubicMeter +
                    ", tenant= " + (tenant==null?"No Tenant":tenant.getName()) +
                    " }\n";

    }
}
