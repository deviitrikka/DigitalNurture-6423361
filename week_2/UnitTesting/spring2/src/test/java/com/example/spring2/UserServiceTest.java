package com.example.spring2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserById_UserExists() {
        // Arrange
        User mockUser = new User(1L, "John Doe");
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        // Act
        User user = userService.getUserById(1L);

        // Assert
        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testGetUserById_UserDoesNotExist() {
        // Arrange: mock the repository to return empty
    when(userRepository.findById(2L)).thenReturn(Optional.empty());

    // Act + Assert: expect UserNotFoundException
    assertThrows(UserNotFoundException.class, () -> userService.getUserById(2L));
    }

    
    @Test
    public void testGetUserById_UserNotFound_ShouldThrowException() {
        Long userId = 99L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> {
            userService.getUserById(userId);
        });

        assertEquals("User not found with id: 99", exception.getMessage());
    }
}
