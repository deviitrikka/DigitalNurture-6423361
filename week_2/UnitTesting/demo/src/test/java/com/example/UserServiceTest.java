package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testUpdateUserCalledWithCorrectArguments() {
        // Step 1: Mock the API
        UserApi mockUserApi = mock(UserApi.class);

        // Step 2: Inject into service and call method
        UserService service = new UserService(mockUserApi);
        service.performUpdate();

        // Step 3: Verify arguments
        verify(mockUserApi).updateUser(eq("user42"), anyInt());
    }
}
