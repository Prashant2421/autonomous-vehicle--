package com.vehicle.management.service;

import com.vehicle.management.dao.UserDao;
import com.vehicle.management.model.User;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class UserServiceTest {
    @Test
    public void testGetAllUsers() {
        // Mock DAO
        UserDao userDaoMock = mock(UserDao.class);
        UserService userService = new UserService(userDaoMock);

        // Create mock data
        List<User> mockUsers = Arrays.asList(
            new User(1, "John", "john@example.com"),
            new User(2, "Jane", "jane@example.com")
        );
        when(userDaoMock.getAllUsers()).thenReturn(mockUsers);

        // Call method and assert
        List<User> users = userService.getAllUsers();
        assertEquals(2, users.size());
        verify(userDaoMock, times(1)).getAllUsers();
    }
}
