package com.example.spring2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
        userRepository.save(new User(null, "Alice"));
        userRepository.save(new User(null, "Bob"));
        userRepository.save(new User(null, "Alice"));
    }

    @Test
    public void testFindByName_ReturnsCorrectUsers() {
        List<User> result = userRepository.findByName("Alice");

        assertThat(result).hasSize(2);
        assertThat(result).allMatch(user -> user.getName().equals("Alice"));
    }

    @Test
    public void testFindByName_ReturnsEmptyList() {
        List<User> result = userRepository.findByName("Charlie");

        assertThat(result).isEmpty();
    }
}
