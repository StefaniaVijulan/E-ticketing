import client.Buyer;
import client.Organizer;
import event.*;
import location.GuestHouse;
import location.Hotel;
import location.Zone;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Service service = Service.getInstance();
        //   System.out.println(service.getConcerts());
        if (service.logIn()==1){
            System.out.println("\t\t\tHello, admin!");
            System.out.println("What do you want to do?");
            System.out.println("  1. Add location");
            System.out.println("  2. Remove location");
            System.out.println("  3. See location ");
            System.out.println("  4. See events");
            System.out.println("  5. LogOff");

            System.out.print("Answer:");
            Scanner a = new Scanner(System.in);
            String b = a.nextLine();
            b=b.toUpperCase();
            if(b.equals("ADD LOCATION")){
                System.out.println("\tHow many locations do you want to add?");
                System.out.print("\tAnswer: ");
                Scanner read = new Scanner(System.in);
                int nr= read.nextInt();
                for (int i =0 ; i <nr ; i++)
                    service.AddLocations();
            }
            else if(b.equals("REMOVE LOCATION")){
                System.out.println("\tHow many locations do you want to add?");
                System.out.print("\tAnswer: ");
                Scanner read = new Scanner(System.in);
                int nr= read.nextInt();
                for (int i =0 ; i <nr ; i++)
                    service.DeleteLocation();
            }
            else if(b.equals("SEE LOCATION")){
                service.PrintLocation();
            }
            else if(b.equals("SEE EVENTS")){
                service.PrintEvent();
            } else if( b.equals("LOGOFF")){
                service.logOff();
            }
            else{
                System.out.println("Sorry, but you can not do what you want tu do!");
            }

        }
        else{

            Scanner a = new Scanner(System.in);
            System.out.println("Signed as "+ service.getCurentClientEmail());
            System.out.print("What kind of user are you?\n");
            System.out.print("\t1. Buyer\n");
            System.out.println("\t2. Organizer");
            System.out.print("Answer:");
            String b = a.nextLine();
            b=b.toUpperCase();
            if(b.equals("BUYER")){

                service.AddBuyer();
                System.out.println("Do you want to see all events?");
                Scanner read = new Scanner(System.in);
                String nr= read.nextLine();
                nr = nr.toUpperCase();
                if (nr.equals("YES")){
                    service.PrintEvent();
                }
                else
                {
                    System.out.print("The name of the event you want to see: ");
                    Scanner read1 = new Scanner(System.in);
                    String name_ev = read1.nextLine();
                    service.SeeEvent(name_ev);

                    System.out.print("Do you want to know the event price? ");
                    Scanner read2 = new Scanner(System.in);
                    String nr1= read2.nextLine();
                    nr1 = nr1.toUpperCase();
                    if (nr1.equals("YES")){
                        service.SeeTicketPrice(name_ev);
                    }else if (nr1.equals("NO")){
                        System.out.print("Thank you for your time!");
                    }else{
                        System.out.print("Sorry! but what you try to do it is not good!");
                    }

                }
            }
            else if (b.equals("ORGANIZER")){
                service.AddOrganizer();
                Organizer org = service.AddOrganizer();

                System.out.println("\tWhat do you want to do?");
                System.out.println("\n\t\t1. Add events");
                System.out.println("\n\t\t2. Delete events");
                System.out.print("\tAnswer: ");
                Scanner read = new Scanner(System.in);
                String action = read.nextLine();
                action = action.toUpperCase();
                if (action.equals("ADD EVENTS"))
                    service.AddEvents(org);
                else if ( action.equals("DELETE EVENTS")){
                    service.DeleteEvents(org);
                }else{
                    System.out.print("Sorry! Try again!");
                }

            }
            else {
                System.out.println("Try again!");
            }


        }}}