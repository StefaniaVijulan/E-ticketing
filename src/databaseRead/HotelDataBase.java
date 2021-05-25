package databaseRead;

import config.DatabaseConfiguration;
import database.HotelRepository;
import model.location.GuestHouse;
import model.location.Hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HotelDataBase {
    HotelRepository hotelRepository = new HotelRepository();

    private Hotel CreatHotel() {
        Hotel hotel = new Hotel();
        hotel.Read_Info();
        return hotel;

    }

    private String ReadHotel() {
        System.out.println("Choose the name of the hotel?");

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Integer id = 1;
            Statement stm = databaseConnection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name from hotel");
            while (rs.next()) {
                System.out.println("\t" + id.toString() + ". " + rs.getString("name"));
                id += 1;
            }

            System.out.println("\t\tPlease enter the name of the hotel");
            System.out.print("\t\t Answer: ");
            ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();

        return b;
    }

    private void UpdateHotel() {
        System.out.println("You will change the number of stars!");
        System.out.println("Choose the name of location?");

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Integer id = 1;
            Statement stm = databaseConnection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name from hotel");
            while (rs.next()) {
                System.out.println("\t" + id.toString() + ". " + rs.getString("name"));
                id += 1;
            }

            System.out.println("\t\tPlease enter the name of the location");
            System.out.print("\t\t Answer: ");
            ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();

        System.out.print("\t\tPlease enter the new number of stars: ");
        Integer c = Integer.parseInt(a.nextLine());
        hotelRepository.updateHotel(b, c);
        System.out.println("The information about " + b + " has changed!");
    }

    private void DeleteHotel() {
        System.out.println("Choose the name of location?");
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Integer id = 1;
            Statement stm = databaseConnection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name from hotel");
            while (rs.next()) {
                System.out.println("\t" + id.toString() + ". " + rs.getString("name"));
                id += 1;
            }

            System.out.println("\t\tPlease enter the name of the location");
            System.out.print("\t\t Answer: ");
            ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();
        hotelRepository.deleteHotel(b);
        System.out.println("The information about " + b + " has deleted!");
    }

    public void GuestHouseCRUD() {
        String b = "";
        while (!b.equals("5")) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("\t1. Create a new Hotel");
            System.out.println("\t2. Read a Hotel");
            System.out.println("\t3. Update a Hotel");
            System.out.println("\t4. Delete a Hotel");
            System.out.println("\t5. Out");
            System.out.print("\t\tPlease choose a number: ");
            Scanner a = new Scanner(System.in);
            b = a.nextLine();
            if (b.equals("1")) {
                hotelRepository.insertHotel(CreatHotel());
            } else if (b.equals("2")) {
                Hotel hotel = hotelRepository.getHotel(ReadHotel());
                System.out.println(hotel.getName() + " are " + hotel.getNumber_of_starts() + " stars");
            } else if (b.equals("3")) {
                UpdateHotel();
            } else if (b.equals("4")) {
                DeleteHotel();
            } else if(b.equals("5"))
            {
                break;
            }
            else{
                System.out.println("What you want to do it is not ok!");
            }
        }
    }
}
