package com.vehicle.management.dao;

import com.vehicle.management.model.User;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {
    private final UserDao userDao = new UserDao();

    @Test
    public void testGetAllUsers() {
        List<User> users = userDao.getAllUsers();
        assertNotNull(users, "The user list should not be null");
        assertTrue(users.size() > 0, "The user list should have at least one user");
    }
}
