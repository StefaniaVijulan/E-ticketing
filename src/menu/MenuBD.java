package menu;

import config.DataSetup;

import databaseRead.GuestHouseDataBase;
import databaseRead.HotelDataBase;
import databaseRead.MultipurposeHallDataBase;
import databaseRead.RestaurantDataBase;

import java.util.Scanner;

public class MenuBD {
    public static void main(String[] args)  {
        DataSetup dataSetup = new DataSetup();
        GuestHouseDataBase guestHouseDataBase = new GuestHouseDataBase();
        HotelDataBase hotelDataBase = new HotelDataBase();
        MultipurposeHallDataBase multipurposeHallDataBase = new MultipurposeHallDataBase();
        RestaurantDataBase restaurantDataBase = new RestaurantDataBase();
        String b = "";
        while(!b.equals("5")) {
            System.out.println("Which locations do you want to make changes to?");
            System.out.println("  1. Guest House");
            System.out.println("  2. Hotel");
            System.out.println("  3. Restaurant");
            System.out.println("  4. MultipurposeHall");
            System.out.println("  5. Out");
            System.out.println("\tPlease choose a number");
            System.out.print("\tAnswer:");
            Scanner a = new Scanner(System.in);
            b = a.nextLine();
            b = b.toUpperCase();
            if(b.equals("1")){
                guestHouseDataBase.GuestHouseCRUD();
            }
            else if (b.equals("2")){
                hotelDataBase.GuestHouseCRUD();
            }
            else if (b.equals("3")){
                restaurantDataBase.RestaurantCRUD();
            }
            else if (b.equals("4")){
                multipurposeHallDataBase.MultipurposeHallCRUD();
            }
            else if (b.equals("5")){
                System.out.println("Thank you for your time!");
               break;
            }
            else {
                System.out.println("What you want to do it is not ok!");
            }

        }
    }
}
