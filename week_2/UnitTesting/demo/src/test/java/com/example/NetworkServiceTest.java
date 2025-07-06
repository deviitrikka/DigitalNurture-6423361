package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NetworkServiceTest {

    @Test
    public void testServiceWithMockNetworkClient() {
        // Step 1: Create a mock client
        NetworkClient mockNetworkClient = mock(NetworkClient.class);

        // Step 2: Stub the connect method
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // Step 3: Use the mock in your service
        NetworkService networkService = new NetworkService(mockNetworkClient);

        // Step 4: Call and assert
        String result = networkService.connectToServer();
        assertEquals("Connected to Mock Connection", result);

        // Optional: Verify the connect method was called
        verify(mockNetworkClient).connect();
    }
}
