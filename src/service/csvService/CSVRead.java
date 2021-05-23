package service.csvService;
import model.client.Buyer;
import model.client.Organizer;
import model.event.*;
import model.location.*;
import service.modelService.EventService;
import service.modelService.LocationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CSVRead {
        private static CSVRead single_instance = null;

        private List<Buyer> buyers;
        private  List<Organizer> organizers;
        private List<Concert> concerts;
        private List<SchoolCamp> schoolCamps;
        private List<StreetFood> streetFoods;
        private List<TheatricalPiece> theatricalPieces;
        private List<Event> events;

        private List<GuestHouse> guestHouses;
        private List<Hotel> hotels;
        private List<MultipurposeHall> multipurposeHalls;
        private List<Restaurant> restaurants;
        private List<Location> locations;

    public CSVRead() throws IOException {
        this.locations = new ArrayList<Location>();
        this.events = new ArrayList<Event>();
        this.guestHouses = new ArrayList<GuestHouse>();
        this.restaurants = new ArrayList<Restaurant>();
        this.hotels = new ArrayList<Hotel>();
        this.multipurposeHalls = new ArrayList<MultipurposeHall>();
        try {
            restaurants = read_from_csv("RESTAURANT", "./src/resources/locations/restaurant.csv");
            guestHouses = read_from_csv("GUESTHOUSE", "./src/resources/locations/guestHouse.csv");
            hotels = read_from_csv("HOTEL", "./src/resources/locations/hotel.csv");
            multipurposeHalls = read_from_csv("MULTIPUPOSEHALL", "./src/resources/locations/multipurposehall.csv");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        this.concerts = new ArrayList<Concert>();
        this.schoolCamps = new ArrayList<SchoolCamp>();
        this.streetFoods = new ArrayList<StreetFood>();
        this.theatricalPieces = new ArrayList<TheatricalPiece>();
        concerts = read_from_csv("CONCERT", "./src/resources/events/concert.csv");
        schoolCamps = read_from_csv("SCHOOLCAMP", "./src/resources/events/schoolCamp.csv");
        streetFoods = read_from_csv("STREETFOOD", "./src/resources/events/streetFood.csv");
        theatricalPieces = read_from_csv("THEATRICALPIECE", "./src/resources/events/theatricalPiece.csv");

        this.buyers = new ArrayList<Buyer>();
        buyers = read_from_csv("BUYER","./src/resources/client/buyer.csv" );
        this.organizers = new ArrayList<Organizer>();
        organizers = read_from_csv("ORGANIZER", "./src/resources/client/organizer.csv");

    }

    public static synchronized CSVRead getInstance() throws IOException {
            if (single_instance == null){
                single_instance = new CSVRead();
            }
            return single_instance;
        }
        public Restaurant Restaurant_read (String[] split_line){
            String name, country, town, street, number, location_type;
            Zone zone = Zone.valueOf(split_line[0].toUpperCase());
            name = split_line[1];
            country = split_line[2];
            town = split_line[3];
            street = split_line[4];
            number = split_line[5];
            Integer number_of_seats = Integer.parseInt(split_line[6]);
            Integer table_seats = Integer.parseInt(split_line[7]);
            Float price_per_seats = Float.parseFloat(split_line[8]);
            Boolean scene = Boolean.parseBoolean(split_line[9]);
            Float scene_price = Float.parseFloat(split_line[10]);
            Boolean equipment = Boolean.parseBoolean(split_line[11]);
            Float price_of_equipment = Float.parseFloat(split_line[12]);
            Restaurant restaurant = new Restaurant(zone, name, country, town, street, number, number_of_seats, table_seats, price_per_seats, scene, scene_price, equipment, price_of_equipment);
            return restaurant;
        }
        public MultipurposeHall MultipurposeHall_read(String[] split_line){
            String name, country, town, street, number, location_type;
            Zone zone = Zone.valueOf(split_line[0].toUpperCase());
            name = split_line[1];
            country = split_line[2];
            town = split_line[3];
            street = split_line[4];
            number = split_line[5];
            Integer number_of_seats = Integer.parseInt(split_line[6]);
            Float price_per_seats = Float.parseFloat(split_line[7]);
            Boolean audio_equipment = Boolean.parseBoolean(split_line[8]);
            Float price_of_the_audio_equipment =Float.parseFloat(split_line[9]);
            Boolean video_equipment = Boolean.parseBoolean(split_line[10]);
            Float price_of_the_video_equipment =Float.parseFloat(split_line[11]);
            MultipurposeHall multipurposeHall = new MultipurposeHall(zone,name,country, town, street,number,number_of_seats,price_per_seats, audio_equipment,price_of_the_audio_equipment,video_equipment, price_of_the_video_equipment);
            return multipurposeHall;

        }
        public Hotel Hotel_read(String[] split_line){
            String name, country, town, street, number, location_type;
            Zone zone = Zone.valueOf(split_line[0].toUpperCase());
            name = split_line[1];
            country = split_line[2];
            town = split_line[3];
            street = split_line[4];
            number = split_line[5];
            Integer number_of_stars = Integer.parseInt(split_line[6]);
            Boolean pets = Boolean.parseBoolean(split_line[7]);
            Boolean conference_room = Boolean.parseBoolean(split_line[8]);
            Float price_of_room = Float.parseFloat(split_line[9]);
            Integer number_of_rooms = Integer.parseInt(split_line[10]);
            Hotel hotel = new Hotel(zone,name, country, town,street, number, number_of_stars, pets,conference_room, price_of_room,number_of_rooms);
            return hotel;
        }
        public GuestHouse GuestHouse_read(String[] split_line){
            String name, country, town, street, number, location_type;
            Zone zone = Zone.valueOf(split_line[0].toUpperCase());
            name = split_line[1];
            country = split_line[2];
            town = split_line[3];
            street = split_line[4];
            number = split_line[5];
            Integer number_of_stars = Integer.parseInt(split_line[6]);
            Boolean pets = Boolean.parseBoolean(split_line[7]);
            Float number_of_rooms = Float.parseFloat(split_line[8]);
            Boolean conference_room = Boolean.parseBoolean(split_line[9]);
            Float rooms_price = Float.parseFloat(split_line[10]);
            Boolean pool = Boolean.parseBoolean(split_line[11]);
            GuestHouse guestHouse = new GuestHouse(zone, name, country, town, street, number, number_of_stars, pets, number_of_rooms, conference_room, rooms_price, pool);
            return guestHouse;
        }

        public Concert Concert_read(String[] split_line){
            String typeLocation = split_line[0];
            Location location= null;
            if(typeLocation.toUpperCase().equals("RESTAURANT")) {

                String nameLocation = split_line[1];
                for (Restaurant value : restaurants) {
                    // System.out.println(value);
                    if (nameLocation.equals(value.getName())) {
                        location = (Location) value;
                        break;
                    } }
            }
            else if(typeLocation.toUpperCase().equals("HOTEL")){
                String nameLocation = split_line[1];
                for (Hotel value :hotels) {
                    // System.out.println(value);
                    if (nameLocation.equals(value.getName())) {
                        location = (Location) value;
                        break;
                    } }
            }
            else if(typeLocation.toUpperCase().equals("GUESTHOUSE")){
                String nameLocation = split_line[1];


                for (GuestHouse value : guestHouses) {

                    if ((nameLocation.toUpperCase()).equals((value.getName().toUpperCase()))) {

                        location = (Location) value;

                    } }

            }
            else if(typeLocation.toUpperCase().equals("MULTIPURPOSEHALL")){
                String nameLocation = split_line[1];
                for (MultipurposeHall value : multipurposeHalls) {

                    if (nameLocation.toUpperCase().equals(value.getName().toUpperCase())) {
                        location = (Location) value;
                        break;
                    } }
            }
        //    System.out.println(location);
            String name_event = split_line[2];
            Integer number_of_tickets = Integer.parseInt(split_line[3]);
            int YearDS = Integer.parseInt(split_line[4]);
            int MonthDS = Integer.parseInt(split_line[5]);
            int DayDS = Integer.parseInt(split_line[6]);
            int YearDE = Integer.parseInt(split_line[7]);
            int MonthDE = Integer.parseInt(split_line[8]);
            int DayDE = Integer.parseInt(split_line[9]);
            LocalDate dateStart = LocalDate.of(YearDS, MonthDS, DayDS);
            LocalDate dateEnd = LocalDate.of(YearDE, MonthDE, DayDE);
            event.Hour hours = new event.Hour(Integer.parseInt(split_line[11]), Integer.parseInt(split_line[10]));
            event.Hour houre = new event.Hour(Integer.parseInt(split_line[13]), Integer.parseInt(split_line[12]));
            Integer number_of_pause = Integer.parseInt(split_line[14]);
            String name_of_singer = split_line[15];
            Float singer_price = Float.parseFloat(split_line[16]);
            Concert concert = new Concert(location, name_event, number_of_tickets, dateStart, dateEnd, hours, houre, number_of_pause, name_of_singer, singer_price);
            return concert;
        }
        public SchoolCamp SchoolCamp_read(String[] split_line){
            String typeLocation = split_line[0];
            Location location= null;
            if(typeLocation.toUpperCase().equals("RESTAURANT")) {

                String nameLocation = split_line[1];
                for (Restaurant value :restaurants) {
                    // System.out.println(value);
                    if (nameLocation.toUpperCase().equals(value.getName().toUpperCase())) {
                        location = (Location) value;
                        break;
                    } }
            }
            else if(typeLocation.toUpperCase().equals("HOTEL")){
                String nameLocation = split_line[1];
                for (Hotel value : hotels) {
                    // System.out.println(value);
                    if (nameLocation.toUpperCase().equals(value.getName().toUpperCase())) {
                        location = (Location) value;
                        break;
                    } }
            }
            else if(typeLocation.toUpperCase().equals("GUESTHOUSE")){
                String nameLocation = split_line[1];
                for (GuestHouse value : guestHouses) {
                    // System.out.println(value);
                    if (nameLocation.toUpperCase().equals(value.getName().toUpperCase())) {
                        location = (Location) value;
                        break;
                    } }
            }
            else if(typeLocation.toUpperCase().equals("MULTIPURPOSEHALL")){
                String nameLocation = split_line[1];
                for (MultipurposeHall value : multipurposeHalls) {
                    // System.out.println(value);
                    if (nameLocation.toUpperCase().equals(value.getName().toUpperCase())) {
                        location = (Location) value;
                        break;
                    } }
            }
            String name_event = split_line[2];
            Integer number_of_tickets = Integer.parseInt(split_line[3]);
            int YearDS = Integer.parseInt(split_line[4]);
            int MonthDS = Integer.parseInt(split_line[5]);
            int DayDS = Integer.parseInt(split_line[6]);
            int YearDE = Integer.parseInt(split_line[7]);
            int MonthDE = Integer.parseInt(split_line[8]);
            int DayDE = Integer.parseInt(split_line[9]);
            LocalDate dateStart = LocalDate.of(YearDS, MonthDS, DayDS);
            LocalDate dateEnd = LocalDate.of(YearDE, MonthDE, DayDE);
            event.Hour hours = new event.Hour(Integer.parseInt(split_line[11]), Integer.parseInt(split_line[10]));
            event.Hour houre = new event.Hour(Integer.parseInt(split_line[13]), Integer.parseInt(split_line[12]));
            Integer number_of_pause = Integer.parseInt(split_line[14]);
            Integer number_of_breakfast = Integer.parseInt(split_line[15]);
            Integer number_of_dinner = Integer.parseInt(split_line[16]);
            Integer number_of_lunch = Integer.parseInt(split_line[17]);
            SchoolCamp schoolCamp = new SchoolCamp(location, name_event, number_of_tickets, dateStart, dateEnd, hours, houre, number_of_pause, number_of_breakfast, number_of_dinner, number_of_lunch);
            return schoolCamp;
        }
        public StreetFood StreetFood_read(String[] split_line){
            String typeLocation = split_line[0];
            Location location= null;
            if(typeLocation.toUpperCase().equals("RESTAURANT")) {

                String nameLocation = split_line[1];
                for (Restaurant value : restaurants) {
                    // System.out.println(value);
                    if (nameLocation.toUpperCase().equals(value.getName().toUpperCase())) {
                        location = (Location) value;
                        break;
                    } }
            }
            else if(typeLocation.toUpperCase().equals("HOTEL")){
                String nameLocation = split_line[1];
                for (Hotel value : hotels) {
                    // System.out.println(value);
                    if (nameLocation.toUpperCase().equals(value.getName().toUpperCase())) {
                        location = (Location) value;
                        break;
                    } }
            }
            else if(typeLocation.toUpperCase().equals("GUESTHOUSE")){
                String nameLocation = split_line[1];
                for (GuestHouse value : guestHouses) {
                    // System.out.println(value);
                    if (nameLocation.toUpperCase().equals(value.getName().toUpperCase())) {
                        location = (Location) value;
                        break;
                    } }
            }
            else if(typeLocation.toUpperCase().equals("MULTIPURPOSEHALL")){
                String nameLocation = split_line[1];
                for (MultipurposeHall value : multipurposeHalls) {
                    // System.out.println(value);
                    if (nameLocation.toUpperCase().equals(value.getName().toUpperCase())) {
                        location = (Location) value;
                        break;
                    } }
            }
            String name_event = split_line[2];
            Integer number_of_tickets = Integer.parseInt(split_line[3]);
            int YearDS = Integer.parseInt(split_line[4]);
            int MonthDS = Integer.parseInt(split_line[5]);
            int DayDS = Integer.parseInt(split_line[6]);
            int YearDE = Integer.parseInt(split_line[7]);
            int MonthDE = Integer.parseInt(split_line[8]);
            int DayDE = Integer.parseInt(split_line[9]);
            LocalDate dateStart = LocalDate.of(YearDS, MonthDS, DayDS);
            LocalDate dateEnd = LocalDate.of(YearDE, MonthDE, DayDE);
            event.Hour hours = new event.Hour(Integer.parseInt(split_line[11]), Integer.parseInt(split_line[10]));
            event.Hour houre = new event.Hour(Integer.parseInt(split_line[13]), Integer.parseInt(split_line[12]));
            Integer number_of_pause = Integer.parseInt(split_line[14]);
            Float price_rented_space = Float.parseFloat(split_line[15]);
            StreetFood streetFood = new StreetFood(location, name_event, number_of_tickets, dateStart, dateEnd, hours, houre, number_of_pause, price_rented_space);
            return streetFood;
        }
        public TheatricalPiece TheatricalPiece_read(String[] split_line){
            String typeLocation = split_line[0];
            Location location= null;
            if(typeLocation.toUpperCase().equals("RESTAURANT")) {

                String nameLocation = split_line[1];
                for (Restaurant value : restaurants) {
                    // System.out.println(value);
                    if (nameLocation.toUpperCase().equals(value.getName().toUpperCase())) {
                        location = (Location) value;
                        break;
                    } }
            }
            else if(typeLocation.toUpperCase().equals("HOTEL")){
                String nameLocation = split_line[1];
                for (Hotel value :hotels) {
                    // System.out.println(value);
                    if (nameLocation.toUpperCase().equals(value.getName().toUpperCase())) {
                        location = (Location) value;
                        break;
                    } }
            }
            else if(typeLocation.toUpperCase().equals("GUESTHOUSE")){
                String nameLocation = split_line[1];
                for (GuestHouse value : guestHouses) {
                    // System.out.println(value);
                    if (nameLocation.toUpperCase().equals(value.getName().toUpperCase())) {
                        location = (Location) value;
                        break;
                    } }
            }
            else if(typeLocation.toUpperCase().equals("MULTIPURPOSEHALL")){
                String nameLocation = split_line[1];
                for (MultipurposeHall value : multipurposeHalls) {
                    // System.out.println(value);
                    if (nameLocation.toUpperCase().equals(value.getName().toUpperCase())) {
                        location = (Location) value;
                        break;
                    } }
            }
            String name_event = split_line[2];
            Integer number_of_tickets = Integer.parseInt(split_line[3]);
            int YearDS = Integer.parseInt(split_line[4]);
            int MonthDS = Integer.parseInt(split_line[5]);
            int DayDS = Integer.parseInt(split_line[6]);
            int YearDE = Integer.parseInt(split_line[7]);
            int MonthDE = Integer.parseInt(split_line[8]);
            int DayDE = Integer.parseInt(split_line[9]);
            LocalDate dateStart = LocalDate.of(YearDS, MonthDS, DayDS);
            LocalDate dateEnd = LocalDate.of(YearDE, MonthDE, DayDE);
            event.Hour hours = new event.Hour(Integer.parseInt(split_line[11]), Integer.parseInt(split_line[10]));
            event.Hour houre = new event.Hour(Integer.parseInt(split_line[13]), Integer.parseInt(split_line[12]));
            Integer number_of_pause = Integer.parseInt(split_line[14]);
            String theme = split_line[15];
            String name_of_team = split_line[16];
            Float price_of_team = Float.parseFloat(split_line[17]);
            Type_ticket type_ticket = Type_ticket.valueOf(split_line[18].toUpperCase());
            TheatricalPiece theatricalPiece = new TheatricalPiece(location, name_event, number_of_tickets, dateStart, dateEnd, hours, houre, number_of_pause, theme, name_of_team, price_of_team, type_ticket);
            return theatricalPiece;
        }
        public <E> List<E> read_from_csv(String option, String path) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            List<E> lists = new ArrayList<E>();
            // bufferedReader.readLine(); // Pe prima line se vor afla capul de tabel
            String lines = bufferedReader.readLine();// citim a doua linie
            while(lines !=null) {
                String[] split_line = lines.split(",");
                if (option.toUpperCase().equals("RESTAURANT")) {
                    lists.add((E) Restaurant_read(split_line));
                    locations.add((Location) Restaurant_read(split_line));
                }
                else if (option.toUpperCase().equals("MULTIPUPOSEHALL")) {
                    lists.add((E) MultipurposeHall_read(split_line));
                    locations.add((Location) MultipurposeHall_read(split_line));
                }
                else if (option.toUpperCase().equals("HOTEL")) {
                    lists.add((E) Hotel_read(split_line));
                    locations.add((Location) Hotel_read(split_line));
                }
                else if (option.toUpperCase().equals("GUESTHOUSE")) {
                    lists.add((E) GuestHouse_read(split_line));
                    locations.add((Location) GuestHouse_read(split_line));
                }
                else if (option.toUpperCase().equals("SCHOOLCAMP")) {

                    lists.add((E) SchoolCamp_read(split_line));
                    events.add((Event) SchoolCamp_read(split_line));

                }
                else if (option.toUpperCase().equals("CONCERT")) {
                    lists.add((E) Concert_read(split_line));
                    events.add((Event) Concert_read(split_line));
                }
                else if (option.toUpperCase().equals("STREETFOOD")) {

                    lists.add((E) StreetFood_read(split_line));
                    events.add((Event) StreetFood_read(split_line));
                }
                else if (option.toUpperCase().equals("THEATRICALPIECE")) {
                    events.add((Event) TheatricalPiece_read(split_line));
                    lists.add((E) TheatricalPiece_read(split_line));
                }
                lines = bufferedReader.readLine();
            }
            return lists;
        }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }

    public List<SchoolCamp> getSchoolCamps() {
        return schoolCamps;
    }

    public void setSchoolCamps(List<SchoolCamp> schoolCamps) {
        this.schoolCamps = schoolCamps;
    }

    public List<StreetFood> getStreetFoods() {
        return streetFoods;
    }

    public void setStreetFoods(List<StreetFood> streetFoods) {
        this.streetFoods = streetFoods;
    }

    public List<TheatricalPiece> getTheatricalPieces() {
        return theatricalPieces;
    }

    public void setTheatricalPieces(List<TheatricalPiece> theatricalPieces) {
        this.theatricalPieces = theatricalPieces;
    }

    public List<GuestHouse> getGuestHouses() {
        return guestHouses;
    }

    public void setGuestHouses(List<GuestHouse> guestHouses) {
        this.guestHouses = guestHouses;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<MultipurposeHall> getMultipurposeHalls() {
        return multipurposeHalls;
    }

    public void setMultipurposeHalls(List<MultipurposeHall> multipurposeHalls) {
        this.multipurposeHalls = multipurposeHalls;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public List<Organizer> getOrganizers() {
        return organizers;
    }
}
