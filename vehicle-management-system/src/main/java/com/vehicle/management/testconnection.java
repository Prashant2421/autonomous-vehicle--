package com.vehicle.management;
import com.vehicle.management.util.DatabaseConnection;

import java.sql.Connection;

public class testconnection {
    public static void main(String[] args) {
        // Attempt to establish a database connection
        Connection connection = DatabaseConnection.getConnection();

        // Check and print the connection status
        if (connection != null) {
            System.out.println("Connection test successful!");
        } else {
            System.out.println("Connection test failed!");
        }

        // Close the connection
        DatabaseConnection.closeConnection();
    }
}
