package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DataServiceTest {

    @Test
    public void testServiceWithMockRepository() {
        // Step 1: Mock the repository
        DataRepository mockRepository = mock(DataRepository.class);

        // Step 2: Stub the method
        when(mockRepository.getData()).thenReturn("Mock Data");

        // Step 3: Use the mock in the service
        DataService service = new DataService(mockRepository);
        String result = service.processData();

        // Step 4: Verify the result
        assertEquals("Processed Mock Data", result);
    }
}
