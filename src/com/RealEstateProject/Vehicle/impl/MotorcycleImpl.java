package com.RealEstateProject.Vehicle.impl;

import com.RealEstateProject.Person;
import com.RealEstateProject.Vehicle.BaseVehicle;
import com.RealEstateProject.Vehicle.Motorcycle;

public class MotorcycleImpl extends BaseVehicle implements Motorcycle {
    public boolean fullySuspension;

    public MotorcycleImpl(int cubicMeter, String name, int engineCapacity, String vehicleType, String engineType, Person owner, boolean fullySuspension) {
        super(cubicMeter, name, engineCapacity, vehicleType, engineType, owner);
        this.fullySuspension = fullySuspension;
    }

    @Override
    public void applyFullySuspension() {
        this.fullySuspension = true;
    }

    public boolean isFullySuspension() {
        return fullySuspension;
    }


}
