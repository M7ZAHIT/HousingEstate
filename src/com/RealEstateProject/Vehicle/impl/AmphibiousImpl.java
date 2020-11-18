package com.RealEstateProject.Vehicle.impl;

import com.RealEstateProject.Person;
import com.RealEstateProject.Vehicle.BaseVehicle;
import com.RealEstateProject.Vehicle.Amphibious;

public class AmphibiousImpl extends BaseVehicle implements Amphibious {
    private boolean hasPalette;

    public AmphibiousImpl(int cubicMeter, String name, int engineCapacity, String vehicleType, String engineType, Person owner, boolean hasPalette) {
        super(cubicMeter, name, engineCapacity, vehicleType, engineType, owner);
        this.hasPalette = hasPalette;
    }

    @Override
    public void applyPalette() {
        this.hasPalette = true;
    }
}
