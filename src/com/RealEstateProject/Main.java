package com.RealEstateProject;

import com.RealEstateProject.Vehicle.BaseVehicle;
import com.RealEstateProject.Vehicle.impl.*;
import com.RealEstateProject.item.BaseItem;
import com.RealEstateProject.util.FileProcess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static List<Apartment> apartmentList = new ArrayList<>();
    public static List<Person> personList = new ArrayList<>();
    public static List<ParkingPlace> parkingPlaces = new ArrayList<>();

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        allocateData();
        printMenuOptions();
        runMenu();

    }



    public static void printMenuOptions() {
        System.out.println(
                "**Welcome to Rent Service**\n" +
                        "----------------------------------------------------------------------------------------" +
                        "\n|1- List All Apartments                                                              |\n" +
                        "|2- Rent An Apartment                                                                  |\n" +
                        "|3- Rent a Parking Place                                                               |\n" +
                        "|4-  Create Item                                                                       |\n" +
                        "|5- Create Vehicle                                                                     |\n" +
                        "|6- Create Person                                                                      |\n" +
                        "|7- Create Apartment                                                                   |\n" +
                        "|8- Create Parking Place                                                               |\n" +
                        "|9- Put Or Remove Item                                                                 |\n" +
                        "|10- Print Menu Options                                                                |\n" +
                        "|0- Enter 0 for exit                                                                   |\n" +
                        "----------------------------------------------------------------------------------------");

    }
    public static void allocateData() {
        //Create 10 Apartments
        Apartment apartment1 = new Apartment(80);
        Apartment apartment2 = new Apartment(94);
        Apartment apartment3 = new Apartment(100);
        Apartment apartment4 = new Apartment(105);
        Apartment apartment5 = new Apartment(75);
        Apartment apartment6 = new Apartment(65);
        Apartment apartment7 = new Apartment(91);
        Apartment apartment8 = new Apartment(83);
        Apartment apartment9 = new Apartment(58);
        Apartment apartment10 = new Apartment(78);

        //Apartment List
        apartmentList.add(apartment1);
        apartmentList.add(apartment2);
        apartmentList.add(apartment3);
        apartmentList.add(apartment4);
        apartmentList.add(apartment5);
        apartmentList.add(apartment6);
        apartmentList.add(apartment7);
        apartmentList.add(apartment8);
        apartmentList.add(apartment9);
        apartmentList.add(apartment10);

        //Create 5 Person
        Person person1 = new Person("William", "Koch", "Frankfurter Street 12");
        Person person2 = new Person("Alfred", "Junior", "Bach Street 23");
        Person person3 = new Person("Jonathan", "Robert", "Rose Stret 56");
        Person person4 = new Person("James", "Smith", "Menonos Street 21");
        Person person5 = new Person("Linus", "Towarlds", "Linux Street 01");
        Person person6 = new Person("Dennis", "Ritchie", "C Street 2");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);

        //Create 10 Parking Place
        ParkingPlace parkingPlace1 = new ParkingPlace(20);
        ParkingPlace parkingPlace2 = new ParkingPlace(25);
        ParkingPlace parkingPlace3 = new ParkingPlace(15);
        ParkingPlace parkingPlace4 = new ParkingPlace(30);
        ParkingPlace parkingPlace5 = new ParkingPlace(25);
        ParkingPlace parkingPlace6 = new ParkingPlace(20);
        ParkingPlace parkingPlace7 = new ParkingPlace(40);
        ParkingPlace parkingPlace8 = new ParkingPlace(34);
        ParkingPlace parkingPlace9 = new ParkingPlace(17);
        ParkingPlace parkingPlace10 = new ParkingPlace(22);

        parkingPlaces.add(parkingPlace1);
        parkingPlaces.add(parkingPlace2);
        parkingPlaces.add(parkingPlace3);
        parkingPlaces.add(parkingPlace4);
        parkingPlaces.add(parkingPlace5);
        parkingPlaces.add(parkingPlace6);
        parkingPlaces.add(parkingPlace7);
        parkingPlaces.add(parkingPlace8);
        parkingPlaces.add(parkingPlace9);
        parkingPlaces.add(parkingPlace10);

        //Pre-Allocate
        RentService rentService = new RentService();
        rentService.rentApartment(person1, apartment1);
        rentService.rentApartment(person2, apartment2);
        rentService.rentApartment(person3, apartment4);
        rentService.rentApartment(person4, apartment7);
        rentService.rentApartment(person5, apartment8);

        //Create Items and Vehicles
        BaseItem television = new BaseItem("Television", 2, person1);
        OffRoadCarImpl offRoadCar = new OffRoadCarImpl(3, "Hyundai", 2, "small", "Eco", person1, true, false);

        // write all list to file



    }
    private static void runMenu() {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        String option;
        int menuItem = 0;

        do {

            startDayTimer(apartmentList);
            startExpiredTimer(apartmentList);
            System.out.println("Choose menu item: ");
            System.out.println("------------------------------------------------------------------------------------------\n"
            );
            option = input.nextLine();
            try {
                menuItem = Integer.valueOf(option);
                switch (menuItem) {

                    case 1:

                        apartmentList.forEach(apartment -> System.out.println(apartment.toString()));
                        break;
                    case 2:

                        rentApartment(personList,apartmentList);
                        break;
                    case 3:

                        rentParkingPlace();
                        break;
                    case 4:


                        createItem();
                        break;
                    case 5:
                        createVehicle();
                        break;
                    case 6:
                        createPerson();
                        putOrRemoveItem();
                        break;
                    case 7:
                       createApartment();
                        break;
                    case 8:
                        createParkingAPlace();
                        break;
                    case 9:
                        putOrRemoveItem();
                        break;
                    case 10:
                        printMenuOptions();
                        break;
                    case 0:
                        System.out.println("You quit successfully...");
                        //Sort person list asc
                        ascOrderAndWritePersonToFile(personList);
                        quit = true;
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                e.getMessage();
            }

        } while (!quit);
    }






    private static void rentParkingPlace() {
        System.out.println("Available Parking Places");
        parkingPlaces.forEach(parkingPlace -> {
            if (parkingPlace.getTenant() == null) {
                System.out.println("Parking Place ID : " + parkingPlace.getID().toString().substring(0, 5) + "\t" + parkingPlace.getCubicMeter() + "m2");
            }
        });
        RentService rentService = new RentService();
        ParkingPlace selectedParkingPlace = null;
        Person selectedPerson = null;

        System.out.println("Enter a parking place  id ");
        String id = scan.nextLine();

        for (ParkingPlace parkingPlace : parkingPlaces) {
            if (parkingPlace.getID().toString().contains(id)) {
                selectedParkingPlace = parkingPlace;
            }
        }
        personList.forEach(person -> {
            System.out.println(person.getID().toString().substring(0, 5) + " " + person.getName());
        });
        System.out.println("Please Enter Person Id");
        String personID = scan.nextLine();

        for (Person person : personList) {
            if (person.getID().toString().contains(personID)) {
                selectedPerson = person;
            }
        }
        if (selectedParkingPlace == null || selectedPerson == null) {
            System.out.println("There is no Person or Parking  as you wanted !");

        } else {
            rentService.rentParkingPlace(selectedPerson, selectedParkingPlace);
        }
    }
    private static void ascOrderAndWritePersonToFile(List<Person> personList) {
        Comparator<Person> c = Comparator.comparing(Person::getName);
        personList.sort(c);

        // write person list to file
        try {
            FileProcess.writePerson(personList);
        }catch(Exception e) {
            System.out.println("Error while file writing");
        }
    }
    private static void startExpiredTimer(List<Apartment> apartmentList) {
        Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                apartmentList.forEach(apartment -> {
                    // First if block for check expired and create tenant letter
                    if(apartment.getStartDate()!=null && apartment.getEndDate()!=null) {
                        if (apartment.getDayCount() * (86400000) > apartment.getEndDate().getTime() - apartment.getStartDate().getTime()) {
                            apartment.setExpired(true);

                            if(apartment.getTenant()!=null) {
                                TenantLetter expireLetter = new TenantLetter();
                                expireLetter.setTenant(apartment.getTenant());
                                expireLetter.setApartment(apartment);
                                expireLetter.setMessage("Apartment is expired");
                                apartment.getTenant().getLetters().add(expireLetter);
                            }
                        }
                    }
                    // Second block is check 30 day control
                    if(apartment.isExpired() && (( apartment.getDayCount()*86400000)-(apartment.getEndDate().getTime()-apartment.getStartDate().getTime())>30*86400000)) {
                        apartment.getTenant().getRentedApartments().forEach(apartment1 -> {
                            if(apartment.getID()==apartment1.getID()) {
                                apartment.getTenant().getRentedApartments().remove(apartment);
                            }
                        });
                        apartment.setTenant(null);
                    }
                });
            }
        }, 10 * (1000));
    }
    private static void startDayTimer(List<Apartment> apartmentList) {
        Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                apartmentList.forEach(apartment -> {
                    apartment.setDayCount(apartment.getDayCount() + 1);
                });
            }
        }, 5 * (1000));
    }
    private static void putOrRemoveItem() {
        personList.forEach(person -> System.out.println(person.getID().toString().substring(0,5)+" "+person.getName()));
        Person selectedPerson = null;
        System.out.println("Please Enter Your ID!");
        String  ID=scan.nextLine();
        for (Person person : personList) {
            if (person.getID().toString().contains(ID)){
                selectedPerson=person;
            }
        }
        System.out.println("Your Items And Vehicles In List");
        selectedPerson.getItems().forEach(item -> System.out.println(item.toString()));
        selectedPerson.getVehicles().forEach(vehicle -> System.out.println(vehicle.toString()));

        System.out.println("1 - Add an Item or Vehicle" +
                "\n2 - Remove an Item or Vehicle");
        RentService rentService = new RentService();
        BaseVehicle selectedVehicle = null;
        BaseItem selectedItem = null;
        System.out.println("Please Enter Item Name");
        String itemName=scan.nextLine();
        for (BaseItem items: selectedPerson.getItems()) {
            if (items.getName().equalsIgnoreCase(itemName)){
                selectedItem=items;
            }
        }
        for (BaseVehicle vehicle: selectedPerson.getVehicles()) {
            if (vehicle.getName().equalsIgnoreCase(itemName)){
            }
            selectedVehicle=vehicle;
        }
       ParkingPlace selectedParkingPlace = null;
        selectedPerson.getRentedParkingPlaces().forEach(parkingPlace -> System.out.println(parkingPlace.getID().toString().substring(0,5)+" "+parkingPlace.getCubicMeter()));
        System.out.println("Please Enter Parking Place ID");
        String parkingPlaceID=scan.nextLine();
        for (ParkingPlace parkingPlace: parkingPlaces) {
            if (parkingPlace.getID().toString().contains(parkingPlaceID)){
                selectedParkingPlace=parkingPlace;
            }
        }
        int option = scan.nextInt();
        switch (option) {
            case 1:
                System.out.println("1 to add Item\n" +
                        "2 to add vehicle");
                int addItemOrVehicle = scan.nextInt();
                switch (addItemOrVehicle) {
                    case 1:
                        rentService.addItem(selectedItem, selectedParkingPlace);
                        break;
                    case 2:
                        rentService.addVehicle(selectedVehicle, selectedParkingPlace);
                        break;
                    default:
                        System.out.println("Unreachable option");
                        break;
                }

            case 2:
                System.out.println("1 to remove an Item\n" +
                        "2 to remove a Vehicle");
                int removeItemOrVehicle = scan.nextInt();
                switch (removeItemOrVehicle) {
                    case 1:
                        rentService.removeItem(selectedItem, selectedParkingPlace);
                        break;
                    case 2:
                        rentService.removeVehicle(selectedVehicle, selectedParkingPlace);
                    default:
                        System.out.println("Unreachable option");
                        break;
                }

                break;
            default:
                break;
        }
    }
    private static void rentApartment(List<Person> personList, List<Apartment> apartmentList) {
        System.out.println("All available apartments - Select One");
        apartmentList.forEach(apartment -> {
            if (apartment.getTenant() == null || apartment.isExpired()) {
                System.out.println("Apartment id: " + apartment.getID().toString().substring(0, 5) + "\t" + apartment.getCubicMeter() + " m2");
            }
        });

        System.out.println("Enter an apartment id only min 5 digits");
        String id = scan.nextLine();
        RentService rentService = new RentService();
        Apartment selectedApartment = null;
        Person selectedPerson = null;
        for (Apartment apartment : apartmentList) {
            if (apartment.getID().toString().contains(id)) {
                selectedApartment = apartment;
            }
        }

        System.out.println("Person List ");
        personList.forEach(person -> {
            System.out.println(person.getID() + "\t" + person.getName());
        });
        System.out.println("Enter an person id only min 5 digits");
        String personId = scan.nextLine();

        for (Person person : personList) {
            if (person.getID().toString().contains(personId)) {
                selectedPerson = person;
            }
        }
        setStartDate(selectedApartment);
        setEndDate(selectedApartment);

        if (selectedApartment == null || selectedPerson == null) {
            System.out.println("No person or apartment selected");
        } else {
            rentService.rentApartment(selectedPerson, selectedApartment);
        }


        ascOrderAndWritePersonToFile(personList);

    }
    private static void setEndDate(Apartment apartment) {
        System.out.println("Please enter end date: (dd-MM-yyyy)");
        String strEndDate=scan.nextLine();

        Date endDate= null;
        try {
            endDate = new SimpleDateFormat("dd-MM-yyyy").parse(strEndDate);
            apartment.setEndDate(endDate);
        } catch (ParseException e) {
            System.out.println("Enter valid date format for end date");
            setEndDate(apartment);
        }


    }
    private static void setStartDate(Apartment apartment) {
        System.out.println("Please enter start date: (dd-MM-yyyy)");
        String strStartDate=scan.nextLine();

        Date startDate= null;
        try {
            startDate = new SimpleDateFormat("dd-MM-yyyy").parse(strStartDate);
            apartment.setStartDate(startDate);
        } catch (ParseException e) {
            System.out.println("Enter valid date format for start date");

            setStartDate(apartment);
        }


    }
    public static void createItem(){
        personList.forEach(person -> System.out.println(person.getID().toString().substring(0,5)+" "+person.getName()));
        Person selectedPerson=null;
        System.out.println("Please Enter Your ID!");
        String ID=scan.nextLine();
        for (Person person : personList) {
            if (person.getName().contains(ID))
                selectedPerson=person;
        }
        System.out.println("Please Enter Item Name");
        String name= scan.nextLine();
        System.out.println("Please Enter The Volume of the Item");
        double cubicMeter = scan.nextDouble();
        BaseItem newItem = new BaseItem(name,cubicMeter,selectedPerson);
        selectedPerson.getItems().add(newItem);
    }
    public static void createVehicle(){
        personList.forEach(person -> System.out.println(person.getID().toString().substring(0,5)+" "+person.getName()));
        Person selectedPerson=null;
        System.out.println("Please Enter Your ID!");
        String ID=scan.nextLine();
        for (Person person : personList) {
            if (person.getName().contains(ID))
                selectedPerson=person;
        }
        System.out.println("Please Enter The Volume Of The Vehicle");
        int volume = scan.nextInt();
        System.out.println("Please Enter The Name Of The Vehicle");
        String name= scan.nextLine();
        System.out.println("Please Enter The Engine Capacity Of The Vehicle");
        int capacity= scan.nextInt();
        System.out.println("Please Enter Engine Type Of The Vehicle");
        String engineType=scan.nextLine();
        String[] types={"city-car","boat","amphibious","motorcycle","off-road"};
        System.out.println("Select vehicle type");
        for(int i=0;i<types.length;i++) {
            System.out.println(i+1+". "+types[i]);
        }

        System.out.println("Enter Type Of The Vehixle");
        String type=scan.nextLine();

       if(type.equalsIgnoreCase("city-car")) {
           System.out.println("Is Vehicle Contains Sun Roof? True or False");
           String isSunRoof=scan.nextLine();
           boolean sunRoof;
           if (isSunRoof.equalsIgnoreCase("true")){
               sunRoof=true;
           }else {
               sunRoof = false;
           }
           System.out.println("Is Vehicle Contains ABS? True or False");
           String isABS=scan.nextLine();
           boolean abs;
           if (isSunRoof.equalsIgnoreCase("true")){
               abs=true;
           }else {
               abs = false;
           }

            CityCarImpl cityCar=new CityCarImpl(volume,name,capacity,type,engineType,selectedPerson,sunRoof,abs);
            selectedPerson.getVehicles().add(cityCar);
        }else if(type.equalsIgnoreCase("boat")) {
           System.out.println("Is Boat Contains Cabin? True or False");
           String hasCabin=scan.nextLine();
           boolean cabin;
           if (hasCabin.equalsIgnoreCase("true")){
               cabin=true;
           }else {
               cabin = false;
           }
           System.out.println("Is Boat Contains Water Tank? True or False");
           String hasWaterTank =scan.nextLine();
           boolean waterTank;
           if (hasWaterTank.equalsIgnoreCase("true")){
               waterTank=true;
           }else {
               waterTank = false;
           }
            BoatImpl boat=new BoatImpl(volume,name,capacity,type,engineType,selectedPerson,cabin,waterTank);
            selectedPerson.getVehicles().add(boat);
        }else if(type.equalsIgnoreCase("amphibious")) {
           System.out.println("Is Amphibious Contains Palette? True or False");
           String hasPalette=scan.nextLine();
           boolean palette;
           if (hasPalette.equalsIgnoreCase("true")){
               palette=true;
           }else {
               palette = false;
           }
            AmphibiousImpl amphibious=new AmphibiousImpl(volume,name,capacity,type,engineType,selectedPerson,palette);
           selectedPerson.getVehicles().add(amphibious);
        }else if(type.equalsIgnoreCase("motorcycle")) {
           System.out.println("Is Motorcycle Fully Suspension? True or False");
           String fullySuspension=scan.nextLine();
           boolean suspension;
           if (fullySuspension.equalsIgnoreCase("true")){
               suspension=true;
           }else {
               suspension = false;
           }

            MotorcycleImpl motorcycle=new MotorcycleImpl(volume,name,capacity,type,engineType,selectedPerson,suspension);
           selectedPerson.getVehicles().add(motorcycle);
        }else if(type.equalsIgnoreCase("off-road")){
           System.out.println("Is Off Road Car with Suspension? True or False");
           String isSuspension=scan.nextLine();
           boolean suspension;
           if (isSuspension.equalsIgnoreCase("true")){
               suspension=true;
           }else {
               suspension = false;
           }
           System.out.println("Is Off Road  Car Big Tier ? True or False");
           String isBigTier=scan.nextLine();
           boolean bigTier;
           if (isBigTier.equalsIgnoreCase("true")){
               bigTier=true;
           }else {
               bigTier = false;
           }
            OffRoadCarImpl offRoadCar=new OffRoadCarImpl(volume,name,capacity,type,engineType,selectedPerson,suspension,bigTier);
           selectedPerson.getVehicles().add(offRoadCar);
        }else {
           BaseVehicle newVehicle = new BaseVehicle(volume,name,capacity,type,engineType,selectedPerson);

        }





    }
    public static void createPerson(){
        System.out.println("Please Enter A new Person name ");
        String name =scan.nextLine();
        System.out.println("Please Enter A surname for Person");
        String surname=scan.nextLine();
        System.out.println("Please Enter Address of the Person");
        String address =scan.nextLine();
        Person newPerson = new Person(name,surname,address);
        personList.add(newPerson );
    }
    public static void createApartment(){
        System.out.println("Please Enter A Volume For new Apartment");
        int volume =scan.nextInt();
        Apartment newApartment = new Apartment(volume);
        apartmentList.add(newApartment);

    }
    public static void createParkingAPlace(){
        System.out.println("Please Enter A Volume For new Parking Place");
        int volume =scan.nextInt();
        ParkingPlace newParkingPlace = new ParkingPlace(volume);
        parkingPlaces.add(newParkingPlace);
    }


}
