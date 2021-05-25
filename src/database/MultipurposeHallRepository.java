package database;

import config.DatabaseConfiguration;
import model.location.Hotel;
import model.location.MultipurposeHall;
import model.location.Zone;

import java.sql.*;

public class MultipurposeHallRepository {
    // CallableStatement
    public void insertMultipurposeHall(MultipurposeHall multipurposeHall) {
        String preparedSql = "{call insertMultipurposeHall(?,?,?,?,?,?,?,?,?,?,?,?)}";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {

            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(1, String.valueOf(multipurposeHall.getZone()));
            cstmt.setString(2,multipurposeHall.getName());
            cstmt.setString(3,multipurposeHall.getCountry());
            cstmt.setString(4,multipurposeHall.getTown());
            cstmt.setString(5,multipurposeHall.getStreet());
            cstmt.setString(6,multipurposeHall.getNumber());
            cstmt.setInt(7,multipurposeHall.getNumber_of_seats());
            cstmt.setFloat(8,multipurposeHall.getPrice_per_seats());
            cstmt.setBoolean(9,multipurposeHall.getAudio_equipment());
            cstmt.setFloat(10,multipurposeHall.getPrice_of_the_audio_equipment());
            cstmt.setBoolean(11,multipurposeHall.getVideo_equipment());
            cstmt.setFloat(12,multipurposeHall.getPrice_of_the_video_equipment());
            //cstmt.registerOutParameter(2, Types.VARCHAR); //out param (result of the procedure call)
            cstmt.execute();

            //  System.out.println("Added user with id:" + cstmt.getInt(1));    //out param (result of the procedure call)
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public MultipurposeHall getMultipurposeHall(String name){
        String preparedSql ="SELECT * FROM multipurposehall where name=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(preparedSql);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToMultipurposeHall(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private MultipurposeHall mapToMultipurposeHall(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new MultipurposeHall(Zone.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6), resultSet.getInt(7), resultSet.getFloat(8),resultSet.getBoolean(9),resultSet.getFloat(10),resultSet.getBoolean(11), resultSet.getFloat(12));
        }
        return null;
    }
    public void deleteMultipurposeHall(String name){
        String deleteSql ="DELETE FROM multipurposehall WHERE name=?";

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
    public void updateMultipurposeHall(String name, Integer price_per_seats) {
        String updateNameSql = "UPDATE multipurposehall SET price_per_seats=? WHERE name=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {

            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);

            // trebuie puse in functie de ordinea parametrilor
            preparedStatement.setInt(1, price_per_seats);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
