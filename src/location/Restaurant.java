package location;

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

    public Restaurant(){}

    @Override
    public void Read_Info() {
        System.out.print("-----------Restaurant---------\n");
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
        String scene= read.nextLine();
        scene =scene.toUpperCase();
        if(scene.equals("YES"))
        {
            this.scene=Boolean.TRUE;
            System.out.print("Price scene:");
            float price_scene = read.nextFloat();
            this.scene_price = price_scene;
        }
        else if (scene.equals("NO")){
            this.scene=Boolean.FALSE;
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
        String equipment = read.nextLine();
        equipment = equipment.toUpperCase();
        if(equipment.equals("YES"))
        {
            this.equipment=Boolean.TRUE;
            System.out.print("Price of equipment:");
            float price_eq = read.nextFloat();
            this.price_of_equipment = price_eq;
        }
        else if (equipment.equals("NO")){
            this.equipment=Boolean.FALSE;
        }
        else {
            System.out.print("Try again!");
        }
    }

    ;
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
    public String toString() {
        String zone_type;
        String location_address="-------- Restaurant ------- \n";
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
    public float money_employees(){

        float money_all_employees =0f;
        if (4 <= table_seats && table_seats <= 6 ){
            money_all_employees = (float) (number_of_seats /table_seats) * 10;
        } else if (7 <= table_seats && table_seats <= 10) {
            money_all_employees = (float) (number_of_seats / table_seats) * 20;
        }
        return  money_all_employees;
    }

    @Override
    public float price_location() {
        float price_location = 0;
        price_location = price_location + number_of_seats * price_per_seats + money_employees();
        if (equipment)
            price_location = price_location + price_of_equipment;
        if (scene)
            price_location = price_location + scene_price;
        return price_location;
    }
}
