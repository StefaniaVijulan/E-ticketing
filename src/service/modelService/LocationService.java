package service.modelService;

import model.location.*;

import service.csvService.CSVAudit;
//import service.csvService.CSVRead;
import service.csvService.CSVRead;
import service.csvService.CSVWrite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class LocationService {
    private static LocationService single_instance = null;
    public CSVRead csvRead = CSVRead.getInstance();
    public CSVAudit csvAudit = CSVAudit.getInstance();
    public CSVWrite csvWrite = CSVWrite.getInstance();

    private LocationService() throws IOException {
    }

    public static LocationService getInstance() throws IOException {

       if (single_instance == null){
            single_instance = new LocationService();
        }
        return single_instance;

    }

    public void AddLocations() throws IOException {

        System.out.println("\tHow many locations do you want to add?");
        System.out.print("\tAnswer: ");
        Scanner read = new Scanner(System.in);
        int nr = read.nextInt();
        for (int i = 0; i < nr; i++) {

            Scanner read1 = new Scanner(System.in);
            System.out.println("\t\tWhat type of location do you want to add?\n\t\t\t1. Hotel\n\t\t\t2. Guest House \n\t\t\t3. Multipurpose hall\n\t\t\t4. Restaurant ");
            System.out.print("\t\t\tAnswer: ");
            String types = read1.nextLine();
            csvAudit.write_in_audit("Add", types);
            types = types.toUpperCase();
            if (types.equals("HOTEL")) {
                //System.out.println("----------HOTEL--------");
                Hotel hotel = new Hotel();
                hotel.Read_Info();
                Location location = (Location) hotel;
                //  System.out.println(hotel);
                try {
                    csvWrite.write_in_csv(hotel, "locations/hotel");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                csvRead.getHotels().add(hotel);
                //locations.add((Location) hotel);
            } else if (types.equals("GUEST HOUSE")) {
                GuestHouse guestHouse = new GuestHouse();
                guestHouse.Read_Info();
                Location location = (Location) guestHouse;
                //   System.out.println(guestHouse);
                try {
                    csvWrite.write_in_csv(guestHouse, "locations/guestHouse");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                csvRead.getGuestHouses().add(guestHouse);
            //    locations.add((Location) guestHouse);
            } else if (types.equals("MULTIPURPOSE HALL")) {
                MultipurposeHall multipurposeHall = new MultipurposeHall();
                multipurposeHall.Read_Info();
                Location location = (Location) multipurposeHall;
                //   System.out.println(multipurposeHall);
                try {
                    csvWrite.write_in_csv(multipurposeHall, "locations/multipurposeHall");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                csvRead.getMultipurposeHalls().add(multipurposeHall);
        //        locations.add((Location) multipurposeHall);

            } else if (types.equals("RESTAURANT")) {
                Restaurant restaurant = new Restaurant();
                restaurant.Read_Info();
                Location location = (Location) restaurant;
                //   System.out.println(restaurant);
                try {
                    csvWrite.write_in_csv(restaurant, "locations/restaurant");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                csvRead.getRestaurants().add(restaurant);
              //  locations.add((Location) restaurant);

            } else {
                System.out.println("Try again");
            }
        }
    }
    public void PrintLocation() throws IOException {
        Scanner read1 = new Scanner(System.in);
        csvAudit.write_in_audit("Print","Locations");
        /*System.out.println("Do you want to see all locations?");
        System.out.println("\t1. Yes\n\t2. No");
        System.out.println("\t\tAnswer: ");
        String types= read1.nextLine();
        types=types.toUpperCase();
        if(types.equals("1") || types.equals("YES")){
            for(int i=0; i<locations.size(); i++) {
                System.out.println(locations.get(i).toString());
            }
        }
        else{*/
            System.out.println("What kind of location do you want to see?");
            System.out.println("\t1. Hotel\n\t2. Restaurant\n\t3. Guest House\n\t4. Multipurpose Hall");
            System.out.print("\t\tAnswer: ");
            String types1= read1.nextLine();
            types1=types1.toUpperCase();
            if(types1.equals("HOTEL") || types1.equals("1")){
                for(int i=0; i<csvRead.getHotels().size(); i++) {
                    System.out.println(csvRead.getHotels().get(i).toString());
                }
            }
            else if (types1.equals("RESTAURANT") ||types1.equals("2")){
                for(int i=0; i<csvRead.getRestaurants().size(); i++) {
                    System.out.println(csvRead.getRestaurants().get(i).toString());
                }
            }
            else if (types1.equals("GUEST HOUSE") ||types1.equals("3")){
                for(int i=0; i<csvRead.getGuestHouses().size(); i++) {
                    System.out.println(csvRead.getGuestHouses().get(i).toString());
                }
            }
            else if (types1.equals("MULTIPURPOSE HALL") ||types1.equals("4")){
                for(int i=0; i<csvRead.getMultipurposeHalls().size(); i++) {
                    System.out.println(csvRead.getMultipurposeHalls().get(i).toString());
                }
            }
        }
    public void DeleteLocation() throws IOException {
       csvAudit.write_in_audit("Delete","Location");
        Scanner read1 = new Scanner(System.in);
        System.out.print("Which is the type of location you want to delete?");
        System.out.println("\n\t1. Hotel\n\t2. Restaurant\n\t3. Guest House\n\t4. Multipurpose Hall");
        System.out.print("\nAnswer:");
        String types1= read1.nextLine();
        types1=types1.toUpperCase();
        System.out.print("What is the name of the location?");
        System.out.print("\nAnswer:");
        String location_name = read1.nextLine();
        if(types1.equals("HOTEL") || types1.equals("1"))        {
            for (int i= 0 ; i< csvRead.getHotels().size() ; i++){
                if(csvRead.getHotels().get(i).getName().equals(location_name)){
                    System.out.print("Location " + location_name + "was successfully removed");
                    csvRead.getHotels().remove(i);

                }
            }

        }
        else if (types1.equals("RESTAURANT") ||types1.equals("2")){
            for (int i= 0 ; i< csvRead.getRestaurants().size() ; i++){
                if(csvRead.getRestaurants().get(i).getName().equals(location_name)){
                    System.out.print("Location " + location_name + "was successfully removed");
                    csvRead.getRestaurants().remove(i);

                }
            }
        }
        else if (types1.equals("GUEST HOUSE") ||types1.equals("3")){
            for (int i= 0 ; i< csvRead.getGuestHouses().size() ; i++){
                if(csvRead.getGuestHouses().get(i).getName().equals(location_name)){
                    System.out.print("Location " + location_name + "was successfully removed");
                    csvRead.getGuestHouses().remove(i);

                }
            }
        }
        else if (types1.equals("MULTIPURPOSE HALL") ||types1.equals("4")){
            for (int i= 0 ; i< csvRead.getMultipurposeHalls().size() ; i++){
                if(csvRead.getMultipurposeHalls().get(i).getName().equals(location_name)){
                    System.out.print("Location " + location_name + "was successfully removed");
                    csvRead.getMultipurposeHalls().remove(i);

                }
            }
        }

    }

    }

