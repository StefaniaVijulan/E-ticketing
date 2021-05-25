package model.location;

import java.util.Scanner;

public class GuestHouse extends Location{
    private Integer number_of_stars;
    private Boolean pets;
    private Float number_of_rooms;
    private Boolean conference_room;
    private Float rooms_price;
    private Boolean pool;

    public GuestHouse() {

    }

    public GuestHouse(Zone zone, String name, String country, String town, String street, String number, Integer number_of_stars, Boolean pets, Float number_of_rooms, Boolean conference_room, Float rooms_price, Boolean pool) {
        super(zone, name, country, town, street, number);
        this.number_of_stars = number_of_stars;
        this.pets = pets;
        this.number_of_rooms = number_of_rooms;
        this.conference_room = conference_room;
        this.rooms_price = rooms_price;
        this.pool = pool;
    }

    @Override
    public void Read_Info() {
        Scanner read = new Scanner(System.in);
        Scanner read1 = new Scanner(System.in);
        System.out.print("You want to add a Guest House!\n");
        System.out.print("Location type:\n\t1. City\n\t2. Sea\n\t3. Mountain");
        System.out.print("\n\tAnswer: ");
        String zone= read.nextLine();
        zone = zone.toUpperCase();
        if (zone.equals("CITY") || zone.equals("1")){
            this.setZone(Zone.CITY);
        } else if (zone.equals("SEA") || zone.equals("2")){
            this.setZone(Zone.SEA);
        }else if (zone.equals("MOUNTAIN") || zone.equals("3")){
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


        System.out.print("With pets?\n\t1. Yes\n\t2. No");
        System.out.print("\n\tAnswer: ");
        String petss = read.nextLine();
        petss= petss.toUpperCase();
        if( petss.equals("YES") || petss.equals("1")){
            this.pets=Boolean.TRUE;
        }else if (petss.equals("NO") || petss.equals("2")){
            this.pets=Boolean.FALSE;
        }else{
            System.out.println("Try again");
        }
        System.out.print("Number of stars: ");
        int num_of_stars = read.nextInt();
        this.number_of_stars = num_of_stars;

        System.out.print("With conference room?\n\t1. Yes\n\t2. No");
        System.out.print("\n\tAnswer: ");
        String conf = read1.nextLine();
        conf = conf.toUpperCase();
        if( conf.equals("YES") ||conf.equals("1")){
            this.conference_room=Boolean.TRUE;
        }else if (conf.equals("NO") ||conf.equals("2")){
            this.conference_room=Boolean.FALSE;
        }else{
            System.out.println("Try again");
        }
        System.out.print("Number of rooms: ");
        float number_of_rooms = read.nextFloat();
        this.number_of_rooms = number_of_rooms;

        System.out.print("Rooms price: ");
        float pricer = read.nextFloat();
        this.rooms_price =pricer;

        System.out.print("With pool?\n\t1. Yes\n\t2. No");
        System.out.print("\n\tAnswer: ");
        String pools = read1.nextLine();
       pools= pools.toUpperCase();
        if( pools.equals("YES") || pools.equals("1")){
            this.pool=Boolean.TRUE;
        }else if (pools.equals("NO") || pools.equals("2")){
            this.pool=Boolean.FALSE;
        }else{
            System.out.println("Try again");
        }
    }
    @Override
    public String toString() {
        String zone_type;
        String location_address="\n\tGuest House:\n";
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
            location_address = location_address + zone_type + "Name of location is " + getName()+ ".\n Address: " + getCountry() + ", " + getTown() + ", " + getStreet() + ", " + "number " + getNumber();
        }
        location_address = location_address + "." +"\n Guest House details: \n" +
                "\t Number of stars: " + number_of_stars;
        if (pets)
            location_address= location_address+ "\n\t With pets";
        else
            location_address= location_address+ "\n\t Without pets";
        if (conference_room)
            location_address= location_address+ "\n\t With conference room";
        else
            location_address= location_address+ "\n\t Without conference room";
        if (pool)
            location_address = location_address + "\n\t With pool";
        else
            location_address =location_address + "\n\t Without pool";
        location_address = location_address + "\n\t With " + number_of_rooms+ " rooms";
        return  location_address;
    }

    public  Integer getNumber_of_stars() {
        return number_of_stars;
    }

    public void setNumber_of_stars(Integer number_of_stars) {
        this.number_of_stars = number_of_stars;
    }

    public Boolean getPets() {
        return pets;
    }

    public void setPets(Boolean pets) {
        this.pets = pets;
    }

    public Float getNumber_of_rooms() {
        return number_of_rooms;
    }

    public void setNumber_of_rooms(Float number_of_rooms) {
        this.number_of_rooms = number_of_rooms;
    }

    public Boolean getConference_room() {
        return conference_room;
    }

    public void setConference_room(Boolean conference_room) {
        this.conference_room = conference_room;
    }

    public Float getRooms_price() {
        return rooms_price;
    }

    public void setRooms_price(Float rooms_price) {
        this.rooms_price = rooms_price;
    }

    public Boolean getPool() {
        return pool;
    }

    public void setPool(Boolean pool) {
        this.pool = pool;
    }
}
