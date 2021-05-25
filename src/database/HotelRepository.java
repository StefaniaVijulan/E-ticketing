package database;

import config.DatabaseConfiguration;
import model.location.GuestHouse;
import model.location.Hotel;
import model.location.Zone;

import java.sql.*;

public class HotelRepository {
    // CallableStatement
    public void insertHotel(Hotel hotel) {
        String preparedSql = "{call insertHotel(?,?,?,?,?,?,?,?,?,?,?)}";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {

            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(1, String.valueOf(hotel.getZone()));
            cstmt.setString(2,hotel.getName());

            cstmt.setString(3,hotel.getCountry());
            cstmt.setString(4,hotel.getTown());
            cstmt.setString(5,hotel.getStreet());
            cstmt.setString(6,hotel.getNumber());
            cstmt.setInt(7,hotel.getNumber_of_starts());
            cstmt.setBoolean(8,hotel.getPets());
            cstmt.setBoolean(9,hotel.getConference_room());
            cstmt.setFloat(10,hotel.getPrice_of_room());
            cstmt.setInt(11,hotel.getNumber_of_rooms());


            //cstmt.registerOutParameter(2, Types.VARCHAR); //out param (result of the procedure call)

            cstmt.execute();

            //  System.out.println("Added user with id:" + cstmt.getInt(1));    //out param (result of the procedure call)
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Hotel getHotel(String name){
        String preparedSql ="SELECT * FROM hotel where name=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(preparedSql);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToHotel(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Hotel mapToHotel(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Hotel(Zone.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6), resultSet.getInt(7), resultSet.getBoolean(8),resultSet.getBoolean(9),resultSet.getFloat(10),resultSet.getInt(11));
        }
        return null;
    }
    public void deleteHotel(String name){
        String deleteSql ="DELETE FROM hotel WHERE name=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteSql);

            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateHotel(String name, Integer number_of_stars) {
        String updateNameSql = "UPDATE hotel SET number_of_stars=? WHERE name=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {

            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);

            // trebuie puse in functie de ordinea parametrilor
            preparedStatement.setInt(1, number_of_stars);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
