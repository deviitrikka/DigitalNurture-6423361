package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MultiReturnServiceTest {

    @Test
    public void testServiceWithMultipleReturnValues() {
        // Step 1: Create a mock repository
        Repository mockRepository = mock(Repository.class);

        // Step 2: Stub the method to return different values
        when(mockRepository.getData())
            .thenReturn("First Mock Data")
            .thenReturn("Second Mock Data");

        // Step 3: Create the service with the mock
        Service service = new Service(mockRepository);

        // Step 4: Call the method twice
        String firstResult = service.processData();
        String secondResult = service.processData();

        // Step 5: Assert both results
        assertEquals("Processed First Mock Data", firstResult);
        assertEquals("Processed Second Mock Data", secondResult);
    }
}
