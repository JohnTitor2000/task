package ru.testtask.uriku.task.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceServiceImplTest {

    @Test
    void getFrequency() {
    }

    @Test
    void testGetFrequency() {
        // Arrange
        SequenceServiceImpl sequenceService = new SequenceServiceImpl();
        String inputSequence = "hello world";

        // Act
        var result = sequenceService.getFrequency(inputSequence);

        // Assert
        assertNotNull(result);
        assertEquals(3, result.get('l'));
        assertEquals(2, result.get('o'));
        assertEquals(1, result.get('h'));
        assertEquals(1, result.get('w'));
        assertEquals(1, result.get('r'));
        assertEquals(1, result.get('e'));
        assertEquals(1, result.get('d'));
        assertEquals(1, result.get(' '));
    }

   // @Test
   // void testGetFrequencyWithNull() {
   //     // Arrange
   //     SequenceServiceImpl sequenceService = new SequenceServiceImpl();
//
   //     // Act
   //     var result = sequenceService.getFrequency(null);
//
   //     // Assert
   //     assertNotNull(result);
   //     assertTrue(result.isEmpty()); // Ожидаем, что для null результат будет пустой мапой
   // }
}