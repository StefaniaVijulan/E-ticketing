package databaseRead;

import config.DatabaseConfiguration;
import database.GuestHousesRepository;
import database.MultipurposeHallRepository;
import model.location.GuestHouse;
import model.location.MultipurposeHall;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MultipurposeHallDataBase {
    MultipurposeHallRepository multipurposeHallRepository = new MultipurposeHallRepository();

    private MultipurposeHall CreatMultipurposeHall() {
        MultipurposeHall multipurposeHall = new MultipurposeHall();
        multipurposeHall.Read_Info();
        return multipurposeHall;

    }

    private String ReadMultipurposeHall() {
        System.out.println("Choose the name of the multipurposeHall?");

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Integer id = 1;
            Statement stm = databaseConnection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name from multipurposehall");
            while (rs.next()) {
                System.out.println("\t" + id.toString() + ". " + rs.getString("name"));
                id += 1;
            }

            System.out.println("\t\tPlease enter the name of the restaurant");
            System.out.print("\t\t Answer: ");
            ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();

        return b;
    }

    private void UpdateMultipurposeHall() {
        System.out.println("You will change price/seats");
        System.out.println("Choose the name of location?");

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Integer id = 1;
            Statement stm = databaseConnection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name from multipurposehall");
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

        System.out.print("\t\tPlease enter the new price/seats: ");
        Integer c = Integer.parseInt(a.nextLine());
        multipurposeHallRepository.updateMultipurposeHall(b, c);
        System.out.println("The information about " + b + " has changed!");
    }

    private void DeleteMultipurposeHall() {
        System.out.println("Choose the name of location?");
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Integer id = 1;
            Statement stm = databaseConnection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name from multipurposehall");
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
        multipurposeHallRepository.deleteMultipurposeHall(b);
        System.out.println("Multipurpose Hall " + b + "has been deleted from the table");
    }

    public void MultipurposeHallCRUD() {
        String b = "";
        while (!b.equals("5")) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("\t1. Create a new MultipurposeHall");
            System.out.println("\t2. Read a multipurposeHall");
            System.out.println("\t3. Update a multipurposeHall");
            System.out.println("\t4. Delete a multipurposeHall");
            System.out.println("\t5. Out");
            System.out.println("\t\tPlease choose a number");
            Scanner a = new Scanner(System.in);
            b = a.nextLine();
            if (b.equals("1")) {
                multipurposeHallRepository.insertMultipurposeHall(CreatMultipurposeHall());
            } else if (b.equals("2")) {
                MultipurposeHall multipurposeHall = multipurposeHallRepository.getMultipurposeHall(ReadMultipurposeHall());
                System.out.println(multipurposeHall.getName() + " are " + multipurposeHall.getNumber_of_seats() + "seats");
            } else if (b.equals("3")) {
                UpdateMultipurposeHall();
            } else if (b.equals("4")) {
                DeleteMultipurposeHall();
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
