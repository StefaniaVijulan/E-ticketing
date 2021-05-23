package menu;

import model.client.Organizer;
import service.csvService.CSVRead;
import service.csvService.CSVWrite;
import service.modelService.EventService;
import service.modelService.LocationService;
import service.modelService.LoginService;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws IOException {
        LocationService locationService = LocationService.getInstance();
        LoginService loginService = LoginService.getInstance();
        EventService eventService = EventService.getInstance();

        if (loginService.logIn() == 1) {
            System.out.println("\t\t\tHello, admin!");
            System.out.println("What do you want to do?");
            System.out.println("  1. Add location");
            System.out.println("  2. Remove location");
            System.out.println("  3. See location ");
            System.out.println("  4. See events");
            System.out.println("  5. See an event");
            System.out.println("  6. LogOff");

            System.out.print("Answer:");
            Scanner a = new Scanner(System.in);
            String b = a.nextLine();
            b = b.toUpperCase();
            if (b.equals("ADD LOCATION")) {
                locationService.AddLocations();
            } else if (b.equals("REMOVE LOCATION")) {
                locationService.DeleteLocation();
            } else if (b.equals("SEE LOCATION")) {
                locationService.PrintLocation();
            } else if (b.equals("SEE EVENTS")) {
                eventService.SeeEvent();
            } else if (b.equals("LOGOFF")) {
                loginService.logOut();
            } else if(b.equals("SEE AN EVENT")){
                eventService.SeeOneEvent();

            }
            else{
                System.out.println("Sorry, but you can not do what you want to do!");
            }

        } else {

            Scanner a = new Scanner(System.in);
            System.out.println("Signed as " + loginService.getCurentClientEmail());
            System.out.print("What kind of user are you?\n");
            System.out.print("\t1. Buyer\n");
            System.out.println("\t2. Organizer");
            System.out.print("Answer:");
             String b = a.nextLine();
             b=b.toUpperCase();
            if(b.equals("BUYER")){
                loginService.AddBuyer();
                System.out.println("What do you want to do?");;
                System.out.println("  1. See events");
                System.out.println("  2. See an event");
                System.out.println("  3. LogOff");
                System.out.print("Answer:");
                Scanner c = new Scanner(System.in);
                String d = c.nextLine();
                d = d.toUpperCase();
                if (d.equals("SEE EVENTS")) {
                    eventService.SeeEvent();
                } else if (d.equals("LOGOFF")) {
                    loginService.logOut();
                } else if(d.equals("SEE AN EVENT")){
                    eventService.SeeOneEvent();
                }

            }else if (b.equals("ORGANIZER")){
                loginService.AddOrganizer();
                Organizer org = loginService.AddOrganizer();

                System.out.println("\tWhat do you want to do?");
                System.out.println("\n\t\t1. Add events");
                System.out.println("\n\t\t2. Delete events");

                System.out.print("\tAnswer: ");
                Scanner read = new Scanner(System.in);
                String action = read.nextLine();
                action = action.toUpperCase();
                if (action.equals("ADD EVENTS"))
                    eventService.AddEvent(org);
                else if ( action.equals("DELETE EVENTS")){
                 //   eventService.DeleteEvents(org);
                }else{
                    System.out.print("Sorry! Try again!");
                }

            }
            else {
                System.out.println("Try again!");}
        }
    }
}