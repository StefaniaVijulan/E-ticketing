package location;

import event.Event;

import java.util.Scanner;

public class GuestHouse extends Location{
    //SchoolCamp
    //StreetFood?
    private Integer number_of_starts;
    private Boolean pets;
    private Float number_of_rooms;
    private Boolean conference_room;
    private Float rooms_price;
    private Boolean pool;

    public  GuestHouse(){}

    public GuestHouse(Zone zone, String name, String country, String town, String street, String number, Integer number_of_starts, Boolean pets, Float number_of_rooms, Boolean conference_room, Float rooms_price, Boolean pool) {
        super(zone, name, country, town, street, number);
        this.number_of_starts = number_of_starts;
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
        System.out.print("----------Guest House-----------\n");
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


        System.out.print("With pets?\n\t1. Yes\n\t2. No");
        System.out.print("\n\tAnswer: ");
        String petss = read.nextLine();
        petss= petss.toUpperCase();
        if( petss.equals("YES")){
            this.pets=Boolean.TRUE;
        }else if (petss.equals("NO")){
            this.pets=Boolean.FALSE;
        }else{
            System.out.println("Try again");
        }
        System.out.print("Number of starts: ");
        int num_of_starts = read.nextInt();
        this.number_of_starts = num_of_starts;

        System.out.print("With conference room?\n\t1. Yes\n\t2. No");
        System.out.print("\n\tAnswer: ");
        String conf = read1.nextLine();
        conf = conf.toUpperCase();
        if( conf.equals("YES")){
            this.conference_room=Boolean.TRUE;
        }else if (conf.equals("NO")){
            this.conference_room=Boolean.FALSE;
        }else{
            System.out.println("Try again");
        }

        System.out.print("Rooms price: ");
        float pricer = read.nextFloat();
        this.rooms_price =pricer;

        System.out.print("With pool?\n\t1. Yes\n\t2. No");
        System.out.print("\n\tAnswer: ");
        String conf1 = read1.nextLine();
        conf = conf1.toUpperCase();
        if( conf1.equals("YES")){
            this.conference_room=Boolean.TRUE;
        }else if (conf1.equals("NO")){
            this.conference_room=Boolean.FALSE;
        }else{
            System.out.println("Try again");
        }


    };
    @Override
    public String toString() {
        String zone_type;
        String location_address="------------Guest House--------\n";
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
                "\t Number of starts: " + number_of_starts;
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


    @Override
    public float price_location() {
        float price_location = 0;
        price_location = price_location + number_of_starts * 30;
        if (pets)
            price_location = price_location + 105;
        if (conference_room)
            price_location = price_location + 100;
        price_location = price_location + rooms_price *number_of_rooms;
        if(pool)
            price_location = price_location + 35 * number_of_rooms;
        return price_location;
    }

    public Integer getNumber_of_starts() {
        return number_of_starts;
    }

    public void setNumber_of_starts(Integer number_of_starts) {
        this.number_of_starts = number_of_starts;
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
