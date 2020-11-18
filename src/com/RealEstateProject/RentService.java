package com.RealEstateProject;

import com.RealEstateProject.Vehicle.BaseVehicle;
import com.RealEstateProject.exceptions.ProblematicTenantException;
import com.RealEstateProject.exceptions.TooManyThingsException;
import com.RealEstateProject.item.BaseItem;

import java.util.List;

public class RentService{

    public  boolean rentApartment(Person person, Apartment apartment) {
        try {
            checkPersonProblematicStatus(person);
            if (isRented(apartment)){
                System.out.println("Sorry selected apartment has already rented by another tenant");
                return false;
            } else if(apartment.isExpired()){
                System.out.println("Sorry selected apartment is expired");
                return false;
            } else{
                if (person.getRentedApartments().size()<=5){person.getRentedApartments().add(apartment);
                    System.out.println("You rented the apartment successfully");
                    apartment.setTenant(person);
                    return true;
                }
                else {
                    System.out.println("You already rented 5 apartments !!! " +
                            "\nYou cannot rent more then 5 apartments!!!");
                    return false;
                }
            }
        } catch (ProblematicTenantException e) {
            System.out.println("Problemmatic Tenant: "+e.getMessage());
            return false;
        }


    }

    private void checkPersonProblematicStatus(Person person) throws ProblematicTenantException {
        if(person.getLetters().size()>3) {
            throw new ProblematicTenantException("This tenant has problem for renting");
        }

    }

    public boolean rentParkingPlace(Person person,ParkingPlace place){
        if (isRented(place)){
            return false;
        }else {
            if (person.getRentedParkingPlaces().size()<=5){
                person.getRentedParkingPlaces().add(place);
                System.out.println("You rented the parking place ");
                place.setTenant(person);
                return true;
            }else {
                System.out.println("You already rented 5 parking places !!! " +
                        "\nYou cannot rent more then 5 parking places!!!");
            }
        }

        return false;
    }
    private   boolean isRented(Apartment apartment){
        if (apartment.getTenant()==null){
            return false;
        }else {
            System.out.println("The Room is already Rented by " +apartment.getTenant().getName());
            return true;
        }
    }
    private   boolean isRented(ParkingPlace parkingPlace){
        if (parkingPlace.getTenant()==null){
            return false;
        }else {
            System.out.println("The Place is already Rented by " +parkingPlace.getTenant().getName());
            return true;
        }
    }
    public static List<Apartment> listOfApartments(List<Apartment> apartmentList){
        for (Apartment apartments : apartmentList
        ) {
            System.out.print(apartments.toString());
        }
        return apartmentList;
    }
    public static List<ParkingPlace> parkingPlaceList(List<ParkingPlace>parkingPlaces){
        for (ParkingPlace parkingPlace : parkingPlaces) {
            System.out.println(parkingPlace.toString());
        }
        return parkingPlaces;
    }
    public boolean addItem(BaseItem item, ParkingPlace parkingPlace){
        try {
            if (item==null){
                System.out.println("There is no item as that name");
                return false;
            }else {
                checkTooManyThingStatus(parkingPlace,item);
                parkingPlace.setAddedItemsVolume(parkingPlace.getAddedItemsVolume()+item.getCubicMeter());
                parkingPlace.getItemList().add(item);
                return true;
            }
        } catch (TooManyThingsException e) {
            System.out.println("Too many things in parking place: "+e.getMessage());
            return false;
        }



    }

    private void checkTooManyThingStatus(ParkingPlace parkingPlace, BaseItem item) throws TooManyThingsException{
        if (item.getCubicMeter()+parkingPlace.getAddedItemsVolume()>=parkingPlace.getCubicMeter()){
            throw new TooManyThingsException("Cannot add the item because Parking Place is already full or close to full!!" +
                    "\nTo add an item remove an item");
        }

    }
    private void checkTooManyThingStatus(ParkingPlace parkingPlace, BaseVehicle vehicle) throws TooManyThingsException{
        if (vehicle.getCubicMeter()+parkingPlace.getAddedItemsVolume()>=parkingPlace.getCubicMeter()){
            throw new TooManyThingsException("Cannot add the item because Parking Place is already full or close to full!!" +
                    "\nTo add an item remove an item");
        }

    }

    public boolean removeItem(BaseItem item,ParkingPlace parkingPlace){
        if (item==null){
            System.out.println("There is no item as that name");
            return false;
        }else {

                parkingPlace.setAddedItemsVolume(parkingPlace.getAddedItemsVolume()-item.getCubicMeter());
                parkingPlace.getItemList().remove(item);
                return true;

        }
    }
    public boolean addVehicle(BaseVehicle vehicle, ParkingPlace parkingPlace) {
        try {
            if (vehicle==null){
                System.out.println("There is no item as that name");
                return false;
            }else {
                checkTooManyThingStatus(parkingPlace,vehicle);
                parkingPlace.setAddedItemsVolume(parkingPlace.getAddedItemsVolume()+vehicle.getCubicMeter());
                parkingPlace.getVehicleList().add(vehicle);
                return true;
            }
        } catch (TooManyThingsException e) {
            System.out.println("Too many things in parking place: "+e.getMessage());
            return false;
        }

    }
    public boolean removeVehicle(BaseVehicle vehicle, ParkingPlace parkingPlace) {
        if (vehicle==null){
            System.out.println("There is no item as that name");
            return false;
        }else {

            parkingPlace.setAddedItemsVolume(parkingPlace.getAddedItemsVolume()-vehicle.getCubicMeter());
            parkingPlace.getItemList().remove(vehicle);
            return true;

        }
    }

}
