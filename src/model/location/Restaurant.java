package model.location;

import java.util.Scanner;

public class Restaurant extends Location {
    //for concerts
    //StreetFood
    //TheatricalPiece

    private Integer number_of_seats;
    private Integer table_seats;
    private Float price_per_seats;
    private Boolean scene;
    private Float scene_price;
    private Boolean equipment;
    private Float price_of_equipment;

    public Restaurant() {}

    public Restaurant(Zone zone, String name, String country, String town, String street, String number, Integer number_of_seats, Integer table_seats, Float price_per_seats, Boolean scene, Float scene_price, Boolean equipment, Float price_of_equipment) {
        super(zone, name, country, town, street, number);
        this.number_of_seats = number_of_seats;
        this.table_seats = table_seats;
        this.price_per_seats = price_per_seats;
        this.scene = scene;
        this.scene_price = scene_price;
        this.equipment = equipment;
        this.price_of_equipment = price_of_equipment;
    }
    @Override
    public void Read_Info() {
        System.out.print("\nYou want to add a restaurant\n");
        Scanner read = new Scanner(System.in);
        Scanner read1 = new Scanner(System.in);
        System.out.print("Location type:\n\t1. City\n\t2. Sea\n\t3. Mountain");
        System.out.print("\n\tAnswer: ");
        String zone= read.nextLine();
        zone = zone.toUpperCase();

        if (zone.equals("CITY")){
            this.setZone(Zone.CITY);
        } else if (zone.equals("SEA")){
            this.setZone(Zone.SEA);
        }else if (zone.equals("MOUNTAIN")){
            this.setZone(Zone.MOUNTAIN);
        }
        else{
            System.out.print("\n\tSorry! Try again");

        }

        System.out.print("Location name: ");
        String loc_name = read.nextLine();
        this.setName(loc_name);

        System.out.print("Contry name: ");
        String contry = read.nextLine();
        this.setCountry(contry);

        System.out.print("Town name: ");
        String town = read.nextLine();
        this.setTown(town);

        System.out.print("Street name: ");
        String street = read.nextLine();
        this.setStreet(street);

        System.out.print("Location number: ");
        String number = read.nextLine();
        this.setNumber(number);


        System.out.print("With scene?\n\t1. Yes\n\t2. No");
        System.out.print("\n\tAnswer: ");
        String scene= read.nextLine();
        scene =scene.toUpperCase();
        if(scene.equals("YES"))
        {
            this.scene=Boolean.TRUE;
            System.out.print("Price scene:");
            String price_scene = read.nextLine();
            this.scene_price = Float.parseFloat(price_scene);
        }
        else if (scene.equals("NO")){
            this.scene=Boolean.FALSE;
            this.scene_price = 0.0f;
        }
        else {
            System.out.print("Try again!");
        }

        System.out.print("Number of seats: ");
        int num_of_seats = read.nextInt();
        this.number_of_seats = num_of_seats;

        System.out.print("Price per seats:");
        float price_per_seats = read.nextFloat();
        this.price_per_seats = price_per_seats;

        System.out.print("Table of seats: ");
        int table = read.nextInt();
        this.table_seats = table;

        System.out.print("With equipment?\n\t1. Yes\n\t2. No");
        System.out.print("\n\tAnswer1/2: ");
        Integer equipment1 = read.nextInt();
       // equipment1 = equipment1.toUpperCase();
        if(equipment1 == 1)
        {
            this.equipment=Boolean.TRUE;
            System.out.print("Price of equipment:");
            float price_eq = read.nextFloat();
            this.price_of_equipment = price_eq;
        }
        else if (equipment1==2){
            this.equipment=Boolean.FALSE;
            this.price_of_equipment = 0.0f;
        }
        else {
            System.out.print("Try again!");
        }
    }

    @Override
    public String toString() {
        String zone_type;
        String location_address=" \n\nRestaurant info: \n";

        if (getZone() == Zone.SEA){
            zone_type = "The location is at sea. ";
        }
        else if (getZone() == Zone.CITY) {
            zone_type = "The location is in the city. ";
        }
        else
            zone_type = "The location is in the mountains. ";
        if (getName().equals("") ||  getCountry().equals("") || getStreet().equals("") || getTown().equals("") || getNumber().equals("")) {
            location_address = location_address + zone_type + "No other details are known about this location";
        }
        else{
            location_address = location_address + zone_type + "Name of location is " + getName() + "Address: " + getCountry() + ", " + getTown() + ", " + getStreet() + ", " + "number " + getNumber();
        }
        location_address = location_address + "." +"\n Restaurant details: \n" +
                "\n\t Tables with " + table_seats + "chairs";
        if (scene)
            location_address = location_address + "\n\t With scene";
        else
            location_address = location_address + "\n\t Without scene";
        if (equipment)
            location_address = location_address + "\n\t With equipment";
        else
            location_address = location_address + "\n\t Without equipment";
        return location_address;
    }

    public Integer getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(Integer number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public Integer getTable_seats() {
        return table_seats;
    }

    public void setTable_seats(Integer table_seats) {
        this.table_seats = table_seats;
    }

    public Float getPrice_per_seats() {
        return price_per_seats;
    }

    public void setPrice_per_seats(Float price_per_seats) {
        this.price_per_seats = price_per_seats;
    }

    public Boolean getScene() {
        return scene;
    }

    public void setScene(Boolean scene) {
        this.scene = scene;
    }

    public Float getScene_price() {
        return scene_price;
    }

    public void setScene_price(Float scene_price) {
        this.scene_price = scene_price;
    }

    public Boolean getEquipment() {
        return equipment;
    }

    public void setEquipment(Boolean equipment) {
        this.equipment = equipment;
    }

    public Float getPrice_of_equipment() {
        return price_of_equipment;
    }

    public void setPrice_of_equipment(Float price_of_equipment) {
        this.price_of_equipment = price_of_equipment;
    }
}
