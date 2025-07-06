package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {
        // Step 1: Create mocks
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        // Step 2: Stub the reader method
        when(mockFileReader.read()).thenReturn("Mock File Content");

        // Step 3: Inject mocks into service
        FileService fileService = new FileService(mockFileReader, mockFileWriter);

        // Step 4: Call the method and assert the result
        String result = fileService.processFile();
        assertEquals("Processed Mock File Content", result);

        // Step 5: Verify the writer was called with correct value
        verify(mockFileWriter).write("Processed Mock File Content");
    }
}
