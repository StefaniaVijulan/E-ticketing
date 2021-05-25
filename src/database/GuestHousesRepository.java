package database;

import config.DatabaseConfiguration;
import model.location.GuestHouse;
import model.location.Zone;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.*;
public class GuestHousesRepository {
    // CallableStatement
    public void insertGuestHouses(GuestHouse guestHouse) {
       String preparedSql = "{call insertGuestHouses(?,?,?,?,?,?,?,?,?,?,?,?)}";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {

            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(1, String.valueOf(guestHouse.getZone()));
            cstmt.setString(2,guestHouse.getName());
            cstmt.setString(3,guestHouse.getCountry());
            cstmt.setString(4,guestHouse.getTown());
            cstmt.setString(5,guestHouse.getStreet());
            cstmt.setString(6,guestHouse.getNumber());
            cstmt.setInt(7,guestHouse.getNumber_of_stars());
            cstmt.setBoolean(8,guestHouse.getPets());
            cstmt.setFloat(9,guestHouse.getNumber_of_rooms());
            cstmt.setBoolean(10,guestHouse.getConference_room());
            cstmt.setFloat(11,guestHouse.getRooms_price());
            cstmt.setBoolean(12,guestHouse.getPool());
            //cstmt.registerOutParameter(2, Types.VARCHAR); //out param (result of the procedure call)
            cstmt.execute();

          //  System.out.println("Added user with id:" + cstmt.getInt(1));    //out param (result of the procedure call)
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public GuestHouse getGuestHouses(String name){
        String preparedSql ="SELECT * FROM guesthouses where name=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(preparedSql);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToGuestHouses(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private GuestHouse mapToGuestHouses(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new GuestHouse(Zone.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6), resultSet.getInt(7), resultSet.getBoolean(8),resultSet.getFloat(9),resultSet.getBoolean(10),resultSet.getFloat(11),resultSet.getBoolean(12));
        }
        return null;
    }
    public void deleteGuestHouses(String name){
        String deleteSql ="DELETE FROM guesthouses WHERE name=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteSql);

            // trebuie puse in functie de ordinea parametrilor
            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateGuestHouses(String name, Boolean pets) {

        String updateNameSql = "UPDATE guesthouses SET pets=? WHERE name=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {

            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);

            // trebuie puse in functie de ordinea parametrilor
            preparedStatement.setBoolean(1, pets);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
