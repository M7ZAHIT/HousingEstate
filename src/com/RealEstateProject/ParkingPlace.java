package com.RealEstateProject;

import com.RealEstateProject.Vehicle.BaseVehicle;
import com.RealEstateProject.item.BaseItem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingPlace {
    private UUID ID;
    private int cubicMeter;
    private double addedItemsVolume;
    private List<BaseItem> itemList;
    private List<BaseVehicle> vehicleList;
    private Person tenant;


    public ParkingPlace(int volume) {
        this.ID=UUID.randomUUID();
        this.cubicMeter=volume;
        this.addedItemsVolume=0;
        this.itemList=new ArrayList<>();
        this.vehicleList=new ArrayList<>();

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
    public double getAddedItemsVolume() {
        return addedItemsVolume;
    }

    public void setAddedItemsVolume(double addedItemsVolume) {
        this.addedItemsVolume = addedItemsVolume;
    }

    @Override
    public String toString() {
        return "ParkingPlace{" +
                "ID=" + ID.toString().substring(0,5) +
                ", cubicMeter=" + cubicMeter +
                ", tenant=" + (tenant==null?"No Tenant":tenant.getName()) +
                '}';
    }

    public List<BaseItem> getItemList() {
        return itemList;
    }

    public List<BaseVehicle> getVehicleList() {
        return vehicleList;
    }
}
