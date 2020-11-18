package com.RealEstateProject.Vehicle.impl;

import com.RealEstateProject.Person;
import com.RealEstateProject.Vehicle.BaseVehicle;
import com.RealEstateProject.Vehicle.Boat;

public class BoatImpl extends BaseVehicle implements Boat {
    private boolean hasCabin;
    private boolean hasWaterTank;

    public BoatImpl(int cubicMeter, String name, int engineCapacity, String vehicleType, String engineType, Person owner, boolean hasCabin, boolean hasWaterTank) {
        super(cubicMeter, name, engineCapacity, vehicleType, engineType, owner);
        this.hasCabin = hasCabin;
        this.hasWaterTank = hasWaterTank;
    }

    @Override
    public void applyCabin() {
        this.hasCabin = true;
    }

    @Override
    public void applyWaterTank() {
        this.hasWaterTank = true;
    }

    public boolean isHasCabin() {
        return hasCabin;
    }

    public boolean isHasWaterTank() {
        return hasWaterTank;
    }
}
