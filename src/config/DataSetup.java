package config;
import database.RepositoryHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DataSetup {
    public void setUp() {
        String createGuestHouses = "CREATE TABLE IF NOT EXISTS GuestHouses" +
                "(zone varchar(30)," +
                "name varchar(40) PRIMARY KEY,"+
                "country varchar(60),"+
                "town varchar(60),"+
                "street varchar(60),"+
                "number varchar(10),"+
                "number_of_stars int,"+
                "pets TINYINT(1),"+
                "number_of_rooms float,"+
                "conference_room TINYINT(1),"+
                "rooms_price float,"+
                "pool TINYINT(1))";
        String createHotel = "CREATE TABLE IF NOT EXISTS Hotel" +
               "(zone varchar(30)," +
                "name varchar(40) PRIMARY KEY," +
                "country varchar(60)," +
                "town varchar(60)," +
                "street varchar(60)," +
                "number varchar(10)," +
                "number_of_stars int," +
                "pets TINYINT(1)," +
                "conference_room boolean," +
                "price_of_room float," +
                "number_of_rooms int)";
        String creatMultipurposeHall = "CREATE TABLE IF NOT EXISTS MultipurposeHall" +
                "(zone varchar(30)," +
                "name varchar(40)PRIMARY KEY," +
                "country varchar(60)," +
                "town varchar(60)," +
                "street varchar(60)," +
                "number varchar(10)," +
                "number_of_seats int," +
                "price_per_seats float,"+
                "audio_equipment boolean," +
                "price_of_the_audio_equipment float," +
                "video_equipment boolean," +
                "price_of_the_video_equipment float)";
        String creatRestaurant = "CREATE TABLE IF NOT EXISTS Restaurant" +
                "(zone varchar(30)," +
                "name varchar(40) PRIMARY KEY," +
                "country varchar(60)," +
                "town varchar(60)," +
                "street varchar(60)," +
                "number varchar(10)," +
                "number_of_seats int," +
                "table_seats int," +
                "price_per_seats float,"+
                "scene boolean," +
                "scene_price float," +
                "equipment boolean," +
                "price_of_equipment float)";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeSql(databaseConnection, createGuestHouses);
            repositoryHelper.executeSql(databaseConnection, createHotel);
            repositoryHelper.executeSql(databaseConnection, creatMultipurposeHall);
            repositoryHelper.executeSql(databaseConnection,creatRestaurant);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  /* TO DO!!!
   public void addGuestHouses() {
        String insertGuestHousesSQL = "INSERT INTO GuestHouses(zone, name, country, town, street, "+
            "number, number_of_stars, pets, number_of_rooms, conference_room, rooms_price, pool) VALUES('CITY', 'MariaGH','Bucuresti','Bucuresti','Ecaterina Teodoroiu','12A',5,false,143,false,152.0,false)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertGuestHousesSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addHotel() {
        String insertHotelSQL = "INSERT INTO HOTEL(zone varchar(30)," +
                "name varchar(40),"+
                "country varchar(60)," +
                "town varchar(60)," +
                "street varchar(60)," +
                "number varchar(10)," +
                "number_of_stars int," +
                "pets TINYINT(1)," +
                "conference_room boolean," +
                "price_of_room float," +
                "number_of_rooms int) VALUES('CITY', 'AnnaHotel','Bucuresti','Bucuresti','Ecaterina Teodoroiu','12A',5,false,true,155.0,50)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertHotelSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addMultipurposeHall() {
        String insertMultipurposeHallSQL = "INSERT INTO MultipurposeHall(zone varchar(30)," +
                "name varchar(40),"+
                "country varchar(60)," +
                "town varchar(60)," +
                "street varchar(60)," +
                "number varchar(10)," +
                "number_of_seats int," +
                "price_per_seats float,"+
                "audio_equipment boolean," +
                "price_of_the_audio_equipment float," +
                "video_equipment boolean," +
                "price_of_the_video_equipment float) VALUES('CITY','Casa Danielescu', 'Bucuresti','Bucuresti','Ecaterina Teodoroiu','12A',75,50,false,0,true,1560)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertMultipurposeHallSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
   /* public void displayPerson() {
        String selectSql = "SELECT * FROM persons";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("Name:" + resultSet.getString(2));
                System.out.println("Age:" + resultSet.getDouble(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
