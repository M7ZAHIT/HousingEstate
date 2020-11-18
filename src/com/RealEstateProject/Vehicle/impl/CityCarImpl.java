package com.RealEstateProject.Vehicle.impl;

import com.RealEstateProject.Person;
import com.RealEstateProject.Vehicle.BaseVehicle;
import com.RealEstateProject.Vehicle.CityCar;

public class CityCarImpl extends BaseVehicle implements CityCar {
    private boolean isSunRoof;
    private boolean isABS;

    public CityCarImpl(int cubicMeter, String name, int engineCapacity, String vehicleType, String engineType, Person owner, boolean isSunRoof, boolean isABS) {
        super(cubicMeter, name, engineCapacity, vehicleType, engineType, owner);
        this.isSunRoof = isSunRoof;
        this.isABS = isABS;
    }

    @Override
    public void applySunRoof() {
        this.isSunRoof=true;
    }

    @Override
    public void applyABS() {
        this.isABS=true;
    }

    public boolean isSunRoof() {
        return isSunRoof;
    }

    public boolean isABS() {
        return isABS;
    }
}
