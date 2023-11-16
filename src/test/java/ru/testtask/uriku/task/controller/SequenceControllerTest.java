package ru.testtask.uriku.task.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ru.testtask.uriku.task.service.SequenceService;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(SequenceController.class)
class SequenceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SequenceService sequenceService;

    @Test
    void testGetFrequency() throws Exception {
        String inputSequence = "hello world";

        when(sequenceService.getFrequency(inputSequence))
                .thenReturn(Map.of('l', 3, 'o', 2, 'w', 1, 'r', 1, 'h', 1, 'e', 1, 'd', 1, ' ', 1));

        ResultActions resultActions = mockMvc.perform(get("/{sequence}", inputSequence)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        resultActions.andExpect(jsonPath("$.l", is(3)))
                .andExpect(jsonPath("$.o", is(2)))
                .andExpect(jsonPath("$.w", is(1)))
                .andExpect(jsonPath("$.r", is(1)))
                .andExpect(jsonPath("$.h", is(1)))
                .andExpect(jsonPath("$.e", is(1)))
                .andExpect(jsonPath("$.d", is(1)));
    }
}