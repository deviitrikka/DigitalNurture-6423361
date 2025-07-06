package com.example.spring2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
// Use the embedded in-memory DB instead of any real DB (optional)
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
public void setUp() {
    userRepository.deleteAll(); // Clean the DB before each test

    // Save a test user to the DB, let the DB assign the ID
    userRepository.save(new User(null, "Integration Test User"));
}

    @Test
    public void testGetUser_FullFlow() throws Exception {
        mockMvc.perform(get("/users/1")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Integration Test User"));
    }
    //error: returning 500 error instead of 404
    //global exception handler did not include all exception, so one of the exceptions was not being handled properly

    @Test
    public void testGetUser_NotFound() throws Exception {
        mockMvc.perform(get("/users/999")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
            //error fix : by adding @tablename("users") otherwise it was not detecting 
            //renamed the table to "users" to avoid clashing with the SQL keyword "user" used internally by the database.
    }
}
