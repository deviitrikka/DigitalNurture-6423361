package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Step 1: Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub the method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Inject the mock into the service
        MyService service = new MyService(mockApi);

        // Step 4: Assert the behavior
        String result = service.fetchData();
        assertEquals("Mock Data", result);

        // Step 5: Verify the interaction
        verify(mockApi).getData();
    }
}
