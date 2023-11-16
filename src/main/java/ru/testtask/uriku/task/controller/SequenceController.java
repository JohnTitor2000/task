package ru.testtask.uriku.task.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.testtask.uriku.task.service.SequenceService;

import java.util.Map;

@Validated
@RestController
@RequestMapping
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SequenceController {

    SequenceService sequenceService;

    @GetMapping("/{sequence}")
    @ResponseStatus(HttpStatus.OK)
    public Map<Character, Integer> getFrequency(@PathVariable String sequence) {
        return sequenceService.getFrequency(sequence);
    }
}