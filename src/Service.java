import client.Buyer;
import client.Client;
import client.Login;
import client.Organizer;
import event.*;
import location.*;

import java.io.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Service {
    private static Service single_instance = null;
    public static List<Event> events = new ArrayList<Event>();
    public static List<Location> locations = new ArrayList<Location>();

    private List<Buyer> buyers;
    private List<Organizer> organizers;

    private List<Concert> concerts;
    private List<SchoolCamp> schoolCamps ;
    private List<StreetFood> streetFoods;
    private List<TheatricalPiece> theatricalPieces;

    private List<GuestHouse> guestHouses;
    private List<Hotel> hotels;
    private List<MultipurposeHall> multipurposeHalls;
    private List<Restaurant> restaurants;


    // private audit_write auditWrite;
    private Login login;
    private Client curent;
    public static <E> List<E> read_csv(String option, String path) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<E> lists = new ArrayList<E>();
        // bufferedReader.readLine(); // Pe prima line se vor afla capul de tabel
        String lines = bufferedReader.readLine();// citim a doua linie
        while(lines !=null) {
            String[] split_line = lines.split(",");
            if (option.toUpperCase().equals("BUYER")) {
                String first_name = split_line[0];
                String last_name = split_line[1];
                String phone_number = split_line[2];
                String email = split_line[3];
                String password = split_line[4];
                Integer age = Integer.parseInt(split_line[5]);
                Buyer buyer = new Buyer(first_name, last_name, phone_number, email, password, age);
                lists.add((E) buyer);
            }
            else /*if (option.toUpperCase().equals("ORGANIZER")) {

                String first_name, last_name, phone_number, email, password;
                Integer seniority_in_the_field_int;
                String idEvents0;

                first_name = split_line[0];
                last_name = split_line[1];
                phone_number = split_line[2];
                email = split_line[3];
                password = split_line[4];
                Integer seniority_in_the_field = Integer.parseInt(split_line[5]);

                idEvents0 = split_line[6];

                idEvents0 = idEvents0.substring(1);

                idEvents0 = idEvents0.substring(0, idEvents0.length() - 1);
                String[] idEvents;
                idEvents = idEvents0.split(";");

                //       System.out.println(Arrays.toString(idEvents));
              /*  List<Event> list_of_events = new ArrayList<Event>();
                for (String idEvent : idEvents) {
                    {
                        Integer ids = Integer.parseInt(idEvent);
                        // System.out.println("IDS:" + ids.toString());
                        for (Event event : events) {
                            //System.out.println("Events id:" + event.getIdEvent().toString());
                            if (event.getIdEvent().equals(ids)) {
                                list_of_events.add(event);
                                // System.out.println(eventList.get(j).toString());
                                break;
                            }
                            //  list_of_events.add(eventList.get(i));

                        }
                    }
                }
                Organizer organizer = new Organizer(first_name, last_name, phone_number, email, password, seniority_in_the_field, list_of_events);
                lists.add((E) organizer);
            }
            else*/ if (option.toUpperCase().equals("CONCERT")) {
                Integer idEvent = Integer.parseInt(split_line[0]);
                Location location = null;
                String nameLocation = split_line[1];

                for (Location value : locations) {
                    // System.out.println(value);
                    if (nameLocation.equals(value.getName())) {
                        location = value;
                        break;
                    }
                }
                //   System.out.println(location);
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
                Hour hours = new Hour(Integer.parseInt(split_line[11]), Integer.parseInt(split_line[10]));
                Hour houre = new Hour(Integer.parseInt(split_line[13]), Integer.parseInt(split_line[12]));
                Integer number_of_pause = Integer.parseInt(split_line[14]);
                String name_of_singer = split_line[1];
                Float singer_price = Float.parseFloat(split_line[16]);
                Concert concert = new Concert(idEvent,location, name_event, number_of_tickets, dateStart, dateEnd, hours, houre, number_of_pause, name_of_singer, singer_price);
                events.add((Event) concert);
                lists.add((E) concert);

            }
            else if (option.toUpperCase().equals("SCHOOLCAMP")) {
                Integer idEvent = Integer.parseInt(split_line[0]);
                Location location = null;
                String nameLocation = split_line[1];
                //  System.out.println(nameLocation);
                for (Location value : locations) {

                    if (nameLocation.equals(value.getName())) {
                        location = value;
                        break;
                    }
                }
                //   System.out.println(location);
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
                Hour hours = new Hour(Integer.parseInt(split_line[11]), Integer.parseInt(split_line[10]));
                Hour houre = new Hour(Integer.parseInt(split_line[13]), Integer.parseInt(split_line[12]));
                Integer number_of_pause = Integer.parseInt(split_line[14]);
                Integer number_of_breakfast = Integer.parseInt(split_line[15]);
                Integer number_of_dinner = Integer.parseInt(split_line[16]);
                Integer number_of_lunch = Integer.parseInt(split_line[17]);
                SchoolCamp schoolCamp = new SchoolCamp(idEvent,location, name_event, number_of_tickets, dateStart, dateEnd, hours, houre, number_of_pause, number_of_breakfast, number_of_dinner, number_of_lunch);
                events.add((Event) schoolCamp);
                lists.add((E) schoolCamp);

            }
            else if (option.toUpperCase().equals("STREETFOOD")) {
                Integer idEvent = Integer.parseInt(split_line[0]);
                Location location = null;
                String nameLocation = split_line[1];
                //      System.out.println(nameLocation);
                for (Location value : locations) {

                    if (nameLocation.equals(value.getName())) {
                        location = value;
                        break;
                    }
                }
                //   System.out.println(location);
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
                Hour hours = new Hour(Integer.parseInt(split_line[11]), Integer.parseInt(split_line[10]));
                Hour houre = new Hour(Integer.parseInt(split_line[13]), Integer.parseInt(split_line[12]));
                Integer number_of_pause = Integer.parseInt(split_line[14]);
                Float price_rented_space = Float.parseFloat(split_line[15]);
                StreetFood streetFood = new StreetFood(idEvent,location, name_event, number_of_tickets, dateStart, dateEnd, hours, houre, number_of_pause, price_rented_space);
                events.add((Event) streetFood);
                lists.add((E) streetFood);
            }
            else if (option.toUpperCase().equals("THEATRICALPIECE")) {
                Integer idEvent = Integer.parseInt(split_line[0]);
                Location location = null;
                String nameLocation = split_line[1];
                //  System.out.println(nameLocation);
                for (Location value : locations) {

                    if (nameLocation.equals(value.getName())) {
                        location = value;
                        break;
                    }
                }
                //   System.out.println(location);
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
                Hour hours = new Hour(Integer.parseInt(split_line[11]), Integer.parseInt(split_line[10]));
                Hour houre = new Hour(Integer.parseInt(split_line[13]), Integer.parseInt(split_line[12]));
                Integer number_of_pause = Integer.parseInt(split_line[14]);
                String theme = split_line[15];
                String name_of_team = split_line[16];
                Float price_of_team = Float.parseFloat(split_line[17]);
                Type_ticket type_ticket = Type_ticket.valueOf(split_line[18].toUpperCase());
                TheatricalPiece theatricalPiece = new TheatricalPiece(idEvent,location, name_event, number_of_tickets, dateStart, dateEnd, hours, houre, number_of_pause, theme, name_of_team, price_of_team, type_ticket);
                events.add((Event) theatricalPiece);
                lists.add((E) theatricalPiece);

            }
            else if (option.toUpperCase().equals("GUESTHOUSE")) {
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
                locations.add((Location) guestHouse);
                lists.add((E) guestHouse);
            }
            else if (option.toUpperCase().equals("RESTAURANT")) {
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
                locations.add((Location) restaurant);
                lists.add((E) restaurant);
            }
            else if (option.toUpperCase().equals("HOTEL")) {
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
                locations.add((Location) hotel);
                lists.add((E) hotel);
            }
            else if (option.toUpperCase().equals("MULTIPURPOSEHALL")) {
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
                locations.add((Location) multipurposeHall);
                lists.add((E) multipurposeHall);
            }
            lines = bufferedReader.readLine();
        }
        return lists;

    }
    public Service () throws IOException {
        this.buyers = new ArrayList<Buyer>();
        buyers = read_csv("BUYER", "./src/buyer_read.csv");

    /*    this.organizers = new ArrayList<Organizer>();
        organizers = read_csv("ORGANIZER", "./src/organizer.csv");*/

        this.guestHouses = new ArrayList<GuestHouse>();
        guestHouses = read_csv("GuestHouse", "./src/guesthouse.csv");

        this.hotels = new ArrayList<Hotel>();
        hotels = read_csv("Hotel", "./src/hotel.csv");

        this.multipurposeHalls = new ArrayList<MultipurposeHall>();
        multipurposeHalls = read_csv("MultipurposeHall", "./src/Multipurposehall.csv");

        this.restaurants = new ArrayList<Restaurant>();
        restaurants = read_csv("Restaurant", "./src/restaurant.csv");

        this.concerts = new ArrayList<Concert>();
        concerts = read_csv("CONCERT", "./src/concert.csv");

        this.schoolCamps = new ArrayList<SchoolCamp>();
        schoolCamps = read_csv("SchoolCamp", "./src/schoolcamp.csv");

        this.streetFoods = new ArrayList<StreetFood>();
        streetFoods = read_csv("STREETFOOD", "./src/streetfood.csv");

        this.theatricalPieces = new ArrayList<TheatricalPiece>();
        theatricalPieces = read_csv("theatricalPiece", "./src/theatricalpiece.csv");

        // System.out.println(concerts);
        //this.auditWrite = audit_write.getInstanta();
    }
    public static Service getInstance() throws IOException{
        if (single_instance == null)
            single_instance = new Service();
        return single_instance;
    }
    public Buyer AddBuyer() throws IOException {

        auditWrite("Add","Buyer");
        Buyer buyer = new Buyer();
        buyer.Read_Info(curent.getLast_name(), curent.getFirst_name(), curent.getEmail(), curent.getPhone_number(), curent.getPassword());//DE FACUT CU PARAMETRII
        try {
            write_in_csv(buyer, "buyer_read");
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        buyers.add(buyer);
        return buyer;
    }
    public Organizer AddOrganizer() throws IOException {
        auditWrite("Add","Organizer");
        Organizer organizer = new Organizer();
        organizer.Read_Info(curent.getLast_name(), curent.getFirst_name(), curent.getEmail(), curent.getPhone_number(), curent.getPassword());
      /*  try {
            write_in_csv(organizer, "organizer");
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }*/
        organizers.add(organizer);
        return organizer;
    }
    public void AddEvents (Organizer organizer) throws IOException {
        auditWrite("Add","Event");
        Scanner read1 = new Scanner(System.in);
        System.out.println("\t\tWhat type of event do you want to add?\n\t\t\t1. Concert\n\t\t\t2. School camp \n\t\t\t3. Street food");
        System.out.print("\t\t\tAnswer: ");
        String types= read1.nextLine();
        types=types.toUpperCase();
        if (types.equals("CONCERT")) {
            Concert concert = new Concert();
            concert.Read_Info();
            Event event = (Event) concert;
            System.out.println(concert);
            try {
                write_in_csv(concert, "concert");
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
            concerts.add(concert);
            events.add(event);

        }
        else if (types.equals("SCHOOP CAMP"))
        {
            SchoolCamp schoolCamp = new SchoolCamp();
            Event event = (Event) schoolCamp;
            try {
                write_in_csv(schoolCamp, "schoolcamp");
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
            schoolCamps.add(schoolCamp);
            events.add(event);
        }
        else if (types.equals("STREET FOOD")){
            StreetFood streetFood = new StreetFood();
            Event event = (Event) streetFood;
            try {
                write_in_csv(streetFood, "streetfood");
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
            events.add(event);
            streetFoods.add(streetFood);
        }
        else if (types.equals("THEATRICAL PIECE")){
            TheatricalPiece theatricalPiece = new TheatricalPiece();
            Event event = (Event) theatricalPiece;
            try {
                write_in_csv(theatricalPiece, "theatricalpiece");
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
            theatricalPieces.add(theatricalPiece);
            events.add(event);
        }
        else{
            System.out.println("Try again");
        }
        organizer.setEvents(events);
    }
    public void DeleteEvents (Organizer organizer) throws IOException {
        auditWrite("Delete","Events");
        List<Event>deleteEvent  = new ArrayList<Event>();
        deleteEvent = organizer.getEvents();
        Scanner read = new Scanner(System.in);
        System.out.print("What is the name of the event?");
        System.out.print("\nAnswer:");
        String event_name = read.nextLine();
        for (int i=0; i< deleteEvent.size(); i++)

            deleteEvent.remove(i);
        System.out.print("Event " + event_name + "was successfully removed");
    }
    public void PrintEvent () throws IOException {
        auditWrite("Print","Event");
        for (int i=0; i < events.size(); i++){
            System.out.println(i);
            System.out.println(events.get(i).toString());
        }
    }
    public void SeeEvent(String name) throws IOException {
        int ok=1;
        auditWrite("See","Event");
        for ( int i=0; i<events.size(); i++)
        {
            if (name.equals(events.get(i).getName_event())) {
                events.get(i).toString();
                ok=0;
            }
        }
        if (ok==1 )
            System.out.print("Sorry, but " + name + " event does not exist!");
    }
    public void AddLocations() throws IOException {
        // System.out.println("Intru aici");
        auditWrite("Add","Location");
        Scanner read1 = new Scanner(System.in);
        System.out.println("\t\tWhat type of location do you want to add?\n\t\t\t1. Hotel\n\t\t\t2. Guest House \n\t\t\t3. Multipurpose hall\n\t\t\t4. Restaurant ");
        System.out.print("\t\t\tAnswer: ");
        String types= read1.nextLine();
        types=types.toUpperCase();
        if (types.equals("HOTEL")) {
            System.out.println("----------HOTEL--------");
            Hotel hotel = new Hotel();
            hotel.Read_Info();
            Location location = (Location) hotel;
            //  System.out.println(hotel);
            try {
                write_in_csv(hotel, "hotel");
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }

            hotels.add(hotel);
            locations.add(location);

        }
        else if (types.equals("GUEST HOUSE"))
        {
            GuestHouse guestHouse = new GuestHouse();
            guestHouse.Read_Info();
            Location location = (Location) guestHouse;
            //   System.out.println(guestHouse);
            try {
                write_in_csv(guestHouse, "guesthouse");
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
            guestHouses.add(guestHouse);
            locations.add(location);
        }
        else if (types.equals("MULTIPURPOSE HALL")){
            MultipurposeHall multipurposeHall = new MultipurposeHall();
            multipurposeHall.Read_Info();
            Location location = (Location) multipurposeHall;
            //   System.out.println(multipurposeHall);
            multipurposeHalls.add(multipurposeHall);
            locations.add(location);
        }
        else if (types.equals("RESTAURANT")){
            Restaurant restaurant = new Restaurant();
            restaurant.Read_Info();
            Location location = (Location) restaurant;
            //   System.out.println(restaurant);
            try {
                write_in_csv(restaurant, "restaurant");
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
            restaurants.add(restaurant);
            locations.add(location);
        }
        else{
            System.out.println("Try again");
        }
    }
    public void PrintLocation() throws IOException {
        auditWrite("Print","Location");
        for (int i=0; i < locations.size(); i++){
            System.out.println(locations.get(i).toString());
        }
    }
    public void DeleteLocation() throws IOException {
        auditWrite("Delete","Location");
        Scanner read = new Scanner(System.in);
        System.out.print("What is the name of the location?");
        System.out.print("\nAnswer:");
        String location_name = read.nextLine();
        for (int i= 0 ; i< locations.size() ; i++){
            if(locations.get(i).getName().equals(location_name)){
                System.out.print("Location " + location_name + "was successfully removed");
                locations.remove(i);
            }
        }
    }
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    public void SeeTicketPrice(String name){
        for ( int i=0; i<events.size(); i++) {
            if (name.equals(events.get(i).getName_event()))
                System.out.print("Pretul evenimentului " + name+ " este: "+events.get(i).ticket_value());
        }
    }
    public int logIn() throws IOException {
        //LOgIn
        login = Login.getInstance();
        int type=0;
        while (true) {
            Scanner read = new Scanner(System.in);
            System.out.print("What do you want to do?\n\t\t1. Register\n\t\t2. Log In\nAnswer: ");
            String connection = read.nextLine();
            connection.toUpperCase();
            if (connection.equalsIgnoreCase("LOG IN")) {
                //LogIn

                System.out.print("Email: ");
                String email = read.nextLine();
                if (isValidEmailAddress(email))
                {System.out.print("Password: ");
                    String password = read.nextLine();

                    if (login.signIn(email, password)) {
                        auditWrite("Login","");
                        System.out.println("Login successfully");
                        curent =login.getCurent();
                        if (email.equals("admin@gmail.com"))
                            type=1;
                        break;
                    }
                    else {
                        System.out.println("Sorry, login unsuccessfully, because "+email+" doesn't exists! Try again!");

                    }}

            } else if (connection.equalsIgnoreCase("REGISTER")) {
                //Register

                Client client = new Client();
                client.Read_Info();
                if(login.signUp(client))
                {   auditWrite("Register",":)");
                    System.out.println("Registration succssefully");
                    curent=client;
                }
                else
                    System.out.println("You are already signed");

            }
            else{
                System.out.println("You must LogIn or Register before attempting any other actions");
            }
        }
        return type;
    }
    public void logOff() throws IOException {
        //delogare
        auditWrite("LogOff",":(");
        login.setCurent(null);
        System.out.println("Thanks for your time! I hope i will see you soon!");
    }
    public String getCurentClientEmail(){
        return curent.getEmail();
    }
    public String getCurentClientName() {return  curent.getFirst_name();}

    public static Service getSingle_instance() {
        return single_instance;
    }

    public static List<Event> getEvents() {
        return events;
    }

    public static List<Location> getLocations() {
        return locations;
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public List<Organizer> getOrganizers() {
        return organizers;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public List<SchoolCamp> getSchoolCamps() {
        return schoolCamps;
    }

    public List<StreetFood> getStreetFoods() {
        return streetFoods;
    }

    public List<TheatricalPiece> getTheatricalPieces() {
        return theatricalPieces;
    }

    public List<GuestHouse> getGuestHouses() {
        return guestHouses;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public List<MultipurposeHall> getMultipurposeHalls() {
        return multipurposeHalls;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Login getLogin() {
        return login;
    }

    public Client getCurent() {
        return curent;
    }
    public static <E> void write_in_csv (E object_name, String name_path) throws IOException{
        //Creem calea
        String path = "./src/" + name_path+".csv";
        File file = new File(path);
        if (file.isFile()){
            if (file.length() == 0){
                FileWriter fileWriter = new FileWriter(path, true);
                //luam numele clasei
                switch (object_name.getClass().getSimpleName()){
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
            switch (object_name.getClass().getSimpleName()){
                case "Buyer" ->{
                    Buyer buyer = (Buyer) object_name;
                    fileWriter.append(buyer.getFirst_name());
                    fileWriter.append(",");
                    fileWriter.append(buyer.getLast_name());
                    fileWriter.append(",");
                    fileWriter.append(buyer.getPhone_number());
                    fileWriter.append(",");
                    fileWriter.append(buyer.getEmail());
                    fileWriter.append(",");
                    fileWriter.append(buyer.getPassword());
                    fileWriter.append(",");
                    fileWriter.append(buyer.getAge().toString());
                    fileWriter.append("\n");
                }
             /*   case "Organizer" ->{
                    Organizer organizer = (Organizer) object_name;
                    fileWriter.append(organizer.getFirst_name());
                    fileWriter.append(",");
                    fileWriter.append(organizer.getLast_name());
                    fileWriter.append(",");
                    fileWriter.append(organizer.getPhone_number());
                    fileWriter.append(",");
                    fileWriter.append(organizer.getEmail());
                    fileWriter.append(",");
                    fileWriter.append(organizer.getPassword());
                    fileWriter.append(",");
                    fileWriter.append(organizer.getSeniority_in_the_field().toString());
                    fileWriter.append(",");
                 //   fileWriter.append("[]");
                    fileWriter.append("\n");
                }*/

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

                case "Hotel" -> {
                    Hotel hotel = (Hotel) object_name;
                    fileWriter.append(hotel.getZone().toString());
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
                    fileWriter.append(guestHouse.getCountry());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getTown());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getStreet());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getNumber());
                    fileWriter.append(",");
                    fileWriter.append(guestHouse.getNumber_of_starts().toString());
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

            }
            fileWriter.close();
        }
    }

    public static void auditWrite(String action, String object) throws IOException {
        Timestamp timestamp= Timestamp.from(Instant.now());
        File file = new File("./src/audit_write.csv");
        if (file.isFile()) {
            if (file.length() <= 1) {
                FileWriter csvWriter = new FileWriter("./src/audit_write.csv", true);
                csvWriter.append("Action,Object,Timestamp\n");
                csvWriter.close();
            }
            FileWriter csvWriter = new FileWriter("./src/audit_write.csv", true);
            csvWriter.append(action + " " + object + "," + timestamp + "\n");
            csvWriter.close();
        }

    }
}

