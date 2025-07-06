package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class ErrorHandlerTest {

    @Test
    public void testVoidMethodThrowsException() {
        // Step 1: Mock the dependency
        Logger mockLogger = mock(Logger.class);

        // Step 2: Stub the void method to throw an exception
        doThrow(new RuntimeException("Log failed")).when(mockLogger).logError("CRITICAL");

        // Step 3: Use the mock in the service
        ErrorHandler handler = new ErrorHandler(mockLogger);
        handler.handle("CRITICAL");

        // Step 4: Verify interaction still occurred
        verify(mockLogger).logError("CRITICAL");
    }
}
