package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UserManagerTest {

    @Test
    public void testSendNotificationCalled() {
        // Step 1: Create mock
        NotificationService mockNotificationService = mock(NotificationService.class);

        // Step 2: Stub the void method (optional, only needed if it throws exceptions)
        // doNothing().when(mockNotificationService).sendNotification(anyString());

        // Step 3: Inject mock and call real method
        UserManager manager = new UserManager(mockNotificationService);
        manager.registerUser("user123");

        // Step 4: Verify interaction
        verify(mockNotificationService).sendNotification("user123");
    }
}
