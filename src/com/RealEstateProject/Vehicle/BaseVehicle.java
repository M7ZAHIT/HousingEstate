package com.RealEstateProject.Vehicle;

import com.RealEstateProject.Person;

public class BaseVehicle {
    private int cubicMeter;
    private String name;
    private int engineCapacity;
    private String vehicleType;
    private String engineType;
    private Person owner;

    public BaseVehicle(int cubicMeter, String name, int engineCapacity, String vehicleType, String engineType, Person owner) {
        this.cubicMeter = cubicMeter;
        this.name = name;
        this.engineCapacity = engineCapacity;
        this.vehicleType = vehicleType;
        this.engineType = engineType;
        this.owner = owner;
    }

    public int getCubicMeter() {
        return cubicMeter;
    }

    public void setCubicMeter(int cubicMeter) {
        this.cubicMeter = cubicMeter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Person getOwner() {

        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
