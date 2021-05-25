package databaseRead;

import config.DatabaseConfiguration;
import database.HotelRepository;
import database.RestaurantRepository;
import model.location.Hotel;
import model.location.Restaurant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RestaurantDataBase {
    RestaurantRepository restaurantRepository = new RestaurantRepository();

    private Restaurant CreatRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.Read_Info();
        return restaurant;

    }

    private String ReadRestaurant() {
        System.out.println("Choose the name of the restaurant?");

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Integer id = 1;
            Statement stm = databaseConnection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name from restaurant");
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

    private void UpdateRestaurant() {
        System.out.println("You will change price/seats");
        System.out.println("Choose the name of location?");

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Integer id = 1;
            Statement stm = databaseConnection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name from restaurant");
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
        restaurantRepository.updateRestaurant(b, c);
        System.out.println("The information about " + b + " has changed!");
    }

    private void DeleteRestaurant() {
        System.out.println("Choose the name of location?");
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Integer id = 1;
            Statement stm = databaseConnection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name from restaurant");
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
        restaurantRepository.deleteRestaurant(b);
        System.out.println("Hotel " + b + " has been deleted from the table");
    }

    public void RestaurantCRUD() {
        String b = "";
        while (!b.equals("5")) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("\t1. Create a new Restaurant");
            System.out.println("\t2. Read a Restaurant");
            System.out.println("\t3. Update a Restaurant");
            System.out.println("\t4. Delete a Restaurant");
            System.out.println("\t5. Out");
            System.out.print("\t\tPlease choose a number: ");
            Scanner a = new Scanner(System.in);
            b = a.nextLine();
            if (b.equals("1")) {
                restaurantRepository.insertRestaurant(CreatRestaurant());
            } else if (b.equals("2")) {
                Restaurant restaurant = restaurantRepository.getRestaurant(ReadRestaurant());
                System.out.println(restaurant.getName() + "'s location are " + restaurant.getNumber_of_seats() + "seats");
            } else if (b.equals("3")) {
                UpdateRestaurant();
            } else if (b.equals("4")) {
                DeleteRestaurant();
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