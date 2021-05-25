package databaseRead;

import config.DatabaseConfiguration;
import database.GuestHousesRepository;
import model.location.GuestHouse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class GuestHouseDataBase {
    GuestHousesRepository guestHousesRepository = new GuestHousesRepository();
    private GuestHouse CreatGuestHouse(){
        GuestHouse guestHouse = new GuestHouse();
        guestHouse.Read_Info();
        return guestHouse;

    }
    private String ReadGuestHouse(){
        System.out.println("Choose the name of location?");

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Integer id =1;
            Statement stm = databaseConnection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name from guesthouses");
            while(rs.next()){
                System.out.println("\t"+id.toString() + ". "+ rs.getString("name"));
                id +=1;
            }

            System.out.println("\t\tPlease enter the name of the location");
            System.out.print("\t\t Answer: "); ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();

        return b;
    }
    private void UpdateGuestHouse(){
        System.out.println("You will change whether the location accepts animals or not");
        System.out.println("Choose the name of location?");
        HashMap<String, Boolean> data = new HashMap<>();

        Boolean acceptsAnimals;
        String houseName;
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Integer id =1;
            Statement stm = databaseConnection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name, pets from guesthouses");
            while(rs.next()){
                houseName = rs.getString("name");
                acceptsAnimals = rs.getBoolean("pets");
                data.put(houseName, acceptsAnimals);
                System.out.println(String.format("%d.  %s, acceptsPets: %s", id, houseName,acceptsAnimals ? "yes":"no"));
                id +=1;
            }

            System.out.println("\t\tPlease enter the name of the location");
            System.out.print("\t\t Answer: "); ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String location = new Scanner(System.in).nextLine();
        acceptsAnimals = data.get(location);
        System.out.println(acceptsAnimals ? "Accepta animale" : "Nu accepta animale");
        guestHousesRepository.updateGuestHouses(location,!acceptsAnimals);
    }
    private void DeleteGuestHouse(){

        System.out.println("Choose the name of location?");
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Integer id =1;
            Statement stm = databaseConnection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name from guesthouses");
            while(rs.next()){
                System.out.println("\t"+id.toString() + ". "+ rs.getString("name"));
                id +=1;
            }

            System.out.println("\t\tPlease enter the name of the location");
            System.out.print("\t\t Answer: "); ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();
        guestHousesRepository.deleteGuestHouses(b);
        System.out.println("The information about " + b +" has deleted!");
    }
    public void GuestHouseCRUD(){
        String b = "";
        while(!b.equals("5")) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("\t1. Create a new Guest House");
            System.out.println("\t2. Read a Guest House");
            System.out.println("\t3. Update a Guest House");
            System.out.println("\t4. Delete a Guest House");
            System.out.println("\t5. Out");
            System.out.print("\t\tPlease choose a number: ");
            Scanner a = new Scanner(System.in);
            b = a.nextLine();
            if (b.equals("1")) {
                guestHousesRepository.insertGuestHouses(CreatGuestHouse());
            } else if (b.equals("2")) {
                GuestHouse guestHouse = guestHousesRepository.getGuestHouses(ReadGuestHouse());
                System.out.println(guestHouse.getName() + " has " + guestHouse.getNumber_of_stars() + " stars");
            } else if (b.equals("3")) {
                UpdateGuestHouse();
            } else if (b.equals("4")) {
                DeleteGuestHouse();
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

