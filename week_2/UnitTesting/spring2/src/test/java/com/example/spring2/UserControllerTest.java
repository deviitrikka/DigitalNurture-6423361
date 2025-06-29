package com.example.spring2;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.NoSuchElementException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        objectMapper = new ObjectMapper(); // Moved from field to here (good practice)
    }

    @Test
    public void testCreateUser() throws Exception {
        // Arrange
        User inputUser = new User(null, "New User");
        User savedUser = new User(1L, "New User");

        when(userService.saveUser(any(User.class))).thenReturn(savedUser);

        // Act & Assert
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputUser)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("New User"));
    }

    @Test
    public void testGetUserById_UserNotFound_ShouldReturn404() throws Exception {
        Long missingId = 999L;

        when(userService.getUserById(missingId))
            .thenThrow(new NoSuchElementException("User not found"));

        mockMvc.perform(get("/users/{id}", missingId))
            .andExpect(status().isNotFound())
            .andExpect(content().string("User not found"));
    }

}
