package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        // Step 1: Mock the REST client
        RestClient mockRestClient = mock(RestClient.class);

        // Step 2: Stub its method
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // Step 3: Use the mock in the service
        ApiService apiService = new ApiService(mockRestClient);

        // Step 4: Verify logic
        String result = apiService.fetchData();
        assertEquals("Fetched Mock Response", result);
    }
}
    