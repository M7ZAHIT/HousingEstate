package com.RealEstateProject.Vehicle.impl;

import com.RealEstateProject.Person;
import com.RealEstateProject.Vehicle.BaseVehicle;
import com.RealEstateProject.Vehicle.OffRoadCar;

public class OffRoadCarImpl extends BaseVehicle implements OffRoadCar {
    private boolean isSuspension;
    private boolean isBigTier;

    public OffRoadCarImpl(int cubicMeter, String name, int engineCapacity, String vehicleType, String engineType, Person owner, boolean isSuspension, boolean isBigTier) {
        super(cubicMeter, name, engineCapacity, vehicleType, engineType, owner);
        this.isSuspension = isSuspension;
        this.isBigTier = isBigTier;
    }

    @Override
    public void applySuspension() {
        this.isSuspension=true;
    }

    @Override
    public void applyBigTier() {
        this.isBigTier=true;
    }

    public boolean isSuspension() {
        return isSuspension;
    }


    public boolean isBigTier() {
        return isBigTier;
    }

}
