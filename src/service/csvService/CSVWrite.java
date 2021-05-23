package service.csvService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import client.Buyer;
import model.event.Concert;
import model.event.SchoolCamp;
import model.event.StreetFood;
import model.event.TheatricalPiece;
import model.location.GuestHouse;
import model.location.Hotel;
import model.location.MultipurposeHall;
import model.location.Restaurant;

public class CSVWrite {
    private static CSVWrite single_instance = null;

    public static synchronized CSVWrite getInstance() {
        if (single_instance == null) {
            single_instance = new CSVWrite();

        }
        return single_instance;
    }

    public static <E> void write_in_csv(E object_name, String name_path) throws IOException {
        //Creem calea
        String path = "./src/resources/" + name_path + ".csv";
        File file = new File(path);
        if (file.isFile()) {
            if (file.length() == 0) {
                FileWriter fileWriter = new FileWriter(path, true);
                //luam numele clasei
                switch (object_name.getClass().getSimpleName()) {
                    case "Buyer" -> fileWriter.append("First name,Last name,Phone number,Email,Password,Age");
                    //   case "Organizer" -> fileWriter.append("First name,Last name,Phone number,Email,Password,Seniority in the field");

                    case "Concert" -> fileWriter.append("Location, Name, Number of tickets, Date start, Date end, Hour start, Hour end, Number of pause, Name of singer(s), Singer(s) price");
                    case "SchoolCamp" -> fileWriter.append("Location, Name, Number of tickets, Date start, Date end, Hour start, Hour end, Number of pause, Number of breakfast, Number of dinner, Number of lunch");
                    case "StreetFood" -> fileWriter.append("Location, Name, Number of tickets, Date start, Date end, Hour start, Hour end, Number of pause, Price rented space");
                    case "TheatricalPiece" -> fileWriter.append("Location, Name, Number of tickets, Date start, Date end, Hour start, Hour end, Number of pause, Theme, Name of team, Price of team, Ticket type");

                    case "Hotel" -> fileWriter.append("Zone, Name, Country, Town, Street, Number, Number of stars, Pets, Conference room, Price of room, Number of rooms");
                    case "Restaurant" -> fileWriter.append("Zone, Name, Country, Town, Street, Number, Number of seats, Table seats, Price per seats, Scene, Scene price, Equipment, Price of equipment");
                    case "MultipurposeHall" -> fileWriter.append("Zone, Name, Country, Town, Street, Number, Number of stars, Price per seats, Audio equipment, Price of the audio equipment, Video equipment, Price of the video equipment");
                    case "GuestHouse" -> fileWriter.append("Zone, Name, Country, Town, Street, Number, Number of stars, Pets, Number of rooms, Conference room, Room price, Pool");

                }
                fileWriter.close();
            }
            FileWriter fileWriter = new FileWriter(path, true);
            switch (object_name.getClass().getSimpleName()) {
                case "Hotel" -> {
                    Hotel hotel = (Hotel) object_name;
                    fileWriter.append(hotel.getZone().toString());
                    fileWriter.append(",");
                    fileWriter.append(hotel.getName());
                    fileWriter.append(",");
                    fileWriter.append(hotel.getCountry());
                    fileWriter.append(",");
                    fileWriter.append(hotel.getTown());
                    fileWriter.append(",");
                    fileWriter.append(hotel.getStreet());
                    fileWriter.append(",");
                    fileWriter.append(hotel.getNumber());
                    fileWriter.append(",");
                    fileWriter.append(hotel.getNumber_of_starts().toString());
                    fileWriter.append(",");
                    fileWriter.append(hotel.getPets().toString().toUpperCase());
                    fileWriter.append(",");
                    fileWriter.append(hotel.getConference_room().toString());
                    fileWriter.append(",");
                    fileWriter.append(hotel.getPrice_of_room().toString());
                    fileWriter.append(",");
                    fileWriter.append(hotel.getNumber_of_rooms().toString());
                    fileWriter.append("\n");
                }
                case "Restaurant" -> {
                    Restaurant restaurant =(Restaurant) object_name;

                    fileWriter.append(restaurant.getZone().toString());
                    fileWriter.append(",");
                    fileWriter.append(restaurant.getName());
                    fileWriter.append(",");
                    fileWriter.append(restaurant.getCountry());
                    fileWriter.append(",");
                    fileWriter.append(restaurant.getTown());
                    fileWriter.append(",");
                    fileWriter.append(restaurant.getStreet());
                    fileWriter.append(",");
                    fileWriter.append(restaurant.getNumber());
                    fileWriter.append(",");
                    fileWriter.append(restaurant.getNumber_of_seats().toString());
                    fileWriter.append(",");
                    fileWriter.append(restaurant.getTable_seats().toString());
                    fileWriter.append(",");
                    fileWriter.append(restaurant.getPrice_per_seats().toString());
                    fileWriter.append(",");
                    fileWriter.append(restaurant.getScene().toString());
                    fileWriter.append(",");
                    fileWriter.append(restaurant.getScene_price().toString());
                    fileWriter.append(",");
                    fileWriter.append(restaurant.getEquipment().toString());
                    fileWriter.append(",");
                    fileWriter.append(restaurant.getPrice_of_equipment().toString());
                    fileWriter.append("\n");

                }
                case "MultipurposeHall" -> {
                    MultipurposeHall multipurposeHall =(MultipurposeHall) object_name;
                    fileWriter.append(multipurposeHall.getZone().toString());
                    fileWriter.append(",");
                    fileWriter.append(multipurposeHall.getName());
                    fileWriter.append(",");
                    fileWriter.append(multipurposeHall.getCountry());
                    fileWriter.append(",");
                    fileWriter.append(multipurposeHall.getTown());
                    fileWriter.append(",");
                    fileWriter.append(multipurposeHall.getStreet());
                    fileWriter.append(",");
                    fileWriter.append(multipurposeHall.getNumber());
                    fileWriter.append(",");
                    fileWriter.append(multipurposeHall.getNumber_of_seats().toString());
                    fileWriter.append(",");
                    fileWriter.append(multipurposeHall.getPrice_per_seats().toString());
                    fileWriter.append(",");
                    fileWriter.append(multipurposeHall.getAudio_equipment().toString());
                    fileWriter.append(",");
                    fileWriter.append(multipurposeHall.getPrice_of_the_audio_equipment().toString());
                    fileWriter.append(",");
                    fileWriter.append(multipurposeHall.getVideo_equipment().toString());
                    fileWriter.append(",");
                    fileWriter.append(multipurposeHall.getPrice_of_the_video_equipment().toString());

                    fileWriter.append("\n");
                }
                case "GuestHouse" -> {
                    GuestHouse guestHouse =(GuestHouse) object_name;
                    fileWriter.append(guestHouse.getZone().toString());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getName());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getCountry());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getTown());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getStreet());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getNumber());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getNumber_of_stars().toString());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getPets().toString());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getNumber_of_rooms().toString());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getConference_room().toString());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getRooms_price().toString());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getPool().toString());

                    fileWriter.append("\n");
                }

                case "Concert" ->{
                    Concert concert= (Concert) object_name;
                    fileWriter.append(concert.getLocation().getName());
                    fileWriter.append(",");
                    fileWriter.append(concert.getName_event());
                    fileWriter.append(",");
                    fileWriter.append(concert.getNumber_of_tickets().toString());
                    fileWriter.append(",");
                    fileWriter.append(concert.getDate_start().toString());
                    fileWriter.append(",");
                    fileWriter.append(concert.getDate_end().toString());
                    fileWriter.append(",");
                    fileWriter.append((CharSequence) concert.getHour_start());
                    fileWriter.append(",");
                    fileWriter.append((CharSequence) concert.getHour_end());
                    fileWriter.append(",");
                    fileWriter.append(concert.getNumber_of_pause().toString());
                    fileWriter.append(",");
                    fileWriter.append(concert.getName_of_singer());
                    fileWriter.append(",");
                    fileWriter.append(concert.getSinger_price());
                    fileWriter.append("\n");
                }
                case "SchoolCamp" -> {
                    SchoolCamp schoolCamp = (SchoolCamp) object_name;
                    fileWriter.append(schoolCamp.getLocation().getName());
                    fileWriter.append(",");
                    fileWriter.append(schoolCamp.getName_event());
                    fileWriter.append(",");
                    fileWriter.append(schoolCamp.getNumber_of_tickets().toString());
                    fileWriter.append(",");
                    fileWriter.append(schoolCamp.getDate_start().toString());
                    fileWriter.append(",");
                    fileWriter.append(schoolCamp.getDate_end().toString());
                    fileWriter.append(",");
                    fileWriter.append((CharSequence) schoolCamp.getHour_start());
                    fileWriter.append(",");
                    fileWriter.append((CharSequence) schoolCamp.getHour_end());
                    fileWriter.append(",");
                    fileWriter.append(schoolCamp.getNumber_of_pause().toString());
                    fileWriter.append(",");
                    fileWriter.append(schoolCamp.getNumber_of_breakfast().toString());
                    fileWriter.append(",");
                    fileWriter.append(schoolCamp.getNumber_of_dinner().toString());
                    fileWriter.append(",");
                    fileWriter.append(schoolCamp.getNumber_of_lunch().toString());
                    fileWriter.append("\n");
                }
                case "StreetFood" -> {
                    StreetFood streetFood = (StreetFood) object_name;
                    fileWriter.append(streetFood.getLocation().getName());
                    fileWriter.append(",");
                    fileWriter.append(streetFood.getName_event());
                    fileWriter.append(",");
                    fileWriter.append(streetFood.getNumber_of_tickets().toString());
                    fileWriter.append(",");
                    fileWriter.append(streetFood.getDate_start().toString());
                    fileWriter.append(",");
                    fileWriter.append(streetFood.getDate_end().toString());
                    fileWriter.append(",");
                    fileWriter.append((CharSequence) streetFood.getHour_start());
                    fileWriter.append(",");
                    fileWriter.append((CharSequence) streetFood.getHour_end());
                    fileWriter.append(",");
                    fileWriter.append(streetFood.getNumber_of_pause().toString());
                    fileWriter.append(",");
                    fileWriter.append(streetFood.getPrice_rented_space().toString());
                    fileWriter.append("\n");
                }
                case "TheatricalPiece" ->{
                    TheatricalPiece theatricalPiece = (TheatricalPiece) object_name;
                    fileWriter.append(theatricalPiece.getLocation().getName());
                    fileWriter.append(",");
                    fileWriter.append(theatricalPiece.getName_event());
                    fileWriter.append(",");
                    fileWriter.append(theatricalPiece.getNumber_of_tickets().toString());
                    fileWriter.append(",");
                    fileWriter.append(theatricalPiece.getDate_start().toString());
                    fileWriter.append(",");
                    fileWriter.append(theatricalPiece.getDate_end().toString());
                    fileWriter.append(",");
                    fileWriter.append((CharSequence) theatricalPiece.getHour_start());
                    fileWriter.append(",");
                    fileWriter.append((CharSequence) theatricalPiece.getHour_end());
                    fileWriter.append(",");
                    fileWriter.append(theatricalPiece.getNumber_of_pause().toString());
                    fileWriter.append(",");
                    fileWriter.append(theatricalPiece.getTheme());
                    fileWriter.append(",");
                    fileWriter.append(theatricalPiece.getName_of_team());
                    fileWriter.append(",");
                    fileWriter.append(theatricalPiece.getPrice_of_team().toString());
                    fileWriter.append(",");
                    fileWriter.append(theatricalPiece.getType_ticket().toString());
                    fileWriter.append("\n");
                }
            }
            fileWriter.close();
        }
    }
}