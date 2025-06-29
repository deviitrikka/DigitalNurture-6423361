package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class SessionServiceTest {

    @Test
    public void testMethodCallOrder() {
        // Step 1: Mock the dependency
        SessionManager mockManager = mock(SessionManager.class);

        // Step 2: Use in service and call method
        SessionService service = new SessionService(mockManager);
        service.performSession("alice");

        // Step 3: Verify interaction order
        InOrder inOrder = inOrder(mockManager);
        inOrder.verify(mockManager).login("alice");
        inOrder.verify(mockManager).fetchData();
        inOrder.verify(mockManager).logout();
    }
}
