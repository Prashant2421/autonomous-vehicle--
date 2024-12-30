package com.vehicle.management.vehicleservice;

import com.vehicle.management.Dao.userdao;
import com.vehicle.management.model.user;

public class userservice {
    private userdao userdao;

    public userservice() {
        this.userdao = new userdao();
    }

    // Authenticate a user
    public user authenticateUser(String username, String password) {
        user user = userdao.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user; // Authentication successful
        }
        return null; // Authentication failed
    }

    // Register a new user
    public boolean registerUser(user user) {
        if (userdao.getUserByUsername(user.getUsername()) == null) {
            return userdao.saveUser(user);
        }
        return false; // Username already exists
    }
}
