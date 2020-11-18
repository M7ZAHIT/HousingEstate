package com.RealEstateProject;

import com.RealEstateProject.Vehicle.BaseVehicle;
import com.RealEstateProject.item.BaseItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Person implements Serializable {
    private final UUID ID;
    private final String name;
    private final String surname;
    private String address;
    private List<Apartment> rentedApartments;
    private List<ParkingPlace> rentedParkingPlaces;
    private List<BaseItem> items =new ArrayList<>();
    private List<BaseVehicle> vehicles;
    private List<TenantLetter> letters;

    public Person(String name, String surname, String address) {
        this.ID=UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.rentedApartments = new ArrayList<>();
        this.rentedParkingPlaces = new ArrayList<>();
        this.letters = new ArrayList<>();
    }

    public UUID getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getAddress() {
        return address;
    }
    public List<Apartment> getRentedApartments() {
        return rentedApartments;
    }
    public List<ParkingPlace> getRentedParkingPlaces() {
        return rentedParkingPlaces;
    }
    public List<TenantLetter> getLetters() {
        return letters;
    }
    public List<BaseItem> getItems() {
        return items;
    }
    public List<BaseVehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", name='" + name +
                ", surname='" + surname +
                ", address='" + address +
                ", rentedApartments = " + rentedApartments +
                ", rentedParkingPlaces = " + rentedParkingPlaces +
                ", items=" + items +
                ", vehicles=" + vehicles +
                ", letters=" + letters +
                '}';
    }
}
