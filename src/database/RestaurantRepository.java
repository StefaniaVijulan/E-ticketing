package database;

import config.DatabaseConfiguration;
import model.location.MultipurposeHall;
import model.location.Restaurant;
import model.location.Zone;

import java.sql.*;

public class RestaurantRepository {
    // CallableStatement
    public void insertRestaurant(Restaurant restaurant) {
        String preparedSql = "{call insertRestaurant(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {

            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(1, String.valueOf(restaurant.getZone()));
            cstmt.setString(2,restaurant.getName());
            cstmt.setString(3,restaurant.getCountry());
            cstmt.setString(4,restaurant.getTown());
            cstmt.setString(5,restaurant.getStreet());
            cstmt.setString(6,restaurant.getNumber());
            cstmt.setInt(7,restaurant.getNumber_of_seats());
            cstmt.setInt(8,restaurant.getTable_seats());
            cstmt.setFloat(9,restaurant.getPrice_per_seats());
            cstmt.setBoolean(10,restaurant.getScene());
            cstmt.setFloat(11,restaurant.getScene_price());
            cstmt.setBoolean(12,restaurant.getEquipment());
            cstmt.setFloat(13,restaurant.getPrice_of_equipment());
            //cstmt.registerOutParameter(2, Types.VARCHAR); //out param (result of the procedure call)
            cstmt.execute();

            //  System.out.println("Added user with id:" + cstmt.getInt(1));    //out param (result of the procedure call)
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Restaurant getRestaurant(String name){
        String preparedSql ="SELECT * FROM restaurant where name=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(preparedSql);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToRestaurant(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Restaurant mapToRestaurant(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Restaurant(Zone.valueOf(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6), resultSet.getInt(7), resultSet.getInt(8),resultSet.getFloat(9),resultSet.getBoolean(10),resultSet.getFloat(11),resultSet.getBoolean(12), resultSet.getFloat(13));
        }
        return null;
    }
    public void deleteRestaurant(String name){
        String deleteSql ="DELETE FROM restaurant WHERE name=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteSql);


            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateRestaurant(String name, Integer price_per_seats) {
        String updateNameSql = "UPDATE restaurant SET price_per_seats=? WHERE name=?";

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
