package com.vehicle.management.Dao;
import com.vehicle.management.util.DatabaseConnection;
import com.vehicle.management.util.JDBCConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class vehicledao {

    // Method to add a new vehicle
    public boolean addVehicle(String vehicleNumber, String model, String owner, String type) {
        String query = "INSERT INTO vehicles (vehicle_number, model, owner, type) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, vehicleNumber);
            preparedStatement.setString(2, model);
            preparedStatement.setString(3, owner);
            preparedStatement.setString(4, type);

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0; // Return true if the vehicle was added
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to retrieve all vehicles
    public List<String> getAllVehicles() {
        List<String> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles";
        try (Connection connection = JDBCConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String vehicleDetails = "Vehicle Number: " + resultSet.getString("vehicle_number")
                        + ", Model: " + resultSet.getString("model")
                        + ", Owner: " + resultSet.getString("owner")
                        + ", Type: " + resultSet.getString("type");
                vehicles.add(vehicleDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    // Method to delete a vehicle
    public boolean deleteVehicle(String vehicleNumber) {
        String query = "DELETE FROM vehicles WHERE vehicle_number = ?";
        try (Connection connection = JDBCConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, vehicleNumber);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0; // Return true if the vehicle was deleted
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

