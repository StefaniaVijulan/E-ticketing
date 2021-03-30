import client.Buyer;
import client.Client;
import client.Login;
import client.Organizer;
import event.*;
import location.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Service {
    private static Service single_instance = null;
    List<Event> events = new ArrayList<Event>();
    List<Location> locations = new ArrayList<Location>();
    private Login login;
    private Client curent;
    public Service () {}
    public static Service getInstance()
    {
        if (single_instance == null)
            single_instance = new Service();
        return single_instance;
    }
    public Buyer AddBuyer(){
        Buyer buyer = new Buyer();
        buyer.Read_Info(curent.getLast_name(), curent.getFirst_name(), curent.getEmail(), curent.getPhone_number());//DE FACUT CU PARAMETRII
        return buyer;
    }
    public Organizer AddOrganizer(){
        Organizer organizer = new Organizer();
        organizer.Read_Info(curent.getLast_name(), curent.getFirst_name(), curent.getEmail(), curent.getPhone_number());
        return organizer;
    }
    public void AddEvents (Organizer organizer){

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
            events.add(event);

        }
        else if (types.equals("SCHOOP CAMP"))
        {
            SchoolCamp schoolCamp = new SchoolCamp();
            Event event = (Event) schoolCamp;
            events.add(event);
        }
        else if (types.equals("STREET FOOD")){
                StreetFood streetFood = new StreetFood();
                Event event = (Event) streetFood;
                events.add(event);
        }
        else if (types.equals("THEATRICAL PIECE")){
            TheatricalPiece theatricalPiece = new TheatricalPiece();
            Event event = (Event) theatricalPiece;
            events.add(event);
        }
        else{
            System.out.println("Try again");
            }
        organizer.setEvents(events);
    }
    public void DeleteEvents (Organizer organizer){
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
    public void PrintEvent (){

        for (int i=0; i < events.size(); i++){
            System.out.println(i);
            System.out.println(events.get(i).toString());
        }
    }
    public void SeeEvent(String name){
        int ok=1;
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
    public void AddLocations(){
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
            locations.add(location);

        }
        else if (types.equals("GUEST HOUSE"))
        {
            GuestHouse guestHouse = new GuestHouse();
            guestHouse.Read_Info();
            Location location = (Location) guestHouse;
         //   System.out.println(guestHouse);
            locations.add(location);
        }
        else if (types.equals("MULTIPURPOSE HALL")){
            MultipurposeHall multipurposeHall = new MultipurposeHall();
            multipurposeHall.Read_Info();
            Location location = (Location) multipurposeHall;
         //   System.out.println(multipurposeHall);
            locations.add(location);
        }
        else if (types.equals("RESTAURANT")){
            Restaurant restaurant = new Restaurant();
            restaurant.Read_Info();
            Location location = (Location) restaurant;
         //   System.out.println(restaurant);
            locations.add(location);
        }
        else{
            System.out.println("Try again");
        }
    }
    public void PrintLocation(){
        for (int i=0; i < locations.size(); i++){
            System.out.println(locations.get(i).toString());
        }
    }
    public void DeleteLocation(){
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
    public int logIn(){
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
                {
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
    public void logOff(){
        //delogare
        login.setCurent(null);
        System.out.println("Thanks for your time! I hope i will see you soon!");
    }
    public String getCurentClientEmail(){
        return curent.getEmail();
    }
    public String getCurentClientName() {return  curent.getFirst_name();}

}
