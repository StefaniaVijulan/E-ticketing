package model.location;

import java.util.Scanner;

public class MultipurposeHall extends Location {
    //For concerts
    //TheatricalPiece
    private Integer number_of_seats;
    private Float price_per_seats;
    private Boolean audio_equipment;
    private Float price_of_the_audio_equipment;
    private Boolean video_equipment;
    private Float price_of_the_video_equipment;

    public MultipurposeHall() { }

    public MultipurposeHall(Zone zone, String name, String country, String town, String street, String number, Integer number_of_seats, Float price_per_seats, Boolean audio_equipment, Float price_of_the_audio_equipment, Boolean video_equipment, Float price_of_the_video_equipment) {
        super(zone, name, country, town, street, number);
        this.number_of_seats = number_of_seats;
        this.price_per_seats = price_per_seats;
        this.audio_equipment = audio_equipment;
        this.price_of_the_audio_equipment = price_of_the_audio_equipment;
        this.video_equipment = video_equipment;
        this.price_of_the_video_equipment = price_of_the_video_equipment;
    }

    @Override
    public String toString() {

        String zone_type;
        String location_address = "------------Multipurpose Hall----------\n";
        if (getZone() == Zone.SEA) {
            zone_type = "The location is at sea. ";
        } else if (getZone() == Zone.CITY) {
            zone_type = "The location is in the city. ";
        } else
            zone_type = "The location is in the mountains. ";
        if (getName().equals("") || getCountry().equals("") || getStreet().equals("") || getTown().equals("") || getNumber().equals("")) {
            location_address = location_address + zone_type + "No other details are known about this location";
        } else {
            location_address = location_address + zone_type + "Name of location is " + getName() + ".\n Address: " + getCountry() + ", " + getTown() + ", " + getStreet() + ", " + "number " + getNumber();
        }
        location_address = location_address + "." + "\n Multipurpose Hall details: \n" +
                "\tNumer of seats: " + number_of_seats;
        if (audio_equipment)
            location_address = location_address + "\n\tWith audio equipment";
        else
            location_address = location_address + "\n\tWithout audio equipment";
        if (video_equipment)
            location_address = location_address + "\n\tWith video equipment";
        else
            location_address = location_address + "\n\tWithout video equipment";

        return location_address;

    }


    @Override
    public void Read_Info() {
        System.out.print("\nYou want to add a Multipurpose Hall\n");
        Scanner read = new Scanner(System.in);
        Scanner read1 = new Scanner(System.in);
        System.out.print("Location type:\n\t1. City\n\t2. Sea\n\t3. Mountain");
        System.out.print("\n\tAnswer: ");
        String zone = read.nextLine();
        zone = zone.toUpperCase();

        if (zone.equals("CITY")) {
            this.setZone(Zone.CITY);
        } else if (zone.equals("SEA")) {
            this.setZone(Zone.SEA);
        } else if (zone.equals("MOUNTAIN")) {
            this.setZone(Zone.MOUNTAIN);
        } else {
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

        System.out.print("Number of seats: ");
        int num_of_seats = read.nextInt();
        this.number_of_seats = num_of_seats;

        System.out.print("Price per seats:");
        float price_per_seats = read.nextFloat();
        this.price_per_seats = price_per_seats;

        System.out.print("With audio system?\n\t1. Yes\n\t2. No");
        System.out.print("\n\tAnswer: ");
        String audio = read.nextLine();
        audio = audio.toUpperCase();
        if (audio.equals("YES")) {
            this.audio_equipment = Boolean.TRUE;
            System.out.print("Price of the audio equipment: ");
            float price_audio = read.nextFloat();
            this.price_of_the_audio_equipment = price_audio;
        } else if (audio.equals("NO")) {
            this.audio_equipment = Boolean.FALSE;
            this.price_of_the_audio_equipment = 0.0f;
        } else {
            System.out.print("Try again!");
        }

        System.out.print("With video system?\n\t1. Yes\n\t2. No");
        String video = read.nextLine();
        video = video.toUpperCase();
        if (video.equals("YES")) {
            this.audio_equipment = Boolean.TRUE;
            System.out.print("Price of the audio equipment:");
            float price_video = read.nextFloat();
            this.price_of_the_video_equipment = price_video;
        } else if (video.equals("NO")) {
            this.audio_equipment = Boolean.FALSE;
            this.price_of_the_video_equipment = 0.0f;
        } else {
            System.out.print("Try again!");
        }

    }


    public Integer getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(Integer number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public Float getPrice_per_seats() {
        return price_per_seats;
    }

    public void setPrice_per_seats(Float price_per_seats) {
        this.price_per_seats = price_per_seats;
    }

    public Boolean getAudio_equipment() {
        return audio_equipment;
    }

    public void setAudio_equipment(Boolean audio_equipment) {
        this.audio_equipment = audio_equipment;
    }

    public Float getPrice_of_the_audio_equipment() {
        return price_of_the_audio_equipment;
    }

    public void setPrice_of_the_audio_equipment(Float price_of_the_audio_equipment) {
        this.price_of_the_audio_equipment = price_of_the_audio_equipment;
    }

    public Boolean getVideo_equipment() {
        return video_equipment;
    }

    public void setVideo_equipment(Boolean video_equipment) {
        this.video_equipment = video_equipment;
    }

    public Float getPrice_of_the_video_equipment() {
        return price_of_the_video_equipment;
    }

    public void setPrice_of_the_video_equipment(Float price_of_the_video_equipment) {
        this.price_of_the_video_equipment = price_of_the_video_equipment;
    }
}

